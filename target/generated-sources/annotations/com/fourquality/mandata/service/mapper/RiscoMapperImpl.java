package com.fourquality.mandata.service.mapper;

import com.fourquality.mandata.domain.Risco;
import com.fourquality.mandata.service.dto.RiscoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-08T19:30:29+0000",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class RiscoMapperImpl implements RiscoMapper {

    @Override
    public Risco toEntity(RiscoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Risco risco = new Risco();

        risco.setId( dto.getId() );
        risco.setDescricao( dto.getDescricao() );
        risco.setStatus( dto.isStatus() );

        return risco;
    }

    @Override
    public RiscoDTO toDto(Risco entity) {
        if ( entity == null ) {
            return null;
        }

        RiscoDTO riscoDTO = new RiscoDTO();

        riscoDTO.setId( entity.getId() );
        riscoDTO.setDescricao( entity.getDescricao() );
        riscoDTO.setStatus( entity.isStatus() );

        return riscoDTO;
    }

    @Override
    public List<Risco> toEntity(List<RiscoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Risco> list = new ArrayList<Risco>( dtoList.size() );
        for ( RiscoDTO riscoDTO : dtoList ) {
            list.add( toEntity( riscoDTO ) );
        }

        return list;
    }

    @Override
    public List<RiscoDTO> toDto(List<Risco> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RiscoDTO> list = new ArrayList<RiscoDTO>( entityList.size() );
        for ( Risco risco : entityList ) {
            list.add( toDto( risco ) );
        }

        return list;
    }
}
