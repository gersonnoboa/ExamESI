package com.esi.bookings.application.dto;

import com.esi.common.rest.ResourceSupport;
import lombok.AllArgsConstructor;
import lombok.Data;

import sun.misc.Resource;

import java.math.BigDecimal;

/**
 * Created by gerson on 09/06/17.
 */
@Data
//@AllArgsConstructor(staticName = "of")
public class PropertyDTO extends ResourceSupport {

    String _id;

    String city;

    Float price;

    String address;

    boolean free;

    /*Float area;

    int floor;

    String amenities;

    boolean hasKitchen;

    int beds;

    boolean hasInternetAccess;

    boolean hasAirConditioning;*/
}
