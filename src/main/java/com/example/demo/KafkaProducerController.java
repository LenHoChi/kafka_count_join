package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    KafkaTemplate<String, Item> KafkaJsontemplate;

    String TOPIC_NAME = "my-kafka-left-stream-topic";
    String TOPIC_NAME_2 = "my-kafka-right-stream-topic";
    Item item;

    //sending same msg to both topics
    @RequestMapping("/sendMessages2/")
    public String sendMessages2() {
        System.out.println("processing>> " + item);

        item = new Item(1, "nuwan", "home");
        KafkaJsontemplate.send(TOPIC_NAME, "1", item);

        return "Message ONE published successfully";
    }

    @RequestMapping("/sendMessages3a/")
    public String sendMessages3a() {
        System.out.println("processing>> " + item);

        item = new Item(1, "chamara", "office");
        KafkaJsontemplate.send(TOPIC_NAME_2, "1", item);

        return "Message ONE published successfully";
    }
}// end of public class KafkaProducerController
