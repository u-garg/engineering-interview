import java.util.Arrays;

class QuickSort{

    public static void main(String[] args){
        int[] arr = new int[]{2,3,5,6,1,8,4,3};
        
        quickSort(arr, 0, arr.length-1);
       System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end){
        if (start == end || start == end+1){
            return;
        }
        int mid = start + (end-start)/2;
        swap(arr, mid, end);
        
        int pi = partition(arr, start, end);
        quickSort(arr, start, pi-1);
        quickSort(arr, pi+1, end);
    }

    private static int partition(int[] arr, int start, int end){
        int low = start;
        for (int i = start; i<=end-1; i++){
            if (arr[i] <= arr[end]){
                swap(arr, i, low);
                low++;
            }
        }
        swap(arr, low, end);
        return low;
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}