package fm.wrapped.musicgator;

/*
    Summary:
        Easy Http Client made to make API calls.

    Author: Noctsol
    CreatedDate: 2022-08-22
*/


/********************* JAVA DEFAULT CLASSES *********************/
// Java Native Data Structures

import java.util.List;          // Map<type,type>
import java.util.Arrays;        // List<?>

// UnitTesting
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;


/********************* * LOCAL LIBRARIES *********************/
import fm.wrapped.musicgator.helper.Str;


/********************* PUBLIC PACKAGES *********************/


/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/

@SpringBootTest
class HelperStrTests {
    /******************************************* TESTS *******************************************/

    // Test Helper.Str Join functionality with no delimiter
    @Test
    void shouldJoin_ListOfStrings_WithNoDelimiter() {
        String expectedString = "";

        // Initializing a list
        List<String> myList = Arrays.asList("i", "am", "joined");

        for (String word : myList) {
            expectedString+=word;
        }

        // Joining String
        String resultString = Str.join(myList);

        assertEquals(expectedString, resultString);
    }

    // Test Helper.Str Join functionality with delimited
    @Test
    void shouldJoin_ListOfStrings_WithDelimiter() {
        String expectedString = "i-am-joined";

        // Initializing a list
        List<String> myList = Arrays.asList("i", "am", "joined");

        // Joining String
        String resultString = Str.join(myList, "-");

        assertEquals(expectedString, resultString);
    }
}
