package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Animal;

import java.time.format.DateTimeFormatter;

public class AnimalConsultaDto {
    private String nome;
    private String tipo;
    private String nascimento;
    private String nomeTutor;


    public static AnimalConsultaDto createFromAnimal(Animal animal) {
        AnimalConsultaDto dto = new AnimalConsultaDto();
        dto.nome = animal.getNome();
        dto.tipo = animal.getTipoDeAnimal().name();
        dto.nascimento = animal.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dto.nomeTutor = animal.getTutor().getNome();
        return dto;
    }
}
