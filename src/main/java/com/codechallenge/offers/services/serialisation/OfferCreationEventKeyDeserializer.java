package com.codechallenge.offers.services.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Try;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;
import java.util.UUID;

public class OfferCreationEventKeyDeserializer implements Deserializer {

    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {

        ObjectMapper objectMapper = new ObjectMapper();

        return Try.of(() -> objectMapper.readValue(topic, UUID.class))
                .getOrElseThrow(() -> new RuntimeException("Unable to deserialize event key"));
    }

    @Override
    public Object deserialize(String topic, Headers headers, byte[] data) {
        return null;
    }

    @Override
    public void close() {

    }
}
