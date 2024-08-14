package com.example.mpesa_test.Services;

import com.example.mpesa_test.Model.AccessToken;
import com.example.mpesa_test.Model.STKPush;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

// Interface defining the API endpoints for the M-Pesa STK Push service.
public interface STKPushService {

    // Endpoint to process an STK Push request.
    @POST("mpesa/stkpush/v1/processrequest")
    Call<STKPush> sendPush(@Body STKPush stkPush);

    // Endpoint to retrieve an access token.
    @GET("oauth/v1/generate?grant_type=client_credentials")
    Call<AccessToken> getAccessToken();
}