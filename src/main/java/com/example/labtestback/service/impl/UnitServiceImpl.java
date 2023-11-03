package com.example.labtestback.service.impl;

import com.example.labtestback.entity.Unit;
import com.example.labtestback.repository.UnitRepository;
import com.example.labtestback.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {
private UnitRepository unitRepository;
    @Override
    public Unit findUnitByName(String name) {
        return unitRepository.findByName(name);
    }

    @Override
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }
}
