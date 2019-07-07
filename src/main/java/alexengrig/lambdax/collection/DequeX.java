package alexengrig.lambdax.collection;

import java.util.Deque;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This utility class contains useful lambdas for {@link Deque}
 *
 * @author Grig Alex
 * @see Deque
 * @see Consumer
 * @see Predicate
 * @since 0.1.0
 */
public final class DequeX {
    private DequeX() {
    }

    public static <E> Predicate<Deque<? super E>> contains(E item) {
        return d -> d.contains(item);
    }

    public static <E> Predicate<Deque<? super E>> add(E item) {
        return d -> d.add(item);
    }

    public static <E> Consumer<Deque<? super E>> onlyAdd(E item) {
        return d -> d.add(item);
    }

    public static <E> Consumer<Deque<? super E>> addFirst(E item) {
        return d -> d.addFirst(item);
    }

    public static <E> Consumer<Deque<? super E>> addLast(E item) {
        return d -> d.addLast(item);
    }

    public static <E> Predicate<Deque<? super E>> offer(E item) {
        return d -> d.offer(item);
    }

    public static <E> Consumer<Deque<? super E>> onlyOffer(E item) {
        return d -> d.offer(item);
    }

    public static <E> Predicate<Deque<? super E>> offerFirst(E item) {
        return d -> d.offerFirst(item);
    }

    public static <E> Consumer<Deque<? super E>> onlyOfferFirst(E item) {
        return d -> d.offerFirst(item);
    }

    public static <E> Predicate<Deque<? super E>> offerLast(E item) {
        return d -> d.offerLast(item);
    }

    public static <E> Consumer<Deque<? super E>> onlyOfferLast(E item) {
        return d -> d.offerLast(item);
    }

    public static <E> Consumer<Deque<? super E>> push(E item) {
        return d -> d.push(item);
    }

    public static <E> Predicate<Deque<? super E>> remove(E item) {
        return d -> d.remove(item);
    }

    public static <E> Consumer<Deque<? super E>> onlyRemove(E item) {
        return d -> d.remove(item);
    }

    public static <E> Predicate<Deque<? super E>> removeFirstOccurrence(E item) {
        return d -> d.removeFirstOccurrence(item);
    }

    public static <E> Consumer<Deque<? super E>> onlyRemoveFirstOccurrence(E item) {
        return d -> d.removeFirstOccurrence(item);
    }

    public static <E> Predicate<Deque<? super E>> removeLastOccurrence(E item) {
        return d -> d.removeLastOccurrence(item);
    }

    public static <E> Consumer<Deque<? super E>> onlyRemoveLastOccurrence(E item) {
        return d -> d.removeLastOccurrence(item);
    }
}
