package edu.fdzc.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.fdzc.mall.product.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
    // BaseMapper已提供CRUD方法
}