package com.esi.common.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by gerson on 09/06/17.
 */

@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class RentalPeriod {

    LocalDate startDate;
    LocalDate endDate;

    public long numberOfWorkingDays() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    public boolean intersects(RentalPeriod other) {
        return !(other.startDate.isAfter(this.endDate) ||
                other.endDate.isBefore(this.startDate) ||
                other.startDate.isEqual(this.endDate) ||
                other.endDate.isEqual(this.startDate));
    }
}
