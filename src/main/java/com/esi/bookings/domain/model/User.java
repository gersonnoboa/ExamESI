package com.esi.bookings.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import sun.misc.Resource;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by gerson on 09/06/17.
 */

@Entity
@Getter
@NoArgsConstructor(force=true, access= AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class User extends ResourceSupport{

    @Id
    String _id;

    String name;

    int bitcoins;
}
