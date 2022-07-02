package com.softka.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Carton {

    private List<String> filaB = new ArrayList<>();
    private List<String> filaI = new ArrayList<>();
    private List<String> filaN = new ArrayList<>();
    private List<String> filaG = new ArrayList<>();
    private List<String> filaO = new ArrayList<>();

    private List<String> numerosTapados = new ArrayList<>();

    public Carton(){
        this.filaB.add("B");
        this.filaI.add("I");
        this.filaN.add("N");
        this.filaG.add("G");
        this.filaO.add("O");

        this.generarCarton();
    }

    public void llenarNumeros(List lista, int min, int max){
        Random num = new Random();
        while(lista.size()<6){
            int numero = num.nextInt(max-min+1)+min;
            if(!lista.contains(numero)){
                lista.add(numero);
            }
        }
    }

    public void generarCarton(){
        this.llenarNumeros(this.filaB,1,15);
        this.llenarNumeros(this.filaI,16,30);
        this.llenarNumeros(this.filaN,31,45);
        this.llenarNumeros(this.filaG,46,60);
        this.llenarNumeros(this.filaO,61,75);
    }

    public void taparNumero(String num){
        this.numerosTapados.add(num);
    }

}
