
import java.util.Scanner;
import java.util.*;

public class myRsa {
/*
 * �㷨ʵ�ֹ���
 * 1��ѡ����������p��q�����㣺 N = p * q r = (p-1)(q-1)
 * 2������ģ��Ԫ��
 *  2.1ģ��Ԫ�أ��������������e��r���ʣ���ôһ�����ҵ�����d��ʹ�� ed%r=1 ���� (ed-1)%r=0�����dΪe��ģ��Ԫ�ء�
 *  2.2���ѡ��һ������e:1<e<r,��e��r����
 *  2.3����e����r��ģ��Ԫ��d: (ed-1)/r=k �� ed-kr=1(k��������������
 * 3.�ӵ�p��q
 * 4.��Կ��(N,e)��˽Կ��(N,d)
 */
	/*
	 * ����ʵ�ֹ���
	 * ��Կ��(N��e)
                  ����ת���� 
                  ����Ϣmת��Ϊһ������n ( n < N )
                 �����Ϣ�ܳ�������Ϣ�ֳɶ�Σ���ÿ��ת��Ϊһ������n ( n < N )
                       ���ܹ�ʽ��c = (n^e)%N
	 */
	/*
	 * ����ԭ��
	 * ˽Կ�� (N��e)
                         ���ܹ�ʽ��n = (c^d)%N
                     ������nת��Ϊ��Ϣm
	 */
//�������ݣ�ʵ���ݵ�ȡ��
	public static int candp(int a,int b,int c) {
		int r =1;
		b=b+1;
		while(b!=1) {
			r=r*a;
			r=r%c;
			b--;
		}
		System.out.println("������ݣ�"+ r);
		return r;
		
	}
//��Կe��t�Ļ������ж�
	public static boolean fun(int x,int y) {
		int  t;
		while(y!=0) {
			t=x;
			x=y;
			y=t%y;
		}
		if(x==1) {
			return false;
		}
		else return true;
		
	}
	//�ж��Ƿ�������
	public static  boolean isPrimeNumber(int num){  
	    if(num == 2) return true;//2���⴦��  
	    if(num < 2 || num % 2 == 0) return false;//ʶ��С��2������ż��  
	    for(int i=3; i<=Math.sqrt(num); i+=2){  
	        if(num % i == 0){//ʶ����������  
	            return false;  
	        }  
	    }  
	    return true;  
	}   
	//������
	 public static void main (String[] args)  {
	    int  p,q,d;//d����Կ
		int e; //��Կ
		int m; //����
		int n; //
	    int t, c;//c������
		int r; //
	    Scanner a = new Scanner(System.in);
	    System.out.println("��������p��q");
//           p = a.nextInt();//ȡ��p��q
//           q =a.nextInt();
        //�����������
           p = (int)(Math.random()*400)+2;
           while(!isPrimeNumber(p) ) {
        	   p = (int)(Math.random()*400)+2; 
           }
           q = (int)Math.random()*400+2;
           while(!isPrimeNumber(q) ) {
        	   p = (int)(Math.random()*400)+2; 
           }
           System.out.println("p:"+p +"  q:"+q);
        n=p*q;
        System.out.println("�����n��"+n);
        
        //��n��ŷ����
        t =(p-1)*(q-1);
        System.out.println("���tΪ"+t);
        
        System.out.println("���빫Կ:��ԿΪ����");
        e=a.nextInt();
        //�жϹ�Կ�Ƿ�Ϸ�
        if(e < 1 || e > t || fun(e,t)) {
        	System.out.println("��Կ����Ҫ���������룺");
        	  e=a.nextInt();
        }
        d= 1;
        //�ɹ�Կ���˽Կ
        while(((e * d) % t) != 1)
            d++;             
        System.out.println("��������ԿΪ:"+ d);
        
         //���ܻ����ѡ��
        System.out.println("��ѡ����ܻ��ǽ��ܣ�����1������2");
        r =a.nextInt();
        switch(r) {
           case 1:
           System.out.println("��������m");//����Ҫ���ܵ���������
            m = a.nextInt();
            c =candp(m,e,n);
            System.out.println("����Ϊ:"+c);
            break;
           case 2:
        	   System.out.println("��������m");//����Ҫ���ܵ���������
               c = a.nextInt();
               m =candp(c,d,n);
               System.out.println("����Ϊ:"+m);
               break;
        	   
        }
	}
	
}
