package com.leandroMaro.Service.Implementation;

import com.leandroMaro.models.dao.RegexDao;
import com.leandroMaro.models.entities.RegexEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 5/1/17.
 */
@Service
public class RegexService {

    @Autowired
    RegexDao regexDao;

    public ArrayList<RegexEntity> getAllRegexs(){
        List<RegexEntity> regexs = new ArrayList<RegexEntity>();
        try {
            regexs = regexDao.getAllUsers();
        } catch (Exception ex) {
            throw ex;
        }
        return (ArrayList<RegexEntity>) regexs;
    }

    /**
     * Create a new RegexEntity with an auto-generated id and name and regex as passed
     * values.
     */
    public String create(String word, String regularExpression) {
        try {
            RegexEntity regex = new RegexEntity(word, regularExpression);
            regexDao.create(regex);
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            return "Error creating the regex: " + ex.toString();
        }
        return "Regex successfully created!";
    }

    /**
     * Delete the regex with the passed id.
     */

    public String delete(long id) {
        try {
            RegexEntity regex = new RegexEntity(id);
            regexDao.delete(regex);
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            return "Error deleting the regex: " + ex.toString();
        }
        return "Regex successfully deleted!";
    }


    /**
     * Update the regular expression and the name for the regular expression identified by the passed id.
     */
    public String updateRegex(long id, String word, String regularExpression) throws TransactionSystemException {
        try {
            RegexEntity regexEntity = regexDao.getById(id);
            regexEntity.setWord(word);
            regexEntity.setRegularExpresions(regularExpression);
            regexDao.update(regexEntity);
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            return "Error updating the regex " + ex.toString();
        }

        return "Regex succesfully updated!";
    }
}
