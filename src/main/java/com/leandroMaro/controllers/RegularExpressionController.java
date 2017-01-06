package com.leandroMaro.controllers;

import com.leandroMaro.Service.Implementation.RegexService;
import com.leandroMaro.models.entities.RegexEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 31/12/16.
 */
@RestController
@RequestMapping(value = "/regularExpresions")
public class RegularExpressionController {

    @Autowired
    RegexService regexService;

    @RequestMapping(value = "getAllRegex", method = RequestMethod.GET)
    @ResponseBody
    public List<RegexEntity> getAllRegex (){
        return regexService.getAllRegexs();
    }

    /**
     * Create a new regex with an auto-generated id, word and regularExpressions are passed
     * as parameter values.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam(value = "word", required = true) String word,
                         @RequestParam(value = "regularExpressions", required = true) String regularExpressions) {
        return regexService.create(word, regularExpressions);
    }

    /**
     * Delete the regex with the passed id.
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "id", required = true) long id) {
        return regexService.delete(id);
    }


    /**
     * Update the word and the regular expression for the regex identified by the passed id.
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public String updateRegex(@RequestParam(value = "id", required = true) long id,
                             @RequestParam(value = "word", required = true) String word,
                             @RequestParam(value = "regularExpressions", required = true) String regularExpressions) {
        return regexService.updateRegex(id, word, regularExpressions);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class,TransactionSystemException.class,IllegalArgumentException.class, NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
