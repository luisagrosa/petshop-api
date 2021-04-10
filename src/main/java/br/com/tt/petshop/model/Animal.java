package br.com.tt.petshop.model;

import br.com.tt.petshop.dto.AnimalCriacaoDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tb_animal")
public class Animal {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoAnimal;

    @Column
    private LocalDate nascimento; // TODO: nao tem um tipo pra data ja , trocar o tipo

    @Column
    private String nome;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoDeAnimal tipoDeAnimal;

    @Column
    private Long idDoCliente;

    @Column
    private int peso;

    @Column
    private String cor;

    @ManyToOne
    @JoinColumn(name ="cliente_id")
    private Cliente tutor;

    public static Animal fromDto(AnimalCriacaoDto animalDto, Cliente tutor) {
        Animal animal = new Animal();
        animal.nome = animalDto.getNome();
        animal.cor = animalDto.getCor();
        animal.nascimento = LocalDate.parse(animalDto.getNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        animal.tipoDeAnimal = animalDto.getTipo();
        animal.peso = animalDto.getPeso();
        return animal;

    }

    public Long getIdDoAnimal() {
        return idDoAnimal;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeAnimal getTipoDeAnimal() {
        return tipoDeAnimal;
    }

    public int getPeso() {
        return peso;
    }

    public String getCor() {
        return cor;
    }

    public Cliente getTutor() {
        return tutor;
    }

    Animal(){}

    @JsonCreator // TODO precisou do JSON creator sera
    public Animal(Long id, LocalDate nascimento, String nome, TipoDeAnimal tipoDeAnimal,
                   int peso, String cor, Cliente tutor){
        this.idDoAnimal = id;
        this.nascimento = nascimento;
        this.nome = nome;
        this.tipoDeAnimal = tipoDeAnimal;
        this.peso = peso;
        this.cor = cor;
        this.tutor = tutor;
    }
}
