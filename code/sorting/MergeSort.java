class MergeSort{

    public static void main(String[] args) {
        int[] nums = new int[]{3,7,6,1,8,3,8};
        helper(nums, 0, nums.length-1);
    }

    private static void helper(int[] array, int start, int end) {
        
        if (start == end){
            return;
        }

        int mid = start + (end-start)/2;
        helper(array, start, mid);
        helper(array, mid+1, end);

        int[] aux = new int[end-start+1];
        
        int i = start;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= end){
            if (array[i] <= array[j]){
                aux[k++]  = array[i++];
            } else {
                aux[k++] = array[j++];
            }
        }

        while (i<= mid){
            aux[k++] = array[i++];
        }

        while (j<= end){
            aux[k++] = array[j++];
        }

        for(int l = 0; l<aux.length; l++){
            array[start+l] = aux[l];
        }

    }

}