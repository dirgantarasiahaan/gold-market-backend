package com.mandiri.pocket.controller;

import com.mandiri.pocket.dto.WalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

@RestController
public class WalletRestTemplate {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/wallet")
    public ResponseEntity<WalletDto> createWallet(@RequestBody WalletDto wallet){
        String url = "http://localhost:8081/wallet";
        WalletDto walletDto = new WalletDto("0812131323", BigDecimal.ZERO);

        ResponseEntity<WalletDto> response = restTemplate.postForEntity(URI.create(url),
                walletDto,
                WalletDto.class);
        return response;
    }
}
