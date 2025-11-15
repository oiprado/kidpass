package com.kidpass.qrservice.repository;

import com.kidpass.qrservice.entity.QRCode;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QRCodeRepository extends MongoRepository<QRCode, String> {

    Optional<QRCode> findByAuthorizationId(String authorizationId);
}
