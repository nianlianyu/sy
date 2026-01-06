package edu.fdzc.mall.product.controller;

import edu.fdzc.mall.entity.Result;
import edu.fdzc.mall.product.entity.Product;
import edu.fdzc.mall.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // 构造注入对象
@RequestMapping("/product") // 接口前缀
public class ProductController {
    private final ProductService productService;

    /**
     * 商品列表
     * @return
     */
    @GetMapping("/list")
    public Result<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return Result.success(products);
    }

    /**
     * 根据商品ID查询商品
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return product == null ? Result.error("商品不存在") : Result.success(product);
    }
}