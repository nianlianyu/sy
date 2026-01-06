package edu.fdzc.mall.product.service;

import edu.fdzc.mall.product.entity.Product;
import edu.fdzc.mall.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 将此对象实例化后注入到容器中
@RequiredArgsConstructor // 生成一个带属性的构造方法，而此属性的实例从容器获取
public class ProductService {
    private final ProductMapper productMapper;

    /**
     * 查询所有商品
     * @return
     */
    public List<Product> getAllProducts() {
        return productMapper.selectList(null);
    }

    /**
     * 根据ID查询商品
     * @param id
     * @return
     */
    public Product getProductById(long id) {
        return productMapper.selectById(id);
    }
}