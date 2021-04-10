package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

    /* List<Cliente> findByCpfAndNome(String cpf, String nome);
    List<Cliente> findByNascimentoBetween(LocalDate inicio, LocalDate fim);
    List<Cliente> findByTelefoneIsNullOrderByCpf();
    */
}

