package cs2030.mystream;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class MyIntStreamImpl implements MyIntStream {
    ArrayList<Integer> stream;

    public MyIntStreamImpl(ArrayList<Integer> stream) {
        this.stream = stream;
    }

    public long count() {
        return (long) stream.size();
    }

    public int sum() {
        int sum = 0;
        for(int i = 0; i < stream.size(); i++) {
            sum += stream.get(i);
        }
        return sum;
    }

    public OptionalDouble average() {
        if (stream.size() == 0) {
            return OptionalDouble.empty();
        } else {
            int sum = sum();
            long count = count();
            return OptionalDouble.of(sum / count);
        }

    }

    public OptionalInt min() {
        if(stream.size() == 0) {
            return OptionalInt.empty();
        }

        int min = stream.get(0);
        for(int i = 1; i < stream.size(); i++) {
            if(min > stream.get(i)) {
                min = stream.get(i);
            }
        }

        return OptionalInt.of(min);
    } 

    public OptionalInt max() {
        if(stream.size() == 0) {
            return OptionalInt.empty();
        }

        int max = stream.get(0);
        for(int i = 0; i < stream.size(); i++) {
            if(max < stream.get(i)) {
                max = stream.get(i);
            }
        }
        return OptionalInt.of(max);
    }

    public MyIntStream limit(int maxSize) {
        ArrayList<Integer> s2 = new ArrayList<>();
        for(int i = 0; i < maxSize; i++) {
            s2.add(stream.get(i));
        }
        MyIntStream x = new MyIntStreamImpl(s2);
        return x;
    }

    public MyIntStream distinct() {
        ArrayList<Integer> s2 = new ArrayList<>();
        for(int i = 0; i < stream.size(); i++) {
            if(!s2.contains(stream.get(i))) {
                s2.add(stream.get(i));
            }
        }
        
        MyIntStream x = new MyIntStreamImpl(s2);
        return x;
    }

    public MyIntStream filter(IntPredicate func) {
        ArrayList<Integer> s2 = new ArrayList<>();
        for(int i = 0; i < stream.size(); i++) {
            if(func.test(stream.get(i))) {
                s2.add(stream.get(i));
            }
        }
        
        MyIntStream x = new MyIntStreamImpl(s2);
        return x;
    }
    
    public MyIntStream map(IntUnaryOperator func) {
        ArrayList<Integer> s2 = new ArrayList<>();
        for(int i = 0; i < stream.size(); i++) {
                s2.add(func.applyAsInt(stream.get(i)));
        }

        MyIntStream x = new MyIntStreamImpl(s2);

        return x;
    }

    public void forEach(Consumer<Integer> consume) {
        for(int i = 0; i < stream.size(); i++) {
            consume.accept(stream.get(i));
        }
    }

    public int reduce(int identity, IntBinaryOperator op) {
        int sum = identity;
        for(int i = 0; i < stream.size(); i++) {
            sum = op.applyAsInt(stream.get(i), sum);
        }
        return sum;
    }

    public OptionalInt reduce(IntBinaryOperator op) {
        if(stream.size() == 0) {
            return OptionalInt.empty();
        } else {
            return OptionalInt.of(reduce(0, op));
        }
    }

    public String toString() {
        return stream.toString();
    }
}
