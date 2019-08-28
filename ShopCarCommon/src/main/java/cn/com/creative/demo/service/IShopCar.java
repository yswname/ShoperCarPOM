package cn.com.creative.demo.service;

import cn.com.creative.demo.entity.BookEntity;
import javafx.util.Pair;

import java.util.List;

public interface IShopCar {
    /**
     * 查看购物车
     * 每个商品的名称 价格 数量 小计
     * 所有商品价值的总计
     * */
    public List<Pair<BookEntity, Integer>> viewShopCar();

    /**
     * 添加购物车
     * 将某个商品添加到购物车中（新增一个）
     * 如果是新增-》添加一个商品
     * 如果以前有-》修改商品数量
     * */
    public boolean add(BookEntity book);

    /**
     * 修改商品数量
     * */
    public boolean edit(int bkId, int count);

    /**
     * 删除商品
     * */
    public boolean remove(int bkId);

    /**
     * 清空购物车
     * */
    public boolean clear();
}
