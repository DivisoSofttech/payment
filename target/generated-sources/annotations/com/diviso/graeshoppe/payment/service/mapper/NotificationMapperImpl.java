package com.diviso.graeshoppe.payment.service.mapper;

import com.diviso.graeshoppe.payment.domain.Notification;
import com.diviso.graeshoppe.payment.service.dto.NotificationDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-04T10:18:05+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public Notification toEntity(NotificationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Notification notification = new Notification();

        notification.setId( dto.getId() );
        notification.setTitle( dto.getTitle() );
        notification.setMessage( dto.getMessage() );
        notification.setTargetId( dto.getTargetId() );
        notification.setType( dto.getType() );
        byte[] image = dto.getImage();
        if ( image != null ) {
            notification.setImage( Arrays.copyOf( image, image.length ) );
        }
        notification.setImageContentType( dto.getImageContentType() );
        notification.setDate( dto.getDate() );
        notification.setReceiverId( dto.getReceiverId() );
        notification.setStatus( dto.getStatus() );

        return notification;
    }

    @Override
    public NotificationDTO toDto(Notification entity) {
        if ( entity == null ) {
            return null;
        }

        NotificationDTO notificationDTO = new NotificationDTO();

        notificationDTO.setId( entity.getId() );
        notificationDTO.setTitle( entity.getTitle() );
        notificationDTO.setMessage( entity.getMessage() );
        notificationDTO.setTargetId( entity.getTargetId() );
        notificationDTO.setType( entity.getType() );
        byte[] image = entity.getImage();
        if ( image != null ) {
            notificationDTO.setImage( Arrays.copyOf( image, image.length ) );
        }
        notificationDTO.setImageContentType( entity.getImageContentType() );
        notificationDTO.setDate( entity.getDate() );
        notificationDTO.setReceiverId( entity.getReceiverId() );
        notificationDTO.setStatus( entity.getStatus() );

        return notificationDTO;
    }

    @Override
    public List<Notification> toEntity(List<NotificationDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Notification> list = new ArrayList<Notification>( dtoList.size() );
        for ( NotificationDTO notificationDTO : dtoList ) {
            list.add( toEntity( notificationDTO ) );
        }

        return list;
    }

    @Override
    public List<NotificationDTO> toDto(List<Notification> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<NotificationDTO> list = new ArrayList<NotificationDTO>( entityList.size() );
        for ( Notification notification : entityList ) {
            list.add( toDto( notification ) );
        }

        return list;
    }
}
