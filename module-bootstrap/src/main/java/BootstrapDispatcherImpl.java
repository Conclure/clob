import me.conclure.clob.configuration.processing.Configuration;

@Configuration
public class BootstrapDispatcherImpl implements BootstrapDispatcher {
    private Bot.Builder builder;

    public BootstrapDispatcherImpl(Bot.Builder builder) {
        this.builder = builder;
    }

    @Override
    public void initiate() {

    }
}