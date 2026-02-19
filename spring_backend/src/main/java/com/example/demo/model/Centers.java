package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "centers")
public class Centers {

    @Id
    @Column(name = "center_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer centerId;
    @Column(name = "center_name")
    private String centerName;

    public Centers(){}

    public Centers(Integer centerId,String centerName){
        this.centerId=centerId;
        this.centerName=centerName;
    }
    public Integer getCenterId(){return this.centerId;}
    public void setCenterName(String centerName){ this.centerName=centerName;}
    public String getCenterName(){return this.centerName;}

}
