package br.com.samuelgaitkoski.internacional_api.model.dto;

import br.com.samuelgaitkoski.internacional_api.model.Position;

public class PlayerDTO {

    private int id; 
    private String name;
    private Position position;
    private byte age;
    private byte weight;
    private short birthCity;
    private short birthCountry;
    private short birthYear;


    public PlayerDTO(int id, String name, Position position, byte age, byte weight, short birthCity, 
    short birthCountry, short birthYear) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.weight = weight;
        this.birthCity = birthCity;
        this.birthCountry = birthCountry;
        this.birthYear = birthYear;
    }

    public PlayerDTO() {
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

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public byte getAge() {
        return this.age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getWeight() {
        return this.weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
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

    public short getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(short birthYear) {
        this.birthYear = birthYear;
    }

}
