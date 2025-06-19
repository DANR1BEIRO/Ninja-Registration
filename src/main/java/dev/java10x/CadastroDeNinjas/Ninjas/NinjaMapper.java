package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaDTO toDto(NinjaModel ninjaModel) {
        if (ninjaModel == null) return null;

        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setSpecialAbility(ninjaModel.getSpecialAbility());
        ninjaDTO.setMissions(ninjaModel.getMissions());
        return ninjaDTO;
    }

    public NinjaModel toEntity(NinjaDTO ninjaDTO) {
        if (ninjaDTO == null) return null;

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setSpecialAbility(ninjaDTO.getSpecialAbility());
        ninjaModel.setMissions(ninjaDTO.getMissions());
        return ninjaModel;
    }
}
