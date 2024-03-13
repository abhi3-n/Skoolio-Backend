package com.Skoolio.SchoolService.SchoolService.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UniqueIdGenerator {



    public static String generateAdminId(int schoolId, String email) {
        // Concatenate schoolId, email, and registrationDate to form a unique string
        String uniqueString = schoolId + "_" + email;

        // Compute the SHA-256 hash of the unique string
        byte[] hash = computeSHA256Hash(uniqueString);

        // Encode the hash using base64 encoding
        String base64urlHash = base64UrlEncode(hash);
        // Return a substring of the base64 encoding to shorten the ID
        return base64urlHash.substring(0, 10); // Adjust the length as needed
    }

    private static byte[] computeSHA256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static String base64UrlEncode(byte[] bytes) {
        String base64 = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        return base64.replace("_", "").replace("-", ""); // Remove URL-unsafe characters
    }
//    public static String generateAdminId(int schoolId, String email, long registrationDate) {
//        // Concatenate schoolId, email, and registrationDate to form a unique string
//        String uniqueString = schoolId + "_" + email + "_" + registrationDate;
//
//        // Compute the SHA-256 hash of the unique string to generate the adminID
//        String adminId = null;
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hash = digest.digest(uniqueString.getBytes());
//            adminId = bytesToHex(hash);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return adminId;
//    }

    public static String generateClassId(int schoolId, String grade, String section) {
        // Concatenate schoolId, email, and registrationDate to form a unique string
        String uniqueString = schoolId + "_" + grade + "_" + section;
        // Compute the SHA-256 hash of the unique string
        byte[] hash = computeSHA256Hash(uniqueString);

        // Encode the hash using base64 encoding
        String base64urlHash = base64UrlEncode(hash);
        // Return a substring of the base64 encoding to shorten the ID
        return base64urlHash.substring(0, 10); // Adjust the length as needed
    }

//    private static String bytesToHex(byte[] hash) {
//        StringBuilder hexString = new StringBuilder(2 * hash.length);
//        for (byte b : hash) {
//            String hex = Integer.toHexString(0xff & b);
//            if (hex.length() == 1) {
//                hexString.append('0');
//            }
//            hexString.append(hex);
//        }
//        return hexString.toString();
//    }
}