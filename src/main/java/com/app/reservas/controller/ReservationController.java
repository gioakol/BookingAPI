package com.app.reservas.controller;

import com.app.reservas.entities.Reservation;
import com.app.reservas.repository.ClientCount;
import com.app.reservas.service.ClientStatus;
import com.app.reservas.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getById(@PathVariable("id") int id) {
        return reservationService.getById(id);
    }

    @GetMapping("/report-clients")
    public List<ClientCount> getByClient(){
        return reservationService.getByClient();
    }

    @GetMapping("/report-dates/{dateStart}/{dateFinish}")
    public List<Reservation> getByDate(@PathVariable("dateStart") String dateStart,@PathVariable("dateFinish") String dateFinish){
        return reservationService.getByDate(dateStart, dateFinish);
    }

    @GetMapping("/report-status")
    public ClientStatus getByStatus(){
        return reservationService.getByStatus();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p) {
        return reservationService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation p) {
        return reservationService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return reservationService.delete(id);
    }
}
