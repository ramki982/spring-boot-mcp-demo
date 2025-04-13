package com.example.spring_boot_mcp_demo;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/echo")
    public Map<String, Object> echo(@RequestBody Map<String, Object> payload) {
        return payload;
    }
}