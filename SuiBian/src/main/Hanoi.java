package main;

import java.util.Scanner;

public class Hanoi {
	
		public static void main(String[] args) {
			Scanner scan =new Scanner(System.in);
			System.out.println("请输入盘子数量：");
			int a = scan.nextInt();
			hanoi(a,1,2,3);
		}

		private static void hanoi(int n, int i, int j, int k) {
			if(n==1)
				System.out.println("盘子从"+i+"移到"+k+";");
			else{
				hanoi(n-1,i,k,j);
				System.out.println("盘子从"+i+"移到"+k+";");
				hanoi(n-1,j,i,k);
			}
			
		}

}

