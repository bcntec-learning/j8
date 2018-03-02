package houseware.learn.j8.stream.exercises;

import lombok.ToString;

/**
 * @author fphilip@houseware.es
 */
@ToString
public class Stats {

    private long count;
    private long sum;
    private int min;
    private int max;



    public Stats(final long countValue,
                 final long sumValue,
                 final int minValue,
                 final int maxValue) {
        count = countValue;
        sum = sumValue;
        min = minValue;
        max = maxValue;
        System.out.println("creae "+this);
    }

    public Stats() {
        System.out.println("creae ");
    }

    public final long getCount() {
        return count;
    }

    public final long getSum() {
        return sum;
    }

    public final int getMin() {
        return min;
    }

    public final int getMax() {
        return max;
    }


    public final double getAverage() {
        return getCount() > 0 ? (double) getSum() / getCount() : 0.0d;
    }

    public void accept(int age) {
        System.out.println("accept");
        sum += age;
        min = Math.min(min, age);
        max = Math.max(max, age);
        count++;
    }

    public void combine(Stats o) {
        System.out.println("combine");
        this.count += o.count;
        //recalcualr totalizadores

    }
}
