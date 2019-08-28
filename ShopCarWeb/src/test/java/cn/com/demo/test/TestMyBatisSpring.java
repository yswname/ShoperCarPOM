package cn.com.demo.test;

import cn.com.creative.demo.config.SpringConfiguration;
import cn.com.creative.demo.dao.IBookDAO;
import cn.com.creative.demo.entity.BookEntity;
import cn.com.creative.demo.service.IBookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestMyBatisSpring {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //IBookDAO bookDAO = ctx.getBean(IBookDAO.class);
//        List<BookEntity> boolList = bookDAO.selectAllBooks();
        IBookService bookService = ctx.getBean(IBookService.class);
        List<BookEntity> bookList = bookService.findBookList();
        for(BookEntity book:bookList){
            System.out.println(book.getBkName());
        }
    }
}
