package com.example.daryaharkina.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    //Уникальный идентификатор рейса
    private int ID;
    //Город отправления
    private String departure_city;
    //Город прибытия
    private String arrival_city;
    //Кол-во пассажиров
    private int number_passengers;
    //Длительность перелета
    private String duration;
    //Стоимость
    private double price;

    //Внутренний список рейсов
    public static List<Flight> flightList = new ArrayList();

    public Flight(int ID, String departure_city, String arrival_city, int number_passengers, String duration, double price) {
        this.ID = ID;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.number_passengers = number_passengers;
        this.duration = duration;
        this.price = price;

        //Добавление объекта во внутреннюю коллекцию
        flightList.add(this);
    }

    public Flight()
    {
        this.ID = 0;
        this.departure_city = "000";
        this.arrival_city = "000";
        this.number_passengers = 0;
        this.duration = "000";
        this.price = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public int getNumber_passengers() {
        return number_passengers;
    }

    public void setNumber_passengers(int number_passengers) {
        this.number_passengers = number_passengers;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
