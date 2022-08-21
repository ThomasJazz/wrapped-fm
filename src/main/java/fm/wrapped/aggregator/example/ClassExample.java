package fm.wrapped.aggregator.example;

public class ClassExample {
    public int someInt = 5;
    public String preFilledString = "hello";
    public String unfilledString;

    public ClassExample(String unfilled)  {
        this.unfilledString = unfilled;  // Set the initial value for the class attribute x
    }
}
