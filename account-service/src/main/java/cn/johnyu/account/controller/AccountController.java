package cn.johnyu.account.controller;

import cn.johnyu.account.dao.AccountDao;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired private AccountDao accountDao;
    @DS(value = "master")
    @Transactional
    @PostMapping(value = "reduce-balance")
    public String reduceBalance(int aid,int balance){
        int val=accountDao.findBalance(aid);
        if((val-balance)<0){
            throw new RuntimeException("余额不足");
        }
        return accountDao.reduceBalance(aid,balance)+"";
    }
    @DS(value = "slave")
    @GetMapping(value = "/findBalance")
    public String findBalance(@RequestParam("aid") int aid){
       return accountDao.findBalance(aid)+"";
    }
}
