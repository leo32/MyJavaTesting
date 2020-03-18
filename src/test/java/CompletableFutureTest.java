import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {
    @Test
    public void shouldBeAync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "!");

// 使用allOf方法
        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
        all.get();

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());

// 结合StreamAPI
        List<String> result = Stream.of(f1, f2, f3)
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
