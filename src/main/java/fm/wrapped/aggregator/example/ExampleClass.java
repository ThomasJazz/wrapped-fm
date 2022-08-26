/*
Summary:
    Example of a class you can use
Author: Noctsol
CreatedDate: 2022-08-21

*/



/********************* * LOCAL LIBRARIES *********************/
package fm.wrapped.aggregator.example;


/********************* PUBLIC PACKAGES *********************/


/********************* JAVA DEFAULT CLASSES *********************/
import com.fasterxml.jackson.annotation.JsonIgnore;



public class ExampleClass {
    /********************* PUBLIC PROPERTIES *********************/
    public int myInt = 5;
    public double myFloat = 67.887;
    public String myDefaultString = "hello";
    @JsonIgnore
    public String myIgnoredString = "dude";
    public String myArgString;
    public ExampleNestedClass Nested = new ExampleNestedClass();

    /********************* CONSTRUCTORS *********************/

    // Primary Constructor
    public ExampleClass(String argString)  {
        this.myArgString = argString;  // Set the initial value for the class attribute x
    }

    // Secondary Constructor
    public ExampleClass()  {
        this.myArgString = "Secondary Constructor";  // Set the initial value for the class attribute x
    }
}
