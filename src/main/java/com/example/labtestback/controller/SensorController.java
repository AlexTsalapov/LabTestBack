package com.example.labtestback.controller;

import com.example.labtestback.facade.SensorFacade;
import com.example.labtestback.models.SensorDto;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sensors")
@AllArgsConstructor
public class SensorController {
    private final SensorFacade sensorFacade;

    @GetMapping("/search{search}")
    public ResponseEntity<List<SensorDto>> getSearchSensors(@PathVariable String search) {
        List<SensorDto> sensors = sensorFacade.getSearchSensors(search);
        return ResponseEntity.ok(sensors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getSensor(@PathVariable long id) {
        try {
            return ResponseEntity.ok( sensorFacade.getSensor(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sensor not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @GetMapping("/units")
    public ResponseEntity<List<String>> getUnits() {
        return ResponseEntity.ok(sensorFacade.getAllUnits());
    }
    @GetMapping("/types")
    public ResponseEntity<List<String>> getTypes() {
        return ResponseEntity.ok(sensorFacade.getAllTypes());
    }

    @GetMapping("/all")
    public ResponseEntity<List<SensorDto>> getAllSensors() {
        List<SensorDto> sensors = sensorFacade.getAllSensors();
        return ResponseEntity.ok(sensors);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSensor(@RequestBody @Valid SensorDto sensorDto) {
        return ResponseEntity.ok(sensorFacade.createSensor(sensorDto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> editSensor(@RequestBody @Valid SensorDto sensorDto) {
        try {

            return ResponseEntity.ok(sensorFacade.editSensor(sensorDto));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sensor not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSensor(@PathVariable long id) {
        try {
            sensorFacade.deleteSensor(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sensor not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
