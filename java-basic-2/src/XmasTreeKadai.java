public class XmasTree {

    public static void main(String[] args) {
     
       
        
        int N=20;
        for (int i = 0; i < N; i++) {
         
            for (int j = 0; j <( N - i)/2; j++) {
                System.out.print("+"+" ");
            }
            
         
            for (int j = 0; j < 2 * i+1 ; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < (N - i )/2; j++) {
                System.out.print("+"+" ");
            }
         
            System.out.println();
        }

      
        for (int i = 0; i < 8; i++) {
         
            for (int j = 0; j < N - 3; j++) {
                System.out.print(" ");
            }
            
          
            System.out.println("*******");
        }  
    }
}
