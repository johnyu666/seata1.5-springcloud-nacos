package cn.johnyu.account.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountDao {
    int findBalance(@Param("aid") int aid);
    int reduceBalance(@Param("aid") int aid,@Param("balance") int balance);
}
