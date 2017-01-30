package com.leandroMaro.Service.Implementation;

import com.leandroMaro.Service.Interface.RegexServiceInterface;
import com.leandroMaro.models.dao.RegexDao;
import com.leandroMaro.models.entities.RegexEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandromaro on 5/1/17.
 */
@Service
public class RegexService implements RegexServiceInterface{

    @Autowired
    RegexDao regexDao;

    @Override
    public ArrayList<RegexEntity> getAllRegexs(){
        List<RegexEntity> regexs;
        try {
            regexs = regexDao.getAllUsers();
        } catch (Exception ex) {
            throw ex;
        }
        return (ArrayList<RegexEntity>) regexs;
    }

    @Override
    public String delete(int idRegex) {
        RegexEntity regexEntity = regexDao.getById(idRegex);
        regexDao.delete(regexEntity);
        return "User successfully deleted!";
    }

    @Override
    public String updateRegex(RegexEntity regexEntity) {
        try {
            regexDao.update(regexEntity);
            return "Regex successfully updated!";
        }
        catch (TransactionSystemException ex) {
            throw ex;
        }catch (Exception ex) {
            return "Error updating the regex " + ex.toString();
        }
    }

    @Override
    public RegexEntity create(RegexEntity regexEntity) throws PersistenceException {
        regexDao.create(regexEntity);
        return regexEntity;
    }
}
