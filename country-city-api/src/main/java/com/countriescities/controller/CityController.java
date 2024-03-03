package com.countriescities.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CityController {
    // API REST
    // https://documenter.getpostman.com/view/1134062/T1LJjU52#dd5bd0d9-2602-4161-8c77-3af30cd2f41a
    
    // TEST
    @GetMapping("/cities")
    public List<Object> getCity(){
        String url = "https://countriesnow.space/api/v0.1/countries";
        RestTemplate template = new RestTemplate();
        Object[] objects = new Object[]{template.getForObject(url, Object.class)};
        return Arrays.asList(objects);
    }
}


// https://blog.codmind.com/mi-primer-api-rest-con-spring-boot/
