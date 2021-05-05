package com.fourquality.mandata.repository;

import com.fourquality.mandata.domain.Tribunal;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Tribunal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TribunalRepository extends JpaRepository<Tribunal, Long> {

}
