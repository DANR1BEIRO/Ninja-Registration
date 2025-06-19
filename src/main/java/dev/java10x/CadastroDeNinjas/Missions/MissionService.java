package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    private MissionsRepository missionsRepository;

    public MissionService(MissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    public List<MissionModel> displayAllMissions() {
        return missionsRepository.findAll();
    }

    public Optional<MissionModel> getMissionById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Mission can't be null");
        }
        return missionsRepository.findById(id);
    }

    public MissionModel createMission(MissionModel mission) {
        return missionsRepository.save(mission);
    }

    public void deleteMissionById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Mission is null");
        }
        missionsRepository.deleteById(id);
    }

    public MissionModel updateMission(Long id, MissionModel mission) {
        if (missionsRepository.existsById(id)) {
            mission.setId(id);
            return missionsRepository.save(mission);
        }
        return null;
    }
}
