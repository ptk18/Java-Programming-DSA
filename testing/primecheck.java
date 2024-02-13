package testing;

public class primecheck {
    public static void main(String[] args) {
        int count = 0;
        int N = 10;
        for (int n=1; n<N; n++){
            if(isPrime0(n)) count++;
        }
        System.out.println("Pi(" + N + ")=" + count);
    }
    static boolean isPrime0(int n){
        if(n==1) return false;
        if(n<=3) return true;
        int m = n/2;
        for (int i=2; i<=m; i++){
            if (n%i==0) return false;
        }
        return true;
    }
}
