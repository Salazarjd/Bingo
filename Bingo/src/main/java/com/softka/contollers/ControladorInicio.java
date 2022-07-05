package com.softka.contollers;

import com.softka.domain.Bingo;
import com.softka.domain.Gamer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    Bingo bingo = new Bingo();
    Gamer gamer = new Gamer();

    @GetMapping("/")
    public String inicio(Model model){

        gamer.setNombre("Juan Diego");
        gamer.setEmail("juan@mail.com");
        gamer.setPassword("123");
        bingo.agregarJugador(gamer);

        model.addAttribute("lista1", gamer.getCarton().getColumnaB());
        model.addAttribute("lista2", gamer.getCarton().getColumnaI());
        model.addAttribute("lista3", gamer.getCarton().getColumnaN());
        model.addAttribute("lista4", gamer.getCarton().getColumnaG());
        model.addAttribute("lista5", gamer.getCarton().getColumnaO());

        model.addAttribute("boton", bingo.sacarBalota());

        model.addAttribute("bingo",gamer.getCarton().cartonLleno());


        return "index";
    }
}
