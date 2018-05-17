package functor;

import common.DataClass;

import java.util.function.Function;

public interface Functor<A> {
    <B> Functor<B> fmap(Function<A, B> f);
}

abstract class Maybe<A> extends DataClass implements Functor<A> {
}

class Just<A> extends Maybe<A> {

    private final A value;

    Just(A value) {
        this.value = value;
    }

    @Override
    public <B> Functor<B> fmap(Function<A, B> f) {
        return new Just(f.apply(value));
    }
}

class Nothing<A> extends Maybe<A> {

    @Override
    public <B> Functor<B> fmap(Function<A, B> f) {
        return new Nothing<>();
    }
}


