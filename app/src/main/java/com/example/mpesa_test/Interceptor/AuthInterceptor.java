package com.example.mpesa_test.Interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

// This class implements the Interceptor interface from OkHttp to add an Authorization header to outgoing HTTP requests.
public class AuthInterceptor implements Interceptor {

        // A string to hold the authentication token.
        private String mAuthToken;

        // Constructor that accepts an authentication token and initializes the mAuthToken field.
        public AuthInterceptor(String authToken) {
        mAuthToken = authToken;
        }

// It adds the Authorization header to the request and then proceeds with the request.
@Override
public Response intercept(@NonNull Chain chain) throws IOException {

        // Build a new request by adding the Authorization header with the Bearer token.
        Request request  = chain.request().newBuilder()
        .addHeader("Authorization", "Bearer " + mAuthToken)
        .build();

        // Proceed with the request.
        return chain.proceed(request);
        }
        }
