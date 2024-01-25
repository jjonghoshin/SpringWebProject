package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 책(Object) -> 제목, 가격, 지은이, 페이지수,ISBN,출판사,색상,무게...... 속성, 멤버, 상태
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO { // class = 새로운 자료형을 만드는 도구 / 어떻게 설계하는 것이 잘 설계하는 것인가?
    //1. 모든 멤버를 정보은닉 시킨다.(private)
    private int num; // setter, getter
    private String title;
    private int price;
    private String name;
    private int page;
}
