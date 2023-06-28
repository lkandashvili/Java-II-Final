package com.exam.lashakandashvili.services;


import com.exam.lashakandashvili.dtos.ApiResponse;
import com.exam.lashakandashvili.dtos.DateDto;
import com.exam.lashakandashvili.dtos.HotelDto;

public interface IHotelService {
    ApiResponse add(HotelDto dto);
    ApiResponse getAll();

    ApiResponse getFreeRooms(Long id, DateDto dto);

    ApiResponse sales();
}
