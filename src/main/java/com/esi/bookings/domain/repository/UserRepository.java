package com.esi.bookings.domain.repository;

import com.esi.bookings.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gerson on 09/06/17.
 */
@Repository
public interface UserRepository  extends JpaRepository<User, String> {
    User findBy_id(String id);
}
