/**
 *
 * @author saed_
 */


package security_fxml;
import java.util.Scanner;
/**
 *
 * @author saed_
 */
public class Caeaser {

 

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
 
    public  String encrypt_caeaser(String plainText, int shiftKey)
    {
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }
 
    public  String decrypt_caeaser(String cipherText, int shiftKey)
    {
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }
 
    public static void main(String[] args)
    {
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String for Encryption: ");
        String message = new String();
        message = sc.next();
        System.out.println(encrypt_caeaser(message, 3));
        System.out.println(decrypt_caeaser(encrypt_caeaser(message, 3), 3));
        sc.close();
*/
    }

}
