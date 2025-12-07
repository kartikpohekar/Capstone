package com.example.entity;
import jakarta.persistence.*;

@Entity
@Table(name="owner")
public class Owner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;
    private String username;
    private String password;
    private String email;
    private String name;

    public Long getOwnerId(){return ownerId;}
    public void setOwnerId(Long id){this.ownerId=id;}

    public String getUsername(){return username;}
    public void setUsername(String u){this.username=u;}

    public String getPassword(){return password;}
    public void setPassword(String p){this.password=p;}

    public String getEmail(){return email;}
    public void setEmail(String e){this.email=e;}

    public String getName(){return name;}
    public void setName(String n){this.name=n;}
}
