package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missions.MissionModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NinjaDTO {

    private Long id;
    private String name;
    private int age;
    private String email;
    private String imgUrl;
    private NinjaRank rank;
    private String specialAbility;
    private MissionModel missions;
}
