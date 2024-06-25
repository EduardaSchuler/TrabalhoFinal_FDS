package com.trabalhofinal.adapters.Controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.application.dtos.AplicativoDTO;
import com.trabalhofinal.application.dtos.ClienteDTO;
import com.trabalhofinal.application.usecase.ListaAplicativoUC;
import com.trabalhofinal.application.usecase.ListaClientesUC;
import com.trabalhofinal.domain.model.ClienteModel;
import com.trabalhofinal.domain.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Controller {
    private ListaClientesUC listaClientesUC;
    private ListaAplicativoUC listaAplicativoUC;

    @Autowired
    public Controller(ListaClientesUC listaClientesUC, ListaAplicativoUC listaAplicativoUC){
        this.listaClientesUC = listaClientesUC;
        this.listaAplicativoUC = listaAplicativoUC;
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
    
    @GetMapping("/servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<AplicativoDTO> aplicativos() {
        return listaAplicativoUC.executa();
    }
}
