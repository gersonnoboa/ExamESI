package com.esi.bookings.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;
import sun.misc.Resource;

import java.math.BigDecimal;

/**
 * Created by gerson on 09/06/17.
 */
@Data
@AllArgsConstructor(staticName = "of")
public class PropertyDTO extends ResourceSupport{
    String _id;

    String city;

    int price;

    String address;

    /*Float area;

    int floor;

    String amenities;

    boolean hasKitchen;

    int beds;

    boolean hasInternetAccess;

    boolean hasAirConditioning;*/
}
