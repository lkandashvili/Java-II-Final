package com.exam.lashakandashvili.services;

import com.exam.lashakandashvili.dtos.ApiResponse;
import com.exam.lashakandashvili.dtos.DateDto;
import com.exam.lashakandashvili.dtos.ReservationDto;

import java.util.Date;

public interface IReservationService {
    ApiResponse add(ReservationDto dto);
    ApiResponse getAll();

    ApiResponse getFreeRooms(DateDto dto);

    ApiResponse getBusyRooms(DateDto date);
}
