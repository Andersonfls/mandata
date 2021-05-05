package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.TipoAdvogado;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoAdvogado entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoAdvogadoRepository extends JpaRepository<TipoAdvogado, Long>, JpaSpecificationExecutor<TipoAdvogado> {

}
