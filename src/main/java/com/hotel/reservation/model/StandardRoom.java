package com.hotel.reservation.model;

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
@DiscriminatorValue("StandardRoom")
@Table(name = "standard_rooms")
@PrimaryKeyJoinColumn(name = "room_id")
public class StandardRoom extends Room {

    @Override
    public String getRoomType() {
        return "STANDARD";
    }

    @Override
    public double calculatePrice(int nights) {
        return this.getPricePerNight() * nights;
    }
}