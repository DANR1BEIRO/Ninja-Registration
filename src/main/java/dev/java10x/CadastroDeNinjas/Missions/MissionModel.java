package dev.java10x.CadastroDeNinjas.Missions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data // getters e setters
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private MissionRank rank;

    // @OneToMany (um para muitos): Uma MissionModel pode ter vários ninjas
    @OneToMany(mappedBy = "missions")
    @JsonIgnore // ignora a serializacao para parar o loop
    private List<NinjaModel> ninjas;
}
