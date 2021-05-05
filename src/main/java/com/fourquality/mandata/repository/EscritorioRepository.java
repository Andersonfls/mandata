package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.Escritorio;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Escritorio entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EscritorioRepository extends JpaRepository<Escritorio, Long>, JpaSpecificationExecutor<Escritorio> {

}
