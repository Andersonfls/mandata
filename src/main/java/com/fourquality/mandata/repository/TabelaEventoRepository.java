package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.TabelaEvento;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TabelaEvento entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TabelaEventoRepository extends JpaRepository<TabelaEvento, Long>, JpaSpecificationExecutor<TabelaEvento> {

}
