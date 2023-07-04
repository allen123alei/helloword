package com.atguigu.oss.service.impl;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.atguigu.oss.mapper.AccountMapper;
import com.atguigu.oss.dto.Account;
import com.atguigu.oss.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountService {

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
