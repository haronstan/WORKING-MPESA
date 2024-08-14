package com.example.mpesa_test.Model;

import okhttp3.*;
import org.json.JSONObject;
import java.io.IOException;

// This class handles sending a request to the M-Pesa API and receiving a response asynchronously.
public class MpesaRequest {

// Interface for callback methods to handle success and failure responses.
public interface MpesaRequestCallback {
        void onSuccess(String response);
        void onFailure(String error);
        }

// Method to send a request to the M-Pesa API.
// It takes parameters for businessShortCode, password, timestamp, checkoutRequestID, token, and a callback to handle the response.
public void sendRequest(String businessShortCode, String password, String timestamp, String checkoutRequestID, String token, MpesaRequestCallback callback) {

        // Create an OkHttpClient instance to send the request.
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Define the media type for the request body as JSON.
        MediaType mediaType = MediaType.parse("application/json");

        // Create a JSON object to hold the request parameters.
        JSONObject json = new JSONObject();
        try {

        // Add the necessary parameters to the JSON object.
        json.put("BusinessShortCode", businessShortCode);
        json.put("Password", password);
        json.put("Timestamp", timestamp);
        json.put("CheckoutRequestID", checkoutRequestID);
        } catch (Exception e) {

        // Print the stack trace in case of an exception.
        e.printStackTrace();
        }

        // Create the request body using the JSON object.
        RequestBody body = RequestBody.create(mediaType, json.toString());

        // Build the HTTP request, setting the URL, method, and headers.
        Request request = new Request.Builder()
        .url("https://sandbox.safaricom.co.ke/mpesa/stkpushquery/v1/query")
        .method("POST", body)
        .addHeader("Content-Type", "application/json")
        .addHeader("Authorization", "Bearer " + token)
        .build();

        // Send the request asynchronously and handle the response with a callback.
        client.newCall(request).enqueue(new Callback() {
@Override
// Called when the request fails.
public void onFailure(Call call, IOException e) {

        // Print the stack trace and pass the error message to the callback's onFailure method.
        e.printStackTrace();
        callback.onFailure(e.getMessage());
        }

@Override
// Called when the request receives a response.
public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
        // If the response is successful, read the response body as a string.
        String responseData = response.body().string();
        // Pass the response data to the callback's onSuccess method.
        callback.onSuccess(responseData);
        } else {
        // If the response is not successful, pass the error message to the callback's onFailure method.
        callback.onFailure("Request failed: " + response.message());
        }
        }
        });
        }
        }
