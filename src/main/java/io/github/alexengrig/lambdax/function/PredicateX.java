/*
 * Copyright 2019 - 2020 Alexengrig Dev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.alexengrig.lambdax.function;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>This utility class contains useful lambdas for {@link java.util.function.Predicate}.</p>
 *
 * @author Grig Alex
 * @version 0.3.0
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
 * @see io.github.alexengrig.lambdax.function.ComparablePredicateI
 * @see io.github.alexengrig.lambdax.function.PredicateI
 * @since 0.2.0
 */
public final class PredicateX {
    /**
     * <p>The private constructor.</p>
     *
     * @since 0.2.0
     */
    private PredicateX() {
    }

    /**
     * <p>Returns the {@link java.util.function.Predicate}: t -&gt; true.</p>
     *
     * @param <T> a type of the input to the predicate
     * @return The {@link java.util.function.Predicate} that always returns {@code
     * true}
     * @see java.util.function.Predicate
     * @since 0.2.0
     */
    public static <T> Predicate<T> truth() {
        return t -> true;
    }

    /**
     * <p>Returns the {@link java.util.function.Predicate}: t -&gt; false.</p>
     *
     * @param <T> a type of the input to the predicate
     * @return The {@link java.util.function.Predicate} that always returns {@code
     * false}
     * @see java.util.function.Predicate
     * @since 0.2.0
     */
    public static <T> Predicate<T> lie() {
        return t -> false;
    }

