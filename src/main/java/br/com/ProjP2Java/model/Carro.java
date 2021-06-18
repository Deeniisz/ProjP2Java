package br.com.ProjP2Java.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document
public class Carro implements Serializable {

    @Id
    private String _id;
    private String idmarca;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(String idmarca) {
        this.idmarca = idmarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;

    public Carro(String id, String idmarca, String nome){
        this.idmarca = idmarca; this.nome = nome; this._id = id;
    }

    public Carro() {
    }

}
