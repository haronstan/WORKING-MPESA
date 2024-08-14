package com.example.mpesa_test.Services;

import static com.example.mpesa_test.Constants.BASE_URL;
import static com.example.mpesa_test.Constants.CONNECT_TIMEOUT;
import static com.example.mpesa_test.Constants.READ_TIMEOUT;
import static com.example.mpesa_test.Constants.WRITE_TIMEOUT;

import com.example.mpesa_test.Interceptor.AccessTokenInterceptor;
import com.example.mpesa_test.Interceptor.AuthInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// This class is responsible for setting up the Retrofit client used for making API requests to the Daraja (M-Pesa) API.
public class DarajaApiClient {

    // Instance of Retrofit used for making API requests.
    private Retrofit retrofit;

    // Flag to indicate whether debugging mode is enabled.
    private boolean isDebug;

    // Flag to indicate whether an access token needs to be obtained.
    private boolean isGetAccessToken;

    // Stores the authorization token used for making authorized requests.
    private String mAuthToken;

    // Instance of HttpLoggingInterceptor used for logging HTTP request and response data.
    private HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

    // Method to set the debugging mode. Returns the DarajaApiClient instance for chaining.
    public DarajaApiClient setIsDebug(boolean isDebug) {
    this.isDebug = isDebug;
    return this;
    }

    // Method to set the authorization token. Returns the DarajaApiClient instance for chaining.
    public DarajaApiClient setAuthToken(String authToken) {
    mAuthToken = authToken;
    return this;
    }

    // Method to set whether to obtain an access token. Returns the DarajaApiClient instance for chaining.
    public DarajaApiClient setGetAccessToken(boolean getAccessToken) {
    isGetAccessToken = getAccessToken;
    return this;
    }

// Method to create and configure an OkHttpClient.Builder instance.
private OkHttpClient.Builder okHttpClient() {
    OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
    okHttpClient
    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS) // Set the connection timeout duration.
    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS) // Set the write timeout duration.
    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS) // Set the read timeout duration.
    .addInterceptor(httpLoggingInterceptor); // Add the logging interceptor to the OkHttpClient.
    return okHttpClient;
    }

// Method to create and configure a Retrofit instance.
private Retrofit getRestAdapter() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL); // Set the base URL for the API.
        builder.addConverterFactory(GsonConverterFactory.create()); // Add Gson converter factory for JSON deserialization.

        // If debugging is enabled, set the logging level to BODY to log full request and response data.
        if (isDebug) {
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        OkHttpClient.Builder okhttpBuilder = okHttpClient();

        // If an access token needs to be obtained, add the AccessTokenInterceptor.
        if (isGetAccessToken) {
        okhttpBuilder.addInterceptor(new AccessTokenInterceptor());
        }

        // If an authorization token is provided, add the AuthInterceptor with the token.
        if (mAuthToken != null && !mAuthToken.isEmpty()) {
        okhttpBuilder.addInterceptor(new AuthInterceptor(mAuthToken));
        }

        // Set the OkHttpClient instance to the Retrofit builder.
        builder.client(okhttpBuilder.build());

        // Build the Retrofit instance.
        retrofit = builder.build();
        return retrofit;
        }

    // Method to create and return the STKPushService instance for making API requests related to M-Pesa STK Push.
public STKPushService mpesaService() {
        return getRestAdapter().create(STKPushService.class);
        }
        }
