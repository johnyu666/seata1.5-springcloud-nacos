package cn.johnyu.product.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDao {
   int findStock(@Param("pid") int pid);
   int reduceStock(@Param("pid") int pid,@Param("stock") int stock);
}
