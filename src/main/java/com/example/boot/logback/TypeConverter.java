package com.example.boot.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class TypeConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {

        return null;
    }
}
