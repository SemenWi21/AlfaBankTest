package com.java.homework.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//интерфейс для взаимодействия с сервисом валюты//
@FeignClient(name = "gifGenerator", url = "https://api.giphy.com/v1/gifs")
public interface ServiceGif {
    // если курсы меньше//
    @RequestMapping(value = "/random?api_key=8srKfqKhtdVGRoQvjqpwPa3UE6eX2V83&tag=rich", method = RequestMethod.GET)
    Object happyGif();
    // если курс больше//
    @RequestMapping(value = "/random?api_key=8srKfqKhtdVGRoQvjqpwPa3UE6eX2V83&tag=broke", method = RequestMethod.GET)
    Object badGif();
}
