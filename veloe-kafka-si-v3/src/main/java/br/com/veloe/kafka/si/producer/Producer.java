package br.com.veloe.kafka.si.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.veloe.kafka.si.constantes.Constantes;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	@Autowired
    private KafkaTemplate<String, br.com.veloe.kafka.si.model.EstabComlDto> kafkaTemplateEstabComl;

	@Autowired
    private KafkaTemplate<String, br.com.veloe.kafka.si.model.IdentificadorDto> kafkaTemplateIdentiricador;

	public void sendMessageEstabComl(HttpHeaders headers, br.com.veloe.kafka.si.model.EstabComlDto estabComlDto) {
		logger.info(String.format("#### -> Producing message -> %s", estabComlDto));
		this.kafkaTemplateEstabComl.send(headers.getFirst(Constantes.HEADER_CORRELATION_TOPIC), estabComlDto.getIdEcGrupo(), estabComlDto);
	}

	public void sendMessageIdentificador(HttpHeaders headers, br.com.veloe.kafka.si.model.IdentificadorDto identificadorDto) {
		logger.info(String.format("#### -> Producing message -> %s", identificadorDto));
		this.kafkaTemplateIdentiricador.send(headers.getFirst(Constantes.HEADER_CORRELATION_TOPIC), identificadorDto.getIdEcGrupo(), identificadorDto);
	}
	
}