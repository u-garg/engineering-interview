import java.util.Arrays;

class KthLargest{

    public static void main(String[] args){
        int[] arr = new int[] {3,2,1,5,6,4};
        int k = 5;

        System.out.println("Kth element: " +  findKthLargest(arr, arr.length-k));
    }

    private static int findKthLargest(int[] arr, int k) {
        Integer result = -1;

        helper(arr, k, 0, arr.length-1, result);

        System.out.println(Arrays.toString(arr));
        return arr[k];

    }

    private static void helper(int[] arr, int k, int start, int end, Integer result){  //{1,4,5,6,3,5};

        if (start >= end)
            return;

        int mid = start + (end-start)/2;
        swap(arr, mid, end);
        
        int low=start;  //4    3   2   1   0
        int i = start;
        for (i = start; i<end-1; i++){
            if(arr[i] <= arr[end]){
                low++;
                swap(arr, i, low);
            }
        }

        swap(arr, low+1, end);

        if (k < low){
             helper(arr, k, start, low-1, result);
        } else if (k > low){
             helper(arr, k, low+1, end, result);
        } else {
            result =  arr[low];
        }
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

}