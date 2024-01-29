package com.example.controller;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import com.example.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // JSON 응답 -> RESTful Service(GET, POST,PUT,DELETE)
public class SpringRestController {
    // http://localhost:8081/shopping/rest1
    @Autowired
    private BookMapper mapper;

    @GetMapping("/api/book") //Get방식 요청
    public  List<BookDTO> bookList(){
        List<BookDTO> list = mapper.bookList();
        return list;
    }
    @GetMapping("/api/book/{num}")
    public BookDTO view(@PathVariable int num){
        BookDTO dto=mapper.getByNum(num);
        return dto;
    }
}