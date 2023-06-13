package com.example.example3;

import com.example.example3.fifaranking.util.CountryEnum;
import com.example.example3.fifaranking.service.RankService;
import com.example.example3.fifaranking.dao.RankProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.example3.fifaranking.util.CountryEnum.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RankServiceTest {

    RankService rankService;

    @BeforeEach
    public void setup() {
        RankProvider externalRatesProvider = mock(RankProvider.class);
        Map<CountryEnum, Number> rates = new HashMap();
        rates.put(IRAN, 23);
        rates.put(GERMANY, 5);
        rates.put(US, 24);
        when(externalRatesProvider.getCountriesRankMap(any())).thenReturn(rates);
        this.rankService = new RankService(externalRatesProvider);
    }

    @Test
    public void shouldReturnRankIran() {
        assertEquals(23, rankService.getRank(IRAN, new Date()));
    }

    @Test
    public void shouldReturnRankGermany() {
        assertEquals(5, rankService.getRank(GERMANY, new Date()));
    }
}
