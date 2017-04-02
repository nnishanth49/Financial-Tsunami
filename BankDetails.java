public class BankDetails 
{	
	private int size;
	private double limit;
	String output="";

	public BankDetails(int s,double[] cb,double[][] tr ,double lim)
	{
		size=s;
		
		
		double[][] transactions=new double[size][size];
		//maintain transactions between Bank Details
		
		for(int i=0;i<size;i++)
			for(int j=0; j<size;j++)
				transactions[i][j]=tr[i][j];
		
		double[] currentBalance=new double[size];
		for(int j=0; j<size;j++)
			currentBalance[j]=cb[j];
		limit=lim;
		
		boolean[] safe=new boolean[size];
		for(int j=0; j<size;j++)
			safe[j]=true;
		
		boolean[] toCheck=new boolean[size];
		for(int j=0; j<size;j++)
			toCheck[j]=true;
		
		double[] totalAsset=new double[size];
		//calculating total assets
		totalAsset(totalAsset,currentBalance,transactions);
		//generate a list of safe BankDetailss
		safeBankDetails(totalAsset,safe,toCheck,transactions);
		
		// store unsafe BankDetailss list in output
		for(int i=0;i<size;i++)
			if(!safe[i])
				output+="\n"+i;
		
	}
	//calculating total assets
	public void totalAsset(double[] totalAsset,double[] currentBalance,double[][] transactions )
	{
		for(int i=0;i<size;i++)
		{	
				totalAsset[i]=currentBalance[i];
				for(int j=0;j<size;j++)
					{
						if(transactions[i][j]!=0)
							totalAsset[i]+=transactions[i][j];
					}
			
		}
	}
	
	//generate a list of safe Bank Details
	public void safeBankDetails(double[] totalAsset,boolean[] safe,boolean[] toCheck,double[][] transactions)
	{
		int i;
		for(i=0;i<size;i++)
		{
			if(toCheck[i])
			{
			
				if(totalAsset[i]<limit)
				{
					safe[i]=false;
					toCheck[i]=false;
					for(int j=0;j<size;j++)
					{
						if(transactions[j][i]!=0)
							totalAsset[j]=totalAsset[j]-transactions[j][i];
						
					}safeBankDetails(totalAsset,safe,toCheck,transactions);
				}
			}
		}
	}
//return unsafe BankDetails list
	public String getUnSafeBankDetails()
	{	
		return output;
	}

	
}

