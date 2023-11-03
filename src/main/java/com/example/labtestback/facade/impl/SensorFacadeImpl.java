package com.example.labtestback.facade.impl;


import com.example.labtestback.entity.SensorEntity;
import com.example.labtestback.entity.Type;
import com.example.labtestback.entity.Unit;
import com.example.labtestback.facade.SensorFacade;
import com.example.labtestback.mapper.SensorMapper;
import com.example.labtestback.models.SensorDto;
import com.example.labtestback.service.SensorService;
import com.example.labtestback.service.TypeService;
import com.example.labtestback.service.UnitService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SensorFacadeImpl implements SensorFacade {
    private final SensorService sensorService;
    private final TypeService typeService;
    private final UnitService unitService;
    private final SensorMapper sensorMapper;

    @Override
    public List<SensorDto> getAllSensors() {
        return sensorMapper.listEntityToDto(sensorService.getAllSensors());
    }

    @Override
    public List<SensorDto> getSearchSensors(String search) {
       return sensorMapper.listEntityToDto(sensorService.getSearchSensors(search));
    }

    @Override
    public List<String> getAllTypes() {
        return typeService.getAllTypes().stream().map(Type::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllUnits() {
        return unitService.getAllUnits().stream().map(Unit::getName).collect(Collectors.toList());
    }

    @Override
    public SensorDto getSensor(long id) throws Exception {
        SensorEntity sensorEntity = sensorService.getSensor(id);
        return sensorMapper.entityToDto(sensorEntity, sensorEntity.getType(), sensorEntity.getUnit());
    }

    @Override
    public SensorDto createSensor(SensorDto sensorDto) {
        Unit unit = unitService.findUnitByName(sensorDto.getUnit());
        Type type= typeService.findTypeByName(sensorDto.getType());
        return sensorMapper.entityToDto(sensorService.createSensor(sensorMapper.dtoToEntity(sensorDto,type,unit)),type,unit);
    }

    @Override
    public SensorDto editSensor(SensorDto sensorDto) throws Exception {
        Unit unit=unitService.findUnitByName(sensorDto.getUnit());
        Type type=typeService.findTypeByName(sensorDto.getType());
        return sensorMapper.entityToDto(sensorService.editSensor(sensorMapper.dtoToEntity(sensorDto,type,unit)),type,unit);
    }

    @Override
    public void deleteSensor(long id) throws NotFoundException {
        sensorService.deleteSensor(id);
    }

}
