package com.diviso.graeshoppe.payment.service.mapper;

import com.diviso.graeshoppe.payment.domain.Payment;
import com.diviso.graeshoppe.payment.service.dto.PaymentDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-04T10:18:05+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment toEntity(PaymentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( dto.getId() );
        payment.setRef( dto.getRef() );
        payment.setPayee( dto.getPayee() );
        payment.setPayer( dto.getPayer() );
        payment.setTargetId( dto.getTargetId() );
        payment.setPaymentType( dto.getPaymentType() );
        payment.setProvider( dto.getProvider() );
        payment.setAmount( dto.getAmount() );
        payment.setTax( dto.getTax() );
        payment.setTotal( dto.getTotal() );
        payment.setStatus( dto.getStatus() );
        payment.setDateAndTime( dto.getDateAndTime() );

        return payment;
    }

    @Override
    public PaymentDTO toDto(Payment entity) {
        if ( entity == null ) {
            return null;
        }

        PaymentDTO paymentDTO = new PaymentDTO();

        paymentDTO.setId( entity.getId() );
        paymentDTO.setRef( entity.getRef() );
        paymentDTO.setPayee( entity.getPayee() );
        paymentDTO.setPayer( entity.getPayer() );
        paymentDTO.setTargetId( entity.getTargetId() );
        paymentDTO.setPaymentType( entity.getPaymentType() );
        paymentDTO.setProvider( entity.getProvider() );
        paymentDTO.setAmount( entity.getAmount() );
        paymentDTO.setTax( entity.getTax() );
        paymentDTO.setTotal( entity.getTotal() );
        paymentDTO.setStatus( entity.getStatus() );
        paymentDTO.setDateAndTime( entity.getDateAndTime() );

        return paymentDTO;
    }

    @Override
    public List<Payment> toEntity(List<PaymentDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Payment> list = new ArrayList<Payment>( dtoList.size() );
        for ( PaymentDTO paymentDTO : dtoList ) {
            list.add( toEntity( paymentDTO ) );
        }

        return list;
    }

    @Override
    public List<PaymentDTO> toDto(List<Payment> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PaymentDTO> list = new ArrayList<PaymentDTO>( entityList.size() );
        for ( Payment payment : entityList ) {
            list.add( toDto( payment ) );
        }

        return list;
    }
}
