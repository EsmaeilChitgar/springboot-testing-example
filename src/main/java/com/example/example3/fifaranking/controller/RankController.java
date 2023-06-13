package com.example.example3.fifaranking.controller;

import com.example.example3.fifaranking.service.RankService;
import com.example.example3.fifaranking.util.CountryEnum;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RankController {
    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/rank")
    public String getExchangePageWithConversion(
            @RequestParam String country,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        return rankService.getRank(CountryEnum.valueOf(country.toUpperCase()), date).toString();
    }
}
