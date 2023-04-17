package med.voll.api.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/hello")
public class HelloController {
    @GetMapping
    public String helloWorld() {
        return "Hello from Sprint Boot REST API";
    }
}