    /**
     * <p>Returns the {@link java.util.function.Predicate} that is the negation of
     * the supplied predicate.</p> <p>Like in JDK 11.</p>
     *
     * @param <T>       a type of the input to the predicate
     * @param predicate a supplied predicate to negate
     * @return The {@link java.util.function.Predicate} that negates the results
     * of the supplied predicate
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#negate
     * @since 0.2.0
     */
    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * AND of first predicate and second predicate.
     * When evaluating the composed predicate,
     * if first predicate is {@code false},
     * then second predicate is not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-ANDed with the {@code second}
     * @param second a predicate that will be logically-ANDed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * AND of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#and(java.util.function.Predicate)
     * @since 0.3.0
     */
    public static <T> Predicate<T> and(Predicate<T> first, Predicate<T> second) {
        return t -> first.test(t) && second.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical AND of predicates.
     * When evaluating the composed predicate,
     * if any predicate is {@code false},
     * then those following predicates are not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-ANDed with the {@code second}
     * @param second a predicate that will be logically-ANDed with the {@code first}
     * @param others predicates that will be logically-ANDed with previous result
     *               starting from the result of the {@code first} and the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * AND of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#and(java.util.function.Predicate)
     * @see io.github.alexengrig.lambdax.function.PredicateX#and(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<T> first, Predicate<T> second, Predicate<T>... others) {
        Predicate<T> predicate = and(first, second);
        for (Predicate<T> other : others) {
            predicate = and(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * OR of first predicate and second predicate.
     * When evaluating the composed predicate,
     * if first predicate is {@code true},
     * then second predicate is not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-ORed with the {@code second}
     * @param second a predicate that will be logically-ORed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * OR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#or(java.util.function.Predicate)
     * @since 0.3.0
     */
    public static <T> Predicate<T> or(Predicate<T> first, Predicate<T> second) {
        return t -> first.test(t) || second.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical OR of predicates.
     * When evaluating the composed predicate,
     * if any predicate is {@code true},
     * then those following predicates are not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-ORed with the {@code second}
     * @param second a predicate that will be logically-ORed with the {@code first}
     * @param others predicates that will be logically-ORed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * OR of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#or(java.util.function.Predicate)
     * @see io.github.alexengrig.lambdax.function.PredicateX#or(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<T> first, Predicate<T> second, Predicate<T>... others) {
        Predicate<T> predicate = first.or(second);
        for (Predicate<T> other : others) {
            predicate = predicate.or(other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * XOR of first predicate and second predicate.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-XORed with the {@code second}
     * @param second a predicate that will be logically-XORed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * XOR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    public static <T> Predicate<T> xor(Predicate<T> first, Predicate<T> second) {
        return t -> first.test(t) ^ second.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical XOR of predicates.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-XORed with the {@code second}
     * @param second a predicate that will be logically-XORed with the {@code first}
     * @param others predicates that will be logically-XORed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * XOR of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see io.github.alexengrig.lambdax.function.PredicateX#xor(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    public static <T> Predicate<T> xor(Predicate<T> first, Predicate<T> second, Predicate<T>... others) {
        Predicate<T> predicate = xor(first, second);
        for (Predicate<T> other : others) {
            predicate = xor(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * NAND of first predicate and second predicate.
     * When evaluating the composed predicate,
     * if first predicate is {@code false},
     * then second predicate is not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-NANDed with the {@code second}
     * @param second a predicate that will be logically-NANDed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * NAND of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    public static <T> Predicate<T> nand(Predicate<T> first, Predicate<T> second) {
        return t -> !(first.test(t) && second.test(t));
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical NAND of predicates.
     * if any predicate is {@code false},
     * then those following predicates are not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-NANDed with the {@code second}
     * @param second a predicate that will be logically-NANDed with the {@code first}
     * @param others predicates that will be logically-NANDed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * NAND of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see io.github.alexengrig.lambdax.function.PredicateX#nand(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    public static <T> Predicate<T> nand(Predicate<T> first, Predicate<T> second, Predicate<T>... others) {
        Predicate<T> predicate = nand(first, second);
        for (Predicate<T> other : others) {
            predicate = nand(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * NOR of first predicate and second predicate.
     * When evaluating the composed predicate,
     * if first predicate is {@code true},
     * then second predicate is not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-NORed with the {@code second}
     * @param second a predicate that will be logically-NORed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * NOR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    public static <T> Predicate<T> nor(Predicate<T> first, Predicate<T> second) {
        return t -> !(first.test(t) || second.test(t));
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical NOR of predicates.
     * When evaluating the composed predicate,
     * if any predicate is {@code true},
     * then those following predicates are not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-NORed with the {@code second}
     * @param second a predicate that will be logically-NORed with the {@code first}
     * @param others predicates that will be logically-NORed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * NOR of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see io.github.alexengrig.lambdax.function.PredicateX#nor(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    public static <T> Predicate<T> nor(Predicate<T> first, Predicate<T> second, Predicate<T>... others) {
        Predicate<T> predicate = nor(first, second);
        for (Predicate<T> other : others) {
            predicate = nor(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * XNOR of first predicate and second predicate.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-XNORed with the {@code second}
     * @param second a predicate that will be logically-XNORed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * XNOR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    public static <T> Predicate<T> xnor(Predicate<T> first, Predicate<T> second) {
        return t -> first.test(t) == second.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical XNOR of predicates.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-XNORed with the {@code second}
     * @param second a predicate that will be logically-XNORed with the {@code first}
     * @param others predicates that will be logically-XNORed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * XNOR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    @SafeVarargs
    public static <T> Predicate<T> xnor(Predicate<T> first, Predicate<T> second, Predicate<T>... others) {
        Predicate<T> predicate = xnor(first, second);
        for (Predicate<T> other : others) {
            predicate = xnor(predicate, other);
        }
        return predicate;
    }

    /**
     * <p>Returns the same {@link java.util.function.Predicate} as passed to the
     * method.</p>
     *
     * @param checker a predicate
     * @param <T>     a type of the input to the predicate
     * @return The same {@link java.util.function.Predicate} - checker
     * @see java.util.function.Predicate
     */
    @SuppressWarnings("unchecked")
    public static <T> Predicate<T> from(Predicate<? super T> checker) {
        return (Predicate<T>) checker;
    }

    /**
     * <p>Returns the {@link io.github.alexengrig.lambdax.function.PredicateB}
     * with the mapper.</p>
     *
     * @param mapper a function of map the input
     * @param <T>    a type of the input to the predicate
     * @param <R>    a type of the mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.PredicateI}
     * @see io.github.alexengrig.lambdax.function.PredicateI
     * @see java.util.function.Function
     * @see io.github.alexengrig.lambdax.function.PredicateB
     * @since 0.2.0
     */
    public static <T, R> PredicateI<T, R> of(Function<T, R> mapper) {
        return new PredicateB<>(mapper);
    }

    /**
     * <p>Returns the {@link
     * io.github.alexengrig.lambdax.function.ComparablePredicateB} with the mapper
     * with comparable result.</p>
     *
     * @param mapper a function of map the input to comparable result
     * @param <T>    a type of the input to the predicate
     * @param <R>    a comparable type of the mapper result
     * @return The {@link
     * io.github.alexengrig.lambdax.function.ComparablePredicateI}
     * @see java.lang.Comparable
     * @see io.github.alexengrig.lambdax.function.ComparablePredicateI
     * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
     * @see io.github.alexengrig.lambdax.function.ComparablePredicateB
     * @since 0.2.0
     */
    public static <T, R extends Comparable<R>> ComparablePredicateI<T, R> of(ComparableResultFunction<T, R> mapper) {
        return new ComparablePredicateB<>(mapper);
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateB} with
     * the mapper.
     * </p>
     *
     * @param mapper a function of map the input
     * @param <T>    a type of the input to the predicate
     * @param <R>    a type of the optional mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateI}
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateI
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateB
     * @see java.util.function.Function
     * @since 0.3.0
     */
    public static <T, R> OptionalPredicateI<T, R> ofNullable(Function<T, R> mapper) {
        return new OptionalPredicateB<>(mapper);
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.ComparableOptionalPredicateB} with
     * the mapper with comparable optional result.
     * </p>
     *
     * @param mapper a function of map the input to comparable optional result
     * @param <T>    a type of the input to the predicate
     * @param <R>    a comparable type of the optional mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.ComparableOptionalPredicateI}
     * @see java.lang.Comparable
     * @see io.github.alexengrig.lambdax.function.ComparableOptionalPredicateI
     * @see io.github.alexengrig.lambdax.function.ComparableOptionalPredicateB
     * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
     * @since 0.3.0
     */
    public static <T, R extends Comparable<R>> ComparableOptionalPredicateI<T, R> ofNullable(
            ComparableResultFunction<T, R> mapper) {
        return new ComparableOptionalPredicateB<>(mapper);
    }
}
