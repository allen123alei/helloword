package com.atguigu.oss.service.impl;

import com.atguigu.oss.mode.Account;

import java.util.List;

public interface AccountService {  // extends IService<Account>

    public List<Account> getACCount(String coinName);

    /**
     * 查询某个用户的货币资产
     * @param uid  用户ID
     * @param coinName 货币的名称
     * @return
     */
    Account findByUserAndCoin(Long uid, String coinName) ;

}
