package br.com.ProjP2Java.rabbit;

import br.com.ProjP2Java.model.Carro;
import br.com.ProjP2Java.service.CarroService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CarroConsumer {

    @Autowired
    private CarroService carroService;

    @RabbitListener(queues = {"${queue.carro.nome}"})
    public void receive (@Payload Carro carro){
        System.out.println("Id: "+ carro.get_id() + "\nIdmarca:"+ carro.getIdmarca() + "\nNome: " + carro.getNome());
        carroService.save(carro);
    }
}

