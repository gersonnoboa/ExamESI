package com.esi.bookings.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.esi.common.rest.ResourceSupport;
import sun.misc.Resource;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * Created by gerson on 09/06/17.
 */

@Entity
@Getter
@NoArgsConstructor(force=true, access= AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class User{

    @Id
    String _id;

    String name;

    Float bitcoins;

    @Enumerated(EnumType.STRING)
    UserRole userRole;

    public void changeBitcoins(Float change){
        bitcoins = bitcoins - change;
    }
}
