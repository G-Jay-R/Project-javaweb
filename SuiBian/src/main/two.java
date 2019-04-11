package main;

import java.util.Scanner;

public class two {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("请输入正整数：");
		int a = scan.nextInt();
        int r=0,i,s1,b;
        s1=a;
        int [] c=new int[8];
        for(i=0;s1>0;i++){
        	b=s1%2;
        	c[i]=b;
            s1=s1/2;
            if(b==1){
                r++;
            }
        }
        int j=i-1;
        System.out.println("有几个1？ "+r);
        for(;j>=0;j--){
            System.out.print(c[j]+" ");
        }

	}

}
