package com.dabm.sms.infrastructure.persistence.mapper;

import com.dabm.sms.domain.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper MESSAGE_MAPPER = Mappers.getMapper(MessageMapper.class);

    com.dabm.sms.infrastructure.persistence.entity.Message toEntity(Message message);
    Message fromEntity(com.dabm.sms.infrastructure.persistence.entity.Message message);
}
