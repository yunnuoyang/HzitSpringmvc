package com.joinx.repository;

import com.joinx.mapper.ICountMapper;
import com.joinx.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("acountRepository")
public class AcountRepository {
    @Autowired
    private ICountMapper countMapper;
    public Integer save(Account account){
       return countMapper.save(account);
    }

    public Account getCurUserBalance(Account from) {
        return countMapper.getCurUserBalance(from) ;
    }
    public void updateCurUserBalance(Account account){
        countMapper.updateCurUserBalance(account);
    }
}
