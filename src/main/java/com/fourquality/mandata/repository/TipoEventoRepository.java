package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.TipoEvento;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoEvento entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Long>, JpaSpecificationExecutor<TipoEvento> {

}
