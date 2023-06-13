package com.example.example3.fifaranking.dao;

import com.example.example3.fifaranking.util.CountryEnum;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RankProvider {
    public Map<CountryEnum, Number> getCountriesRankMap(Date date) {
        Map<CountryEnum, Number> rates = new HashMap<>();
        rates.put(CountryEnum.IRAN, 23);
        rates.put(CountryEnum.GERMANY, 5);
        rates.put(CountryEnum.US, 24);
        return rates;
    }

    public Number getRank(CountryEnum country, Date date) {
        return getCountriesRankMap(date).get(country);
    }
}
