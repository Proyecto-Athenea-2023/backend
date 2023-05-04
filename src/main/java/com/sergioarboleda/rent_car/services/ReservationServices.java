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
            // TODO check datetime format
            if((reservation.getStartDate() != null) && (reservation.getEndDate() != null) &&
                    (reservation.getEndDate().compareTo(reservation.getStartDate()) < 0))
                if((reservation.getStatus() != null) != (reservation.getCost() != null)) {
                    reservation.setStatus(reservation.getStatus().toLowerCase());
                    return reservationRepository.save(reservation);
                }
                else
                    return reservation;
            else
                return reservation;
        }
        else
            return reservation;
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation updateReservation(Reservation reservation){
        if(reservation.getIdReservation() != null){
            Optional<Reservation> temp = reservationRepository.getById(reservation.getIdReservation());
            if(temp.isPresent()){
                if(reservation.getStatus() != null)
                    temp.get().setStatus(reservation.getStatus().toLowerCase());
                if(reservation.getCost() != null)
                    temp.get().setCost(reservation.getCost());
                if(reservation.getGrade() != null)
                    temp.get().setGrade(reservation.getGrade());
                if(reservation.getComment() != null)
                    temp.get().setComment(reservation.getComment());
                if(reservation.getEndDate() != null){
                    if(reservation.getEndDate().compareTo(temp.get().getStartDate()) > 0)
                        temp.get().setEndDate(reservation.getEndDate());
                }
                return reservationRepository.save(temp.get());
            }
            else
                return reservation;
        }
        else
            return reservation;
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
