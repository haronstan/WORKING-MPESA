package com.example.mpesa_test.Interceptor;

import android.util.Base64;

import androidx.annotation.NonNull;

import com.example.mpesa_test.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AccessTokenInterceptor implements Interceptor {

        // Default constructor for the AccessTokenInterceptor class
        public AccessTokenInterceptor() {

        }

    @Override
public Response intercept(@NonNull Chain chain) throws IOException {

        // Combine the CONSUMER_KEY and CONSUMER_SECRET from BuildConfig into a single string
        String keys = BuildConfig.CONSUMER_KEY + ":" + BuildConfig.CONSUMER_SECRET;

        // Create a new request with the Authorization header added
        Request request = chain.request().newBuilder()
        .addHeader("Authorization", "Basic " + Base64.encodeToString(keys.getBytes(), Base64.NO_WRAP))
        .build();

        // Proceed with the request and return the response
        return chain.proceed(request);
        }
}
