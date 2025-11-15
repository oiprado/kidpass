package com.kidpass.authservice.client;

import com.kidpass.authservice.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/users/username/{username}")
    User getUserByUsername(@PathVariable("username") String username);

    @PostMapping("/users")
    User registerUser(@RequestBody User user);
}
