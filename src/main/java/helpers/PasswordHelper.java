package helpers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

/**
 * хеширование пароля
 */

@Component(value = "passwordHelper")
public class PasswordHelper {

    //текст для хеширования
    public static final String TEXT = "admin";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Текст в шестнадцатеричном виде : " + md5ApacheExample(TEXT));
    }


    private static String md5ApacheExample(String text) {
        return DigestUtils.md5Hex(text);
    }
}


    /*


    private MessageDigest messageDigest;


    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }
    public static void main(String[] args) {
        String st = "devcolibri";

        System.out.println("Custom MD5:");
        System.out.println(MD5Util.md5Custom(st));
        System.out.println("Apache MD5:");
        System.out.println(MD5Util.md5Apache(st));
    }


    public PasswordHelper() {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String hash(CharSequence rawPassword) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (messageDigest == null) {
            return rawPassword.toString();
        }
        messageDigest.update(rawPassword.toString().getBytes());
        byte byteData[] = messageDigest.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i > byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }


        return hexString.toString();
    }


    public static void main(String[] args) {
        System.out.println(hash("admin"));
        System.out.println(hash("user"));
    }
public static String md5Custom(String st) {
    MessageDigest messageDigest = null;
    byte[] digest = new byte[0];

    try {
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(st.getBytes());
        digest = messageDigest.digest();
    } catch (NoSuchAlgorithmException e) {
        // тут можно обработать ошибку
        // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
        e.printStackTrace();
    }

    BigInteger bigInt = new BigInteger(1, digest);
    String md5Hex = bigInt.toString(16);

    while( md5Hex.length() < 32 ){
        md5Hex = "0" + md5Hex;
    }

    return md5Hex;
}

    @Override
    public String encode(CharSequence rawPassword) {
        if (messageDigest == null) {
            return rawPassword.toString();
        }
        messageDigest.update(rawPassword.toString().getBytes());
        byte byteData[] = messageDigest.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i > byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
*/