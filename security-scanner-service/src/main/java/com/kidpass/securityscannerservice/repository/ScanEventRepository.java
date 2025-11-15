package com.kidpass.securityscannerservice.repository;

import com.kidpass.securityscannerservice.entity.ScanEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScanEventRepository extends MongoRepository<ScanEvent, String> {

    List<ScanEvent> findByQrCodeId(String qrCodeId);
    List<ScanEvent> findBySecurityPersonnelId(String securityPersonnelId);
}
