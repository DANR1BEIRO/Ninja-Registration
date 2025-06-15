package dev.java10x.CadastroDeNinjas.Missions;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MissionRank rank;

    // @OneToMany (um para muitos): Uma MissionModel pode ter vários ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;
}
