package com.rsa;

/**
 * @author 老王
 */

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

/**
 * @ClassName: RSATest
 * @Description: TODO
 * @Author: zhānghào
 * @Date: 2021/4/25 3:41 下午
 * @Version: v1.0
 **/
public class RSATest {

    public static void main(String[] args) throws Exception {

        // 使用公钥、私钥对象加解密
        RSAPublicKey puk;
        RSAPrivateKey prk;
        String message = "123456";



        // 使用字符串生成公钥、私钥完成加解密
        List<String> keyStringList = RSAUtils.getRSAKeyString(1024);
        String pukString = keyStringList.get(0);
        String prkString = keyStringList.get(1);
        System.out.println("公钥:" + pukString);
        System.out.println("私钥:" + prkString);
        // 生成公钥、私钥
        puk = RSAUtils.getPublicKey(pukString);
        prk = RSAUtils.getPrivateKey(prkString);
        String encryptedMsg = RSAUtils.encryptByPublicKey(message, puk);
        System.out.println(encryptedMsg);
        String decryptedMsg = RSAUtils.decryptByPrivateKey(encryptedMsg, prk);
        System.out.println(decryptedMsg);
    }
}