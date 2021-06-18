package br.com.ProjP2Java.repository;

import br.com.ProjP2Java.model.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends MongoRepository<Carro, String> {
}
