package com.skoolio.IssueService.IssueService.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UniqueIdGenerator {
    public static String generateUniqueId(String uniqueString) {
        byte[] hash = computeSHA256Hash(uniqueString);
        String base64urlHash = base64UrlEncode(hash);
        return base64urlHash.substring(0, 10);
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
}
