package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.Risco;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Risco entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RiscoRepository extends JpaRepository<Risco, Long> {

}
