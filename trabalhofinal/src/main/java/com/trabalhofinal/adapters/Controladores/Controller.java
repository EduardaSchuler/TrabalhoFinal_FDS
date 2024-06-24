package com.trabalhofinal.adapters.Controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.application.usecase.ListaClientesUC;
import com.trabalhofinal.domain.model.Cliente;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Controller {
    private ListaClientesUC listaClientesUC;

    public Controller(ListaClientesUC listaClientesUC){
        this.listaClientesUC = listaClientesUC;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return "TA RODANDO ESSE CARALHO";
    }

    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<Cliente> clientes() {
        return listaClientesUC.executa();
    }
    
}
