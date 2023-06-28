package com.exam.lashakandashvili.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomDto {
    private Long hotelId;
    private String number;
    private float oneNightPrice;
}