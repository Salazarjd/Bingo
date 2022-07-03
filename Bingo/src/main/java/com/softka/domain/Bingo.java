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

//    public void sacarBalota(){
//
//        String gan = "n";
//        String respuesta = "n";
//        do{
//            int numero = this.num.nextInt(73)+1;
//            if(!balotas.contains(String.valueOf(numero))){
//                this.balotas.add(String.valueOf(numero));
//                if(numero<16){
//                    System.out.println("B"+numero);
//                }else if(numero<31){
//                    System.out.println("I"+numero);
//                }else if(numero<46){
//                    System.out.println("N"+numero);
//                }else if(numero<61){
//                    System.out.println("G"+numero);
//                }else{
//                    System.out.println("O"+numero);
//                }
//            }
//            System.out.println("¿Tienes el número?");
//            respuesta = this.sc.nextLine();
//            if(respuesta.equalsIgnoreCase("s")){
//                this.jugadores.get(0).taparNumero(String.valueOf(numero));
//            }
//            System.out.println("\n¿Hay ganador?");
//            gan = this.sc.nextLine();
//
//        }while (!gan.equalsIgnoreCase("s"));
//
//        this.ganador = this.jugadores.get(0);
//    }

    public String sacarBalota(){
        String resultado = "";
        int numero = this.num.nextInt(73)+1;
        if(!balotas.contains(String.valueOf(numero))){
            this.balotas.add(String.valueOf(numero));
            int pos;
            if(numero<16){
                if(this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaB().contains(String.valueOf(numero))){
                    pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaB().indexOf(String.valueOf(numero));
                    if(pos>0){
                        this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("B", pos, numero);
                    }
                }
                resultado = "B"+numero;
            }else if(numero<31){
                if(this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaI().contains(String.valueOf(numero))){
                    pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaI().indexOf(String.valueOf(numero));
                    if(pos>0){
                        this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("I", pos, numero);
                    }
                }
                resultado = ("I"+numero);
            }else if(numero<46){
                if(this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaN().contains(String.valueOf(numero))){
                    pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaN().indexOf(String.valueOf(numero));
                    if(pos>0){
                        this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("N", pos, numero);
                    }
                }
                resultado = ("N"+numero);
            }else if(numero<61){
                if(this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaG().contains(String.valueOf(numero))){
                    pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaG().indexOf(String.valueOf(numero));
                    if(pos>0){
                        this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("G", pos, numero);
                    }
                }
                resultado = ("G"+numero);
            }else{
                if(this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaO().contains(String.valueOf(numero))){
                    pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getFilaO().indexOf(String.valueOf(numero));
                    if(pos>0){
                        this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("O", pos, numero);
                    }
                }
                resultado = ("O"+numero);
            }
        }else{
            this.sacarBalota();
        }
        return resultado;
    }

}
