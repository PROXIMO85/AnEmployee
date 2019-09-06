package com.amazon.employee.model;

public class AnEmployee {

    private long id;
    private String name;
    private String surname;
    private int age;
    private String jobtitle;
    private String homecity;
    private int experience;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getHomecity() {
        return homecity;
    }

    public void setHomecity(String homecity) {
        this.homecity = homecity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "AnEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", jobtitle='" + jobtitle + '\'' +
                ", homecity='" + homecity + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
