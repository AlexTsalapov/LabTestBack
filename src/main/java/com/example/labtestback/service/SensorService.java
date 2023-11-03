package com.example.labtestback.service;



import com.example.labtestback.entity.SensorEntity;
import javassist.NotFoundException;

import java.util.List;

public interface SensorService {
    SensorEntity createSensor(SensorEntity sensor);
    SensorEntity editSensor(SensorEntity sensor) throws Exception;
    SensorEntity getSensor(long id) throws Exception;
    void deleteSensor(long id) throws NotFoundException;
    List<SensorEntity> getAllSensors();
    List<SensorEntity> getSearchSensors(String search);

}
