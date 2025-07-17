import java.util.Scanner;

public class 알고리즘 {

    public void 소수구하기() {
        //1929
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}
