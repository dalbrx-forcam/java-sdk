////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 14.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.stream;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A Exception Util which makes it possible to throw checked exceptions from streams.
 * <p>
 * {@code https://stackoverflow.com/questions/27644361/how-can-i-throw-checked-exceptions-from-inside-java-8-streams}
 */
public final class LambdaExceptionUtil {

    @FunctionalInterface
    public interface Consumer_WithExceptions<T, E extends Exception> {
        void accept(T t) throws E;
    }

    @FunctionalInterface
    public interface BiConsumer_WithExceptions<T, U, E extends Exception> {
        void accept(T t, U u) throws E;
    }

    @FunctionalInterface
    public interface Function_WithExceptions<T, R, E extends Exception> {
        R apply(T t) throws E;
    }

    @FunctionalInterface
    public interface Supplier_WithExceptions<T, E extends Exception> {
        T get() throws E;
    }

    @FunctionalInterface
    public interface Runnable_WithExceptions<E extends Exception> {
        void run() throws E;
    }

    /**
     * Rethrow the exception of a consumer.
     * <p>
     * {@code .forEach(rethrowConsumer(name -> System.out.println(Class.forName(name)))); or .forEach(rethrowConsumer(ClassNameUtil::println));}
     *
     * @param consumer The {@link Consumer_WithExceptions}.
     * @param <T>      Type of the object which is consumed.
     * @param <E>      Type of the exception.
     * @return {@link Consumer}.
     * @throws E The exception of the consumer method.
     */
    public static <T, E extends Exception> Consumer<T> rethrowConsumer(Consumer_WithExceptions<T, E> consumer) throws E {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception exception) {
                throwAsUnchecked(exception);
            }
        };
    }

    /**
     * Rethrow the exception of a bi consumer.
     *
     * @param biConsumer The {@link BiConsumer_WithExceptions}.
     * @param <T>        Type of the first object which is consumed.
     * @param <U>        Type of second object which is consumed.
     * @param <E>        Type of the exception.
     * @return {@link BiConsumer}.
     * @throws E The exception of the biconsumer method.
     */
    public static <T, U, E extends Exception> BiConsumer<T, U> rethrowBiConsumer(BiConsumer_WithExceptions<T, U, E> biConsumer) throws E {
        return (t, u) -> {
            try {
                biConsumer.accept(t, u);
            } catch (Exception exception) {
                throwAsUnchecked(exception);
            }
        };
    }

    /**
     * Rethrow the exception of a function.
     * <p>
     * {@code .map(rethrowFunction(name -> Class.forName(name))) or .map(rethrowFunction(Class::forName))}
     *
     * @param function The {@link Function_WithExceptions}.
     * @param <T>      Type of the function parameter.
     * @param <R>      Function return type.
     * @param <E>      Type of the exception.
     * @return {@link Function}.
     * @throws E The exception of the function.
     */
    public static <T, R, E extends Exception> Function<T, R> rethrowFunction(Function_WithExceptions<T, R, E> function) throws E {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception exception) {
                throwAsUnchecked(exception);
                return null;
            }
        };
    }

    /**
     * Rethrow the exception of a Supplier.
     * <p>
     * {@code rethrowSupplier(() -> new StringJoiner(new String(new byte[]{77, 97, 114, 107}, StandardCharsets.UTF_8.name())))}
     *
     * @param function The {@link Supplier_WithExceptions}.
     * @param <T>      Return type of the supplier.
     * @param <E>      Type of the exception.
     * @return {@link Supplier}.
     * @throws E The exception of the function.
     */
    public static <T, E extends Exception> Supplier<T> rethrowSupplier(Supplier_WithExceptions<T, E> function) throws E {
        return () -> {
            try {
                return function.get();
            } catch (Exception exception) {
                throwAsUnchecked(exception);
                return null;
            }
        };
    }

    /**
     * Uncheck a runnable exception.
     * <p>
     * {@code uncheck(() -> Class.forName("xxx"));}
     *
     * @param t {@link Runnable_WithExceptions}.
     */
    public static void uncheck(Runnable_WithExceptions t) {
        try {
            t.run();
        } catch (Exception exception) {
            throwAsUnchecked(exception);
        }
    }

    /**
     * Uncheck a supplier exception.
     * <p>
     * {@code uncheck(() -> Class.forName("xxx"));}
     *
     * @param supplier The {@link Supplier_WithExceptions}.
     * @param <R>      The return type of the supplier.
     * @param <E>      The type of the exception.
     * @return The return value of the supplier.
     */
    public static <R, E extends Exception> R uncheck(Supplier_WithExceptions<R, E> supplier) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            throwAsUnchecked(exception);
            return null;
        }
    }

    /**
     * Uncheck a function exception.
     * <p>
     * uncheck(Class::forName, "xxx");
     *
     * @param function The {@link Function_WithExceptions}.
     * @param t        The function argument.
     * @param <T>      The type of the function argument.
     * @param <R>      The return type of the function.
     * @param <E>      The type of the exception.
     * @return The return value of the function.
     */
    public static <T, R, E extends Exception> R uncheck(Function_WithExceptions<T, R, E> function, T t) {
        try {
            return function.apply(t);
        } catch (Exception exception) {
            throwAsUnchecked(exception);
            return null;
        }
    }

    /**
     * Throws a checked exception as unchecked exception.
     */
    @SuppressWarnings("unchecked")
    private static <E extends Throwable> void throwAsUnchecked(Exception exception) throws E { throw (E) exception; }

}