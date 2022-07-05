package com.softka.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Carton {

    private List<String> columnaB = new ArrayList<>();
    private List<String> columnaI = new ArrayList<>();
    private List<String> columnaN = new ArrayList<>();
    private List<String> columnaG = new ArrayList<>();
    private List<String> columnaO = new ArrayList<>();

    private List<String> numerosTapados = new ArrayList<>();

    public Carton(){
        this.columnaB.add("B");
        this.columnaI.add("I");
        this.columnaN.add("N");
        this.columnaG.add("G");
        this.columnaO.add("O");

        this.generarCarton();
    }

    public void llenarNumeros(List lista, int min, int max){
        Random num = new Random();
        String numero;
        while(lista.size()<6){
            numero = String.valueOf(num.nextInt(max-min+1)+min);
            if(!lista.contains(numero)){
                lista.add(numero);
            }
        }
    }

    public void generarCarton(){
        this.llenarNumeros(this.columnaB,1,15);
        this.llenarNumeros(this.columnaI,16,30);
        this.llenarNumeros(this.columnaN,31,45);
        this.llenarNumeros(this.columnaG,46,60);
        this.llenarNumeros(this.columnaO,61,75);
    }

    public void taparNumero(String fila, int pos, int num){
        this.numerosTapados.add(String.valueOf(num));
        if(fila.equalsIgnoreCase("B")){
            this.columnaB.set(pos, "x");
        }else if(fila.equalsIgnoreCase("I")){
            this.columnaI.set(pos,"x");
        }else if(fila.equalsIgnoreCase("N")){
            this.columnaN.set(pos,"x");
        }else if(fila.equalsIgnoreCase("G")){
            this.columnaG.set(pos,"x");
        }else if(fila.equalsIgnoreCase("O")){
            this.columnaO.set(pos,"x");
        }


    }

    public String cartonLleno(){
        String gano = "";
//        int contadorB = 0;
//        int contadorI = 0;
//        int contadorN = 0;
//        int contadorG = 0;
//        int contadorO = 0;
//
//        for(int i = 1; i < 6; i++){
//            if(!this.columnaB.get(i).equalsIgnoreCase("x")){
//                contadorB++;
//            }
//            if(!this.columnaI.get(i).equalsIgnoreCase("x")){
//                contadorI++;
//            }
//            if(!this.columnaN.get(i).equalsIgnoreCase("x")){
//                contadorN++;
//            }
//            if(!this.columnaG.get(i).equalsIgnoreCase("x")){
//                contadorG++;
//            }
//            if(!this.columnaO.get(i).equalsIgnoreCase("x")){
//                contadorO++;
//            }
//        }

        boolean cB = this.columnaB.get(1).equals("x") && this.columnaB.get(2).equals("x") && this.columnaB.get(3).equals("x")
                && this.columnaB.get(4).equals("x") && this.columnaB.get(5).equals("x");

        boolean cI = this.columnaI.get(1).equals("x") && this.columnaI.get(2).equals("x") && this.columnaI.get(3).equals("x")
                && this.columnaI.get(4).equals("x") && this.columnaI.get(5).equals("x");

        boolean cN = this.columnaN.get(1).equals("x") && this.columnaN.get(2).equals("x") && this.columnaN.get(3).equals("x")
                && this.columnaN.get(4).equals("x") && this.columnaN.get(5).equals("x");

        boolean cG = this.columnaG.get(1).equals("x") && this.columnaG.get(2).equals("x") && this.columnaG.get(3).equals("x")
                && this.columnaG.get(4).equals("x") && this.columnaG.get(5).equals("x");

        boolean cO = this.columnaO.get(1).equals("x") && this.columnaO.get(2).equals("x") && this.columnaO.get(3).equals("x")
                && this.columnaO.get(4).equals("x") && this.columnaO.get(5).equals("x");

        boolean f1 = this.columnaB.get(1).equals("x") && this.columnaI.get(1).equals("x") && this.columnaN.get(1).equals("x")
                && this.columnaG.get(1).equals("x") && this.columnaO.get(1).equals("x");

        boolean f2 = this.columnaB.get(2).equals("x") && this.columnaI.get(2).equals("x") && this.columnaN.get(2).equals("x")
                && this.columnaG.get(2).equals("x") && this.columnaO.get(2).equals("x");

        boolean f3 = this.columnaB.get(3).equals("x") && this.columnaI.get(3).equals("x") && this.columnaN.get(3).equals("x")
                && this.columnaG.get(3).equals("x") && this.columnaO.get(3).equals("x");

        boolean f4 = this.columnaB.get(4).equals("x") && this.columnaI.get(4).equals("x") && this.columnaN.get(4).equals("x")
                && this.columnaG.get(4).equals("x") && this.columnaO.get(4).equals("x");

        boolean f5 = this.columnaB.get(5).equals("x") && this.columnaI.get(5).equals("x") && this.columnaN.get(5).equals("x")
                && this.columnaG.get(5).equals("x") && this.columnaO.get(5).equals("x");

        boolean diagonal1 = this.columnaB.get(1).equals("x") && this.columnaI.get(2).equals("x") && this.columnaN.get(3).equals("x")
                && this.columnaG.get(4).equals("x") && this.columnaO.get(5).equals("x");

        boolean diagonal2 = this.columnaB.get(5).equals("x") && this.columnaI.get(4).equals("x") && this.columnaN.get(3).equals("x")
                && this.columnaG.get(2).equals("x") && this.columnaO.get(1).equals("x");


        if(cB || cI || cN || cG || cO || f1 || f2 || f3 || f4 || f5 || diagonal1 || diagonal2){
            gano = "Gano";
        }else{
            gano = "Bingo";
        }

        return gano;
    }

}
