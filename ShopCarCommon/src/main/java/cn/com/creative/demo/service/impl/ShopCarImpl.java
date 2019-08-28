package cn.com.creative.demo.service.impl;

import cn.com.creative.demo.entity.BookEntity;
import cn.com.creative.demo.service.IShopCar;
import javafx.util.Pair;

import java.util.*;

public class ShopCarImpl implements IShopCar {
    // 内部的数据结构
    private Map<Integer, Pair<BookEntity, Integer>> bookMap = new HashMap<Integer, Pair<BookEntity, Integer>>();
    @Override
    public List<Pair<BookEntity, Integer>> viewShopCar() {
        Collection<Pair<BookEntity, Integer>> values = bookMap.values();
        List<Pair<BookEntity,Integer>> list = new ArrayList<>();
        list.addAll(values);
        return list;
    }

    @Override
    public boolean add(BookEntity book) {
        boolean bool = true;
        if(book != null){
            Pair<BookEntity, Integer> pair = this.bookMap.get(book.getBkId());
            if(pair == null){
                pair = new Pair<>(book, 1);
            }else{
                pair = new Pair(book, pair.getValue()+1);
            }
            this.bookMap.put(book.getBkId(), pair);
        }
        return bool;
    }

    @Override
    public boolean edit(int bkId, int count) {
        boolean bool = true;
        Pair<BookEntity,Integer> pair = this.bookMap.get(bkId);
        if(pair == null){
            throw new RuntimeException("购物车中没有id为"+bkId+"的书本，无法修改它的数量");
        }else{
            pair = new Pair<BookEntity,Integer>(pair.getKey(), count);
            this.bookMap.put(bkId, pair);
        }
        return bool;
    }

    @Override
    public boolean remove(int bkId) {
        boolean bool = true;
        this.bookMap.remove(bkId);
        return bool;
    }

    @Override
    public boolean clear() {
        boolean bool = true;
        this.bookMap.clear();
        return bool;
    }
}
