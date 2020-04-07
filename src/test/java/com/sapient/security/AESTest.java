package com.sapient.security;

 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.sapient.security.AES;


 

public class AESTest {
    
    
    @Test
    public void encryptTest() {
        String msg = AES.encrypt("ritvik","PublicisSapientIndia");
        System.out.println(msg);
        assertEquals("decrypt failed ," ,"hkySAZkf91JgYLmCx98MKw==",msg);
    }
    
    @Test
    public void encryptTestFails() {
        assertNull(AES.encrypt("ritvik",null));
    }
    
    @Test
    public void decryptTestFails() {
         AES.decrypt("hkySAZkf91JgYLmCx98MKw==123","PublicisSapientIndia");
         assertNull(AES.decrypt("hkySAZkf91JgYLmCx98MKw==123","PublicisSapientIndia"));
    }
    
    @Test
    public void decryptTest() {
        AES aes=new AES();
        String msg = aes.decrypt("hkySAZkf91JgYLmCx98MKw==","PublicisSapientIndia");
        assertEquals("decrypt failed ," ,"ritvik",msg);
    }
    
    @Test(expected = NoSuchAlgorithmException.class)
    public void expectNoSuchAlgorithmException() throws NoSuchAlgorithmException 

 

    {
        throw new NoSuchAlgorithmException();
        //e.printStackTrace();
    }

 

}