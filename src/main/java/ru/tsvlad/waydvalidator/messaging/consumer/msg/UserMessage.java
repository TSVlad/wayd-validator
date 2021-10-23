package ru.tsvlad.waydvalidator.messaging.consumer.msg;

import lombok.*;
import ru.tsvlad.waydvalidator.messaging.AbstractMessage;
import ru.tsvlad.waydvalidator.messaging.consumer.msg.type.UserMessageType;
import ru.tsvlad.waydvalidator.messaging.dto.UserPublicDTO;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserMessage extends AbstractMessage {
    private UserMessageType type;
    private UserPublicDTO userDTO;
}
