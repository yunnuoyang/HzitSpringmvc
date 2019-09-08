package com.joinx.service.impl;

import com.joinx.pojo.Account;
import com.joinx.repository.AcountRepository;
import com.joinx.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("countService")
public class ICountServiceImpl implements ICountService {
    @Autowired
    @Qualifier("acountRepository")
    private AcountRepository acountRepository;
    @Override
    public boolean tranceferTo(Account from, Account to, Float tranceMoney) {
        if(tranceMoney<10){
            throw new RuntimeException("转账金额不能小于10RMB");
        }
        Account balance= acountRepository.getCurUserBalance(from);
        if(balance.getBalance()<tranceMoney){
            throw new RuntimeException("您的账户余额不足");
        }
        Account toUser = acountRepository.getCurUserBalance(to);
        if (toUser==null){
            throw new RuntimeException("对方账户不存在");
        }
        balance.setBalance(-tranceMoney);
        acountRepository.updateCurUserBalance(balance);
        toUser.setBalance(tranceMoney);
        acountRepository.updateCurUserBalance(toUser);
        return false;
    }
}
