package com.esi.bookings.application.services;

import com.esi.bookings.application.dto.PropertyDTO;
import com.esi.bookings.domain.model.Property;
import com.esi.bookings.domain.repository.CustomPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by gerson on 09/06/17.
 */

@Service
public class RentalService {

    @Autowired
    CustomPropertyRepository propertyRepository;


    public PropertyDTO getEntryById(String entryId) throws Exception {

        return propertyRepository.findPropertyById(entryId);

    }

    public List<PropertyDTO> findAvailableProperties(String city, LocalDate startDate, LocalDate endDate){
        return propertyRepository.findAvailableProps(city, startDate, endDate);
    }
}
