package ru.tsvlad.waydvalidator.messaging.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import ru.tsvlad.waydvalidator.messaging.producer.msg.Validity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDTO {
    private String id;

    private String name;
    private String description;
    private String contacts;
    private String category;
    private String subCategory;
    private LocalDateTime dateTime;
    private int minNumberOfParticipants;
    private int maxNumberOfParticipants;
    private LocalDateTime deadline;
    private List<String> picturesRefs = new ArrayList<>();
    private GeoJsonPoint point;

    private Validity validity;
    private EventStatus status;

    private long ownerId;
    private List<Long> participantsIds = new ArrayList<>();
}
