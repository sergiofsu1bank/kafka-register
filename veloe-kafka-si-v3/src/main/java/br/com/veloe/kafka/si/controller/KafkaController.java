package br.com.veloe.kafka.si.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.veloe.kafka.si.model.EstabComlDto;
import br.com.veloe.kafka.si.model.IdentificadorDto;
import br.com.veloe.kafka.si.producer.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	private final Producer producer;

	@Autowired
	KafkaController(Producer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/producer/estab-coml")
	public void sendMessage(@RequestHeader HttpHeaders headers, @RequestBody EstabComlDto estabComlDto) throws Exception {
		this.producer.sendMessageEstabComl(headers, estabComlDto);
	}

	@PostMapping(value = "/producer/identificador")
	public void sendMessage(@RequestHeader HttpHeaders headers, @RequestBody IdentificadorDto identificadorDto) throws Exception {
		this.producer.sendMessageIdentificador(headers, identificadorDto);
	}
}