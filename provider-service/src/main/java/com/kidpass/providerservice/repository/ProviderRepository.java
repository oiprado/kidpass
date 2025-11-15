package com.kidpass.providerservice.repository;

import com.kidpass.providerservice.entity.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderRepository extends MongoRepository<Provider, String> {
}
