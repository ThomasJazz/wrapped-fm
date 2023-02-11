package fm.wrapped.musicgator.helper;

/*
    Summary:
        Method to make dealing with strings more easily. Unfortunately, Java didn't have some of this written out.
    Author: Noctsol
    CreatedDate: 2022-08-22

*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT CLASSES *********************/
// Java Native Data Structures
import java.util.Collection;


/********************* * LOCAL LIBRARIES *********************/
/********************* PUBLIC PACKAGES *********************/


/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/
public final class Str {
    /******************************************* PUBLIC METHODS *******************************************/
    // General Join Function for any Collection of items
    public static String join(Collection<?> items, String delimiter) {

        StringBuilder strBuilder = new StringBuilder();

        // Gettings total length of items
        int listLength = items.size();

        // Generating Array
        String[] myStrings = new String[listLength];

        // Converting all items in collection to an Array of Strings
        int index = 0;
        for (var i : items) {
            myStrings[index] = i.toString();
            index++;
        }

        // Building String
        int listIndexEnd = listLength - 1;
        for (int i=0; i <= listIndexEnd ;i++){
            // Accessing string in list
            String currentItem = myStrings[i];

            // Append string
            strBuilder.append(currentItem);

            // Check if last item
            if (i != listIndexEnd){
                strBuilder.append(delimiter);
            }
        }

        return strBuilder.toString();
    }

    // Overload1 - Join a collection of strings with no delimiter
    public static String join(Collection<?> items) {

        StringBuilder strBuilder = new StringBuilder();

        // Gettings total length of items
        int listLength = items.size();

        // Generating Array
        String[] myStrings = new String[listLength];

        // Converting all items in collection to an Array of Strings
        int index = 0;
        for (var i : items) {
            myStrings[index] = i.toString();
            index++;
        }

        // Building String
        int listIndexEnd = listLength - 1;
        for (int i=0; i <= listIndexEnd ;i++){
            // Accessing string in list
            String currentItem = myStrings[i];

            // Append string
            strBuilder.append(currentItem);
        }

        return strBuilder.toString();
    }
}
