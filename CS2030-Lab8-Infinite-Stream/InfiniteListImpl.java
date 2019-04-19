package cs2030.mystream;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.Optional;
import java.util.ArrayList;

public abstract class InfiniteListImpl<T> implements InfiniteList<T>{
    boolean conditionMet = false;
    
    public abstract Optional<T> get();

    public <R> InfiniteList<R> map(Function<T, R> mapper) {
        return new InfiniteListImpl<R> () {
            public Optional<R> get() {
                return InfiniteListImpl.this.get().map(mapper);
            }
        };
    }

    public InfiniteList<T> filter(Predicate<T> mapper) {
        return new InfiniteListImpl<T>() {
            public Optional<T> get() {
                Optional<T> something = InfiniteListImpl.this.get();
                if(!something.isPresent()) {
                    return Optional.empty();
                }
                else {
                    while(!mapper.test(something.get())) {
                        something = InfiniteListImpl.this.get();
                    }

                    return something;
                }

            }
        };
    }

    public InfiniteList<T> limit(long n) {

        return new InfiniteListImpl<T>() {
            long remaining = n;
            public Optional<T> get() {
                if(remaining == 0) {
                    return Optional.empty();
                } else {
                    remaining--;
                    return InfiniteListImpl.this.get();
                }
            }
        };
    }

    public InfiniteList<T> takeWhile(Predicate<T> predicate) {
        return new InfiniteListImpl<T>() {
            public Optional<T> get() {
                Optional<T> something = InfiniteListImpl.this.get();
                if(!something.isPresent()) {
                    return Optional.empty();
                } else if(!conditionMet){
                    if(!predicate.test(something.get())) {
                        conditionMet = true;
                        return Optional.empty();
                    } else {
                        return something;
                    }
                } else {
                    return Optional.empty();
                }
            }
        };
    }

    public long count() {
        long counter = 0;
        Optional<T> something = this.get();
        while(something.isPresent()) {
            counter++;
            try {
                something = this.get();
            } catch(Exception NoSuchElementException) {
                break;
            }
        }

        return counter;
    }

    public void forEach(Consumer<T> action) {
        Optional<T> something = this.get();
        while(something.isPresent()) {
            action.accept(something.get());
            try {
                something = this.get();
            } catch(Exception NoSuchElementException) {
                break;
            }
        }
    }

    public Optional<T> reduce(BiFunction<T, T, T> accumulator) {
        boolean foundAny = false;
        T ans = null;
        Optional<T> something = this.get();
        while(something.isPresent()) {
            if(!foundAny) {
                foundAny = true;
                ans = something.get();
            } else {
                ans = accumulator.apply(ans, something.get());
            }
            try {
                something = this.get();
            } catch(Exception NoSuchElementException) {
                break;
            }
        }

        return foundAny ? Optional.of(ans) : Optional.empty();
    }

    public T reduce(T identity, BiFunction<T, T, T> accumulator) {
        T ans = identity;
        Optional<T> something = this.get();
        while(something.isPresent()) {
            ans = accumulator.apply(ans, something.get());
            try {
                something = this.get();
            } catch (Exception NoSuchElementException) {
                break;
            }
        }

        return ans;
    }

    public Object[] toArray() {
        ArrayList<Object> arr = new ArrayList<>();  
        Optional<T> something = this.get();

        while(something.isPresent()) {
            try {
                arr.add(something.get());
                something = this.get();
            } catch(Exception NoSuchElementException) {
                break;
            }

        }
        return arr.toArray();
    }

}
