package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() { return "Essa é minha primeira mensagem nessa rota";}

    // Criar novo ninja (CREATE)
    @PostMapping("/create")
    public String createNinja() {
        return "Ninja created!";
    }

    // Consultar ninja por ID (READ)
    @GetMapping("/allid")
    public String getNinjaById() {
        return "Displaying ninjas by ID";
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/all")
    public String displayAllNinjas() {
        return "Displaying all ninjas";
    }

    // Atualizar dados de um ninja (UPDATE)
    @PutMapping("/updateid")
    public String updateNinjaById() {
        return "Updating ninja by ID ";
    }

    // Remover ninja (DELETE)
    @DeleteMapping("/deleteid")
    public String deleteNinjaById() {
        return "Ninja deleted by ID";
    }
}

/*
@GetMapping // Mapeia requisições HTTP GET. Usado para buscar/ler informações do servidor.
@PostMapping // Mapeia requisições HTTP POST. Usado para enviar/criar novos recursos no servidor.
@PutMapping // Mapeia requisições HTTP PUT. Usado para substituir/atualizar um recurso inteiro no servidor.
@PatchMapping // Mapeia requisições HTTP PATCH. Usado para atualizações parciais de um recurso.
@DeleteMapping *///  Mapeia requisições HTTP DELETE. Usado para remover um recurso do servidor.
