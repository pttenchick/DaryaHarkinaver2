package com.example.daryaharkina.service;

import com.example.daryaharkina.entity.Flight;
import org.springframework.stereotype.Service;
import com.example.daryaharkina.repository.JSON;
import java.io.IOException;
import java.util.List;

@Service
public class ServiceFlight {

    private JSON json;

    public void Write() throws IOException {
        json.Write(Flight.flightList);
    }

    public void RemoveByID(int id) throws IOException {
        json.removeById(Flight.flightList, id);
    }

    public String Read() throws IOException {
        json.Read();
        return "service read";
    }

    public Flight GetByID(int id){
        return json.GetById(id);
    }

    public List<Flight> GetAllFlight(){
        return json.GetAllFlight();
    }

    public void Update(Flight flight){
        json.Update(flight);
    }
}
