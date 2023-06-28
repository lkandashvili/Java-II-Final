package com.exam.lashakandashvili.services;

import com.exam.lashakandashvili.dtos.ApiResponse;
import com.exam.lashakandashvili.dtos.RoomDto;

public interface IRoomService {
    ApiResponse add(RoomDto dto);
    ApiResponse getAll();
}