import java.util.Arrays;

class QuickSelect{

    public static void main(String[] args){

        int[] arr = new int[]{4,3,6,5,1,2};
        int k = 6;

        quickSelect(arr, 0, arr.length-1, k-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(k + "th element is: " + arr[k-1]);
    }

    private static void quickSelect(int[] arr, int start, int end, int k){
        if (start >= end){
            return;
        }

        int mid = start + (end-start)/2;
        swap(arr, mid, end);

        int pi = partition(arr, start, end);

        if (k < pi){
            quickSelect(arr, start, pi-1, k);
        } else if (k > pi){
            quickSelect(arr, pi+1, end, k);
        } else {
            return;
        }

    }

    private static int partition(int[] arr, int start, int end) {

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

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }

}