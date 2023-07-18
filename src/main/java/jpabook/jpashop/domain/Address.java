package jpabook.jpashop.domain;
//값타입은 기본적으로 변경이 되면 안된다.
//생성시만 값이 세팅되어야한다.


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    //기본생성자를 만들어줘야한다.
    //jpa 기본 스펙때문에 기본 생성자를 만들어야한다.
    protected Address(){

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
