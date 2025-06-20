package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission") // diz para o spring que tudo abaixo será mapeado
public class MissionController {

    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    // Mapeia requisições HTTP GET. Usado para buscar/ler informações do servidor.
    @GetMapping("/all")
    public List<MissionDTO> displayAllMissions() {
        return missionService.displayAllMissions();
    }

    @GetMapping("/getbyid/{id}")
    public MissionDTO getMissionById(@PathVariable Long id) {
        return missionService.getMissionById(id);
    }

    // Mapeia requisições HTTP POST. Usado para enviar/criar novos recursos no servidor.
    @PostMapping("/create")
    public MissionDTO createMission(@RequestBody MissionDTO missionDTO) {
        return missionService.createMission(missionDTO);
    }

    // Mapeia requisições HTTP DELETE. Usado para remover um recurso do servidor.
    @DeleteMapping("/delete/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionService.deleteMissionById(id);
    }

    // Mapeia requisições HTTP PUT. Usado para substituir/atualizar um recurso inteiro no servidor.
    @PutMapping("/update/{id}")
    public MissionDTO updateMission(@PathVariable Long id, @RequestBody MissionDTO mission) {
        return missionService.updateMission(id, mission);
    }
}
