package com.example.mpesa_test;

public class Constants {

    // Timeout settings for network requests
    public static final int CONNECT_TIMEOUT = 60 * 1000; // Connection timeout in milliseconds (60 seconds)
    public static final int READ_TIMEOUT = 60 * 1000;    // Read timeout in milliseconds (60 seconds)
    public static final int WRITE_TIMEOUT = 60 * 1000;   // Write timeout in milliseconds (60 seconds)

    // Base URL for the M-Pesa sandbox environment
    public static final String BASE_URL = "https://sandbox.safaricom.co.ke/";

    // M-Pesa configuration constants
    public static final String BUSINESS_SHORT_CODE = "174379"; // Business short code for M-Pesa transactions
    public static final String PASSKEY = "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919"; // Passkey for M-Pesa transactions
    public static final String TRANSACTION_TYPE = "CustomerPayBillOnline"; // Type of transaction (PayBill)
    public static final String PARTYB = "174379"; // Party B for the transaction, same as the business short code
    public static final String CALLBACKURL = "https://mydomain.com/path"; // URL to receive callback responses from M-Pesa

}
