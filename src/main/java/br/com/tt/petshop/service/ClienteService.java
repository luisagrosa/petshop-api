package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorCpf(String cpf){
        return clienteRepository. findByCpf(cpf);
    }

    public void atualizar(String cpf, Cliente cliente){
    // refatorar isso pq ta feio! TODO - refatorar quando fizermos os DTOs
        Cliente clienteASerSalvo = new Cliente(cliente.getId(),
                cliente.getNome(), cpf,
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getAnimais(),
                cliente.getUnidade());
        clienteRepository.save(clienteASerSalvo);
    }

    public void remover(String cpf){
        Cliente clienteASerRemovido =  clienteRepository.findByCpf(cpf);
        clienteRepository.delete(clienteASerRemovido);
    }

    public void criar(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
