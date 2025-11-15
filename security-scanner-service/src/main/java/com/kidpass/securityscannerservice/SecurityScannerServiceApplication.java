package com.kidpass.securityscannerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SecurityScannerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityScannerServiceApplication.class, args);
    }
}
