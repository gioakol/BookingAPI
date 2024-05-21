package com.app.reservas.service;

import com.app.reservas.entities.Reservation;
import com.app.reservas.repository.ClientCount;
import com.app.reservas.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getById(int id) {
        return reservationRepository.getById(id);
    }

    public List<ClientCount> getByClient(){
        return reservationRepository.getByClient();
    }

    public List<Reservation> getByDate(String dateStart, String dateFinish) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dtStart = new Date();
        Date dtFinish = new Date();
        try
        {
            dtStart = format.parse(dateStart);
            dtFinish = format.parse(dateFinish);
        }
        catch(ParseException e) {
            e.printStackTrace();
        }
        if(dtStart.before(dtFinish)){
            return reservationRepository.getByDate(dtStart, dtFinish);
        } else{
            return new ArrayList<>();
        }
    }

    public ClientStatus getByStatus(){
        List<Reservation> completed = reservationRepository.getByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getByStatus("cancelled");
        return new ClientStatus(completed.size(),cancelled.size());
    }

    public Reservation save(Reservation p) {
        if (p.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getById(p.getIdReservation());
            if (e.isPresent()){
                return e.get();
            }
            else{
                return reservationRepository.save(p);
            }
        } else {
            return reservationRepository.save(p);
        }
    }

    public Reservation update(Reservation p) {
        if(p.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getById(p.getIdReservation());
            if (e.isPresent()){
                if(p.getStartDate()!=null){
                    e.get().setStartDate(p.getStartDate());
                }
                if(p.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(p.getDevolutionDate());
                }
                if(p.getStatus()!=null){
                    e.get().setStatus(p.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }
            else{
                return p;
            }
        }
        else {
            return p;
        }
    }

    public boolean delete(int id) {
        boolean res = false;
        Optional<Reservation> e = reservationRepository.getById(id);
        if (e.isPresent()) {
            reservationRepository.delete(e.get());
            res = true;
        }
        return res;
    }



}
