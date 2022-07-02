package com.softka.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Data
public class Bingo {

    private List<String> balotas = new ArrayList<>();
    private List<Gamer> jugadores = new ArrayList<>();
    private Gamer ganador;
    private Scanner sc = new Scanner(System.in);

    private Random num = new Random();

    public void agregarJugador(Gamer gamer){
        this.jugadores.add(gamer);
    }

    public void sacarBalotas(){

        String gan = "n";
        String respuesta = "n";
        do{
            int numero = this.num.nextInt(73)+1;
            if(!balotas.contains(String.valueOf(numero))){
                this.balotas.add(String.valueOf(numero));
                if(numero<16){
                    System.out.println("B"+numero);
                }else if(numero<31){
                    System.out.println("I"+numero);
                }else if(numero<46){
                    System.out.println("N"+numero);
                }else if(numero<61){
                    System.out.println("G"+numero);
                }else{
                    System.out.println("O"+numero);
                }
            }
            System.out.println("¿Tienes el número?");
            respuesta = this.sc.nextLine();
            if(respuesta.equalsIgnoreCase("s")){
                this.jugadores.get(0).taparNumero(String.valueOf(numero));
            }
            System.out.println("\n¿Hay ganador?");
            gan = this.sc.nextLine();

        }while (!gan.equalsIgnoreCase("s"));

        this.ganador = this.jugadores.get(0);
    }
}
