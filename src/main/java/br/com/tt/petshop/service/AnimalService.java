package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AnimalConsultaDto;
import br.com.tt.petshop.dto.AnimalCriacaoDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {


    private final AnimalRepository animalRepository;
    private final ClienteService clienteService;

    public AnimalService(AnimalRepository animalRepository, ClienteService clienteService){
        this.animalRepository = animalRepository;
        this.clienteService = clienteService;
    }

    public List<AnimalConsultaDto> listar(){
        List<Animal> animais = animalRepository.findAll();
        List<AnimalConsultaDto> dtos = new ArrayList<>();

        for(Animal animal: animais){
            dtos.add(AnimalConsultaDto.createFromAnimal(animal));
        }
        return dtos;
    }

    public Long criar(AnimalCriacaoDto animalDto) {

        Cliente tutor = clienteService.buscarPorCpf(animalDto.getCpfCliente());
        Animal animal = Animal.fromDto(animalDto, tutor);
        Animal animalSalvoo = animalRepository.save(animal);
        return animalSalvoo.getIdDoAnimal();
    }


}

