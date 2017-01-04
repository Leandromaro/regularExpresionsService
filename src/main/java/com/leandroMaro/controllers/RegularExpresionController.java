package com.leandroMaro.controllers;

import com.leandroMaro.models.dao.RegexDao;
import com.leandroMaro.models.entities.RegexEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leandromaro on 31/12/16.
 */
@RestController
@RequestMapping(value = "/regularExpresions")
public class RegularExpresionController {

    @Autowired
    RegexDao regexDao;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public List<RegexEntity> test (){
        return regexDao.getAllUsers();
    }
}
