package SchlumbergerProblems;
import java.util.*;

class UniqueImages   {
    public static class Image {
        private String filename;
        private int width;
        private int height;
        public Image(String filename, int width, int height) {
            this.filename = filename;
            this.width = width;
            this.height = height;
        }
        /**
         * Two Images are considered equal if they have
         * the same filename (without the extension), and the
         * same number of pixels.
         * Thus, flag.jpg with width=60 height=40 is
         * equal to flag.gif with width=40 and height=60
         */
        
        
        // Need to implement hashcode method of object class.
        @Override
        public int hashCode() {
        	 String [] newFileName = this.filename.split("\\.");
        	 System.out.println("hashcode for"+" " + newFileName[0] +"."+ newFileName[1] + ":" + newFileName[0].hashCode() + Integer.valueOf(this.width).hashCode() + Integer.valueOf(this.height).hashCode());
             return (newFileName[0].hashCode() + Integer.valueOf(this.width).hashCode() + Integer.valueOf(this.height).hashCode());        
        }
        
        public boolean equals(Object other) {
        	System.out.println("In Equals Method");
            Image o = (Image)other;
            if (filename == null || o.filename == null)
                return false;
            String[] components = filename.split("\\.");
            String[] ocomponents = o.filename.split("\\.");
            return components[0].equals(ocomponents[0]) && 
                width * height == o.width * o.height;
        }
         
        public String toString() {
            return "Image: filename=" + filename + " Size=" + width*height;
        }
    }

   
    
    public static void printImages(Set<Image> images) {
    
        for(Image image: images) {
            System.out.println(image);
        }
    }

    private static List<Image> unique(List<Image> list) {
        List<Image> uniqueList = new ArrayList<>();
        Set<Image> uniqueSet = new HashSet<>();
        for (Image obj : list) { 
            if (uniqueSet.add(obj)) {//Returns:true if this set did not already contain the specified element
            						 // while adding , first calls hash code method then equals method. 
                uniqueList.add(obj);
            }
        }
        return uniqueList;
    }
    
    public static void main(String[] args) {
    	
    	
    	
        Image[] images = {new Image("flag.jpg", 40, 60),
                          new Image("flag.gif", 40, 60),
                          new Image("smile.gif", 100, 200),
                          new Image("smile.gif", 50, 400),
                          new Image("other.jpg", 40, 60),
                          new Image("lenna.jpg", 512, 512),
                          new Image("Lenna.jpg", 512, 512)};
        
        ArrayList<Image> al = new ArrayList<Image>(Arrays.asList(images));
        //added new method which gives the unique result
        UniqueImages.unique(al);
      
        Set<Image> set = new HashSet<Image>(al);
        UniqueImages.printImages(set);
    }

	
}