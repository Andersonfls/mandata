package com.fourquality.mandata.service.mapper;

import com.fourquality.mandata.service.dto.RiscoDTO;

import com.fourquality.mandata.domain.Risco;
import org.mapstruct.*;

/**
 * Mapper for the entity Risco and its DTO RiscoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RiscoMapper extends EntityMapper<RiscoDTO, Risco> {



    default Risco fromId(Long id) {
        if (id == null) {
            return null;
        }
        Risco risco = new Risco();
        risco.setId(id);
        return risco;
    }
}
