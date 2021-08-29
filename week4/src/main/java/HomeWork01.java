import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class HomeWork01 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        TaskA task = new TaskA();
        Future<Integer> f = executor.submit(task);

        try {
            Integer result = f.get(); //这是得到的返回值

            // 确保  拿到result 并输出
            System.out.println("异步计算结果为：" + result);

            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();

        }


        // 然后退出main线程
    }


}
