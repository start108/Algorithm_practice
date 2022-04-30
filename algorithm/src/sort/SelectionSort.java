package sort;

public class SelectionSort {

    public static void main(String[] args) {
    	
        int i, j, min, index = 0, temp;
        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for(i = 0; i < 10; i++) {
            min = 9999;
            for(j =0; i< 10; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        
        for(i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
