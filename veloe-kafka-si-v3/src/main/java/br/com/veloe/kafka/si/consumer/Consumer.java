package br.com.veloe.kafka.si.consumer;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.veloe.kafka.si.producer.Producer;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    
    @KafkaListener(topics = "siestabcoml", groupId = "group_id")
    public void consumeIdentificador(String message) throws IOException {
    	logger.info("----------------------------------------------------------------------");
        logger.info(String.format("#### Consuming siestabcoml -> %s", message));
        logger.info("----------------------------------------------------------------------");
    }
    
    @KafkaListener(topics = "siidentificador", groupId = "group_id")
    public void consumeEstabelecimento(String message) throws IOException {
    	logger.info("----------------------------------------------------------------------");
        logger.info(String.format("#### Consuming siidentificador -> %s", message));
        logger.info("----------------------------------------------------------------------");
    }
    
    @KafkaListener(topics = "ST_JOIN_IDEN_EST", groupId = "group_id")
    public void consumeJoin(String message) throws IOException {
    	logger.info("----------------------------------------------------------------------");
        logger.info(String.format("#### Consuming ST_JOIN_IDEN_EST -> %s", message));
        logger.info("----------------------------------------------------------------------");
    }
}