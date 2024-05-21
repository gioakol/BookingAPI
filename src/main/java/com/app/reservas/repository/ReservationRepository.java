package com.app.reservas.repository;

import com.app.reservas.entities.Client;
import com.app.reservas.repository.crudRepository.ReservationCrudRepository;
import com.app.reservas.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getById(int id) {
        return reservationCrudRepository.findById(id);
    }

    public List<ClientCount> getByClient(){
        List<ClientCount> r = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.getByClient();
        for(int i=0;i<report.size();i++){
            r.add(new ClientCount((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return r;
    }

    public List<Reservation> getByDate(Date dateStart, Date dateFinish) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateStart, dateFinish);
    }

    public List<Reservation> getByStatus(String status) {
        return reservationCrudRepository.getByStatus(status);
    }

    public Reservation save(Reservation p) {
        return reservationCrudRepository.save(p);
    }

    public void delete(Reservation p) {
        reservationCrudRepository.delete(p);
    }
}
