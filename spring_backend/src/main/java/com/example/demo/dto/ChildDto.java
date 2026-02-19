package com.example.demo.dto;

import java.sql.Date;

public class ChildDto {
    private String fullName;
    private String gender;
    private Date birthDate;
    private Long childId;


    public ChildDto(Long childId, String fullName,String gender,Date birthDate) {
        this.gender = gender;
        this.birthDate = birthDate;
        this.fullName=fullName;
        this.childId=childId;
    }

    public Date getBirthDate(){return this.birthDate;}
    public void setBirthDate(Date birthDate){this.birthDate=birthDate;}
    public void setGender(String gender){this.gender=gender;}
    public String getGender() { return this.gender; }
    public String getFullName(){return this.fullName;}
    public void setFullName(String fullName){this.fullName=fullName;}
    public Long getChildId(){return (Long) this.childId;}
    public void setChildId(Long childId){this.childId=childId;}
   
}
