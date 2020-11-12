////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.config;

/**
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class AES {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    private static final Logger LOGGER = LoggerFactory.getLogger(AES.class);

    private static SecretKeySpec mSecretKey;
    private static byte[] mKey;

    public static void setKey(String myKey) {
        MessageDigest sha;
        try {
            mKey = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            mKey = sha.digest(mKey);
            mKey = Arrays.copyOf(mKey, 16);
            mSecretKey = new SecretKeySpec(mKey, "AES");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Unable to set key", e);
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, mSecretKey);
            return Base64
                .getEncoder()
                .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            LOGGER.error("Error while encrypting:", e);
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, mSecretKey);
            return new String(cipher.doFinal(Base64
                                                 .getDecoder()
                                                 .decode(strToDecrypt)));
        } catch (Exception e) {
            LOGGER.error("Error while decrypting:", e);
        }
        return null;
    }
}
