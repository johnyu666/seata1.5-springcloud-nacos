package cn.johnyu.account.controller;

import cn.johnyu.account.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired private AccountDao accountDao;
    @Transactional
    @PostMapping(value = "reduce-balance")
    public String reduceBalance(int aid,int balance){
        int val=accountDao.findBalance(aid);
        if((val-balance)<0){
            throw new RuntimeException("余额不足");
        }
        return accountDao.reduceBalance(aid,balance)+"";

    }
}
