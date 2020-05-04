package br.com.producer;

import br.com.producer.dispatcher.KafkaDispatcher;
import br.com.producer.entity.Email;
import br.com.producer.entity.Person;
import java.util.UUID;

public class MainApp {

    public static void main(String[] args) throws Exception{

        try(
            //necessário criar um dispatcher para cada tipo ..
            var personDispatcher = new KafkaDispatcher<Person>();
            var emailDdispatcher = new KafkaDispatcher<Email>();
        ) {

            for (int c = 0; c < 100; c++) {
                var key = UUID.randomUUID().toString(); // para gerar um valor randomico e mudar achave
                var value = key + ", 12345, 12345";
                var person = new Person(1, "Marcos", 28);
                personDispatcher.send("TOPICO_KAFKA", key, person);

                var email = new Email("Enviando email de teste ..", "Email Teste");
//                var emailRecord = new ProducerRecord<>("TOPICO_KAFKA", key, T);
                emailDdispatcher.send("TOPICO_KAFKA_2", key, email);

            }
        }
    }

}
