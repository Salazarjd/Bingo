package com.softka.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa al jugador del bingo con sus principales datos personales
 * @Author Juan Diego Salazar
 */
@Data
public class Gamer {

    /**
     * Representa el nombre del usuario
     */
    private String nombre;

    /**
     * Representa el correo electrónico del usuario
     */
    private String email;

    /**
     * Representa el carton del bingo del usuario
     */
    private Carton carton = new Carton();

}
