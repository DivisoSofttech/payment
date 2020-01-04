package com.diviso.graeshoppe.payment.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Payment.class)
public abstract class Payment_ {

	public static volatile SingularAttribute<Payment, String> payee;
	public static volatile SingularAttribute<Payment, String> ref;
	public static volatile SingularAttribute<Payment, Double> amount;
	public static volatile SingularAttribute<Payment, Double> total;
	public static volatile SingularAttribute<Payment, Instant> dateAndTime;
	public static volatile SingularAttribute<Payment, String> targetId;
	public static volatile SingularAttribute<Payment, String> provider;
	public static volatile SingularAttribute<Payment, Double> tax;
	public static volatile SingularAttribute<Payment, Long> id;
	public static volatile SingularAttribute<Payment, String> payer;
	public static volatile SingularAttribute<Payment, String> paymentType;
	public static volatile SingularAttribute<Payment, String> status;

	public static final String PAYEE = "payee";
	public static final String REF = "ref";
	public static final String AMOUNT = "amount";
	public static final String TOTAL = "total";
	public static final String DATE_AND_TIME = "dateAndTime";
	public static final String TARGET_ID = "targetId";
	public static final String PROVIDER = "provider";
	public static final String TAX = "tax";
	public static final String ID = "id";
	public static final String PAYER = "payer";
	public static final String PAYMENT_TYPE = "paymentType";
	public static final String STATUS = "status";

}

