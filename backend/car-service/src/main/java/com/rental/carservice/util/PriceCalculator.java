package com.rental.carservice.util;

import com.rental.carservice.model.Car;
import com.rental.carservice.model.Period;
import com.rental.carservice.model.Season;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Set;

@Component
public class PriceCalculator {

    public static BigDecimal calculateTotalAmount(Car car, OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        int totalDays = getTotalDays(rentalDate, returnDate);
        car.setRentalRate(getChange(car, rentalDate, returnDate));
        return car.getRentalRate().multiply(BigDecimal.valueOf(totalDays));
    }

    private static BigDecimal getChange(Car car, OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        BigDecimal seasonChange = getSeasonChange(car, rentalDate, returnDate);
        Set<Period> periods = car.getGroup().getPeriods();
        int totalDays = getTotalDays(rentalDate, returnDate);
        return getPeriodChange(periods, seasonChange, totalDays);
    }

    private static int getTotalDays(OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        Duration difference = Duration.between(rentalDate, returnDate);
        long minutes = difference.toMinutes();
        return (int) Math.ceil((double) minutes / 1440);
    }

    private static BigDecimal getSeasonChange(Car car, OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        Season season = getSeason(car.getGroup().getSeasons(), rentalDate, returnDate);
        if (season != null) {
            return calculatePriceValue(car.getRentalRate(), season.getChangeValue(), season.isFixed());
        }
        return car.getRentalRate();
    }

    private static Season getSeason(Set<Season> seasons, OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        for (Season s : seasons) {
            if (areDaysInRange(rentalDate, s.getStartDate(), returnDate, s.getEndDate())) {
                return s;
            }
        }
        return null;
    }

    private static BigDecimal getPeriodChange(Set<Period> periods, BigDecimal rentalRate, int totalDays) {
        Period period = getPeriod(periods, totalDays);
        if (period != null) {
            return calculatePriceValue(rentalRate, period.getChangeValue(), period.isFixed());
        }
        return rentalRate;
    }

    private static Period getPeriod(Set<Period> periods, int totalDays) {
        Period period = null;
        for (Period p : periods) {
            int startDay = p.getStartDay();
            int endDay = p.getEndDay();
            if (totalDays >= startDay && (totalDays <= endDay || endDay == 0)) {
                period = p;
            }
        }
        return period;
    }

    private static boolean areDaysInRange(OffsetDateTime rentalDate, OffsetDateTime startDate,
                                   OffsetDateTime returnDate, OffsetDateTime endDate) {
        return rentalDate.isAfter(startDate) && returnDate.isBefore(endDate);
    }

    private static BigDecimal calculatePriceValue(BigDecimal rentalPrice, int change, boolean isFixed) {
        if (isFixed) {
            return rentalPrice.add(BigDecimal.valueOf(change));
        } else {
            double percentage = ((double) (100 + change) / 100);
            return rentalPrice.multiply(BigDecimal.valueOf(percentage));
        }
    }
}
