package com.esi.bookings.infrastructure;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by gerson on 09/06/17.
 */

@Service
public class IdentifierFactory {
    public static String nextID() {
        return UUID.randomUUID().toString();
    }
}
