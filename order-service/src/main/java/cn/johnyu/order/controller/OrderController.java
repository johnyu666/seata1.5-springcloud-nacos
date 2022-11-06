package cn.johnyu.order.controller;


import cn.johnyu.order.dao.OrderDao;
import cn.johnyu.order.service.OrderService;
import cn.johnyu.order.service.feign.AccountService;
import cn.johnyu.order.service.feign.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired private OrderService orderService;
    @PostMapping(value = "/create-order")
    public String createOrder(int aid,int pid,int count){
        return  orderService.createOrder(aid,pid,count)+"";
    }
}
