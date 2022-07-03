package com.softka.contollers;

import com.softka.domain.Bingo;
import com.softka.domain.Carton;
import com.softka.domain.Gamer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class ControladorInicio {

    Bingo bingo = new Bingo();
    Gamer gamer = new Gamer();

    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "Hola mundo desde thymeleaf";
        log.info("Ejecutando el controlador rest");

        model.addAttribute("mensaje", mensaje);





        gamer.setNombre("Juan Diego");
        gamer.setEmail("juan@mail.com");
        gamer.setPassword("123");
//        gamer.setCarton(new Carton());

        model.addAttribute("lista1", gamer.getCarton().getFilaB());
        model.addAttribute("lista2", gamer.getCarton().getFilaI());
        model.addAttribute("lista3", gamer.getCarton().getFilaN());
        model.addAttribute("lista4", gamer.getCarton().getFilaG());
        model.addAttribute("lista5", gamer.getCarton().getFilaO());

        model.addAttribute("boton", bingo.sacarBalota());

        bingo.agregarJugador(gamer);
//        bingo.sacarBalotas();
//        System.out.println("\nGanador: " + bingo.getGanador());
//        System.out.println("Blotas ganador: " + bingo.getGanador().getNumerosTapados());
//        System.out.println("\nBalotas bingo: " + bingo.getBalotas());

        model.addAttribute("gamer", gamer.getNombre());
        model.addAttribute("clase", gamer.taparNumero());

        return "index";
    }
}
