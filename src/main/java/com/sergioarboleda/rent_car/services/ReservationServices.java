package com.sergioarboleda.rent_car.services;

import com.sergioarboleda.rent_car.models.Reservation;
import com.sergioarboleda.rent_car.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     *
     * @return
     */
    public List<Reservation> getAllReservations(){
        return reservationRepository.getAll();
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @param status
     * @return
     */
    public List<Reservation> getAllReservationsByDatesAndStatus(String startDate, String endDate, String status){
        if(endDate.compareTo(startDate) < 0) // Validate endDate is not previous to startDate
            return null;
        status = status.toLowerCase();
        return reservationRepository.getAllByDatesAndStatus(startDate, endDate, status);
    }

    /**
     *
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservationById(Integer reservationId){
        if(reservationId < 0)
            return null;
        return reservationRepository.getById(reservationId);
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation insertReservation(Reservation reservation){
        if((reservation.getCarFK() != null) && (reservation.getClientFK() != null)){
            if((reservation.getStartDate() != null) && (reservation.getEndDate() != null) &&
                    (reservation.getEndDate().compareTo(reservation.getStartDate()) < 0))
                if((reservation.getStatus() != null) != (reservation.getCost() != null))
                    return reservationRepository.save(reservation);
                else
                    return reservation;
            else
                return reservation;
        }
        else
            return reservation;
    }

    public Reservation updateReservation(Reservation reservation){

    }

    /**
     *
     * @param reservationId
     * @return
     */
    public boolean deleteReservation(Integer reservationId){
       Boolean success = getReservationById(reservationId).map(reservation -> {
           reservationRepository.delete(reservation);
           return true;
       }).orElse(false);
       return success;
    }
}
