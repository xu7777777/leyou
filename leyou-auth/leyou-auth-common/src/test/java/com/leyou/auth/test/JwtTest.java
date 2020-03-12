package com.leyou.auth.test;

import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author xu7777777
 * @date 2020/3/12 3:02 PM
 */
public class JwtTest {

    private static final String pubKeyPath = "/Users/xu7777777/profile/key/rsa.pub";

    private static final String priKeyPath = "/Users/xu7777777/profile/key/rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU4Mzk5NzQxMH0.AUxeZrBDgEKG59AXWxWLOiAd9r0VdxWv6tu_7-jEP7J5ni1JZncTjI6to974gGwvWvo-FynQuR5IBOthaiLgYZqGJK2KSAGj5eW7i7G63IahWh0ywFOpP5YkDUvsov37rZ2I0ogIn4wcBif1j2cXyTrqRdkgcIbc9zh6bzReZYs";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}