package com.exam.lashakandashvili.entities;

import com.exam.lashakandashvili.dtos.HotelDto;
import com.exam.lashakandashvili.dtos.ReservationDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RESERVATION")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Reservation extends com.exam.lashakandashvili.entities.AppEntity<Long> {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "reservationIdSeq", sequenceName = "RESERVATION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationIdSeq")
    private Long id;

    @Column(name = "RESERVATION_TO")
    private Date to;
    @Column(name = "RESERVATION_FROM")
    private Date from;

    public Reservation(ReservationDto dto){
        this.to = dto.getTo();
        this.from = dto.getFrom();
    }

    @ManyToOne
    private Room room;
}

