package dev.java10x.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public MissionDTO toDto(MissionModel missionModel) {
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setRank(missionModel.getRank());
        missionDTO.setNinjas(missionModel.getNinjas());

        return missionDTO;
    }

    public MissionModel toEntity(MissionDTO missionDTO) {
        MissionModel missionModel = new MissionModel();
        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setRank(missionDTO.getRank());
        missionModel.setNinjas(missionDTO.getNinjas());

        return missionModel;
    }
}
