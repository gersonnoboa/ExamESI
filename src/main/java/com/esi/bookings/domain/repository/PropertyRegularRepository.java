package com.esi.bookings.domain.repository;

import com.esi.bookings.domain.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gerson on 09/06/17.
 */
@Repository
public interface PropertyRegularRepository extends JpaRepository<Property, String> {
}
