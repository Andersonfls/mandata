package com.fourquality.mandata.service.mapper;

import com.fourquality.mandata.service.mapper.EntityMapper;
import com.fourquality.mandata.service.dto.TipoDocumentoDTO;

import com.fourquality.mandata.domain.TipoDocumento;
import org.mapstruct.*;

/**
 * Mapper for the entity TipoDocumento and its DTO TipoDocumentoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TipoDocumentoMapper extends EntityMapper<TipoDocumentoDTO, TipoDocumento> {



    default TipoDocumento fromId(Long id) {
        if (id == null) {
            return null;
        }
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(id);
        return tipoDocumento;
    }
}
