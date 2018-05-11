package com.demo.pojo;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/9 10:11
 */
public class Person {

    private String name;

    private Integer age;

    private String city;

    private String phone;

    private String desc;

    public Person() {
    }

    public Person(String name, Integer age, String city, String phone, String desc) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.phone = phone;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
