package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.Representado;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Representado entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RepresentadoRepository extends JpaRepository<Representado, Long>, JpaSpecificationExecutor<Representado> {

}
