package com.exam.lashakandashvili.services.impl;

import com.exam.lashakandashvili.dtos.ApiResponse;
import com.exam.lashakandashvili.dtos.DateDto;
import com.exam.lashakandashvili.dtos.ReservationDto;
import com.exam.lashakandashvili.entities.RecordState;
import com.exam.lashakandashvili.entities.Reservation;
import com.exam.lashakandashvili.entities.Room;
import com.exam.lashakandashvili.repositories.HotelRepository;
import com.exam.lashakandashvili.repositories.ReservationRepository;
import com.exam.lashakandashvili.repositories.RoomRepository;
import com.exam.lashakandashvili.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService  implements IReservationService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationService(RoomRepository roomRepository, HotelRepository hotelRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ApiResponse add(ReservationDto dto) {
        Reservation reservation = new Reservation();
        reservation.setRoom(roomRepository.getById(dto.getRoomId()));
        reservation.setFrom(dto.getFrom());
        reservation.setTo(dto.getTo());
        reservation.setRecordState(RecordState.ACTIVE);
        return new ApiResponse("status",reservationRepository.save(reservation));
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("reservation",reservationRepository.getAll());
    }

    @Override
    public ApiResponse getFreeRooms(DateDto dto) {
        List<Room> busyRooms = reservationRepository.getBusyRooms(dto);
        List<Long> ids = busyRooms.stream()
                .map(Room::getId)
                .collect(Collectors.toList());
        return new ApiResponse("reservation",roomRepository.getRoomsByIdNotIn(ids));
    }

    @Override
    public ApiResponse getBusyRooms(DateDto dto) {
        return new ApiResponse("status",reservationRepository.getBusyRooms(dto));
    }
}
