package FormLargestNumberInString;
public class SortingLogic implements Comparable<SortingLogic> {
        int number;
        public SortingLogic(int num) {
            this.number = num;
        }
        
        @Override
        public int compareTo(SortingLogic that) {
        	//String.valueOf->Returns the string representation of the Object argument.
            String first =  String.valueOf(this.number) + String.valueOf(that.number);
            String second = String.valueOf(that.number) + String.valueOf(this.number);
            return second.compareTo(first);
        }                
    }