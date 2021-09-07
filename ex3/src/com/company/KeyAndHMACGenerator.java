package com.company;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class KeyAndHMACGenerator {

    public int randomMove(int bound){
        return new SecureRandom().nextInt(bound);
    }

    public byte[] generateKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return bytes;
    }

    public byte[] calculateHmacSha256(byte[] secretKey, byte[] message) {
        byte[] hmacSha256 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
        return hmacSha256;
    }
}
