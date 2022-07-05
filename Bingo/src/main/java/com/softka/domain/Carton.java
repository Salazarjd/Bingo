package com.softka.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Representa un carton de bingo con cada una de sus carácteristicas
 * @Author Juan Diego Salazar
 */
@Data
public class Carton {

    /**
     * Representa la columna correspondiente a la letra B del bingo
     */
    private List<String> columnaB = new ArrayList<>();

    /**
     * Representa la columna correspondiente a la letra I del bingo
     */
    private List<String> columnaI = new ArrayList<>();

    /**
     * Representa la columna correspondiente a la letra N del bingo
     */
    private List<String> columnaN = new ArrayList<>();

    /**
     * Representa la columna correspondiente a la letra G del bingo
     */
    private List<String> columnaG = new ArrayList<>();

    /**
     * Representa la columna correspondiente a la letra O del bingo
     */
    private List<String> columnaO = new ArrayList<>();


    /**
     * Método para inicializar una instancia de la clase Carton
     */
    public Carton(){
        this.columnaB.add("B");
        this.columnaI.add("I");
        this.columnaN.add("N");
        this.columnaG.add("G");
        this.columnaO.add("O");

        this.generarCarton();
    }

    /**
     * Método para generar números aleatorios para ingresarlos en cada columba del bingo
     * @param lista cada columba del cartón del bingo
     * @param min número mínimo que puede tomar
     * @param max número máximo a asignar
     */
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

    /**
     * Método para generar el llenado de manera aleatoria de cada una de las columnas del bingo
     */
    public void generarCarton(){
        this.llenarNumeros(this.columnaB,1,15);
        this.llenarNumeros(this.columnaI,16,30);
        this.llenarNumeros(this.columnaN,31,45);
        this.llenarNumeros(this.columnaG,46,60);
        this.llenarNumeros(this.columnaO,61,75);
    }

    /**
     * Método para ir llenando el cartón a medida que van saliendo los números del bingo
     * @param fila fila del cartón de bingo
     * @param pos posición del número dentro de la columna (ArrayList)
     * @param num número a tapar en el cartón
     */
    public void taparNumero(String fila, int pos, int num){
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

    /**
     * /Método para comprobar si efectivamente el usuario ha ganado el bingo
     * @return Cadena de texto informando y hay ganador o si el bingo sigue en juego
     */
    public String cartonLleno(){
        String gano = "";

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
