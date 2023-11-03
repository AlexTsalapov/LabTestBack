package com.example.labtestback.repository;


import com.example.labtestback.entity.SensorEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SensorRepository extends CrudRepository<SensorEntity, Long>, JpaSpecificationExecutor<SensorEntity> {
SensorEntity findById(long id);

    List<SensorEntity> findAll();
}
