package com.java.homework.controller;



import com.java.homework.rest.ServiceCurrency;
import com.java.homework.rest.ServiceGif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.NestedServletException;


import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

@RestController
public class Controller {

    private final ServiceCurrency serviceCurrency;
    private final ServiceGif serviceGif;

    @Autowired
    public Controller(ServiceCurrency serviceCurrency, ServiceGif serviceGif) {
        this.serviceCurrency = serviceCurrency;
        this.serviceGif = serviceGif;
    }
    // основной контроллер на который приходят запросы HTTP //
    @GetMapping("/getCur/{curse}")
    public Object getCurrency(@PathVariable String curse){
        // обработка входящих данных //
       try{
            Map valueDate1 = (Map) serviceCurrency.startValue(LocalDate.now() + ".json", curse);
            Map ratesDate1 = getMap(valueDate1);
            Double costDate1 = (Double) ratesDate1.get(curse.toUpperCase());
            // обработка входящих данных //
            Map valueDate2 = (Map) serviceCurrency.startValue(LocalDate.now().minusDays(1) + ".json", curse);
            Map ratesDate2 = getMap(valueDate2);
            Double costDate2 = (Double) ratesDate2.get(curse.toUpperCase());
            // сравнение валюты и отправка гифки//
            if(costDate1 < costDate2){
                return serviceGif.badGif();
            }
            if(costDate1 > costDate2){
                return serviceGif.happyGif();
            }
            return "sorry";
        }catch (Throwable exeption){
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Don't use USD");
       }
    }

    private Map getMap(Map valueDate2) {
        return (Map) valueDate2.get("rates");
    }
}
