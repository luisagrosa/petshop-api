package br.com.tt.petshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_unidade")
public class Unidade {
    @Id
    @GeneratedValue
    private Long idDaUnidade;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String telefone;

    @Column
    private String email;


    public void setIdDaUnidade(Long idDaUnidade) {
        this.idDaUnidade = idDaUnidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
