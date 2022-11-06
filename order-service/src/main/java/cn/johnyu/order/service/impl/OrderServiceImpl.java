package cn.johnyu.order.service.impl;

import cn.johnyu.order.dao.OrderDao;
import cn.johnyu.order.service.OrderService;
import cn.johnyu.order.service.feign.AccountService;
import cn.johnyu.order.service.feign.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductService productService;
    @GlobalTransactional
    @Override
    public int createOrder(int aid, int pid, int count) {
        int price=100;
        int amount=price*count;
        productService.reduceStock(pid,count);
        accountService.reduceBalance(aid,amount);
        int rs=orderDao.createOrder(aid,pid,amount);
        return rs;
    }
}
