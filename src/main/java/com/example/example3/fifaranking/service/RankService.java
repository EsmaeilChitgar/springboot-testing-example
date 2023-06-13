package com.example.example3.fifaranking.service;

import com.example.example3.fifaranking.dao.RankProvider;
import com.example.example3.fifaranking.util.CountryEnum;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RankService {
    private final RankProvider rankProvider;

    public RankService(RankProvider rankProvider) {
        this.rankProvider = rankProvider;
    }

    public Number getRank(CountryEnum country, Date date){
        return rankProvider.getCountriesRankMap(date).get(country);
    }
}
