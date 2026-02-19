package com.example.demo.dto;

public class DoctorDto {
    private String fullName;
    private String cin;
    public DoctorDto(String fullName,String cin){
       this.fullName=fullName;
       this.cin=cin;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    public String getFullName(){
        return this.fullName;
    }
    public void setCin(String cin){
        this.cin=cin;
    }
    public String getCin(){
        return this.cin;
    }
    
}
