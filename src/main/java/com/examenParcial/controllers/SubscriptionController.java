package com.examenParcial.controllers;

import java.util.List;

import com.examenParcial.dtos.SubscriptionDto;
import com.examenParcial.exceptions.WebException;
import com.examenParcial.responses.WebResponse;
import com.examenParcial.services.SubscriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/plans")
public class SubscriptionController {
    
    @Autowired
    private SubscriptionService subscriptionService;

    // --------- get subscription by Id -----------
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public WebResponse<SubscriptionDto> getproductById(@PathVariable Long id) throws WebException {
        return new WebResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", this.subscriptionService.findById(id));
    }

    // -------- get all the subscriptions ----------
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public WebResponse<List<SubscriptionDto>> getRestaurants()
            throws WebException{
        return new WebResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                this.subscriptionService.findAll());
    }

    // --------- actualizar/crear subscription ----------
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public WebResponse<SubscriptionDto> create(@RequestBody SubscriptionDto subscriptionDto) throws WebException {
        return new WebResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                this.subscriptionService.create(subscriptionDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public WebResponse<SubscriptionDto> update(@RequestBody SubscriptionDto subscriptionDto) throws WebException {
        return new WebResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                this.subscriptionService.save(subscriptionDto));
    }

    // ----------- eliminar subscription por id ----------------
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) throws WebException {
       this.subscriptionService.deleteById(id);
    }
}
