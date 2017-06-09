package com.esi.bookings.domain.model;

import com.esi.common.domain.model.RentalPeriod;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by gerson on 09/06/17.
 */

@Entity
@Getter
@NoArgsConstructor(force=true, access= AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class Rental extends ResourceSupport{

    @Id
    String _id;

    @ManyToOne
    User user;

    @ManyToOne
    Property property;

    @Embedded
    RentalPeriod rentalPeriod;

    @Enumerated(EnumType.STRING)
    RentalStatus status;

}
