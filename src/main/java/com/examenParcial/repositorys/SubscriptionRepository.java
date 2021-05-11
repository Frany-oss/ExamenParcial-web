package com.examenParcial.repositorys;


import java.util.List;

import com.examenParcial.entities.Subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByPrice(Integer price);
}
