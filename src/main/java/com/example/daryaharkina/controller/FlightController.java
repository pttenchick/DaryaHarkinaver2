package com.example.daryaharkina.controller;

import com.example.daryaharkina.service.ServiceFlight;
import com.example.daryaharkina.entity.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class FlightController {

    ServiceFlight serviceFlight;

    @GetMapping("{id}")
    public Flight getFlight(@PathVariable("id") int id) throws IOException {
        Flight flight = serviceFlight.GetByID(id);
        return flight;
    }

    @PostMapping("save")
    public void SaveList() throws IOException {
        serviceFlight.Write();
    }

    @DeleteMapping("delete/{id}")
    public void Delete(@PathVariable int id) throws IOException {
        serviceFlight.RemoveByID(id);
    }

    @GetMapping("get_all")
    public List<Flight> GetAll() throws IOException {
        return serviceFlight.GetAllFlight();
    }

    @PutMapping("update")
    public  void Update(@RequestBody Flight flight) throws  IOException{
        serviceFlight.Update(flight);
    }

    @PostMapping("read")
    public String Read() throws IOException {
        serviceFlight.Read();
        return "controller read";
    }

}
