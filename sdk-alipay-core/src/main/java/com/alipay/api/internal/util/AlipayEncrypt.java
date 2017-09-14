/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.alipay.api.internal.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.codec.Base64;

/**
 * 加密工具
 * 
 * @author jiehua
 * @version $Id: AlipayEncrypt.java, v 0.1 2016-3-28 下午5:14:12 jiehua Exp $
 */
public class AlipayEncrypt {

    private static final String AES_ALG = "AES";

    /**
     * AES算法
     */
    private static final String AES_CBC_PCK_ALG = "AES/CBC/PKCS5Padding";

    private static final byte[] AES_IV = initIv(AES_CBC_PCK_ALG);

    public static String encryptContent(
            String content,
            String encryptType,
            String encryptKey,
            String charset) throws AlipayApiException {

        if (AES_ALG.equals(encryptType)) {

            return aesEncrypt(content, encryptKey, charset);

        } else {

            throw new AlipayApiException("当前不支持该算法类型：encrypeType=" + encryptType);
        }

    }

    public static String decryptContent(
            String content,
            String encryptType,
            String encryptKey,
            String charset) throws AlipayApiException {

        if (AES_ALG.equals(encryptType)) {

            return aesDecrypt(content, encryptKey, charset);

        } else {

            throw new AlipayApiException("当前不支持该算法类型：encrypeType=" + encryptType);
        }

    }

    private static String aesEncrypt(
            String content,
            String aesKey,
            String charset) throws AlipayApiException {

        try {
            Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG);

            IvParameterSpec iv = new IvParameterSpec(AES_IV);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Base64.decodeBase64(aesKey.getBytes()), AES_ALG), iv);

            byte[] encryptBytes = cipher.doFinal(content.getBytes(charset));
            return new String(Base64.encodeBase64(encryptBytes));
        } catch (Exception e) {
            throw new AlipayApiException("AES加密失败：Aescontent = " + content + "; charset = " + charset, e);
        }

    }

    private static String aesDecrypt(
            String content,
            String key,
            String charset) throws AlipayApiException {
        try {
            Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG);
            IvParameterSpec iv = new IvParameterSpec(initIv(AES_CBC_PCK_ALG));
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Base64.decodeBase64(key.getBytes()), AES_ALG), iv);

            byte[] cleanBytes = cipher.doFinal(Base64.decodeBase64(content.getBytes()));
            return new String(cleanBytes, charset);
        } catch (Exception e) {
            throw new AlipayApiException("AES解密失败：Aescontent = " + content + "; charset = " + charset, e);
        }
    }

    private static byte[] initIv(
            String fullAlg) {

        try {
            Cipher cipher = Cipher.getInstance(fullAlg);
            int blockSize = cipher.getBlockSize();
            byte[] iv = new byte[blockSize];
            for (int i = 0; i < blockSize; ++i) {
                iv[i] = 0;
            }
            return iv;
        } catch (Exception e) {

            int blockSize = 16;
            byte[] iv = new byte[blockSize];
            for (int i = 0; i < blockSize; ++i) {
                iv[i] = 0;
            }
            return iv;
        }
    }

}
