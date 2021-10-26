package ru.tsvlad.waydvalidator.messaging.consumer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.tsvlad.waydvalidator.messaging.consumer.msg.UserMessage;
import ru.tsvlad.waydvalidator.messaging.dto.UserDTO;
import ru.tsvlad.waydvalidator.messaging.producer.ValidatorServiceProducer;
import ru.tsvlad.waydvalidator.service.ValidationService;

@Component
@AllArgsConstructor
public class UserConsumer {

    private ValidationService validationService;
    private ValidatorServiceProducer validatorServiceProducer;

    @KafkaListener(topics = {"user-to-validator"}, containerFactory = "singleFactory")
    public void consume(UserMessage userMessage) {
        switch (userMessage.getType()) {
            case CREATED:
            case UPDATED:
                validateUser(userMessage.getUserDTO());
                break;
        }
    }

    private void validateUser(UserDTO userDTO) {
        System.out.println("USER");
        validatorServiceProducer.userValidated(userDTO.getId(), validationService.isValidUser(userDTO));
    }
}
