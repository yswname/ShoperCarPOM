package cn.com.creative.demo.service.impl;

import cn.com.creative.demo.dao.IBookDAO;
import cn.com.creative.demo.entity.BookEntity;
import cn.com.creative.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("bookService")
@Transactional
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookDAO bookDAO;
    @Override
    @Transactional( readOnly = true)
    public List<BookEntity> findBookList() {
        return this.bookDAO.selectAllBooks();
    }

    @Override
    @Transactional( readOnly = true)
    public BookEntity findBookById(int bkId) {
        return this.bookDAO.selectByPrimaryKey(bkId);
    }
}
