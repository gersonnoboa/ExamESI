package com.esi.bookings.application.services;

import com.esi.bookings.application.dto.PropertyDTO;
import com.esi.bookings.domain.model.Property;
import com.esi.bookings.rest.controller.RentalRestController;
import com.esi.common.rest.ExtendedLink;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by gerson on 09/06/17.
 */
@Service
public class PropertyAssembler extends ResourceAssemblerSupport<Property, PropertyDTO> {
    public PropertyAssembler() {
        super(RentalRestController.class, PropertyDTO.class);
    }

    @Override
    public PropertyDTO toResource(Property property){
        PropertyDTO dto = createResourceWithId(property.get_id(), property);
        dto.set_id(property.get_id());
        dto.setCity(property.getCity());
        dto.setPrice(property.getPrice());
        dto.setAddress(property.getAddress());
        dto.setFree(property.isFree());
        //PropertyDTO dto = PropertyDTO.of(, property.getCity(), property.getPrice(), property.getAddress());

        try {
            dto.add(new ExtendedLink(linkTo(methodOn(RentalRestController.class).findProperty(dto.get_id())).toString(),
                    "self", HttpMethod.GET));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }
}
