package com.example.shortform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final Environment environment;

    @GetMapping("/profile")
    public String profile() {

        // 현재 실행중인 ActiveProfile을 모두 가져온다.
        List<String> profiles = Arrays.asList(environment.
                getActiveProfiles());


        List<String> prodProfiles = Arrays.asList("prod", "prod1", "prod2");

        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);

        return profiles.stream().filter(prodProfiles::contains)
                .findAny()
                .orElse(defaultProfile);
    }
}
