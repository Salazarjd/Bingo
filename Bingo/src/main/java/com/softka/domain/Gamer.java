package com.softka.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Gamer {

    private String nombre;
    private String email;
    private String password;
    private Carton carton;
    private List<String> numerosTapados = new ArrayList<>();

    public void taparNumero(String num){
        this.numerosTapados.add(num);
    }
}
