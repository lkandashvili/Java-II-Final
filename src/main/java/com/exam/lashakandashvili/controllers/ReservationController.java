package com.exam.lashakandashvili.controllers;

import com.exam.lashakandashvili.dtos.ApiResponse;
import com.exam.lashakandashvili.dtos.DateDto;
import com.exam.lashakandashvili.dtos.ReservationDto;
import com.exam.lashakandashvili.dtos.RoomDto;
import com.exam.lashakandashvili.services.IReservationService;
import com.exam.lashakandashvili.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final IReservationService reservationService;
    @Autowired
    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ApiResponse addReservation(@RequestBody ReservationDto dto){
        return this.reservationService.add(dto);
    }
    @GetMapping(value = "/getAll")
    public ApiResponse getReservations(){
        return this.reservationService.getAll();
    }
    @GetMapping(value = "/getBusyRooms")
    public ApiResponse getBusyRooms(@RequestBody DateDto dto){
        return this.reservationService.getBusyRooms(dto);
    }
    @GetMapping(value = "/getFreeRooms")
    public ApiResponse getFreeRooms(@RequestBody DateDto dto){
        return this.reservationService.getFreeRooms(dto);
    }
}

