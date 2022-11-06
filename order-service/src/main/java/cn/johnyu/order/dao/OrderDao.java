package cn.johnyu.order.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Repository
public interface OrderDao {
    @Transactional
    int createOrder(@Param("aid") int aid, @Param("pid") int pid, @Param("amount") int amount);
}
