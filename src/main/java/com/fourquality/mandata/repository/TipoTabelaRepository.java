package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.TipoTabela;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoTabela entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoTabelaRepository extends JpaRepository<TipoTabela, Long>, JpaSpecificationExecutor<TipoTabela> {

}
