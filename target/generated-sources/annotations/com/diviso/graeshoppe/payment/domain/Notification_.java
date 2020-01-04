package com.diviso.graeshoppe.payment.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Notification.class)
public abstract class Notification_ {

	public static volatile SingularAttribute<Notification, Instant> date;
	public static volatile SingularAttribute<Notification, byte[]> image;
	public static volatile SingularAttribute<Notification, String> receiverId;
	public static volatile SingularAttribute<Notification, String> targetId;
	public static volatile SingularAttribute<Notification, String> imageContentType;
	public static volatile SingularAttribute<Notification, Long> id;
	public static volatile SingularAttribute<Notification, String> title;
	public static volatile SingularAttribute<Notification, String> message;
	public static volatile SingularAttribute<Notification, String> type;
	public static volatile SingularAttribute<Notification, String> status;

	public static final String DATE = "date";
	public static final String IMAGE = "image";
	public static final String RECEIVER_ID = "receiverId";
	public static final String TARGET_ID = "targetId";
	public static final String IMAGE_CONTENT_TYPE = "imageContentType";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String MESSAGE = "message";
	public static final String TYPE = "type";
	public static final String STATUS = "status";

}

