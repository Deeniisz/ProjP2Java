package br.com.ProjP2Java.controller;

import br.com.ProjP2Java.constant.Constant;
import br.com.ProjP2Java.model.Carro;
import br.com.ProjP2Java.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;

@RestController
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping(Constant.API_CARRO)
    public void save(@RequestBody Carro carro){
        carroService.sendProductRabbit(carro); }

    @GetMapping(Constant.API_CARRO)
    public List<Carro> findAll(){
        return carroService.findAll();
    }

    @PutMapping(Constant.API_CARRO)
    public void update (@RequestBody Carro carro){
        carroService.save(carro);
    }

    @DeleteMapping(Constant.API_CARRO + "/{id}")
    public void delete(@PathVariable("id") String id){
        carroService.delete(id);
    }

    @GetMapping(Constant.API_CARRO + "/{id}")
    @Cacheable("carro")
    public Optional<Carro> findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return carroService.findById(id);
    }
}
