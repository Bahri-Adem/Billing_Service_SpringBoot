package com.example.demo.beans;

import lombok.Data;

@Data


public class CustomerBean {

    //il faut définir les mêmeattributs que la classe customer
    private Long id;
    private String name;
    private String email;

}
