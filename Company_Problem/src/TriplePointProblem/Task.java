
package TriplePointProblem;

/**
 *
 * @author aman
 */


public class Task  {
	private int serFee;
    private String tName;
    private int tTaken;
    
    public Task(String tName,int serFee,int tTaken)
    {
    	this.tName=tName;
    	this.serFee=serFee;
    	this.tTaken=tTaken;
    }
    
    public int serviceFee()
    {
        return serFee; 
    }
    
    public String taskName()
    {
        return tName; 
    }
    
    public int timeTaken()
    {
        return tTaken;
    }
  
}
