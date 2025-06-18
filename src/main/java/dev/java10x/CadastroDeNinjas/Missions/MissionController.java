package dev.java10x.CadastroDeNinjas.Missions;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mission") // diz para o spring que tudo abaixo será mapeado
public class MissionController {

    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    // Mapeia requisições HTTP GET. Usado para buscar/ler informações do servidor.
    @GetMapping("/all")
    public List<MissionModel> displayAllMissions() {
        return missionService.displayAllMissions();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<MissionModel> getMissionById(@PathVariable Long id) {
        return missionService.getMissionById(id);
    }


    // Mapeia requisições HTTP POST. Usado para enviar/criar novos recursos no servidor.
    @PostMapping("/create")
    public MissionModel createMission(@RequestBody MissionModel mission) {
        return missionService.createMission(mission);
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
