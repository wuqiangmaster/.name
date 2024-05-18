package com.wuqing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

    private int id;
    private String number;
    private String name;

    private int age;
    private String sex;

    private String tel;

    private String email;

    private String address;

    public Student() {

    }

    public Student(int id, String number, String name, int age, String sex, String tel,
                   String email, String address) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.email = email;
        this.address = address;
    }


}
