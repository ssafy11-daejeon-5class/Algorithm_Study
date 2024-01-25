class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case=1;test_case<=T;test_case++)
    	{
    		int [] arr=new int[11112];
    		int n=sc.nextInt();
    		int m=sc.nextInt();
    		int k=sc.nextInt();
    		int[] person = new int[n];
    		for(int i=0;i<n;i++)
    		{
    			person[i]=sc.nextInt();
    		}
    		Arrays.sort(person);
    		for(int i=1;i<11112;i++)
    		{
    			if(i%m==0)
    			{
    				arr[i]=arr[i-1]+k;
    			}else
    			{
    				arr[i]=arr[i-1];
    			}
    		}
    		int check=0;
    		
    		for(int i=0;i<n;i++)
    		{
    			if(arr[person[i]]<i+1)
    			{
    				check=1;
    				break;
    			}
    		}
    		if(check==1)
    		{
    			System.out.println("#"+test_case + " Impossible");
    		}else
    		{
    			System.out.println("#"+test_case + " Possible");
    		}		
    	}
	}
}
