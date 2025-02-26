import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=Integer.parseInt(sc.nextLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=Integer.parseInt(sc.nextLine());
			int max_num=-1;
			int arr[]=new int[N];
			String []tmp=sc.nextLine().split(" ");
			for(int i=0;i<N;i++){
				arr[i]=Integer.parseInt(tmp[i]);
				if(arr[i]>max_num){
					max_num=arr[i];
				}
			}
            
			int even=0;
			int odd=0;

			for(int i=0;i<N;i++){
				arr[i]=(max_num-arr[i]);
				do{
					if(arr[i]>=2){
						arr[i]-=2;
						even++;
					}
					if(arr[i]==1){
						arr[i]-=1;
						odd++;
					}
				}while(arr[i]>1);
			}
            
			if(even>odd){
				if((even-odd)*2%6>=4)
					System.out.printf("#%d %d\n",test_case, (even-odd)*2/6*4 +((even-odd)*2%6)+odd*2-1);
				else
					System.out.printf("#%d %d\n",test_case, (even-odd)*2/6*4 +((even-odd)*2%6)+odd*2);
			}else if(even==odd){
				System.out.printf("#%d %d\n",test_case, even+odd);
			}else if(odd>even){
				System.out.printf("#%d %d\n",test_case, (odd-1)*2+1);
                
			}
		}
	}
}
