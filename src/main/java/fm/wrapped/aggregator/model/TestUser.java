package fm.wrapped.aggregator.model;

/*
    Summary:
        Model that is used for writing tests

    Author: Noctsol
    CreatedDate: 2022-08-23
*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT CLASSES *********************/

/********************* LOCAL LIBRARIES *********************/

/********************* PUBLIC PACKAGES *********************/
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonAlias;



/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/
public class TestUser {
    /******************************************* PROPERTIES/ATTRIBUTES *******************************************/
    @JsonAlias("user_id")
    public String UserId;

    @JsonAlias("usename")
    public String UserName;

    @JsonIgnore
    public String Password;

    @JsonAlias("description")
    public String Description;

    @JsonAlias("location")
    public TestLocation Location;

    @JsonAlias("recent_actions")
    public TestRecentActions RecentActions;

    /******************************************* CONSTRUCTORS *******************************************/
    // Default Constructor
    public TestUser() {}


    /******************************************* PUBLIC METHODS *******************************************/
    // Generates a instance used for testing
    public TestUser GenerateTestInstance(){
        this.UserId = "SDIUJ3-4HG983-242T-GB32I";
        this.UserName = "tallman";
        this.Password = "thishoudltotallynotbeserializedever";
        this.Description = "I am the largest of all.";
        this.Location = new TestLocation().GenerateTestInstance();
        this.RecentActions = new TestRecentActions().GenerateTestInstance();

        return this;
    };

}