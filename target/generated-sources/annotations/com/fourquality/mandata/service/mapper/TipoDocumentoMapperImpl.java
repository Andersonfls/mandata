package com.fourquality.mandata.service.mapper;

import com.fourquality.mandata.domain.TipoDocumento;
import com.fourquality.mandata.service.dto.TipoDocumentoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-08T19:30:30+0000",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class TipoDocumentoMapperImpl implements TipoDocumentoMapper {

    @Override
    public TipoDocumento toEntity(TipoDocumentoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoDocumento tipoDocumento = new TipoDocumento();

        tipoDocumento.setId( dto.getId() );
        tipoDocumento.setDescricao( dto.getDescricao() );
        tipoDocumento.setStatus( dto.isStatus() );

        return tipoDocumento;
    }

    @Override
    public TipoDocumentoDTO toDto(TipoDocumento entity) {
        if ( entity == null ) {
            return null;
        }

        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();

        tipoDocumentoDTO.setId( entity.getId() );
        tipoDocumentoDTO.setDescricao( entity.getDescricao() );
        tipoDocumentoDTO.setStatus( entity.isStatus() );

        return tipoDocumentoDTO;
    }

    @Override
    public List<TipoDocumento> toEntity(List<TipoDocumentoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoDocumento> list = new ArrayList<TipoDocumento>( dtoList.size() );
        for ( TipoDocumentoDTO tipoDocumentoDTO : dtoList ) {
            list.add( toEntity( tipoDocumentoDTO ) );
        }

        return list;
    }

    @Override
    public List<TipoDocumentoDTO> toDto(List<TipoDocumento> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipoDocumentoDTO> list = new ArrayList<TipoDocumentoDTO>( entityList.size() );
        for ( TipoDocumento tipoDocumento : entityList ) {
            list.add( toDto( tipoDocumento ) );
        }

        return list;
    }
}
