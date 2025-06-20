package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/all")
    public List<NinjaDTO> displayAllNinjas() {
        return ninjaService.displayAllNinjas();
    }

    // Consultar ninja por ID (READ)
    @GetMapping("/getbyid/{id}")
    public  NinjaDTO getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    // Criar novo ninja (CREATE)
    @PostMapping("/create")
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.createNinja(ninjaDTO);

    }

    // Remover ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
    }

    // Atualizar dados de um ninja (UPDATE)
    @PutMapping("/update/{id}")
    public NinjaDTO updateNinjaById(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.updateNinja(id, ninja);
    }
}

/*
@GetMapping // Mapeia requisições HTTP GET. Usado para buscar/ler informações do servidor.
@PostMapping // Mapeia requisições HTTP POST. Usado para enviar/criar novos recursos no servidor.
@PutMapping // Mapeia requisições HTTP PUT. Usado para substituir/atualizar um recurso inteiro no servidor.
@PatchMapping // Mapeia requisições HTTP PATCH. Usado para atualizações parciais de um recurso.
@DeleteMapping // Mapeia requisições HTTP DELETE. Usado para remover um recurso do servidor.*/
