package testing;

public class sorting {
    public static void printArr(int a[]){
        for(int k:a){
            System.out.print(k+" ");
        }
        System.out.println();
    }
    public static void BubbleSort(int a[], int n){
        int totalPasses = 0;
        for (int i = 0; i<n; i++){
            for (int j = 0; j< n-i-1; j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            printArr(a);
            totalPasses++;
        }
        System.out.println("Number of passes "+ totalPasses);
    }
     public static void BubbleSortModified(int a[], int n){
        int totalPasses = 0;
        for (int i = 0; i<n; i++){
            int noOfSwap = 0;
            for (int j = 0; j< n-i-1; j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    noOfSwap++;
                }
            }
            printArr(a);
            totalPasses++;
            if(noOfSwap == 0) break;
        }
        System.out.println("Number of passes "+ totalPasses);
    }
    public static void SelectionSort(int[] a, int n){
        int totalPasses = 0;
        for (int i=0; i<n-1; i++){
            int min_index = i;
            for (int j=i+1; j<n; j++){
                if (a[j]<a[min_index]){
                    min_index = j;
                }
            }
            if (min_index!=i){
                int temp = a[min_index];
                a[min_index] = a[i];
                a[i] = temp;
            }
            printArr(a);
            totalPasses++;
        }
        System.out.println("Number of passes "+ totalPasses);
        
    }
    public static void InsertionSort(int[] a, int n){
        int totalPasses = 0;
        for(int i=1; i<n; i++){
            int key = a[i];
            int j = i-1;
            while (j>=0 && a[j]>key) {
                a[j+1] = a[j];
                j--;  
            }
            a[j+1] = key;
            printArr(a);
            totalPasses++;
        }
        System.out.println("Number of passes "+ totalPasses);
    }
    public static int Partition(int[] a,int low, int high){
        int pivot = a[low];
        int i = low;
        int j = high;
        while (i<j) {
            do{
                i++;
            }while(a[i]<=pivot);
            do{
                j--;
            }while(a[i]>pivot);
            if(i<j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            int temp2 = a[low];
            a[low] = a[j];
            a[j] = temp2;
            
        }
        return j;
    }
    /*public static int Partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];
 
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
 
                // Increment index of smaller element
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp2 = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp2;
        //swap(arr, i + 1, high);
        return (i + 1);
    }*/
    public static void QuickSort(int[] a, int low, int high){
        if (low<high){
            int j = Partition(a,low,high);
            QuickSort(a,low, j-1);
            QuickSort(a,j+1, high);
        }
    }

    
    public static void main(String[] args) {
        int a[] = new int[] {2,7,4,1,5,3,8,12,33,40,59,10,15,32,17,11,39};
        System.out.println("Bubble Sort");
        BubbleSort(a,6);
        int a_1[] = new int[] {2,7,4,1,5,3,8,12,33,40,59,10,15,32,17,11,39};
        System.out.println("Bubble Sort Modified");
        BubbleSortModified(a_1,a_1.length);
        int a_2[] = new int[] {2,7,4,1,5,3,8,12,33,40,59,10,15,32,17,11,39};
        System.out.println("Selection Sort");
        SelectionSort(a_2,a_2.length);
        int a_3[] = new int[] {4,3,2,10,12,1,5,6};
        System.out.println("Insertion Sort");
        InsertionSort(a_3,a_3.length);
        int a_4[] = new int[] {4,3,2,10,12,1,5,6};
        System.out.println("Quick Sort");
        QuickSort(a_4,0,a_4.length-1);
        printArr(a_4);
    }
}
