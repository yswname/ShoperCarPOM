package cn.com.creative.demo.service;

import cn.com.creative.demo.entity.BookEntity;

import java.util.List;

public interface IBookService {
    /**
     * 查找所有BookEntity
     * */
    List<BookEntity> findBookList();
    /**
     * 查询指定id对应的Book对象
     * */
    BookEntity findBookById(int bkId);
}
