package com.esi.common.application.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by gerson on 09/06/17.
 */
@Data
public class RentalPeriodDTO {
    LocalDate startDate;
    LocalDate endDate;
}
