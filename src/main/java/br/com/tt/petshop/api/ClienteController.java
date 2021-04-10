package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
    this.clienteService = clienteService;
}

@GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public List<Cliente> listar() {
    return clienteService.listar();

          /*  Arrays.asList(new Cliente(1L, "Gilberto",
            "111.111.111-11", "gilberto@tt.com", "99999999"),
            new Cliente(2L, "Tayhuzinha", "696.969.696-00",
                    "tayhuzinhabonitinho@cat.com", "969696969"));
            */
}

@PostMapping(value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@RequestBody Cliente cliente){
        clienteService.criar(cliente);

        URI location =  URI.create(String.format("/clientes/%s", cliente.getCpf()));
        return ResponseEntity.created(location)
                .build();
}

@GetMapping("/clientes/{cpf}")
    public Cliente buscarPorId(@PathVariable("cpf") String cpf){
        Cliente cliente = clienteService.buscarPorCpf(cpf);
        return cliente;
    }

@DeleteMapping("/clientes/{cpf}")// sempre que usa esse {} na URL tem que usar a anotação @PathVariable
public ResponseEntity remover(@PathVariable String cpf){
        clienteService.remover(cpf);
        return ResponseEntity.noContent().build();
}

@PutMapping("/clientes/{cpf}")
    public ResponseEntity atualizar(@PathVariable("cpf") String cpf, @RequestBody Cliente cliente) {
        clienteService.atualizar(cpf, cliente);
        return ResponseEntity.noContent().build();
}
}


