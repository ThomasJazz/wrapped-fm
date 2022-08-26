package fm.wrapped.aggregator.model;

/*
    Summary:
        Test model used to in writing tests to test out the Http Library

    Author: Noctsol
    CreatedDate: 2022-08-22
*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT CLASSES *********************/

/********************* LOCAL LIBRARIES *********************/

/********************* PUBLIC PACKAGES *********************/
import com.fasterxml.jackson.annotation.JsonAlias;



/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/

public class TestLocation {
    /******************************************* PROPERTIES/ATTRIBUTES *******************************************/
    @JsonAlias("city")
    public String City;

    @JsonAlias("state")
    public String State;

    @JsonAlias("zip_code")
    public String ZipCode;

    @JsonAlias("country")
    public String Country;


    /******************************************* CONSTRUCTOR *******************************************/
    public TestLocation(){};


    /******************************************* PUBLIC METHODS *******************************************/

    // Generates a prefilled instance used for testing
    public TestLocation GenerateTestInstance(){
        this.City = "Liscor";
        this.State = "Solstice";
        this.ZipCode = "77777";
        this.Country = "Izrael";

        return this;
    }

}
