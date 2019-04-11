package main;

import java.util.Scanner;

public class camlautor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		String b=Integer.toBinaryString(n);
        char[] c=b.toCharArray();
        int t=0;
        for(int i=0;i<c.length;i++){
             
                if(c[i]=='1'){
                    t++;
                }
             
        }
        System.out.print("转换为的二进制：");        
		System.out.println(b.toCharArray());
		System.out.println("1的位数是："+t);

	}

}
