package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.AdvogadoCliente;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the AdvogadoCliente entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Advogado_clienteRepository extends JpaRepository<AdvogadoCliente, Long> {

    @Query("select advogado_cliente from AdvogadoCliente advogado_cliente where advogado_cliente.cliente.login = ?#{principal.username}")
    List<AdvogadoCliente> findByClienteIsCurrentUser();

    List<AdvogadoCliente> findAllByClienteId(Long id);
}
