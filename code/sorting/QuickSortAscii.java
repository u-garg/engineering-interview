import java.util.ArrayList;
import java.util.List;

class QuickSortAscii{

    public static void main(String[] args){
        List<Character> arr = new ArrayList<Character>(List.of('a', 's', 'd', 'f', 'g', '*', '&', '!', 'z', 'y'));

        helper(arr, 0, arr.size()-1);
        System.out.println(arr);

    }

    private static void helper(List<Character> arr, int start, int end){
        if (start >= end){
            return;
        }

        int pivot = start + (end-start)/2;
        swap(arr, pivot, end);

        int pi = partition(arr, start, end);

        helper(arr, start, pi-1);
        helper(arr, pi+1, end);

    }

    private static int partition(List<Character> arr, int start, int end){
        int low = start;

        for (int i=start; i<end-1; i++){
            System.out.println("Checking " + arr.get(i) + "<=" + arr.get(end));
            System.out.println("->" + (int) arr.get(i) + " <= " + (int) arr.get(end));
            System.out.println("result: " + ((int) arr.get(i) <= (int) arr.get(end)));

            if(arr.get(i) <=  arr.get(end)){
                swap(arr, i, low);
                low++; 
            }
        }
        swap(arr, low, end);
        return low;
    }

    private static void swap(List<Character> arr, int first, int second){
        Character c = arr.get(first);
        arr.set(first, arr.get(second));
        arr.set(second, c);
    }

}