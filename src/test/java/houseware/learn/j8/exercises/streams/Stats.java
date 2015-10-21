package houseware.learn.j8.exercises.streams;

/**
 * @author fphilip@houseware.es
 */
public class Stats {

    public Stats(final long countValue,
                 final long sumValue,
                 final int minValue,
                 final int maxValue) {
        count = countValue;
        sum = sumValue;
        min = minValue;
        max = maxValue;
    }

    public Stats() {
    }

    private long count;

    public final long getCount() {
        return count;
    }

    private long sum;

    public final long getSum() {
        return sum;
    }

    private int min;

    public final int getMin() {
        return min;
    }

    private int max;

    public final int getMax() {
        return max;
    }

    public final double getAverage() {
        return getCount() > 0 ? (double) getSum() / getCount() : 0.0d;
    }

    public void accept(int age) {
        sum += age;
        min = Math.min(min, age);
        max = Math.max(max, age);
        count++;
    }

    public void combine(Stats o) {
        this.count += o.count;

    }
}
