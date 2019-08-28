package cn.com.creative.demo.web.controller;

import cn.com.creative.demo.entity.BookEntity;
import cn.com.creative.demo.service.IBookService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class BookController {
    private IBookService bookService;
    // 显示书本列表的方法
    public ModelAndView showBookList(){
        ModelAndView mv = new ModelAndView("bookList");
        List<BookEntity> bookList = this.bookService.findBookList();
        mv.addObject("bookList", bookList);
        return mv;
    }
}
