package com.mandiri.pocket.service;

import com.mandiri.pocket.entity.Purchase;
import org.springframework.stereotype.Repository;

public interface CustomeMailService {

    public void SendEmail(Purchase purchase);



}
