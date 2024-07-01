package com.trabalhofinal.adapters.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.application.dtos.AplicativoDTO;
import com.trabalhofinal.application.dtos.AssinaturaDTO;
import com.trabalhofinal.application.dtos.ClienteDTO;
import com.trabalhofinal.application.dtos.PagamentoDTO;
import com.trabalhofinal.application.usecase.AssinaturaValidaUC;
import com.trabalhofinal.application.usecase.AtualizaCustoAppUC;
import com.trabalhofinal.application.usecase.CriaAssinatura;
import com.trabalhofinal.application.usecase.ListaAplicativoUC;
import com.trabalhofinal.application.usecase.ListaAssinaturasPorAppUC;
import com.trabalhofinal.application.usecase.ListaAssinaturasPorClienteUC;
import com.trabalhofinal.application.usecase.ListaAssinaturasPorTipoUC;
import com.trabalhofinal.application.usecase.ListaClientesUC;
import com.trabalhofinal.application.usecase.RegistrarPagamentoUC;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controller {
    private ListaClientesUC listaClientesUC;
    private ListaAplicativoUC listaAplicativoUC;
    private ListaAssinaturasPorTipoUC listaAssinaturasPorTipoUC;
    private ListaAssinaturasPorClienteUC listaAssinaturasPorClienteUC;
    private ListaAssinaturasPorAppUC listaAssinaturasPorAppUC;
    private AssinaturaValidaUC assinaturaValidaUC;
    private CriaAssinatura criaAssinatura;
    private AtualizaCustoAppUC atualizaCustoAppUC;
    private RegistrarPagamentoUC registrarPagamentoUC;

    public Controller(ListaClientesUC listaClientesUC, ListaAplicativoUC listaAplicativoUC,
                        ListaAssinaturasPorTipoUC listaAssinaturasPorTipoUC, ListaAssinaturasPorClienteUC listaAssinaturasPorClienteUC,
                        ListaAssinaturasPorAppUC listaAssinaturasPorAppUC, AssinaturaValidaUC assinaturaValidaUC,
                        CriaAssinatura criaAssinatura, AtualizaCustoAppUC atualizaCustoAppUC, RegistrarPagamentoUC registrarPagamentoUC){
        this.listaClientesUC = listaClientesUC;
        this.listaAplicativoUC = listaAplicativoUC;
        this.listaAssinaturasPorTipoUC = listaAssinaturasPorTipoUC;
        this.listaAssinaturasPorClienteUC = listaAssinaturasPorClienteUC;
        this.listaAssinaturasPorAppUC = listaAssinaturasPorAppUC;
        this.assinaturaValidaUC = assinaturaValidaUC;
        this.criaAssinatura = criaAssinatura;
        this.atualizaCustoAppUC = atualizaCustoAppUC;
        this.registrarPagamentoUC = registrarPagamentoUC;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return "Pagina Inicial";
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

    @GetMapping("/servcad/asscli/{codcli}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> assinaturasPorCliente(@PathVariable(value="codcli") long codcli) {
        return listaAssinaturasPorClienteUC.executa(codcli);
    }

    @GetMapping("/servcad/assapp/{codapp}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> assinaturasPorApp(@PathVariable(value="codapp") long codapp) {
        return listaAssinaturasPorAppUC.executa(codapp);
    }

    @GetMapping("/assinvalida/{codass}")
    @CrossOrigin(origins = "*")
    public boolean assinaturaValida(@PathVariable(value="codass") long codass) {
        return assinaturaValidaUC.executa(codass);
    }

    @PostMapping("/servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaNovaAssinatura(@RequestBody Map<String, Long> payload) {
        long codigoCliente = payload.get("codigoCliente");
        long codigoApp = payload.get("codigoApp");

        return criaAssinatura.executa(codigoCliente, codigoApp);
    }

    @PostMapping("/registrarpagamento")
    @CrossOrigin(origins = "*")
    public String regitrarPagamento(@RequestBody Map<String, Long> codigos, @RequestBody Map<String, Double> valorPago, @RequestBody Map<String, String> promocao) {
        long codigo = codigos.get("codigo");
        long codigoAssinatura = codigos.get("codigoAssinatura");
        Double valor = valorPago.get("valorPago");
        String promo = promocao.get("promocao");
        
        return registrarPagamentoUC.executa(codigo, codigoAssinatura, valor, promo);
    }

    @PostMapping("/servcad/aplicativos/{idAplicativo}")
    @CrossOrigin(origins = "*")
    public AplicativoDTO AtualizaCustoAplicativo(@PathVariable(value= "idAplicativo") long idAplicativo, @RequestBody Map<String, Double> payload) {
        Double novoCusto = payload.get("novoCusto");
        return atualizaCustoAppUC.executa(idAplicativo, novoCusto);
    }
}
