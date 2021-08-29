import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class HomeWork03 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<>(new TaskA());
        Thread t1 = new Thread(futureTask);
        t1.start();

        try {
            int result = futureTask.get();
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为：" + result);

            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
