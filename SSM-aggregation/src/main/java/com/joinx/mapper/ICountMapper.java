package com.joinx.mapper;

import com.joinx.pojo.Account;

public interface ICountMapper {
    Integer save(Account account);

    Account getCurUserBalance(Account from);
    void updateCurUserBalance(Account account);
}
