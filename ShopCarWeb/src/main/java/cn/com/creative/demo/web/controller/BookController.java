package cn.com.creative.demo.web.controller;

import cn.com.creative.demo.entity.BookEntity;
import cn.com.creative.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookService")
    private IBookService bookService;
    // 显示书本列表的方法
    @RequestMapping("/showBookList")
    public ModelAndView showBookList(){
        ModelAndView mv = new ModelAndView("bookList");
        List<BookEntity> bookList = this.bookService.findBookList();
        mv.addObject("bookList", bookList);
        return mv;
    }
}
