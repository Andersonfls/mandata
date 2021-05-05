package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.Tabela;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Tabela entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TabelaRepository extends JpaRepository<Tabela, Long>, JpaSpecificationExecutor<Tabela> {

}
