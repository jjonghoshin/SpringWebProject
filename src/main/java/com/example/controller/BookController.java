package com.example.controller;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import com.example.repository.BookMapper;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller // Spring에서 POJO를 나타내기위해서사용하는 어노테이션
public class BookController {   // new BookController() : Spring Container

    //@Autowired  // DI(의존성 주입) , 생성자 주입 방법도 있음.
    //private BookMapper mapper; // new SqlSessionFactoryBean()<--implements BookMapper
    // http://localhost:8081/shopping/list -> get방식임.
    // public BookController(mapper){this.mapper=mapper}; 생성자 주입 방법 으로 @Autowired 대체 가능함.
    @Autowired
    private BookService service;
    @GetMapping("/list") //RequestMapping도 가능,Put,Get,Post,Delete
    public String list(Model model){ // HttpServletRequest req
        List<BookDTO> list=service.bookList();
        model.addAttribute("list", list);
        return "list"; // /WEB-INF/views/list.jsp <--- ${list}
    }

    @GetMapping("/delete/{num}") //?num=3 , 매개변수 이름이 같으면 @RequestParam 어노테이션 생략 가능함.
    public String delete(@PathVariable int num){  //int num = Integer.parseInt(req.getParmeter("num")) 구현
        //int num = Integer.parseInt(req.getParmeter("num"))
        int cnt=service.bookDelete(num);
        return "redirect:/list";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    //(@RequestBody BookDTO dto) json 문자열로 날아올 수 있음.
    @PostMapping("/register")
    public String registerPost(BookDTO dto){ //파라메터 수집 완료
        int cnt=service.bookInsert(dto);
        return "redirect:/list";
    }

    @GetMapping("/ajaxList")
    public @ResponseBody List<BookDTO> ajaxList(){
        List<BookDTO>list = service.bookList();
        return list; //JSON문자열
    }

    @GetMapping("/view/{num}")
    public String view(Model model,@PathVariable int num){
        BookDTO dto = service.getByNum(num);
        model.addAttribute("dto",dto);
        return "view"; // view,jsp(상세보기 페이지) ->${dto~}
    }
    @PostMapping("/update")
    public String update(BookDTO dto){
    int cnt = service.bookUpdate(dto);
    return "redirect:/list";
    }
}