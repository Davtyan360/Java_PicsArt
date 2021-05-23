package Registration;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface PasswordCrypt {
    static String crypt(String val) {
        try {
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(val.getBytes(),0,val.length());
            return new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return " ";
    }
}
