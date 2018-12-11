package Immutable;

import java.util.Date;

public final class DateImmutableConcept {

	    private final Date remindingDate;

		/*public Date getRemindingDate() {
			return remindingDate;
		}
	  */
	    public DateImmutableConcept (Date remindingDate) {
	        if(remindingDate.getTime() < System.currentTimeMillis()){
	            throw new IllegalArgumentException("Can not set reminder� + � for past time: " + remindingDate);
	        }
	        this.remindingDate = new Date(remindingDate.getTime());
	    }
	  
	    public Date getRemindingDate() {
	        return (Date) remindingDate.clone();
	        //return new Date(remindingDate.getTime());
	    }
	    
	   
	}

class Test {
	
	public static void main(String[] args) {
	
		DateImmutableConcept obj = new DateImmutableConcept(new Date());
		
		obj.getRemindingDate().setDate(0);
	}
	 
}