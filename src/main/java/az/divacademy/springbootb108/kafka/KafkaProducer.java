package az.divacademy.springbootb108.kafka;

import az.divacademy.springbootb108.model.Book;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
  private final KafkaTemplate<String,Book> kafkaTemplate;

  public KafkaProducer(KafkaTemplate<String , Book> kafkaTemplate){
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(Book message){
    kafkaTemplate.send("Div-B108",message);
  }

}
