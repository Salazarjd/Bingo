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
    boolean finalizado = false;

    private Random num = new Random();

    public void agregarJugador(Gamer gamer){
        this.jugadores.add(gamer);
    }


    public String sacarBalota(){
        String resultado = "";
        int numero = this.num.nextInt(73)+1;

        int pos;
        if(numero<16){
            if(this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaB().contains(String.valueOf(numero))){
                pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaB().indexOf(String.valueOf(numero));
                if(pos>0){
                    this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("B", pos, numero);
                }
            }
            resultado = "B"+numero;
        }else if(numero<31){
            if(this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaI().contains(String.valueOf(numero))){
                pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaI().indexOf(String.valueOf(numero));
                if(pos>0){
                    this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("I", pos, numero);
                }
            }
            resultado = ("I"+numero);
        }else if(numero<46){
            if(this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaN().contains(String.valueOf(numero))){
                pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaN().indexOf(String.valueOf(numero));
                if(pos>0){
                    this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("N", pos, numero);
                }
            }
            resultado = ("N"+numero);
        }else if(numero<61){
            if(this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaG().contains(String.valueOf(numero))){
                pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaG().indexOf(String.valueOf(numero));
                if(pos>0){
                    this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("G", pos, numero);
                }
            }
            resultado = ("G"+numero);
        }else{
            if(this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaO().contains(String.valueOf(numero))){
                pos = this.jugadores.get(this.jugadores.size()-1).getCarton().getColumnaO().indexOf(String.valueOf(numero));
                if(pos>0){
                    this.jugadores.get(this.jugadores.size()-1).getCarton().taparNumero("O", pos, numero);
                }
            }
            resultado = ("O"+numero);
        }

        if(!balotas.contains(String.valueOf(numero))){
            this.balotas.add(String.valueOf(numero));
        }
        return resultado;
    }

    public String juegoFinalizado(){
        String juego = this.jugadores.get(0).getCarton().cartonLleno();
        String resultado = "";
        if(this.finalizado){
            if(juego.equalsIgnoreCase("gano")){
                resultado = "Ganaste";
            }else{
                resultado = "No hay ganador";
                this.finalizado = false;
            }
        }

        return resultado;
    }

}
