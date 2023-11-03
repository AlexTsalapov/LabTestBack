package com.example.labtestback.service;

import com.example.labtestback.entity.Unit;

import java.util.List;

public interface UnitService {
    Unit findUnitByName(String name);
    List<Unit> getAllUnits();
}
