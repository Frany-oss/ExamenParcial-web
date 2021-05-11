package com.examenParcial.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.examenParcial.dtos.SubscriptionDto;
import com.examenParcial.entities.Subscription;
import com.examenParcial.exceptions.NotFoundException;
import com.examenParcial.exceptions.WebException;
import com.examenParcial.repositorys.SubscriptionRepository;
import com.examenParcial.services.SubscriptionService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    // ----------- encontrar por ID ------------
    @Override
    public SubscriptionDto findById(Long id) throws WebException{
        return modelMapper.map(findEntity(id), SubscriptionDto.class);
    }

    private Object findEntity(Long id) throws WebException{
        return subscriptionRepository.findById(id).orElseThrow(() -> new NotFoundException("NOTFOUND-404","_NOTFOUND-404"));
    }

    // ------------- encontrar todos -------------
    @Override
    public List<SubscriptionDto> findAll() {
        List<Subscription> subscriptionEntity = subscriptionRepository.findAll();
        return subscriptionEntity.stream().map(product -> modelMapper.map(product, SubscriptionDto.class)).collect(Collectors.toList());
    }

    // ---------- guardar y actualizar -----------
    public SubscriptionDto save(SubscriptionDto subscriptionDto) throws WebException {

        Subscription product = this.dtoEntity(subscriptionDto);
        Subscription saveProduct = this.subscriptionRepository.save(product);

        return new SubscriptionDto(saveProduct);
    }
    private Subscription dtoEntity(SubscriptionDto subscriptionDto) {
        Subscription subscription = new Subscription();
        BeanUtils.copyProperties(subscriptionDto, subscription);
        return subscription;
    }

    // ----------- Crear subscription -----------
    @Transactional
    @Override
    public SubscriptionDto create(SubscriptionDto subscriptionDto) throws IllegalArgumentException {
        Subscription subscription = new Subscription();
        List<Subscription> prices = subscriptionRepository.findByPrice(subscriptionDto.getPrice());
        
        subscription.setStatus(subscriptionDto.getStatus());
        subscription.setName(subscriptionDto.getName());
        subscription.setDescription(subscriptionDto.getDescription());
        subscription.setPrice(subscriptionDto.getPrice());

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).getStatus() == 1) {
                    throw new IllegalArgumentException("Price is already assigned to an existing Plan");
            }
        }
        subscription = subscriptionRepository.save(subscription);
        return modelMapper.map(getSubscriptionEntity(subscription.getId()),SubscriptionDto.class);
    }

    private Object getSubscriptionEntity(Long id) throws IllegalArgumentException {
        return subscriptionRepository.findById(id).orElseThrow(
                                                ()-> new IllegalArgumentException("Price is already assigned to an existing Plan"));
    }
    
    // ------------- eliminar por ID --------------
    @Override
    public void deleteById(Long id) throws WebException {
        this.subscriptionRepository.deleteById(id);
    }
}
