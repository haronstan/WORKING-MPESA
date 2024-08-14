package com.example.mpesa_test.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// This class represents an AccessToken model which is used to store the access token and its expiry information.
public class AccessToken {

    // The access token received from the API, mapped to the JSON key "access_token".
    @SerializedName("access_token")
    @Expose
    public String accessToken;

    // The expiration time of the access token, mapped to the JSON key "expires_in".
    @SerializedName("expires_in")
    @Expose
    private String expiresIn;

    // Constructor to initialize the AccessToken object with the provided access token and expiry time.
    public AccessToken(String accessToken, String expiresIn) {
    this.accessToken = accessToken;
    this.expiresIn = expiresIn;
    }
    }
