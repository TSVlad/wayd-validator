package ru.tsvlad.waydvalidator.messaging.consumer.msg;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tsvlad.waydvalidator.messaging.AbstractMessage;
import ru.tsvlad.waydvalidator.messaging.dto.EventDTO;
import ru.tsvlad.waydvalidator.messaging.consumer.msg.type.EventMessageType;

@EqualsAndHashCode(callSuper = true)
@Data
public class EventMessage extends AbstractMessage {
    private EventMessageType type;
    private EventDTO eventDTO;

    public EventMessage() {
        super();
    }

    public EventMessage(EventMessageType type, EventDTO eventDTO) {
        super();
        this.type = type;
        this.eventDTO = eventDTO;
    }
}
