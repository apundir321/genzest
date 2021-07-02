package com.howtodoinjava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.model.DeviceMetadata;

public interface DeviceMetadataRepository extends JpaRepository<DeviceMetadata, Long> {

    List<DeviceMetadata> findByUserId(Long userId);
}
