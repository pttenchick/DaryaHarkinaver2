package com.example.daryaharkina.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.example.daryaharkina.entity.Flight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JSON {
        static final String path = "src/main/resources/json.json";

        //Метод записи списка в файл
        public void Write(List<Flight> list) throws IOException {
                try {

                        Writer writer = new FileWriter(path, false);
                        ObjectMapper mapper = new ObjectMapper();
                        ObjectWriter prettyWriter = mapper.writer(new DefaultPrettyPrinter());
                        prettyWriter.writeValue(writer, list);
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        //Метод удаления по ID
        public void removeById(List<Flight> list, int id) throws IOException {
                Flight flight;
                for (int i = 0; i < list.size(); i++) {
                        flight = list.get(i);

                        if (flight.getID() == id) {
                                list.remove(i);
                        }
                }
                Write(list);
        }

        //Метод прочтения файла json
        public void Read() throws IOException {
                File file =  new File(path);
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

                Flight.flightList = mapper.readValue(file, new TypeReference<List<Flight>>() {});
        }

        //Метод получения объекта по ID
        public Flight GetById(int id) {
                for(Flight flight : Flight.flightList) {
                        if(flight.getID() == id) {
                                return flight;
                        }
                }
                return null;
        }

        //Метод получения всей коллекции объектов
        public List<Flight> GetAllFlight(){
                List<Flight> list = new ArrayList<Flight>();
                list = Flight.flightList;
                return list;
        }

        public void Update(Flight flight){

                if(Flight.flightList.isEmpty()){
                        Flight.flightList.add(new Flight());
                }
                else {
                        for (var item : Flight.flightList) {
                                if (flight.getID() == item.getID() && flight != null) {
                                        item = flight;
                                }
                        }
                }
        }
}

