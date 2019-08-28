package cn.com.creative.demo.dao;

import cn.com.creative.demo.entity.BookEntity;

import java.util.List;

public interface IBookDAO {
    public List<BookEntity> selectAllBooks();
    BookEntity selectByPrimaryKey(Integer bkId);
}
