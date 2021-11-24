package org.dheeraj.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
public class Home {

    @Autowired
    private DBConfiguration dbConfiguration;

    @Value("${message}")
    private String message;

    @Value("${days}")
    private List<String> weekDays;

    @Value("#{${studentDetails}}")
    private Map<String,String> studentDetails;

    @GetMapping("/")
    public String home(){
        return message+" " +weekDays+" "+studentDetails;
    }
}
