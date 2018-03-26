
import java.util.Scanner;
import java.util.*;

public class myRsa {
/*
 * 算法实现过程
 * 1、选择两个质数p和q，计算： N = p * q r = (p-1)(q-1)
 * 2、计算模反元素
 *  2.1模反元素：如果两个正整数e和r互质，那么一定能找到整数d，使得 ed%r=1 ，即 (ed-1)%r=0，则称d为e的模反元素。
 *  2.2随机选择一个整数e:1<e<r,且e和r互质
 *  2.3计算e关于r的模反元素d: (ed-1)/r=k 或 ed-kr=1(k是任意正整数）
 * 3.扔掉p和q
 * 4.公钥匙(N,e)、私钥是(N,d)
 */
	/*
	 * 加密实现过程
	 * 公钥：(N，e)
                  明文转换： 
                  将消息m转换为一个整数n ( n < N )
                 如果消息很长，则将消息分成多段，将每段转换为一个整数n ( n < N )
                       加密公式：c = (n^e)%N
	 */
	/*
	 * 解密原理
	 * 私钥： (N，e)
                         解密公式：n = (c^d)%N
                     将整数n转换为消息m
	 */
//处理数据，实现幂的取余
	public static int candp(int a,int b,int c) {
		int r =1;
		b=b+1;
		while(b!=1) {
			r=r*a;
			r=r%c;
			b--;
		}
		System.out.println("输出数据："+ r);
		return r;
		
	}
//公钥e和t的互素数判断
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
	//判断是否是素数
	public static  boolean isPrimeNumber(int num){  
	    if(num == 2) return true;//2特殊处理  
	    if(num < 2 || num % 2 == 0) return false;//识别小于2的数和偶数  
	    for(int i=3; i<=Math.sqrt(num); i+=2){  
	        if(num % i == 0){//识别被奇数整除  
	            return false;  
	        }  
	    }  
	    return true;  
	}   
	//主函数
	 public static void main (String[] args)  {
	    int  p,q,d;//d是秘钥
		int e; //公钥
		int m; //明文
		int n; //
	    int t, c;//c是密文
		int r; //
	    Scanner a = new Scanner(System.in);
	    System.out.println("两个素数p和q");
//           p = a.nextInt();//取得p和q
//           q =a.nextInt();
        //随机生成素数
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
        System.out.println("计算的n得"+n);
        
        //求n的欧拉数
        t =(p-1)*(q-1);
        System.out.println("求得t为"+t);
        
        System.out.println("输入公钥:公钥为素数");
        e=a.nextInt();
        //判断公钥是否合法
        if(e < 1 || e > t || fun(e,t)) {
        	System.out.println("公钥不合要求，重新输入：");
        	  e=a.nextInt();
        }
        d= 1;
        //由公钥求出私钥
        while(((e * d) % t) != 1)
            d++;             
        System.out.println("经计算秘钥为:"+ d);
        
         //加密或解密选择
        System.out.println("请选择加密还是解密：加密1，解密2");
        r =a.nextInt();
        switch(r) {
           case 1:
           System.out.println("输入明文m");//输入要加密的明文数字
            m = a.nextInt();
            c =candp(m,e,n);
            System.out.println("密文为:"+c);
            break;
           case 2:
        	   System.out.println("输入密文m");//输入要加密的明文数字
               c = a.nextInt();
               m =candp(c,d,n);
               System.out.println("明文为:"+m);
               break;
        	   
        }
	}
	
}
