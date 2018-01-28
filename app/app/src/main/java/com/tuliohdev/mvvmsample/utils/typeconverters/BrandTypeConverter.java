package com.tuliohdev.mvvmsample.utils.typeconverters;

import android.arch.persistence.room.TypeConverter;

import static com.tuliohdev.mvvmsample.data.model.repositorymodel.CreditCardRM.*;

/**
 * Created by tulio on 21/01/2018.
 */

public class BrandTypeConverter {

    @TypeConverter
    public static BrandType toBrandType(String value) {
        return BrandType.valueOf(value);
    }

    @TypeConverter
    public static String fromBrandType(BrandType value) {
        return value.toString();
    }
}
