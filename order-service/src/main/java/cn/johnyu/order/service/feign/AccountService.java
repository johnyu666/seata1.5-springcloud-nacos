package cn.johnyu.order.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "account-service")
public interface AccountService {

    @PostMapping(value = "/reduce-balance")
    String reduceBalance(@RequestParam("aid") int aid,@RequestParam("balance") int balance);
}
