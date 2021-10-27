package ru.tsvlad.waydvalidator.messaging.producer.msg;

import lombok.*;
import ru.tsvlad.waydvalidator.messaging.AbstractMessage;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidatorMessage extends AbstractMessage {
    private ValidatorMessageType type;
    private String eventId;
    private long userId;
    private Validity validity;
}
