package io.swagger.service;


import io.swagger.model.Lde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class PublisherService {

    @Autowired
    private KafkaTemplate<Integer, Object> kafkaTemplate;
 
    /**
     * topic to publish change of logical date on
     */
    public void publishLogicalDateChanged(Integer key, Lde lde) {
        Message<Lde> message = MessageBuilder.withPayload(lde)
                .setHeader(KafkaHeaders.TOPIC, "lds.logicalDateChanged")
                .setHeader(KafkaHeaders.MESSAGE_KEY, key)
                .build();
        kafkaTemplate.send(message);
    }
}
