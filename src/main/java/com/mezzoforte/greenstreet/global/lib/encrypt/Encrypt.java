package com.mezzoforte.greenstreet.global.lib.encrypt;

public interface Encrypt {

    String getEncryptMethodName();

    String encode(String data);

    boolean match(String originalData, String encryptedData);
}
