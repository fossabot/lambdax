/*
 * Copyright 2019 LambdaX contributors
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
 * <p>The base implementation of {@link io.github.alexengrig.lambdax.function.PredicateI} interface.</p>
 *
 * @param <T> a type
 * @param <R> a result
 * @author Grig Alex
 * @version 0.2.0
 * @see io.github.alexengrig.lambdax.function.PredicateI
 * @see java.util.function.Predicate
 * @see java.util.function.Function
 * @since 0.2.0
 */
/* package */ final class BasePredicate<T, R> implements PredicateI<T, R> {
    private final Function<T, R> function;

    public BasePredicate(Function<T, R> mapper) {
        this.function = mapper;
    }

    @Override
    public <U> PredicateI<T, U> map(Function<R, U> mapper) {
        return new BasePredicate<>(function.andThen(mapper));
    }

    @Override
    public Predicate<T> check(Predicate<R> checker) {
        return t -> checker.test(function.apply(t));
    }
}
