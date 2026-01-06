package edu.fdzc.mall.user.controller;


import edu.fdzc.mall.entity.Result;
import edu.fdzc.mall.user.entity.Cart;
import edu.fdzc.mall.user.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    // 访问路径 /cart/list?userId=XXXX
    @GetMapping("/list")
    public Result<List<Cart>> getCartByUserId(@RequestParam Long userId) {
        List<Cart> cartList = cartService.getCartByUserId(userId);
        return Result.success(cartList);
    }

    // 添加购物车 post /cart/add
    @PostMapping("/add")
    public Result<Boolean> addCart(@RequestBody Cart cart) {
        boolean success = cartService.addCart(cart);
        return success ? Result.success() : Result.error("添加失败");
    }

    // 删除购物车 DELETE /cart/{id}
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteCart(@PathVariable Long id) {
        boolean success = cartService.deleteCart(id);
        return success ? Result.success() : Result.error("删除失败");
    }
}