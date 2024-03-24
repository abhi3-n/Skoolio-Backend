package com.Skoolio.ClassService.ClassService.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UniqueIdGenerator {
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
    public static String generateAdminId(String uniqueString) {
//        String uniqueString = schoolId + "_" + email;
        byte[] hash = computeSHA256Hash(uniqueString);
        String base64urlHash = base64UrlEncode(hash);
        return base64urlHash.substring(0, 10); // Adjust the length as needed
    }

    public static String generateClassId(String uniqueString) {
//        String uniqueString = schoolId + "_" + grade + "_" + section;
        byte[] hash = computeSHA256Hash(uniqueString);
        String base64urlHash = base64UrlEncode(hash);
        return base64urlHash.substring(0, 10); // Adjust the length as needed
    }
}