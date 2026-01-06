package edu.fdzc.mall.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.fdzc.mall.user.entity.Cart;
import edu.fdzc.mall.user.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper cartMapper;

    public List<Cart> getCartByUserId(Long userId) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return cartMapper.selectList(queryWrapper);
    }

    public boolean addCart(Cart cart) {
        // 检查是否已存在相同商品
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", cart.getUserId())
                .eq("product_id", cart.getProductId());

        Cart existingCart = cartMapper.selectOne(queryWrapper);

        if (existingCart != null) {
            // 如果已存在，更新数量
            existingCart.setNum(existingCart.getNum() + cart.getNum());
            return cartMapper.updateById(existingCart) > 0;
        } else {
            // 不存在，新增
            return cartMapper.insert(cart) > 0;
        }
    }

    public boolean deleteCart(Long id) {
        return cartMapper.deleteById(id) > 0;
    }
}