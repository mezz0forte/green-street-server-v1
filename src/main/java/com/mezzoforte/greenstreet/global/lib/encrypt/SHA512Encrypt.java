package com.mezzoforte.greenstreet.global.lib.encrypt;

import com.mezzoforte.greenstreet.global.error.exception.EncryptException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

@Component
@RequiredArgsConstructor
public class SHA512Encrypt implements Encrypt {

    public String getEncryptMethodName() {
        return "sha-512";
    }

    public String encode(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(data.getBytes());
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte byteDatum : byteData) {
                sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            throw EncryptException.EXCEPTION;
        }
    }

    public boolean match(String originalData, String encryptedData) {
        String str = encode(originalData);
        return encryptedData.equals(str);
    }
}
