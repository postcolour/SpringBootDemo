package com.example.demo.dto.model;

public class FilialDto {
    private Integer id;
    private String fullName;
    private String name;
    private String mailAddress;
    private String director;

    public FilialDto(Integer id,
                     String fullName,
                     String name,
                     String mailAddress,
                     String director) {
        this.id = id;
        this.fullName = fullName;
        this.name = name;
        this.mailAddress = mailAddress;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
