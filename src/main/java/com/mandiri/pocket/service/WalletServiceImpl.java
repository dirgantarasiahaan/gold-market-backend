package com.mandiri.pocket.service;

import com.mandiri.pocket.config.RedisConfiguration;
import com.mandiri.pocket.constant.AppConfig;
import com.mandiri.pocket.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppConfigService appConfigService;

    @Override
    public void debitWaller(Customer customer, BigDecimal amount) {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(appConfigService.getValue(AppConfig.OPO_WALLET_ENDPOINT_URL))
                .queryParam("phoneNumber", customer.getPhoneNumber())
                .queryParam("amount", amount);

        restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);

    }
}
