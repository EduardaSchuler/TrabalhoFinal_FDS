package com.trabalhofinal.application.Controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.application.dtos.ClienteDTO;
import com.trabalhofinal.application.usecase.ListaClientesUC;
import com.trabalhofinal.domain.model.Cliente;
import com.trabalhofinal.domain.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Controller {
    private ListaClientesUC listaClientesUC;

    @Autowired
    public Controller(ListaClientesUC listaClientesUC){
        this.listaClientesUC = listaClientesUC;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return "TA RODANDO ESSE CARALHO";
    }

    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClienteDTO> clientes() {
        return listaClientesUC.executa();
    }
    
}
