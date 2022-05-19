package com.rsa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

/**
 * @author 老王
 */

@WebServlet(name = "login",value = "/login")
public class Login extends HttpServlet {


    List<String> keyStringList = RSAUtils.getRSAKeyString(1024);
    String pukString = keyStringList.get(0);
    String prkString = keyStringList.get(1);
    RSAPublicKey puk = RSAUtils.getPublicKey(pukString);
    RSAPrivateKey prk = RSAUtils.getPrivateKey(prkString);

    
    


    public Login() throws Exception {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("pas");
        try {
            System.out.println("收到的密文为:" + s);
            String decryptedMsg = RSAUtils.decryptByPrivateKey(s, prk);
            System.out.println("经传输解密后明文为：" + decryptedMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("生成的公钥是：" + pukString);
        System.out.println("生成的私钥是：" + prkString);
        resp.getWriter().write(pukString);
    }
}
