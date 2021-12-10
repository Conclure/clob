public interface BootstrapDispatcher {
    static BootstrapDispatcher create(Bot.Builder builder) {
        return new BootstrapDispatcherImpl(builder);
    }

    void initiate();
}