package com.esi.bookings.application.dto;

import com.esi.common.application.dto.RentalPeriodDTO;
import com.esi.common.domain.model.RentalPeriod;
import lombok.Data;

/**
 * Created by gerson on 09/06/17.
 */
@Data
public class BookingCreationDTO {
    String propertyId;
    String userId;
    RentalPeriod rentalPeriod;
}
