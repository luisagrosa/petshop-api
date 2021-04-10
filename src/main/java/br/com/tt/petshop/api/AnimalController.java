package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalConsultaDto;
import br.com.tt.petshop.dto.AnimalCriacaoDto;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }
@GetMapping(value="/animais", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalConsultaDto> lista(){
    return animalService.listar();
}

@PostMapping(value = "/animais", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar (@RequestBody AnimalCriacaoDto animalDto) {
    Long animalId = animalService.criar(animalDto);
    String location = String.format("/animais/%s", animalId);
    return ResponseEntity.created(URI.create("/animais/"+animalId)).build();
}
}
