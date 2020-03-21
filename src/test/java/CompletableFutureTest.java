import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {
    @Test
    public void shouldBeAync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {ThreadUtil.safeSleep(1000);return "hello" ;});
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "!");

// 使用allOf方法
//        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
//        all.get();
//
        System.out.println(f3.get());
        System.out.println(f1.get());
       System.out.println(f2.get());
       Future<String> testingString=ThreadUtil.execAsync(()->{
            ThreadUtil.safeSleep(1000);
            return "aaaa";
        });

        Console.log( testingString.get());
        //ThreadUtil.safeSleep(10000);
 //结合StreamAPI
//        List<String> result = Stream.of(f1, f2, f3)
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList());
//
//        System.out.println(result);
    }
}
