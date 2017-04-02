
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinancialTsunami
{
	public static void main(String[] args) //throws Exception ,IException 
	{
		int outerOption = JOptionPane.YES_OPTION;
	    while (outerOption == JOptionPane.YES_OPTION)
	    {	String ip="";
	    	String ip1="";
	    	int Number=0;
	    	double Limit=0;
	    	
	//input number of banks and limit    	
	    	JTextField nField = new JTextField(5);
			 JTextField lField = new JTextField(5);
		     JPanel myPanel = new JPanel();
		     myPanel.add(new JLabel("number of banks:"));
		     myPanel.add(nField);
		     myPanel.add(new JLabel("limit:"));
		     myPanel.add(lField);
		     JOptionPane.showConfirmDialog(null, myPanel,"Please Enter ", JOptionPane.OK_CANCEL_OPTION);
	
		     InputDetails nl=new InputDetails();
		     
		     try
		     {
		    	 nl.setNumber(nField.getText());	 
					nl.setLimit(lField.getText());
					
					Number=nl.getNumber();
					Limit=nl.getLimit();
					ip+="No. of Banks = "+Number+" Limit = "+Limit+"\n\n";
					ip1+=Number+" "+Limit+"\n";
					//double dimension array to keep track of all transactions
					
		     double[][] transactions=new double[Number][Number];
		     for(int i=0;i<Number;i++)
					for(int j=0; j<Number;j++)
						transactions[i][j]=0;
		     double[] currentAmount=new double[Number];
		     for(int j=0; j<Number;j++)
		    	 currentAmount[j]=0;
		     int bnkNo=0;
		     while(bnkNo<Number)
		    	 {
		    	 // input each banks current value and no.of borrowers 
		    	 JTextField n1Field = new JTextField(5);
		    	 JTextField l1Field = new JTextField(5);
				 JPanel myPanel1 = new JPanel();
				 myPanel1.add(new JLabel("current value:"));
			     myPanel1.add(l1Field);
			     myPanel1.add(new JLabel("\nnumber of borrowers : "));
			     myPanel1.add(n1Field);
			     
			     JOptionPane.showConfirmDialog(null, myPanel1,"Please enter for bank "+ bnkNo , JOptionPane.OK_CANCEL_OPTION);
			     
			     InputCheck bk=new InputCheck(Number);
			     try
			     {
			    	 bk.setNumber(n1Field.getText());
			    	 bk.setAmount(l1Field.getText());
						int numberOfBorrowers=bk.getNumber();
						currentAmount[bnkNo]=bk.getAmount();
						ip+="\nbank "+bnkNo+" has current value="+currentAmount[bnkNo]+" loans to "+numberOfBorrowers+" bank ";
						ip1+=currentAmount[bnkNo]+" "+numberOfBorrowers+" ";
						int brwrs=0;
						
						while(brwrs<numberOfBorrowers)
						{
							//input each borrowers no and amount pair
							
							JTextField n2Field = new JTextField(5);
							JTextField l2Field = new JTextField(5);
							 JPanel myPanel2 = new JPanel();
						     myPanel2.add(new JLabel("\nMoney lent to bank No?:"));
						     myPanel2.add(n2Field);
						     myPanel2.add(new JLabel("Amount:"));
						     myPanel2.add(l2Field);
						     
						     JOptionPane.showConfirmDialog(null, myPanel2,"From Bank no. "+bnkNo, JOptionPane.OK_CANCEL_OPTION);
						     
						     InputCheck bk1=new InputCheck(Number);
						     try
						     {
						    	 bk1.setNumber(n2Field.getText());	 
									bk1.setAmount(l2Field.getText());
									if(bnkNo!=bk1.getNumber())
									{
										if(transactions[bnkNo][bk1.getNumber()]==0)
										{
											transactions[bnkNo][bk1.getNumber()]=bk1.getAmount();
											brwrs++;
											ip+="\nbank "+bnkNo+" loans to bank "+bk1.getNumber() +"amount= "+bk1.getAmount();
											ip1+=bk1.getNumber()+" "+bk1.getAmount()+" ";
											
										}
										else
											JOptionPane.showMessageDialog(null,"Error!\n\nBank "+bnkNo+" has already given a loan to "+bk1.getNumber()); 
										
											
									}
									else
										JOptionPane.showMessageDialog(null,"Error!\n\nBank can not lend money to itself");
							 }
						     catch(Exception e)
					    	 {
					    		 JOptionPane.showMessageDialog(null,"Error!\n\n"+bk1.getErrorMessage());
					    	 }
						     
						     
					    	
						}ip1+="\n";
						 bnkNo++;		
			     }
			    
				
		    	 catch(Exception e)
		    	 {
		    		 JOptionPane.showMessageDialog(null,"Error!\n\n"+bk.getErrorMessage());
		    	 }
		    	
		    	 }
	
		     BankDetails B =new BankDetails(Number,currentAmount,transactions,Limit);
		     String out=B.getUnSafeBankDetails();
		     JOptionPane.showMessageDialog(null,ip);
		     if(!out.equals(""))
		     	{
		    	 //JOptionPane.showMessageDialog(null,ip);
		    	 JOptionPane.showMessageDialog(null,ip1+"\n\nUnsafe Banks are:"+out);
		     	}
		     else
		    	 {
		    	 
		    	 JOptionPane.showMessageDialog(null,ip1+"\n\nAll banks are safe:");}
			     
		    
				outerOption = JOptionPane.showConfirmDialog(null, "Repeat the Program?");
		     }
			    
				catch(Exception E)
				{	
		    			JOptionPane.showMessageDialog(null,"Error!\n\n"+nl.getErrorMessage());
				}
	    }
	}

}
