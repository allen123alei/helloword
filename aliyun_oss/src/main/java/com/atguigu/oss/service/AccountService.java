package com.atguigu.oss.service;

import com.atguigu.oss.dto.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
