package az.divacademy.springbootb108.controller;

import az.divacademy.springbootb108.kafka.KafkaProducer;
import az.divacademy.springbootb108.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kafka")
public class KafkaController {

  private final KafkaProducer kafkaProducer;

  @PostMapping
  public ResponseEntity<Book> publish(@RequestBody Book message) {
    kafkaProducer.send(message);
    return ResponseEntity.ok(message);
  }

}
