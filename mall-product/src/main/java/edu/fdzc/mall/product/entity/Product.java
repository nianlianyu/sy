package edu.fdzc.mall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("product") //对应的数据库表
public class Product {
    @TableId(type = IdType.AUTO) //主键自增
    private Long id; // 商品id
    private String name; // 商品名称
    private String description; // 商品描述
    private BigDecimal price; // 商品价格
    private Integer stock; // 库存
    private String image; // 商品图片
}