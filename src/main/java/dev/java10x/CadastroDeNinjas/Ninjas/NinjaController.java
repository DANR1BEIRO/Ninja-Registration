package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")  // Mapeia requisições HTTP GET. Usado para buscar/ler informações do servidor.
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

}


/*
@PostMapping // Mapeia requisições HTTP POST. Usado para enviar/criar novos recursos no servidor.
@PutMapping // Mapeia requisições HTTP PUT. Usado para substituir/atualizar um recurso inteiro no servidor.
@PatchMapping // Mapeia requisições HTTP PATCH. Usado para atualizações parciais de um recurso.
@DeleteMapping *///  Mapeia requisições HTTP DELETE. Usado para remover um recurso do servidor.