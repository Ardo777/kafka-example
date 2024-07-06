package am.itspace.kafkaconsumerservices.consumer;

import am.itspace.kafkaconsumerservices.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "test-topic", groupId = "test-group")
    public void listen(String message) throws JsonProcessingException {
        Message convertedValue = objectMapper.readValue(message, Message.class);
        System.out.println("Received message: " + convertedValue.getContent());
    }

}
