package com.leandroMaro.controllers;

import com.leandroMaro.Service.Implementation.RegexService;
import com.leandroMaro.models.entities.RegexEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by leandromaro on 31/12/16.
 */
@RestController
@RequestMapping(value = "/regularExpresions")
public class RegularExpressionController {

    @Autowired
    RegexService regexService;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * Get all the regexs
     */
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
    public ResponseEntity<RegexEntity> create(@RequestBody RegexEntity regexParams) throws PersistenceException {
        RegexEntity regexEntity = new RegexEntity();
        regexEntity = regexService.create(regexParams);
        return new ResponseEntity<RegexEntity>(regexEntity,HttpStatus.CREATED);
    }

    /**
     * Delete the user with the passed id.
     * ATTENTION: The better way to access a post request it's using a wrapper as @RequestBody parameter,
     * but, here we only want to pass the id value, so we handle the id using the JSONObject class.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete (@PathVariable Integer id) {
        return regexService.delete(id);
    }


    /**
     * Update the word and the regular expression for the regex identified by the passed id.
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public String updateName(@RequestBody RegexEntity regexEntity) {
        return regexService.updateRegex(regexEntity);
    }

    /**
     * Method created to handle the controller's exceptions, so the malformed request are responded in the controller layer
     * @param response HttpStatus.BAD_REQUEST
     * @throws IOException
     */
    @ExceptionHandler({MissingServletRequestParameterException.class,TransactionSystemException.class,IllegalArgumentException.class, NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
