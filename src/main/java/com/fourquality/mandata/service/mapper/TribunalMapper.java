package com.fourquality.mandata.service.mapper;

import com.fourquality.mandata.service.mapper.EntityMapper;
import com.fourquality.mandata.service.dto.TribunalDTO;

import com.fourquality.mandata.domain.Tribunal;
import org.mapstruct.*;

/**
 * Mapper for the entity Tribunal and its DTO TribunalDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TribunalMapper extends EntityMapper<TribunalDTO, Tribunal> {



    default Tribunal fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tribunal tribunal = new Tribunal();
        tribunal.setId(id);
        return tribunal;
    }
}
