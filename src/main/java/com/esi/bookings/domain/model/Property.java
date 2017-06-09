package com.esi.bookings.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

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
public class Property extends ResourceSupport {
    @Id
    String _id;

    String city;

    int price;

    String address;

    Float area;

    int floor;

    String amenities;

    boolean hasKitchen;

    int beds;

    boolean hasInternetAccess;

    boolean hasAirConditioning;

    @ManyToOne
    User owner;

}
