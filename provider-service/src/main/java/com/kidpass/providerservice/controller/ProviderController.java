package com.kidpass.providerservice.controller;

import com.kidpass.providerservice.entity.Provider;
import com.kidpass.providerservice.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/{id}")
    public Provider getProviderById(@PathVariable String id) {
        return providerService.getProviderById(id);
    }

    @PostMapping
    public Provider createProvider(@RequestBody Provider provider) {
        return providerService.createProvider(provider);
    }

    @PutMapping("/{id}")
    public Provider updateProvider(@PathVariable String id, @RequestBody Provider provider) {
        return providerService.updateProvider(id, provider);
    }

    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable String id) {
        providerService.deleteProvider(id);
    }
}
