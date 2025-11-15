package com.kidpass.providerservice.service;

import com.kidpass.providerservice.entity.Provider;
import com.kidpass.providerservice.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(String id) {
        return providerRepository.findById(id).orElse(null);
    }

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider updateProvider(String id, Provider provider) {
        Provider existingProvider = providerRepository.findById(id).orElse(null);
        if (existingProvider != null) {
            existingProvider.setName(provider.getName());
            existingProvider.setContactEmail(provider.getContactEmail());
            existingProvider.setContactPhone(provider.getContactPhone());
            existingProvider.setAddress(provider.getAddress());
            existingProvider.setDescription(provider.getDescription());
            existingProvider.setActivityIds(provider.getActivityIds());
            return providerRepository.save(existingProvider);
        }
        return null;
    }

    public void deleteProvider(String id) {
        providerRepository.deleteById(id);
    }
}
