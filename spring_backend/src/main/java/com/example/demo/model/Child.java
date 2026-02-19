package com.example.demo.model;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "child")
public class Child {

   
    @Column(name="cin")
    private String cin;
    @Column(name="full_name")
    private String fullName;
    @Id
    @Column(name = "child_id")
    private Long childId;
    @Column(name="gender")
    private String gender;
    @Column(name = "birth_date")
    private Date birthDate;
  
  

    public Child() {}

    public Child(Long childId, String fullName,String gender,Date birthDate,String cin) {
        this.fullName = fullName;
        this.cin = cin;
        this.gender=gender;
        this.birthDate=birthDate;
        this.childId=childId;
       
    }
    public void setFullName(String fullName){this.fullName=fullName;}
    public String getFullName(){return this.fullName;}
    public void setCin(String cin){this.cin=cin;}
    public String getCin(){return this.cin;}
    public void setBirthDate(Date birthDate){this.birthDate=birthDate;}
    public Date getBirthDate(){return this.birthDate;}
    public void setGender(String gender){this.gender=gender;}
    public String setGender(){return this.gender;}
    public void setChildId(Long childId){this.childId=childId;}
    public Long setChildId(){return (Long) this.childId;}
}
