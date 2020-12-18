package top.chonglie.test;

public class CheckData<T,R> {
    public T input;
    public R expected;

    public CheckData(T input, R expected) {
        this.input = input;
        this.expected = expected;
    }
}
