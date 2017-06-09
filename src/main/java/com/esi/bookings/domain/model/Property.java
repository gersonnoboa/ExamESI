package com.esi.bookings.domain.model;

import com.esi.common.rest.ResourceSupport;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

/**
 * Created by gerson on 09/06/17.
 */

@Entity
@Getter
@NoArgsConstructor(force=true, access= AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class Property{
    @Id
    String _id;

    String city;

    Float price;

    String address;

    Float area;

    int floor;

    String amenities;

    boolean hasKitchen;

    int beds;

    boolean hasInternetAccess;

    boolean hasAirConditioning;

    boolean free;

    @ManyToOne
    User owner;

    public void setFree(boolean isFree){
        free = isFree;
    }

}
