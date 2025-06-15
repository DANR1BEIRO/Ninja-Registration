package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missions.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_ninja_registration")
@Data // cria automaticamente todos os getters e setters
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ninja_id")
    private Long id; // apenas declara, pois o java faz a implementacao

    @Column(name = "ninja_name")
    private String name;

    @Column(name = "ninja_age")
    private int age;

    @Column(unique = true)
    private String email;

    @Column(name = "ninja_img_url")
    private String imgUrl;

    private NinjaRank rank;

    // @ManyToOne (muitos para um): Muitos NinjaModel podem ter uma única MissionModel
    @ManyToOne
    @JoinColumn(name = "missions_id") // Foreign key (chave estrangeira)
    private MissionModel missions;

    /**
     * Chave Estrangeira: Aparece toda vez que forem colocadas
     * duas ou mais tabelas para se relacionarem.
     * Tem um mapa para o que está vindo que cada tabela relacionada
     */
}

/*
A anotação @Entity é uma anotação fundamental no Jakarta Persistence API (JPA),
usada no Spring Boot (e outros frameworks Java) para mapear uma classe Java como
uma tabela no banco de dados. Ela indica que a classe é uma entidade persistente,
ou seja, seus objetos podem ser salvos, recuperados, atualizados ou excluídos (CRUD)
 em um banco de dados relacional.

Função da @Entity
Transforma uma classe Java em uma entidade gerenciada pelo JPA/Hibernate.
Cada instância dessa classe representa uma linha em uma tabela do banco de dados.
O nome da tabela é, por padrão, o mesmo nome da classe, mas pode ser customizado
com @Table(name = "nome_da_tabela").

Quando Usar @Entity?

Quando queremos persistir objetos em um banco de dados relacional (MySQL, PostgreSQL, etc.).
Em aplicações Spring Boot com Spring Data JPA (para criar repositórios com JpaRepository).

Para aproveitar recursos como:
  - Consultas automáticas (métodos findByNome, etc.).
  - Transações (@Transactional).
  - Relacionamentos (@OneToMany, @ManyToOne).
*/
