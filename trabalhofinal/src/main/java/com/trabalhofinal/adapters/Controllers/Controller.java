package com.trabalhofinal.adapters.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.application.dtos.AplicativoDTO;
import com.trabalhofinal.application.dtos.AssinaturaDTO;
import com.trabalhofinal.application.dtos.ClienteDTO;
import com.trabalhofinal.application.usecase.ListaAplicativoUC;
import com.trabalhofinal.application.usecase.ListaAssinaturasPorTipoUC;
import com.trabalhofinal.application.usecase.ListaClientesUC;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class Controller {
    private ListaClientesUC listaClientesUC;
    private ListaAplicativoUC listaAplicativoUC;
    private ListaAssinaturasPorTipoUC listaAssinaturasPorTipoUC;

    @Autowired
    public Controller(ListaClientesUC listaClientesUC, ListaAplicativoUC listaAplicativoUC,
                        ListaAssinaturasPorTipoUC listaAssinaturasPorTipoUC){
        this.listaClientesUC = listaClientesUC;
        this.listaAplicativoUC = listaAplicativoUC;
        this.listaAssinaturasPorTipoUC = listaAssinaturasPorTipoUC;
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

    @GetMapping("/servcad/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> assinaturasPorTipo(@PathVariable(value="tipo") String tipo) {
        return listaAssinaturasPorTipoUC.executa(tipo);
    }
}
