package com.atguigu.oss.service.impl;

import com.atguigu.oss.mapper.AccountMapper;
import com.atguigu.oss.mode.Account;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountService{

    @Override
    public List<Account> getACCount(String coinName) {
        return null;
    }

    @Override
    public Account findByUserAndCoin(Long uid, String coinName){
        Account one = getOne(new LambdaQueryWrapper<Account>()
                .eq(Account::getRid, uid)
                .eq(Account::getCoinName, coinName));

        if (one==null){
           // throw new IllegalAccessException("该资产不存在");
        }

        return one;
    }
}
