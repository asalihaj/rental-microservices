package com.rental.carservice.util;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObjectValidation {

    public <T> T setValue(T newValue, T currentValue) {
        return newValue != null ? newValue : currentValue;
    }

    public <T> T getEntry(Optional<T> data) {
        return data.orElse(null);
    }
}
