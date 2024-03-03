package com.countriescities.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.countriescities.entity.Countries;
import com.countriescities.entity.DataResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController // Controller **
public class CountryController {
    String url = "https://countriesnow.space/api/v0.1/countries";
    List<Countries> countries = new ArrayList<>(); // De forma global para se almacene la data y luego filtrar con
                                                   // getCountry()

    @GetMapping("/countries")
    public List<Countries> getCountries() {

        RestTemplate template = new RestTemplate();
        Object[] objects = new Object[] { template.getForObject(url, Object.class) };

        ObjectMapper objectMapper = new ObjectMapper();

        countries = Arrays.stream(objects)
                .map(obj -> objectMapper.convertValue(obj, DataResponseEntity.class))
                .map(DataResponseEntity::getData)
                .collect(Collectors.toList()).get(0);

        return countries;
    }

    @GetMapping("/country") // Primero ejecutar getCountries() para luego filtrar el país
    public List<Countries> getCountry() {
        return countries.stream().filter(e -> e.getCountry().equals("Ecuador")).collect(Collectors.toList());
    }

    // https://www.datosmundial.com/codigos-de-pais.php
    // https://www.sanidad.gob.es/ciudadanos/saludAmbLaboral/docs/codigoIsoPai.pdf

    // Primero ejecutar getCountries() para luego filtrar el país enviando el codigo
    // ISO2 o ISO 3
    // http://localhost:8080/country/ec
    // http://localhost:8080/country/ecu
    
    @GetMapping("/country/{code}")
    public List<Countries> getCountryIsoCode(@PathVariable("code") String code) {
        return countries.stream()
                .filter(e -> e.getIso2().equals(code.toUpperCase()) || e.getIso3().equals(code.toUpperCase()))
                .collect(Collectors.toList());
    }
}
