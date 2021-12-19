package org.dheeraj.resource;

import org.dheeraj.config.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class Home {

    @Autowired
    DBConfig config;

    @Autowired
    Environment environment;

    @Value("${message}")
    private String message;

    @Value("${days}")
    private List<String> weekDays;

    @GetMapping("/")
    public String home(){
        return message+" " +weekDays+" "+config.getUsername();
    }

    @GetMapping("/environment")
    public String environment()
    {
        return environment.toString();

    }
}
