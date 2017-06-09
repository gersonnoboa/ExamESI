package com.esi.bookings.rest.controller;

import com.esi.bookings.application.dto.BookingCreationDTO;
import com.esi.bookings.application.dto.PropertyDTO;
import com.esi.bookings.application.services.RentalService;
import com.esi.bookings.domain.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    //test: http://localhost:8080/api/bookings/properties?name=&startDate=2017-05-01&endDate=2017-07-03
    @GetMapping("/properties")
    public List<PropertyDTO> findProperties(
            @RequestParam(name = "name", required = false) String city,
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
            return rentalService.findAvailableProperties(city, startDate, endDate);
    }

    @PostMapping("/properties")
    public Rental submitBookingRequest(@RequestBody Optional<BookingCreationDTO> dto) throws Exception{
        return rentalService.submitBookingRequest(dto.get());
    }
}
