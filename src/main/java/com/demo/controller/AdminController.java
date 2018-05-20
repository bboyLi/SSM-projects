package com.demo.controller;

import com.demo.dto.BookCountDTO;
import com.demo.pojo.Book;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/14 23:17
 */
@Controller
public class AdminController {

    @Autowired
    private BookService bookService;

    //图书列表
    @RequestMapping("/admin_book_list")
    public String listBooks(Map map){
        List<Book> books = bookService.listBook();
        map.put("list",books);
        return "admin_book_list";
    }

    //添加图书
    @RequestMapping("/admin_book_add")
    public String addBook(Book book){
        bookService.addBook(book);
        return "forward:/admin_book_list";
    }

    //删除图书
    @RequestMapping("/admin_book_del")
    public String delBook(int id){
        bookService.delBook(id);
        return "forward:/admin_book_list";
    }

    //图书信息统计
    @RequestMapping("/admin_book_count")
    public String count(Map map){
        List<BookCountDTO> bookCountDTOS = bookService.listBookCount();
        map.put("list",bookCountDTOS);
        return "admin_book_count";
    }

}
