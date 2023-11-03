package com.example.labtestback.service;

import com.example.labtestback.entity.Type;
import com.example.labtestback.entity.Unit;

import java.util.List;

public interface TypeService {
    Type findTypeByName(String name);
    List<Type> getAllTypes();
}
