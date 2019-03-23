package br.com.twinsflammer.mcmmo.cosmetics.util;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalConsumer<T> {

    private Optional<T> optional;

    private OptionalConsumer(Optional<T> optional) {
        this.optional = optional;
    }

    public OptionalConsumer<T> ifPresent(Consumer<T> consumer) {
        optional.ifPresent(consumer);
        return this;
    }

    public OptionalConsumer<T> ifNotPresent(Runnable runnable) {
        if (!optional.isPresent()) runnable.run();
        return this;
    }

    public static <T> OptionalConsumer<T> of(Optional<T> optional) {
        return new OptionalConsumer<>(optional);
    }
}