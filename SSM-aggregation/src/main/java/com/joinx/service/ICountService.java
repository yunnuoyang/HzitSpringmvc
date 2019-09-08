package com.joinx.service;

import com.joinx.pojo.Account;

public interface ICountService {
    public boolean tranceferTo(Account from, Account to, Float tranceMoney);
}
