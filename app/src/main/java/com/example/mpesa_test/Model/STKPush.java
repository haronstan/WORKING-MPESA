package com.example.mpesa_test.Model;

import com.google.gson.annotations.SerializedName;

// This class represents the STK (Sim Tool Kit) Push request model used in M-Pesa transactions.
public class STKPush {

    // Mapped to the JSON key "BusinessShortCode", this field represents the short code of the business initiating the transaction.
    @SerializedName("BusinessShortCode")
    private String businessShortCode;

    // Mapped to the JSON key "Password", this field represents the Base64 encoded string combining the business short code, password, and timestamp.
    @SerializedName("Password")
    private String password;

    // Mapped to the JSON key "Timestamp", this field represents the timestamp of the transaction.
    @SerializedName("Timestamp")
    private String timestamp;

    // Mapped to the JSON key "TransactionType", this field represents the type of transaction being initiated.
    @SerializedName("TransactionType")
    private String transactionType;

    // Mapped to the JSON key "Amount", this field represents the amount of money being transacted.
    @SerializedName("Amount")
    private int amount;

    // Mapped to the JSON key "PartyA", this field represents the phone number of the party making the payment.
    @SerializedName("PartyA")
    private String partyA;

    // Mapped to the JSON key "PartyB", this field represents the recipient's business short code or phone number.
    @SerializedName("PartyB")
    private String partyB;

    // Mapped to the JSON key "PhoneNumber", this field represents the phone number that will receive the STK push request.
    @SerializedName("PhoneNumber")
    private String phoneNumber;

    // Mapped to the JSON key "CallBackURL", this field represents the URL to which the API will send the response.
    @SerializedName("CallBackURL")
    private String callBackURL;

    // Mapped to the JSON key "AccountReference", this field represents the account reference or unique identifier for the transaction.
    @SerializedName("AccountReference")
    private String accountReference;

    // Mapped to the JSON key "TransactionDesc", this field represents a description of the transaction.
    @SerializedName("TransactionDesc")
    private String transactionDesc;

    // Mapped to the JSON key "CheckoutRequestID", this field represents the unique ID for the checkout request.
    @SerializedName("CheckoutRequestID")
    private String checkoutRequestID;

    // Constructor to initialize the STKPush object with the provided values.
    public STKPush(String businessShortCode, String password, String timestamp, String transactionType,
        int amount, String partyA, String partyB, String phoneNumber, String callBackURL,
        String accountReference, String transactionDesc) {
        this.businessShortCode = businessShortCode;
        this.password = password;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
        this.amount = amount;
        this.partyA = partyA;
        this.partyB = partyB;
        this.phoneNumber = phoneNumber;
        this.callBackURL = callBackURL;
        this.accountReference = accountReference;
        this.transactionDesc = transactionDesc;
        }

        // Getter for the checkoutRequestID field.
        public String getCheckoutRequestID() {
        return checkoutRequestID;
        }

        // Setter for the checkoutRequestID field.
        public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
        }
        }
