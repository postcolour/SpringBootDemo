package com.example.demo.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class OrganizationDto {
    private Integer id;
    private String fullName;
    private String name;
    private String inn;
    private String ogrn;
    private String mailAddress;
    private String legalAddress;
    private String ceo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FilialDto> filials;

    public OrganizationDto() {

    }
    public OrganizationDto(Integer id,
                           String fullName,
                           String name,
                           String inn,
                           String ogrn,
                           String mailAddress,
                           String legalAddress,
                           String ceo,
                           List<FilialDto> filials) {
        this.id = id;
        this.fullName = fullName;
        this.name = name;
        this.inn = inn;
        this.ogrn = ogrn;
        this.mailAddress = mailAddress;
        this.legalAddress = legalAddress;
        this.ceo = ceo;
        this.filials = filials;
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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public List<FilialDto> getFilials() {
        return filials;
    }

    public void setFilials(List<FilialDto> filials) {
        this.filials = filials;
    }
}
