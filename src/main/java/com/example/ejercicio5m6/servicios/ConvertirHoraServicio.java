package com.example.ejercicio5m6.servicios;

import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
@Service
public class ConvertirHoraServicio implements IConvertirHoraServicio {

    @Override
    public Time convertirCadenaAHora(String tiempoString) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            java.util.Date tiempo = sdf.parse(tiempoString);
            Time hora = new Time(tiempo.getTime());
            return hora;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

