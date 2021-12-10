import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;

public class JdaBotImpl implements Bot {
    final JDA jda;

    public JdaBotImpl(JDA jda) {
        this.jda = jda;
    }

    private void awaitReady() {
        try {
            jda.awaitReady();
        } catch (InterruptedException e) {
            throw new CompletionException(e);
        }
    }

    @Override
    public CompletableFuture<Void> login() {
        return CompletableFuture.runAsync(this::awaitReady);
    }

    @Override
    public CompletableFuture<Void> login(Executor executor) {
        return CompletableFuture.runAsync(this::awaitReady,executor);
    }

    static class BuilderImpl implements Bot.Builder {

        String token;

        @Override
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        @Override
        public Bot build() throws Exception {
            return new JdaBotImpl(JDABuilder.createDefault(this.token).build());
        }
    }
}