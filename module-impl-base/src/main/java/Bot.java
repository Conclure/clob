import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public interface Bot {

    CompletableFuture<Void> login();

    CompletableFuture<Void> login(Executor executor);

    interface Builder {
        Builder token(String token);

        Bot build() throws Exception;
    }
}
