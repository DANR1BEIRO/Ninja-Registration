package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;
    private NinjaMapper ninjaMapper;

    public NinjaController(NinjaService ninjaService, NinjaMapper ninjaMapper) {
        this.ninjaService = ninjaService;
        this.ninjaMapper = ninjaMapper;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/all")
    public List<NinjaModel> displayAllNinjas() {
        return ninjaService.displayAllNinjas();
    }

    // Consultar ninja por ID (READ)
    @GetMapping("/getbyid/{id}")
    public Optional<NinjaModel> getNinjaById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    // Criar novo ninja (CREATE)
    @PostMapping("/create")
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.toEntity(ninjaDTO); //Converte DTO para Model (para o Service/Repository)
        NinjaModel savedNinja = ninjaService.createNinja(ninjaModel); //Chama o Service para salvar (trabalha com Model)
        return ninjaMapper.toDto(savedNinja); //Converte o Model salvo de volta para DTO (resposta da API)
    }

    // Remover ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
    }

    // Atualizar dados de um ninja (UPDATE)
    @PutMapping("/update/{id}")
    public NinjaModel updateNinjaById(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return ninjaService.updateNinja(id, ninja);
    }
}

/*
@GetMapping // Mapeia requisições HTTP GET. Usado para buscar/ler informações do servidor.
@PostMapping // Mapeia requisições HTTP POST. Usado para enviar/criar novos recursos no servidor.
@PutMapping // Mapeia requisições HTTP PUT. Usado para substituir/atualizar um recurso inteiro no servidor.
@PatchMapping // Mapeia requisições HTTP PATCH. Usado para atualizações parciais de um recurso.
@DeleteMapping // Mapeia requisições HTTP DELETE. Usado para remover um recurso do servidor.*/
