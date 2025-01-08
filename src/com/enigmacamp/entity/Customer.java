package com.enigmacamp.entity;

public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String phone_number;
    private String birth_date;

    public Customer(String name, String address, String phone_number, String birth_date) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.birth_date = birth_date;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", birth_date='" + birth_date + '\'' +
                '}';
    }
}
