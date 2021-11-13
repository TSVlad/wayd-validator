package ru.tsvlad.waydvalidator.messaging.consumer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.tsvlad.waydvalidator.messaging.consumer.msg.EventMessage;
import ru.tsvlad.waydvalidator.messaging.producer.ValidatorServiceProducer;
import ru.tsvlad.waydvalidator.service.ValidationService;

@Component
@AllArgsConstructor
public class EventConsumer {

    private ValidationService validationService;
    private ValidatorServiceProducer validatorServiceProducer;

    @KafkaListener(id = "validator-event-customer", topics = {"event-to-validator"}, containerFactory = "singleFactory")
    public void consume(EventMessage eventMessage) {
        switch (eventMessage.getType()) {
            case EVENT_CREATED:
            case EVENT_UPDATED:
                validatorServiceProducer.eventValidation(eventMessage.getEventDTO().getId(), validationService.isValidEvent(eventMessage.getEventDTO()), eventMessage.getUserInfo());
                break;
        }
    }
}
