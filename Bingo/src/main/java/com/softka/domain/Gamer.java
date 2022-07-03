package com.softka.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Gamer {

    private String nombre;
    private String email;
    private String password;
    private Carton carton = new Carton();
    private List<String> numerosTapados = new ArrayList<>();

    public String taparNumero(){
//        String clase = "btn btn-primary";
//        clase = "btn btn-success";
//        boolean marcar = false;
//        if(marcar){
//            clase = "btn btn-success";
//        }
//        this.numerosTapados.add(num);
        return "btn btn-success";
    }
}
