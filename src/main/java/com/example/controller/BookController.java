package com.example.controller;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import com.example.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller // Spring에서 POJO를 나타내기위해서사용하는 어노테이션
public class BookController {   // new BookController() : Spring Container

    @Autowired  // DI(의존성 주입)
    private BookMapper mapper; // new SqlSessionFactoryBean()<--implements BookMapper
    // http://localhost:8081/shopping/list
    @RequestMapping("/list")
    public String list(Model model){ // HttpServletRequest req
        List<BookDTO> list=mapper.bookList();
        model.addAttribute("list", list);
        return "list"; // /WEB-INF/views/list.jsp <--- ${list}
    }
}