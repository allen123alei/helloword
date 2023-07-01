package com.atguigu.oss.controller;

import com.atguigu.oss.mode.Account;
import com.atguigu.oss.service.impl.AccountService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资产服务控制类
 */
@RestController
@RequestMapping("/account")
@Api(tags = "资金服务控制类")
public class AccountController {
    @Autowired
    public AccountService accountService;

    @GetMapping("/{coinName}")
    public Account getUserAccount(@PathVariable String coinName){
//        List<Account> acCount = accountService.getACCount(coinName);
        String userid =null; //SecurityContextHolder.getContext().getAuthentication().getPrincipacation();
        Long uid = Long.valueOf(userid);
        Account acCount=accountService.findByUserAndCoin(uid,coinName);
        return acCount;
    }

    @GetMapping("/user/records")
    @ApiOperation(value = "查询当前用户的充值记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current",value = "当前页"),
            @ApiImplicitParam(name = "size",value = "每页显示的大小"),
            @ApiImplicitParam(name = "status",value = "充值的状态"),
    })
    public Page<Account> findUserCashRecharge(){
        return null;

    }


}
