package am.itspace.kafkaproducerservices.producer;

import am.itspace.kafkaproducerservices.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final String TOPIC = "test-topic";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @SneakyThrows
    public void sendMessage(Message message) {
        String valueAsString = objectMapper.writeValueAsString(message);
        kafkaTemplate.send(TOPIC, valueAsString);
        System.out.println("Produced message: " + message.getContent());
    }

}
