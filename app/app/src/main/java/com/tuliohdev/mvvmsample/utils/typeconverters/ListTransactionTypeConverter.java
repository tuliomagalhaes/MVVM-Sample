package com.tuliohdev.mvvmsample.utils.typeconverters;

import android.arch.persistence.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tuliohdev.mvvmsample.data.model.CreditCard;
import com.tuliohdev.mvvmsample.data.model.Transaction;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by tulio on 21/01/2018.
 */

public class ListTransactionTypeConverter {

    @TypeConverter
    public static List<Transaction> fromString(String value) {
        Type listType = new TypeToken<List<Transaction>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromList(List<Transaction> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}
