
public class InputDetails 
{
	private int number;
	private double limit;
	private String errorMessage = "Wrong Input:\n-N and Limit have to be numeric\n-N has to be an Integer";
	
	
	public void setNumber(String x)throws Exception
	{
		if(! isValidInteger(x))
		{
			Exception e=new Exception(errorMessage);
			throw e;
		
			
		}
		number=Integer.parseInt(x);
		
	}
	public void setLimit(String y)throws Exception
	{
		if(	!isValidDouble(y))
		{
			Exception e=new Exception(errorMessage);
			throw e;
		}
		limit=Double.parseDouble(y);
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
		
		else if(Integer.parseInt(v)<=1)
		{
				errorMessage="Wrong Input:Banks must be greater than 1";
				return false;

		}
		else
		return true;
	}

	public int getNumber()
	{
		return number;
	}
	public double getLimit()
	{
		return limit;
	}
}
