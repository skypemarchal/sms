package com.dabm.sms.infrastructure.web.mapper;

import com.dabm.sms.domain.model.Contact;
import com.dabm.sms.domain.model.Message;
import com.dabm.sms.infrastructure.web.dto.MessageDto;
import com.dabm.sms.infrastructure.web.dto.SmsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper MESSAGE_MAPPER = Mappers.getMapper(MessageMapper.class);

    @Mapping(target = "sender", source = "senderId")
    @Mapping(target = "receiverName", source = "contact", qualifiedByName = "mapReceiverName")
    @Mapping(target = "receiverPhone", source = "contact.phone")
    MessageDto toDto(Message message);

    @Mapping(target = "content", source = "dto.message")
    @Mapping(target = "senderId", source = "dto.senderId")
    @Mapping(target = "contact", source = "contact")
    Message fromDto(SmsRequest dto, Contact contact);

    @Named("mapReceiverName")
    default String mapReceiverName(Contact contact) {
        return contact.getFirstName() + " " + contact.getLastName();
    }
}
