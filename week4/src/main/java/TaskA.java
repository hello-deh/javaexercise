import java.util.concurrent.Callable;

public class TaskA implements Callable<Integer> {

    @Override
    public Integer call() {
        return fibo(36);
    }

    private int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }



}
