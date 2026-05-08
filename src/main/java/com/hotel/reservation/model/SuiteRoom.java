package com.hotel.reservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@DiscriminatorValue("SuiteRoom")
@Table(name = "suite_rooms")
@PrimaryKeyJoinColumn(name = "room_id")
public class SuiteRoom extends Room {

    @Column(name = "has_jacuzzi")
    private Boolean hasJacuzzi = false;

    @Override
    public String getRoomType() {
        return "SUITE";
    }

    @Override
    public double calculatePrice(int nights) {
        return this.getPricePerNight() * nights * 1.25;
    }
}