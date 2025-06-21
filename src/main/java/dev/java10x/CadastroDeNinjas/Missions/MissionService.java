package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {

    private final MissionsRepository missionsRepository;
    private final MissionMapper missionMapper;

    public MissionService(MissionsRepository missionsRepository, MissionMapper missionMapper) {
        this.missionsRepository = missionsRepository;
        this.missionMapper = missionMapper;
    }

    public List<MissionDTO> displayAllMissions() {
        List<MissionModel> missions = missionsRepository.findAll();
        return missions.stream()
                .map(missionMapper::toDto)
                .collect(Collectors.toList());
    }

    public MissionDTO getMissionById(Long id) {
        Optional<MissionModel> missionById = missionsRepository.findById(id);
        return missionById.map(missionMapper::toDto).orElse(null);
    }

    public MissionDTO createMission(MissionDTO missionDTO) {
        MissionModel missionModel = missionMapper.toEntity(missionDTO);
        MissionModel savedMission = missionsRepository.save(missionModel);
        return missionMapper.toDto(savedMission);
    }

    public void deleteMissionById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Mission is null");
        }
        missionsRepository.deleteById(id);
    }

    public MissionDTO updateMission(Long id, MissionDTO missionDTO) {
        Optional<MissionModel> missionExist = missionsRepository.findById(id);
        if (missionExist.isPresent()) {
            MissionModel updatedMission = missionMapper.toEntity(missionDTO);
            updatedMission.setId(id);
            MissionModel savedMission = missionsRepository.save(updatedMission);
            return missionMapper.toDto(savedMission);
        }
        return null;
    }
}
