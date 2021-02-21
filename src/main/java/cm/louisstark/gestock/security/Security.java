package cm.louisstark.gestock.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Security {

    public static String crypte(String plaintext) {
        return (String) BCrypt.hashpw(plaintext, BCrypt.gensalt(12));
    }
    
    public static Boolean compare (String plaintext, String crypted) throws Exception {
        try {
            return BCrypt.checkpw(plaintext, crypted);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
