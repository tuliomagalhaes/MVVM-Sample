package com.tuliohdev.mvvmsample.utils.typeconverters;

import android.arch.persistence.room.TypeConverter;
import com.tuliohdev.mvvmsample.data.model.repositorymodel.TransactionRM.OperationType;

/**
 * Created by tulio on 21/01/2018.
 */

public class OperationTypeConverter {

    @TypeConverter
    public static OperationType toOperationType(String value) {
        return OperationType.valueOf(value);
    }

    @TypeConverter
    public static String fromOperationType(OperationType value) {
        return value.toString();
    }

}
