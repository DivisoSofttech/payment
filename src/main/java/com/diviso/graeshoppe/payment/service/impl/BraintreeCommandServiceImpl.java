package com.diviso.graeshoppe.payment.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.braintreegateway.ValidationError;
import com.diviso.graeshoppe.payment.client.braintree.models.PaymentTransaction;
import com.diviso.graeshoppe.payment.client.braintree.models.PaymentTransactionResponse;
import com.diviso.graeshoppe.payment.client.braintree.models.RefundResponse;
import com.diviso.graeshoppe.payment.service.BraintreeCommandService;
import com.diviso.graeshoppe.payment.service.PaymentService;
import com.diviso.graeshoppe.payment.service.dto.PaymentDTO;

@Service
public class BraintreeCommandServiceImpl implements BraintreeCommandService {

	@Autowired
	private BraintreeGateway braintreeGateway;
	private final Logger log = LoggerFactory.getLogger(BraintreeCommandServiceImpl.class);

	@Autowired
	private PaymentService paymentService;

	@Override
	public String getClientToken() {
		ClientTokenRequest clientTokenRequest = new ClientTokenRequest();
		String clientToken = braintreeGateway.clientToken().generate(clientTokenRequest);
		return clientToken;
	}

	@Override
	public PaymentTransactionResponse createTransaction(PaymentTransaction paymentTransaction) {
		TransactionRequest request = new TransactionRequest().amount(new BigDecimal(paymentTransaction.getAmount()))
				.paymentMethodNonce(paymentTransaction.getNounce()).customerId(paymentTransaction.getCustomerId())
				.options().submitForSettlement(true).done();
		Result<Transaction> result = braintreeGateway.transaction().sale(request);
		PaymentTransactionResponse paymentTransactionResponse = new PaymentTransactionResponse();
		if (result.isSuccess()) {
			Transaction transaction = result.getTarget();
			paymentTransactionResponse.setTransactionId(transaction.getId());
			System.out.println("Success!: " + transaction.getId());
		} else if (result.getTransaction() != null) {
			Transaction transaction = result.getTransaction();
			System.out.println("Error processing transaction:");
			System.out.println("  Status: " + transaction.getStatus());
			System.out.println("  Code: " + transaction.getProcessorResponseCode());
			System.out.println("  Text: " + transaction.getProcessorResponseText());
		} else {

			for (ValidationError error : result.getErrors().getAllDeepValidationErrors()) {
				System.out.println("Attribute: " + error.getAttribute());
				System.out.println("  Code: " + error.getCode());
				System.out.println("  Message: " + error.getMessage());
			}

		}
		return paymentTransactionResponse;
	}

	@Override
	public RefundResponse createRefund(String transactionId,Double amount) {
		BigDecimal amountToBeRefund =new BigDecimal(amount);
		Optional<PaymentDTO> payment = paymentService.findOne(Long.parseLong(transactionId));
		RefundResponse refundResponse = new RefundResponse();
		if (payment.isPresent()) {
			PaymentDTO data = payment.get();
			if (data.getProvider().equalsIgnoreCase("braintree")) {
				String status = braintreeGateway.transaction().find(data.getRef()).getStatus().name();
				if (status.equalsIgnoreCase("SETTLED")) {
					log.info("Refunding payment is " + data);
					Result<Transaction> result = braintreeGateway.transaction().refund(data.getRef(),amountToBeRefund);
					log.info("Refund result  is " + result.getTarget().getRefundedTransactionId());
					refundResponse.setTransactionId(result.getTarget().getRefundedTransactionId());
					refundResponse.setStatus("completed");
					return refundResponse;
				} else {
					refundResponse.setStatus(status);
					return refundResponse;
				}

			} else {
				return null;
			}
		} else {
			return null;
		}

	}

}
