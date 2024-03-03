package com.countriescities.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Countries {
    private String iso2;
    private String iso3;
    private String country;
    private List<City> cities;
}
