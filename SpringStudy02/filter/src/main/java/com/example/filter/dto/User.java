package com.example.filter.dto;

import lombok.*;

// < Lombok 사용 >
//@Getter
//@Setter
@Data   // getter, setter, toString 까지 다 만들어주는 annotation이다.
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 전체생성자
public class User {

    private String name;
    private int age;
}