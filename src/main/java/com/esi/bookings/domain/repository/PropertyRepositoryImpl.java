package com.esi.bookings.domain.repository;

import com.esi.bookings.application.dto.PropertyDTO;
import com.esi.bookings.domain.model.Property;
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
    public List<Property> findAvailableProps(String city, LocalDate startDate, LocalDate endDate) {

        List<Property> properties = em.createQuery("select distinct p FROM Property p WHERE (p.city) LIKE ?1 AND p.free = true AND p.id not in (select r.property.id from Rental r where r.rentalPeriod.startDate < ?3 and r.rentalPeriod.endDate > ?2 AND r.status <> 'CLOSED')")
                .setParameter(1, "%" + city + "%")
                .setParameter(2, startDate)
                .setParameter(3, endDate)
                .getResultList();

        return properties;
    }

    @Override
    public Property findPropertyById(String id) throws Exception{

        System.out.println("Id: " + id);
        try{
            return (Property) em.createQuery("select distinct p FROM Property p WHERE p._id = ?1").setParameter(1, id).getSingleResult();
        }
        catch (Exception e){
            throw new Exception("Property not found");
        }

    }
}
