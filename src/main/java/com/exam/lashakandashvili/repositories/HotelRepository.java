package com.exam.lashakandashvili.repositories;

import com.exam.lashakandashvili.dtos.ApiResponse;
import com.exam.lashakandashvili.dtos.HotelDto;
import com.exam.lashakandashvili.entities.Hotel;
import com.exam.lashakandashvili.entities.Reservation;
import com.exam.lashakandashvili.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long>  {

    @Query("SELECT u FROM Hotel u")
    List<Hotel> getAll();
    @Query("SELECT u.name FROM Hotel u where u.id=:#{#id}")
    String getHotelNameById(Long id);


}