package com.example.demo;


import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class ItemSerde extends Serdes.WrapperSerde<Item> {
    public ItemSerde(){
        super(new JsonSerializer<>(), new JsonDeserializer<>(Item.class));
    }
}
