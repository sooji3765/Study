# Buddle Sort



~~~java
package object01;

public class BuddleSort {

	public static void main(String[] args) {
		
		int[] array = {8,2,6,3,0,7,10,9,4,21};
		
		System.out.println("원본 array");
		printArray(array);
		buddle(array);
		System.out.println("원본 변경후");
		printArray(array);

	}
	
	public static void buddle(int[] array) {
        
        for(int i=0;i< array.length;i++) {
            
            for(int j=0;j<array.length-1;j++) {
                if(array[j]>array[j+1]) {
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j+1]=temp;
                    
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

## 결과


    원본 array
    8 2 6 3 0 7 10 9 4 21 

    원본 변경후
    0 2 3 4 6 7 8 9 10 21 