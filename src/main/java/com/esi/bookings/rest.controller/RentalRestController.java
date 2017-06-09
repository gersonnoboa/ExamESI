package com.esi.bookings.rest.controller;

import com.esi.bookings.application.dto.PropertyDTO;
import com.esi.bookings.application.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by gerson on 09/06/17.
 */
@RestController
@CrossOrigin()
@RequestMapping("/api/bookings")
public class RentalRestController {

    @Autowired
    RentalService rentalService;

    @GetMapping("/properties/{id}")
    public PropertyDTO findProperty(@PathVariable String id) throws Exception {
        return rentalService.getEntryById(id);
    }

    @GetMapping("/properties")
    public List<PropertyDTO> findProperties(
            @RequestParam(name = "name", required = false) String city,
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
            return rentalService.findAvailableProperties(city, startDate, endDate);
    }
}
