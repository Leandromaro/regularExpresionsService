package com.leandroMaro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leandromaro on 31/12/16.
 */
@RestController
@RequestMapping(value = "/regularExpresions")
public class RegularExpresionController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test (){
        return "works";
    }
}
