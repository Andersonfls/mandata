package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.TipoCliente;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoCliente entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long>, JpaSpecificationExecutor<TipoCliente> {

}
