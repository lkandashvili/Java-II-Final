package com.exam.lashakandashvili.services.impl;
import com.exam.lashakandashvili.dtos.ApiResponse;
import com.exam.lashakandashvili.dtos.RoomDto;
import com.exam.lashakandashvili.entities.RecordState;
import com.exam.lashakandashvili.entities.Room;
import com.exam.lashakandashvili.repositories.HotelRepository;
import com.exam.lashakandashvili.repositories.RoomRepository;
import com.exam.lashakandashvili.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public ApiResponse add(RoomDto dto) {
        Room room = new Room();
        room.setNumber(dto.getNumber());
        room.setRecordState(RecordState.ACTIVE);
        room.setOneNightPrice(dto.getOneNightPrice());
        room.setHotel(hotelRepository.getById(dto.getHotelId()));
        return new ApiResponse("status",roomRepository.save(room));
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("rooms",roomRepository.getAll());
    }

}