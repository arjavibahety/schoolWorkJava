package cs2030.mystream;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public interface MyIntStream {

    static MyIntStream of(int... values) {
        ArrayList<Integer> stream = new ArrayList<>();
        for(int i = 0; i < values.length; i++) {
            stream.add(values[i]);
        }

        MyIntStream x = new MyIntStreamImpl(stream);
        return x;
    }

    static MyIntStream range(int start, int end) {
        ArrayList<Integer> stream = new ArrayList<>();
        for(int i = start; i < end; i++) {
            stream.add(i);
        }
        MyIntStream x = new MyIntStreamImpl(stream);
        return x;

    }

    static MyIntStream rangeClosed(int start, int end) {
        ArrayList<Integer> stream = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            stream.add(i);
        }

        MyIntStream x = new MyIntStreamImpl(stream);
        return x;
    }

    public long count();
    public int sum();
    public OptionalDouble average();
    public OptionalInt min();
    public OptionalInt max();
    public MyIntStream limit(int maxSize);
    public MyIntStream distinct();
    public MyIntStream filter(IntPredicate predicate);
    public MyIntStream map(IntUnaryOperator mapper);
    public void forEach(Consumer<Integer> consume);
    public int reduce(int identity, IntBinaryOperator op);
    public OptionalInt reduce(IntBinaryOperator op);

    public String toString();
}
