package it.unicam.cs.LocalDevelopmentPlatform.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class Controller {
    // Example GET endpoint
    @GetMapping("/example")
    public String getExample() {
        return "This is an example GET request";
    }

    // Example POST endpoint with request body
    @PostMapping("/example")
    public String postExample(@RequestBody String requestBody) {
        return "Received POST request with body: " + requestBody;
    }

    // Example GET endpoint with path variable
    @GetMapping("/example/{id}")
    public String getExampleById(@PathVariable Long id) {
        return "Received GET request for ID: " + id;
    }

    // Example PUT endpoint with path variable and request body
    @PutMapping("/example/{id}")
    public String putExampleById(@PathVariable Long id, @RequestBody String requestBody) {
        return "Received PUT request for ID: " + id + " with body: " + requestBody;
    }

    // Example DELETE endpoint with path variable
    @DeleteMapping("/example/{id}")
    public String deleteExampleById(@PathVariable Long id) {
        return "Received DELETE request for ID: " + id;
    }
}
