package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mission") // diz para o spring que tudo abaixo será mapeado
public class MissionController {

    // Mapeia requisições HTTP GET. Usado para buscar/ler informações do servidor.
    @GetMapping("/all")
    public String displayAllMissions() {
        return "Displaying all missions";
    }

    // Mapeia requisições HTTP POST. Usado para enviar/criar novos recursos no servidor.
    @PostMapping("/create")
    public String createMission() {
        return "Mission created!";
    }

    // Mapeia requisições HTTP PUT. Usado para substituir/atualizar um recurso inteiro no servidor.
    @PutMapping("/update")
    public String updateMission() {
        return "Updating mission";
    }

    // Mapeia requisições HTTP DELETE. Usado para remover um recurso do servidor.
    @DeleteMapping("/delete")
    public String deleteMission() {
        return "Mission deleted";
    }


}
