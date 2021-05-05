package com.fourquality.mandata.service.mapper;

import com.fourquality.mandata.domain.Tribunal;
import com.fourquality.mandata.service.dto.TribunalDTO;
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
public class TribunalMapperImpl implements TribunalMapper {

    @Override
    public Tribunal toEntity(TribunalDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tribunal tribunal = new Tribunal();

        tribunal.setId( dto.getId() );
        tribunal.setNome( dto.getNome() );
        tribunal.setSigla( dto.getSigla() );
        tribunal.setStatus( dto.isStatus() );

        return tribunal;
    }

    @Override
    public TribunalDTO toDto(Tribunal entity) {
        if ( entity == null ) {
            return null;
        }

        TribunalDTO tribunalDTO = new TribunalDTO();

        tribunalDTO.setId( entity.getId() );
        tribunalDTO.setNome( entity.getNome() );
        tribunalDTO.setSigla( entity.getSigla() );
        tribunalDTO.setStatus( entity.isStatus() );

        return tribunalDTO;
    }

    @Override
    public List<Tribunal> toEntity(List<TribunalDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Tribunal> list = new ArrayList<Tribunal>( dtoList.size() );
        for ( TribunalDTO tribunalDTO : dtoList ) {
            list.add( toEntity( tribunalDTO ) );
        }

        return list;
    }

    @Override
    public List<TribunalDTO> toDto(List<Tribunal> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TribunalDTO> list = new ArrayList<TribunalDTO>( entityList.size() );
        for ( Tribunal tribunal : entityList ) {
            list.add( toDto( tribunal ) );
        }

        return list;
    }
}
