package com.tuliohdev.mvvmsample.data.creditcard;

import com.tuliohdev.mvvmsample.data.model.CreditCard;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;

/**
 * Created by tulio on 16/01/2018.
 */

public interface CreditCardApiService {

    String PATH = "card";

    @GET(PATH + "/getAll")
    Single<List<CreditCard>> getAllCreditCards();

}
