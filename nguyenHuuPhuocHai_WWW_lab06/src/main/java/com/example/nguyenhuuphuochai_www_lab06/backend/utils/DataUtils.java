package com.example.nguyenhuuphuochai_www_lab06.backend.utils;

import java.time.Instant;
import java.util.Date;

public class DataUtils {
    public static Date convertInstantToDate(Instant instant){
        return Date.from(instant);

    }
}
