package com.esi.bookings.domain.repository;

import com.esi.bookings.application.dto.PropertyDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by gerson on 09/06/17.
 */
public interface CustomPropertyRepository {

    List<PropertyDTO> findAvailableProps(String city, LocalDate startDate, LocalDate endDate);
}
