package cn.johnyu.order.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")
public interface ProductService {

    @PostMapping(value = "/reduce-stock")
    String reduceStock(@RequestParam("pid") int pid,@RequestParam("stock") int stock);
}
