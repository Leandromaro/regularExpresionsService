package com.leandroMaro.Service.Interface;

import com.leandroMaro.models.entities.RegexEntity;
import org.springframework.transaction.TransactionSystemException;

import javax.persistence.PersistenceException;
import java.util.ArrayList;

/**
 * Created by leandromaro on 25/1/17.
 */
public interface RegexServiceInterface {

    /**
     * Method created to get all the added regex
     * @return ArrayList<RegexEntity>
     */
    ArrayList<RegexEntity> getAllRegexs();

    /**
     * Delete the regular expression with the passed id.
     */
    String delete(int idRegex);

    /**
     * Update the regular expression and the name for the regular expression identified by the passed id.
     */
    String updateRegex(RegexEntity regexEntity) throws TransactionSystemException;;

    /**
     * Create a new regex with an auto-generated id, name and regex are passed as
     * values in the request body.
     */
    RegexEntity create(RegexEntity regexEntity) throws PersistenceException;


}
