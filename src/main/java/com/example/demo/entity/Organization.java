package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inn")
    private String inn;

    @Column(name = "ogrn")
    private String ogrn;

    @NotNull
    @Column(name = "mail_address", nullable = false)
    private String mailAddress;

    @NotNull
    @Column(name = "legal_address", nullable = false)
    private String legalAddress;

    @NotNull
    @Column(name = "ceo", nullable = false)
    private String ceo;

    @OneToMany(mappedBy = "org", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Filial> filials = new HashSet<>();

    public Organization(Integer id,
                        String fullName,
                        String name,
                        String inn,
                        String ogrn,
                        String mailAddress,
                        String legalAddress,
                        String ceo,
                        Set<Filial> filials) {
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

    public Organization() {

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

    public Set<Filial> getFilials() {
        return filials;
    }

    public void setFilials(Set<Filial> filials) {
        this.filials = filials;
    }
}
