package com.demo.controller;

import com.demo.pojo.Book;
import com.demo.pojo.User;
import com.demo.service.BookService;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/14 23:13
 */
@Controller
public class KehuController {

    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;

    //图书列表
    @RequestMapping("/kehu_book_list")
    public String listBook(Map map){
        List<Book> books = bookService.listBook();
        map.put("list",books);
        return "kehu_book_list";
    }

    //购买图书
    @RequestMapping("/kehu_book_add")
    public String addBook(int id, HttpSession session){
        User user = (User) session.getAttribute("user");
        orderService.buyBook(id,user.getId());
        return "forward:/kehu_book_list";

    }
    //我购买的图书
    @RequestMapping("/kehu_orders_list")
    public String orders(Map map,HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Book> books = orderService.listBookByUserId(user.getId());
        map.put("list",books);
        return "kehu_orders_list";
    }

}
