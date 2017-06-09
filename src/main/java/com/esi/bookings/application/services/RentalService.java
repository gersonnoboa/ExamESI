package com.esi.bookings.application.services;

import com.esi.bookings.application.dto.BookingCreationDTO;
import com.esi.bookings.application.dto.PropertyDTO;
import com.esi.bookings.domain.model.Property;
import com.esi.bookings.domain.model.Rental;
import com.esi.bookings.domain.model.RentalStatus;
import com.esi.bookings.domain.model.User;
import com.esi.bookings.domain.repository.CustomPropertyRepository;
import com.esi.bookings.domain.repository.PropertyRegularRepository;
import com.esi.bookings.domain.repository.RentalRepository;
import com.esi.bookings.domain.repository.UserRepository;
import com.esi.bookings.infrastructure.IdentifierFactory;
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

    @Autowired
    PropertyRegularRepository propertyRegularRepository;

    @Autowired
    PropertyAssembler propertyAssembler;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IdentifierFactory identifierFactory;

    @Autowired
    RentalRepository rentalRepository;

    public PropertyDTO getEntryById(String entryId) throws Exception {

        Property prop = propertyRepository.findPropertyById(entryId);
        return propertyAssembler.toResource(prop);

    }

    public List<PropertyDTO> findAvailableProperties(String city, LocalDate startDate, LocalDate endDate){
        List<Property> properties = propertyRepository.findAvailableProps(city, startDate, endDate);
        return propertyAssembler.toResources(properties);
    }

    public Rental submitBookingRequest(BookingCreationDTO dto) throws Exception{

        Property property = propertyRepository.findPropertyById(dto.getPropertyId());

        User guest = userRepository.getOne(dto.getUserId());

        Rental rental = Rental.of(
                identifierFactory.nextID(),
                guest,
                property,
                dto.getRentalPeriod(),
                RentalStatus.OPEN
        );

            Float fraction = (property.getPrice() / 2);

        if (guest.getBitcoins() >= fraction){
            User host = property.getOwner();
            guest.changeBitcoins(-fraction);
            host.changeBitcoins(fraction);

            rental.changeStatus(RentalStatus.ACCEPTED);
            property.setFree(false);
        }
        else{
            rental.changeStatus(RentalStatus.REJECTED);
            property.setFree(true);
        }

        propertyRegularRepository.save(property);
        userRepository.save(guest);
        return rentalRepository.save(rental);
    }
}
