package com.esi.bookings.domain.repository;

import com.esi.bookings.application.dto.PropertyDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by gerson on 09/06/17.
 */
public class PropertyRepositoryImpl implements CustomPropertyRepository {
    @Autowired
    EntityManager em;

    @Override
    public List<PropertyDTO> findAvailableProps(String city, LocalDate startDate, LocalDate endDate) {
        return em.createQuery("select distinct p FROM Property p WHERE (p.city) LIKE ?1 AND AND p.id not in (select r.property.id from Rental r where r.rentalPeriod.startDate < ?3 and r.rentalPeriod.endDate > ?2)")
                .setParameter(1, "%" + city + "%")
                .setParameter(2, startDate)
                .setParameter(3, endDate)
                .getResultList();
    }
}
