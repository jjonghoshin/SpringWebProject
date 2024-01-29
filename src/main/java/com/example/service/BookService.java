package com.example.service;

import com.example.entity.BookDTO;
import com.example.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService { //new BookScan?

    @Autowired
    private BookMapper mapper;

    public List<BookDTO> bookList() {
        //비지니스 로직, 트렌젝션 처리를 여기서 한다.
        return mapper.bookList();
    }

    public int bookDelete(int num) {
        return mapper.bookDelete(num);
    }

    public int bookInsert(BookDTO dto) {
        return mapper.bookInsert(dto);
    }

    public BookDTO getByNum(int num) {
        return mapper.getByNum(num);
    }

    public int bookUpdate(BookDTO dto) {
        return mapper.bookUpdate(dto);
    }
}
