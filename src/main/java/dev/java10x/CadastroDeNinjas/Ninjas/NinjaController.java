package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> displayAllNinjas() {
        List<NinjaDTO> ninjas = ninjaService.displayAllNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getNinjaById(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.getNinjaById(id);

        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " not found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO newNinja = ninjaService.createNinja(ninjaDTO);

        return ResponseEntity.ok()
                .body("Ninja " + newNinja.getName() + " created!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinjaById(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.getNinjaById(id);

        if (ninjaDTO != null) {
            ninjaService.deleteNinjaById(id);
            return ResponseEntity.ok("Ninja " + ninjaDTO.getName() + " (ID " + id + ") was deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " not found");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNinjaById(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO updatedNinja = ninjaService.updateNinja(id, ninjaDTO);

        if (updatedNinja != null) {
            return ResponseEntity.ok("Ninja updated!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " not found");
        }
    }
}

/*
@GetMapping // Mapeia requisições HTTP GET. Usado para buscar/ler informações do servidor.
@PostMapping // Mapeia requisições HTTP POST. Usado para enviar/criar novos recursos no servidor.
@PutMapping // Mapeia requisições HTTP PUT. Usado para substituir/atualizar um recurso inteiro no servidor.
@PatchMapping // Mapeia requisições HTTP PATCH. Usado para atualizações parciais de um recurso.
@DeleteMapping // Mapeia requisições HTTP DELETE. Usado para remover um recurso do servidor.*/
