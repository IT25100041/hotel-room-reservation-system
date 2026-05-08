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
@DiscriminatorValue("DeluxeRoom")
@Table(name = "deluxe_rooms")
@PrimaryKeyJoinColumn(name = "room_id")
public class DeluxeRoom extends Room {

    @Column(name = "has_sea_view")
    private Boolean hasSeaView = false;

    @Override
    public String getRoomType() {
        return "DELUXE";
    }

    @Override
    public double calculatePrice(int nights) {
        return this.getPricePerNight() * nights * 1.1;
    }
}