package dev.java10x.CadastroDeNinjas.Missions;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MissionDTO {

    private Long id;
    private String name;
    private MissionRank rank;
    private List<NinjaModel> ninjas;
}
