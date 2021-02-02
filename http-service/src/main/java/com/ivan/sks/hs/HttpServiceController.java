package com.ivan.sks.hs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/http-service")
public class HttpServiceController {

    @Value("${backend-service.url}")
    private String backendServiceUrl;

    private final RestTemplate restTemplate;

    @GetMapping
    public String randomInt() {
        log.info("Calling service '{}'", this.backendServiceUrl);

        final Integer randomInt = this.restTemplate.getForObject(this.backendServiceUrl, Integer.class);

        return "Random number: "
                + randomInt
                + " - "
                + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

}
