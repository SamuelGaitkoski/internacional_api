package br.com.samuelgaitkoski.internacional_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (columnDefinition = "varchar(35) not null") 
    private String name;
    @Column (columnDefinition = "varchar(35) not null") 
    private String nickname;
    private byte age;
    private float height;
    private short birthCity;
    private short birthCountry;


    public Coach(int id, String name, String nickname, byte age, float height, short birthCity, 
    short birthCountry) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.height = height;
        this.birthCity = birthCity;
        this.birthCountry = birthCountry;
    }

    public Coach() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public byte getAge() {
        return this.age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public short getBirthCity() {
        return this.birthCity;
    }

    public void setBirthCity(short birthCity) {
        this.birthCity = birthCity;
    }

    public short getBirthCountry() {
        return this.birthCountry;
    }

    public void setBirthCountry(short birthCountry) {
        this.birthCountry = birthCountry;
    }

}
