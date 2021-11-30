package minpq;

import java.util.*;

/**
 * Optimized binary heap implementation of the {@link ExtrinsicMinPQ} interface.
 *
 * @param <T> the type of elements in this priority queue.
 * @see ExtrinsicMinPQ
 */
@SuppressWarnings("ALL")
public class OptimizedHeapMinPQ<T> implements ExtrinsicMinPQ<T> {
    /**
     * {@link List} of {@link PriorityNode} objects representing the heap of item-priority pairs.
     */
    private final PriorityQueue<PriorityNode<T>> pq;
    /**
     * {@link Map} of each item to its associated index in the {@code items} heap.
     */
    private final Map<T, Integer> itemToIndex;
    private int flag;

    public OptimizedHeapMinPQ() {
        pq = new PriorityQueue<>(Comparator.comparingDouble(PriorityNode::priority));
        itemToIndex = new HashMap<>();
        flag = 0;
    }

    @Override
    public void add(T item, double priority) {
        if (contains(item)) {
            throw new IllegalArgumentException("Already contains " + item);
        }
        // TODO: Replace with your code
        pq.add(new PriorityNode<>(item, priority));
        itemToIndex.put(item, flag);
        flag++;
    }

    @Override
    public boolean contains(T item) {
        // TODO: Replace with your code
        return itemToIndex.containsKey(item);
    }

    @Override
    public T peekMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("PQ is empty");
        }
        // TODO: Replace with your code
        return pq.peek().item();

    }

    @Override
    public T removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("PQ is empty");
        }
        // TODO: Replace with your code
        T item = pq.peek().item();
        pq.remove(pq.peek());
        itemToIndex.remove(item);
        return item;

    }

    @Override
    public void changePriority(T item, double priority) {
        if (!contains(item)) {
            throw new NoSuchElementException("PQ does not contain " + item);
        }
        // TODO: Replace with your code
        pq.remove(new PriorityNode<>(item, 0));
        pq.add(new PriorityNode<>(item, priority));
    }

    @Override
    public int size() {
        // TODO: Replace with your code
        return(pq.size());
    }
}
