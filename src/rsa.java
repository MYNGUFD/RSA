import java.io.InputStream;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Scanner;

public class rsa {

	public static void main(String[] args) throws Exception {
		Scanner a =  new Scanner(System.in);
        // TODO Auto-generated method stub
        HashMap<String, Object> map = RSAUtils.getKeys();
        //���ɹ�Կ��˽Կ
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
        
        //ģ
        String modulus = publicKey.getModulus().toString();
        //��Կָ��
        String public_exponent = publicKey.getPublicExponent().toString();
        //˽Կָ��
        String private_exponent = privateKey.getPrivateExponent().toString();
        //����
         System.out.println("��������");
         String ming = a.nextLine();
         //ʹ��ģ��ָ�����ɹ�Կ��˽Կ
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        //���ܺ������
        String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
        System.err.println("���ܺ�����ģ�"+mi);
        //���ܺ������
        ming = RSAUtils.decryptByPrivateKey(mi, priKey);
        System.err.println("���ܺ�����ģ�"+ming);
    }

 
 
}