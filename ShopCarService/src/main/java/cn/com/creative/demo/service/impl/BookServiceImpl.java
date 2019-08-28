package cn.com.creative.demo.service.impl;

import cn.com.creative.demo.dao.IBookDAO;
import cn.com.creative.demo.entity.BookEntity;
import cn.com.creative.demo.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookDAO bookDAO;
    @Override
    public List<BookEntity> findBookList() {
        return this.bookDAO.selectAllBooks();
    }

    @Override
    public BookEntity findBookById(int bkId) {
        return this.bookDAO.selectByPrimaryKey(bkId);
    }
}
