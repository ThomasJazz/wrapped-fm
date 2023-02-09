package fm.wrapped.musicgator.model;

/*
    Summary:
        Test model used to in writing tests to test out the Http Library

    Author: Noctsol
    CreatedDate: 2022-08-22
*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT CLASSES *********************/
// Java Native Data Structures
import java.util.List;          // List<Type>
import java.util.ArrayList;          // List<Type>


/********************* LOCAL LIBRARIES *********************/

/********************* PUBLIC PACKAGES *********************/
import com.fasterxml.jackson.annotation.JsonAlias;



/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/
public class TestRecentActions {
    /******************************************* PROPERTIES/ATTRIBUTES *******************************************/
    @JsonAlias("actions")
    public List<String> Actions;

    /******************************************* CONSTRUCTORS *******************************************/
    // Default Constructor
    public TestRecentActions() {}


    /******************************************* PUBLIC METHODS *******************************************/
    // Generates a test instance
    public TestRecentActions GenerateTestInstance(){
        List<String> myActions = new ArrayList<String>();

        myActions.add("User logged in.");
        myActions.add("User paid $500.00 for some dubious items.");
        myActions.add("User logged out.");
        myActions.add("User died.");

        this.Actions = myActions;

        return this;
    }

}