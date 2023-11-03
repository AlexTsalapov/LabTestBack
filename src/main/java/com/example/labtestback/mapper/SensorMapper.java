package com.example.labtestback.mapper;

import com.example.labtestback.entity.SensorEntity;
import com.example.labtestback.entity.Type;
import com.example.labtestback.entity.Unit;
import com.example.labtestback.models.SensorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SensorMapper {

    private final ModelMapper modelMapper;

    public SensorMapper() {
        this.modelMapper = new ModelMapper();
    }

    public SensorDto entityToDto(SensorEntity entity, Type type, Unit unit) {
        SensorDto sensorDto = new SensorDto();
        sensorDto.setId(entity.getId());
        sensorDto.setName(entity.getName());
        sensorDto.setLocation(entity.getLocation());
        sensorDto.setModel(entity.getModel());
        sensorDto.setDescription(entity.getDescription());
        sensorDto.setRangeFrom(entity.getRangeFrom());
        sensorDto.setRangeTo(entity.getRangeTo());
        sensorDto.setType(type.getName());
        sensorDto.setUnit(unit.getName());
        return sensorDto;
    }

    public SensorEntity dtoToEntity(SensorDto dto, Type type, Unit unit) {
        SensorEntity sensorEntity = modelMapper.map(dto, SensorEntity.class);
        sensorEntity.setId(dto.getId());
        sensorEntity.setName(dto.getName());
        sensorEntity.setLocation(dto.getLocation());
        sensorEntity.setModel(dto.getModel());
        sensorEntity.setDescription(dto.getDescription());
        sensorEntity.setRangeFrom(dto.getRangeFrom());
        sensorEntity.setRangeTo(dto.getRangeTo());
        sensorEntity.setType(type);
        sensorEntity.setUnit(unit);
        return sensorEntity;
    }

    public List<SensorDto> listEntityToDto(List<SensorEntity> sensorEntities) {

        List<SensorDto> sensorDtos = new ArrayList<>();
        for (SensorEntity sensorEntity : sensorEntities) {
            Unit unit = sensorEntity.getUnit();
            Type type = sensorEntity.getType();
            SensorDto sensorDto = entityToDto(sensorEntity, type, unit);
            sensorDtos.add(sensorDto);
        }

        return sensorDtos;
    }
}
