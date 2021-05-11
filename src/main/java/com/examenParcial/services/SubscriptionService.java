package com.examenParcial.services;

import java.util.List;

import com.examenParcial.dtos.SubscriptionDto;
import com.examenParcial.exceptions.WebException;


public interface SubscriptionService {
    
    SubscriptionDto findById(Long id) throws WebException;

    List<SubscriptionDto> findAll() throws WebException;

    SubscriptionDto save(SubscriptionDto productDto) throws WebException;

    SubscriptionDto create(SubscriptionDto subscriptionDto) throws WebException;
    
    void deleteById(Long id) throws WebException;
}
