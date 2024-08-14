package com.example.mpesa_test;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

// Generates a timestamp in the format "yyyyMMddHHmmss"
public static String getTimestamp() {

        // Create a SimpleDateFormat object with the desired format and locale
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());
        }

// Sanitizes a phone number to conform to international format
public static String sanitizePhoneNumber(String phone) {

        if (phone.equals("")) {
        return "";
        }

        // If phone number starts with '0' and is less than 11 digits, replace '0' with '254'
        if (phone.length() < 11 && phone.startsWith("0")) {
        String p = phone.replaceFirst("^0", "254");
        return p;
        }

        // If phone number starts with '+' and is 13 digits long, remove the '+' sign
        if (phone.length() == 13 && phone.startsWith("+")) {
        String p = phone.replaceFirst("^\\+", "");
        return p;
        }
        return phone;
        }

// Generates a Base64 encoded password for M-Pesa requests
public static String getPassword(String businessShortCode, String passkey, String timestamp) {

        // Concatenate business short code, passkey, and timestamp
        String str = businessShortCode + passkey + timestamp;

        // Encode the concatenated string to Base64
        return Base64.encodeToString(str.getBytes(), Base64.NO_WRAP);
        }
        }
