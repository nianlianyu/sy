package edu.fdzc.mall.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("cart")
public class Cart {
    @TableId(type = IdType.AUTO)  // 添加主键注解
    private Long id; // 购物车id
    private Long userId; // 用户id
    private Long productId; // 商品id
    private String productName; // 商品名称
    private BigDecimal price; // 商品价格
    private Integer num; // 商品数量
}