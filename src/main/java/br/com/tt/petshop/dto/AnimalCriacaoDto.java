package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.TipoDeAnimal;

public class AnimalCriacaoDto {
    private String nome;
    private TipoDeAnimal tipo;
    private String nascimento;
    private String cpfCliente;
    private int peso;
    private String cor;

    public String getNome() {
        return nome;
    }

    public TipoDeAnimal getTipo() {
        return tipo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public int getPeso() {
        return peso;
    }

    public String getCor() {
        return cor;
    }
}
