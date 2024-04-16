package az.divacademy.springbootb108.kafka;

import az.divacademy.springbootb108.model.Book;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

  @KafkaListener(topics = "Div-B108")
  public void consume(Book message) {
    System.out.println(message);
  }

}
