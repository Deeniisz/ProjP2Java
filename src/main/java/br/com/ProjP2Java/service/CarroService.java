package br.com.ProjP2Java.service;

import br.com.ProjP2Java.model.Carro;
import br.com.ProjP2Java.rabbit.CarroProducer;
import br.com.ProjP2Java.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroProducer carroProducer;

    public void sendProductRabbit(Carro carro){
        carroProducer.send(carro);
    }

    public void save(Carro carro){
        carroRepository.save(carro);
    }

    public List<Carro> findAll (){
        return carroRepository.findAll();
    }

    public Optional<Carro> findById(String id){
        return carroRepository.findById(id);
    }

    public void delete(String id){
        carroRepository.deleteById(id);
    }

    public void deleteAll(){
        carroRepository.deleteAll();
    }
}
