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
    public RegexEntity updateRegex(RegexEntity regexEntity) throws TransactionSystemException {
        try {
            if (regexEntity.getId() == null) {
                throw new TransactionSystemException("Invalid id to update");
            }else {
                regexDao.update(regexEntity);
            }
            return regexEntity;
        } catch (TransactionSystemException ex) {
            throw ex;
        }
    }

    @Override
    public RegexEntity create(RegexEntity regexEntity) throws PersistenceException {
        regexDao.create(regexEntity);
        return regexEntity;
    }
}
