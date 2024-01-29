package com.example.repository;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface BookMapper { //SqlSessionFactoryBean 구현체
    public List<BookDTO> bookList();
    public int bookInsert(BookDTO book);
    public UserDTO userLogin(UserDTO dto);
    public int bookDelete(int num);
    public BookDTO getByNum(int num);
    public int bookUpdate(BookDTO dto);
}
