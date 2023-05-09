import java.util.Stack;

class Hanoi{

    static Stack<Integer> s = new Stack<Integer>();
    static Stack<Integer> aux = new Stack<Integer>();
    static Stack<Integer> d = new Stack<Integer>();
    public static int N;
    static int times1;

    public static void main(String[] args) {

        N=64;

        for (int i = N; i> 0; i--){
            s.push(i);
        }
        helper(s, aux, d, N);
        //display();
        System.out.println("We moved plates " + times1 + " times");

    }

    static void helper(Stack<Integer> s1, Stack<Integer> aux, Stack<Integer> dest, int n){
        times1++;
            //Move n-1 plates from source to aux
            //Move plate from plate from source to destination
            //move n-1 plates from aux to destination
            if (n == 0){
                return;
            }

            helper(s1, dest, aux, n-1);
            if (!s1.empty()){
                //display();

                dest.push(s1.pop());
            }
            helper(aux, s1, dest, n-1);
    }

    /*  Function to display */
    public static void display()
    {
        System.out.println("  S  |  A  |  D");
        System.out.println("---------------" + times1++ + "----------------");
        for(int i = N - 1; i >= 0; i--)
        {
            String d1 = " ", d2 = " ", d3 = " ";
            try
            {
                d1 = String.valueOf(s.get(i));
            }
            catch (Exception e){
            }    
            try
            {
                d2 = String.valueOf(aux.get(i));
            }
            catch(Exception e){
            }
            try
            {
                d3 = String.valueOf(d.get(i));
            }
            catch (Exception e){
            }
            System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
        }
        System.out.println("\n");         
    }
}