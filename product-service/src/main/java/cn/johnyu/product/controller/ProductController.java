package cn.johnyu.product.controller;

import cn.johnyu.product.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired private ProductDao productDao;
    @Transactional
    @PostMapping(value = "/reduce-stock")
    public String reduceStock(int pid,int stock){
        if((productDao.findStock(pid)-stock)<0){
            throw new RuntimeException("库存不足");
        }
        return productDao.reduceStock(pid,stock)+"";
    }
}
