package com.example.labtestback.service.impl;


import com.example.labtestback.entity.SensorEntity;
import com.example.labtestback.repository.SensorRepository;
import com.example.labtestback.service.SensorService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {
    private SensorRepository sensorRepository;

    @Override
    public SensorEntity createSensor(SensorEntity sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public SensorEntity editSensor(SensorEntity sensor) throws NotFoundException {
        try {
            return sensorRepository.save(sensor);
        } catch (Exception ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @Override
    public SensorEntity getSensor(long id) throws Exception {
        return sensorRepository.findById(id);
    }

    @Override
    public void deleteSensor(long id) throws NotFoundException {
        try {
            sensorRepository.deleteById(id);
        } catch (Exception ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<SensorEntity> getAllSensors() {
        return sensorRepository.findAll();
    }

    public List<SensorEntity> getSearchSensors(String search) {
        Specification<SensorEntity> specification = (root, query, criteriaBuilder) -> {
            String searchLower = search.toLowerCase(); // Преобразование поискового значения к нижнему регистру
            try {
                int searchValue = Integer.parseInt(search);
                return criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("type").get("name")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("location")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + searchLower + "%"),
                        criteriaBuilder.equal(root.get("rangeFrom"), searchValue),
                        criteriaBuilder.equal(root.get("rangeTo"), searchValue),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("unit").get("name")), "%" + searchLower + "%")
                );
            } catch (NumberFormatException ex) {
                return criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("type").get("name")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("location")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + searchLower + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("unit").get("name")), "%" + searchLower + "%")
                );
            }
        };
        return sensorRepository.findAll(specification);

    }
}
