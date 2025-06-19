package dev.java10x.CadastroDeNinjas.Missions;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mission") // diz para o spring que tudo abaixo será mapeado
public class MissionController {

    private MissionService missionService;
    private MissionMapper missionMapper;

    public MissionController(MissionService missionService, MissionMapper missionMapper) {
        this.missionService = missionService;
        this.missionMapper = missionMapper;
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
    public MissionDTO createMission(@RequestBody MissionDTO missionDTO) {
        MissionModel missionModel = missionMapper.toEntity(missionDTO);
        MissionModel savedMission = missionService.createMission(missionModel);
        return missionMapper.toDto(savedMission);
    }

    // Mapeia requisições HTTP DELETE. Usado para remover um recurso do servidor.
    @DeleteMapping("/delete/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionService.deleteMissionById(id);
    }

    // Mapeia requisições HTTP PUT. Usado para substituir/atualizar um recurso inteiro no servidor.
    @PutMapping("/update/{id}")
    public MissionModel updateMission(@PathVariable Long id, @RequestBody MissionModel mission) {
        return missionService.updateMission(id, mission);
    }


}
