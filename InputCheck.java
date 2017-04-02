
public class InputCheck
{	
	private int numberOfBanks;
	private int number;
	private double amount;
	private String errorMessage = "Wrong Input:\n-Inputs must be numeric\n-Bank related input has to be an Integer";
	
	public InputCheck(int n)
	{
		numberOfBanks=n;
	}
	
	public void setNumber(String x)throws Exception
	{
		if(! isValidInteger(x))
		{
			Exception e=new Exception(errorMessage);
			throw e;
		
			
		}
		number=Integer.parseInt(x);
		
	}
	public void setAmount(String y)throws Exception
	{
		if(	!isValidDouble(y))
		{
			Exception e=new Exception(errorMessage);
			throw e;
		}
		amount=Double.parseDouble(y);
	}
	
	public String getErrorMessage() { return errorMessage; }
	
	public boolean isValidDouble(String v)
	{
		if(v.equals(""))
		{
			errorMessage="Wrong Input:empty Fields";
			return false;

		}
		else if(Double.parseDouble(v)<=0)
		{
				errorMessage="Wrong Input:Input must be greater than 0";
				return false;

		}
		else
		return true;
	}

	public boolean isValidInteger(String v)
	{
		if(v.equals(""))
		{
			errorMessage="Wrong Input:empty Fields";
			return false;

		}
		
		else if(Integer.parseInt(v)<0)
		{
				errorMessage="Wrong Input:Input must be greater than or equal to 0";
				return false;

		}
		else if(Integer.parseInt(v)>=numberOfBanks)
		{
				errorMessage="Wrong Input:No. of banks are "+(numberOfBanks)+"only";
				return false;

		}

		else
		return true;
	}

	public int getNumber()
	{
		return number;
	}
	public double getAmount()
	{
		return amount;
	}
}
