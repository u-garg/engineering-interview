class Fabonnici{
    public static void main(String[] args) {

        //0,1,1,2,3,5,8,13
        helper(40, 1, 1);

    }

    private static void helper(int n, int base1, int base2){
        
        System.out.println(base2);
        int newBase = base1 + base2;
        if (newBase < n){
            //System.out.println(newBase);
            helper(n, base2, newBase);
        }

    }
}
