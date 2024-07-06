package am.itspace.kafkaproducerservices.controller;

import am.itspace.kafkaproducerservices.model.Message;
import am.itspace.kafkaproducerservices.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    private final List<Message> reviews = new ArrayList<>();


    @GetMapping("/")
    public String index(ModelMap modelMap) {
        if (!reviews.isEmpty()) {
            modelMap.addAttribute("reviews", reviews);
        }
        return "index";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam("content")String content) {
       Message message = new Message();
       message.setContent(content);
        kafkaProducer.sendMessage(message);
        reviews.add(message);
        return "redirect:/";
    }
}
