# Select Sort

~~~java
package object01;

public class SelectSort {

    public static void main(String[] args) {
        
        int[] array = {2,6,3,7,23,86,43};
        
        System.out.println("변경 전");
        printArray(array);
        
        select(array);
        
        System.out.println("변경 후");
        printArray(array);
    }
    
    public static void select(int[] array) {
        
        int temp;
        
        for(int i=0;i< array.length-1;i++) {
            
            for(int j=i+1;j<array.length;j++) {
                if(array[j]<array[i]) {
                    temp = array[i];
                    array[i]= array[j];
                    array[j]=temp;
                    
                }
            }
        }
    }
    
    public static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}

~~~