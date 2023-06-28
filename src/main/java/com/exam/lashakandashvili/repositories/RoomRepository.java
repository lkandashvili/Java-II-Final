package com.exam.lashakandashvili.repositories;


import com.exam.lashakandashvili.dtos.ApiResponse;
import com.exam.lashakandashvili.dtos.RoomDto;
import com.exam.lashakandashvili.entities.Reservation;
import com.exam.lashakandashvili.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT u FROM Room u")
    List<Room> getAll();

    List<Room> getRoomsByIdNotIn(List<Long> id);
    List<Room> getRoomsByHotelIdAndIdNotIn(Long hotelId,List<Long> id);

}
