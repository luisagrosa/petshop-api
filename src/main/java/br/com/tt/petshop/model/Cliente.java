package br.com.tt.petshop.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @Column
    private Long id;

    @Column(name = "txt_nome")
    private String nome;

    @Column
    private String cpf;

    @Column
    private String email;

    @Column
    private String telefone;

    @OneToMany(
            mappedBy = "tutor",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL // reflete operações de update/delete nos animais
    )
    private List<Animal> animais;

    @ManyToOne
    @JoinColumn(name="unidade_id")
    private Unidade unidade;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public Unidade getUnidade() {return unidade; }

    Cliente(){

    }

    @JsonCreator
    public Cliente(@JsonProperty("id") Long id,
                   @JsonProperty("nome")String nome,
                   @JsonProperty("cpf")String cpf,
                   @JsonProperty("email")String email,
                   @JsonProperty("telefone")String telefone,
                   @JsonProperty("animais") List<Animal> animais,
                   @JsonProperty("unidade") Unidade unidade){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.animais = animais;
        this.unidade = unidade;
    }
}
