package com.java.homework.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.Date;
//интерфейс для взаимодействия с сервисом валюты//
@FeignClient(name = "getVal",url = "https://openexchangerates.org/api/historical")
public interface ServiceCurrency {
    @RequestMapping(value = "/{date}?app_id=b36caf5adc6c4ba5a25709c874e53283&symbols={curse}&base=USD", method = RequestMethod.GET)
    Object startValue(@PathVariable String date, @PathVariable String curse);
}
