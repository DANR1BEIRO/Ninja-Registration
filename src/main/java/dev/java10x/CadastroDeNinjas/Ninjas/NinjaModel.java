package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missions.MissionModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_ninja_registration")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // apenas declara, pois o java faz a implementacao

    private String name;
    private int age;
    private String email;
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

    public NinjaModel() {
    }

    public NinjaModel(String name, int age, String email, NinjaRank rank) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NinjaRank getRank() {
        return rank;
    }

    public void setRank(NinjaRank rank) {
        this.rank = rank;
    }
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
