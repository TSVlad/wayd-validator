package ru.tsvlad.waydvalidator.messaging.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tsvlad.waydvalidator.messaging.producer.msg.ValidatorMessage;
import ru.tsvlad.waydvalidator.messaging.producer.msg.ValidatorMessageType;

@Service
@AllArgsConstructor
public class ValidatorServiceProducer {
    private final KafkaTemplate<Long, ValidatorMessage> eventValidationMessageKafkaTemplate;

    public void eventValidation(String id, boolean isValid) {
        send(/*new ValidatorMessage(ValidatorMessageType.EVENT_VALIDATED, id, isValid)*/ ValidatorMessage.builder()
                .type(ValidatorMessageType.EVENT_VALIDATED)
                .eventId(id)
                .isValid(isValid)
                .build());
    }

    private void send(ValidatorMessage message) {
        eventValidationMessageKafkaTemplate.send("validator-to-event", message);
    }
}
