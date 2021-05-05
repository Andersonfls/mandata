package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.Advogado;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Advogado entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdvogadoRepository extends JpaRepository<Advogado, Long>, JpaSpecificationExecutor<Advogado> {

}
