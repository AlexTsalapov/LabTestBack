package com.example.labtestback.facade;


import com.example.labtestback.entity.SensorEntity;
import com.example.labtestback.models.SensorDto;
import javassist.NotFoundException;
import java.util.List;


public interface SensorFacade {
    List<String> getAllTypes();
    List<String> getAllUnits();
    SensorDto getSensor(long id) throws Exception;
    SensorDto createSensor(SensorDto sensor);

    SensorDto editSensor(SensorDto sensor) throws Exception;

    void deleteSensor(long id) throws NotFoundException;

    List<SensorDto> getAllSensors();
    List<SensorDto> getSearchSensors(String search);
}
