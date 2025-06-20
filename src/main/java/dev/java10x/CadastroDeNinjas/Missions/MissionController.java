package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission") // diz para o spring que tudo abaixo será mapeado
public class MissionController {

    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MissionDTO>> displayAllMissions() {
        List<MissionDTO> missions = missionService.displayAllMissions();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getMissionById(@PathVariable Long id) {
        MissionDTO missionDTO = missionService.getMissionById(id);

        if (missionDTO != null) {
            return ResponseEntity.ok(missionDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " not found");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createMission(@RequestBody MissionDTO missionDTO) {
        MissionDTO newMission = missionService.createMission(missionDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission " + newMission.getName() +
                        " of rank " + newMission.getRank() + " created!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMissionById(@PathVariable Long id) {
        MissionDTO missionDTO = missionService.getMissionById(id);

        if (missionDTO != null) {
            missionService.deleteMissionById(id);
            return ResponseEntity.ok("Mission " + missionDTO.getName() + " (ID " + id + ") was deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " not found");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMission(@PathVariable Long id, @RequestBody MissionDTO missionDTO) {
        MissionDTO updatedMission = missionService.updateMission(id, missionDTO);

        if (updatedMission != null) {
            return ResponseEntity.ok("Mission updated!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " not found");
        }
    }
}



