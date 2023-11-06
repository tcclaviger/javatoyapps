package validator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class stores a String containing HTML text
 * and can report whether the HTML is valid or not.
 *
 * @author Josh Archer
 * @author Rob Smith
 * @version 1.1
 */
public class Validator {
    private String path;

    /**
     * Stores an HTML string to inspect.
     *
     * @param path the HTML string
     */
    public Validator(String path) {
        this.path = path;
    }

    /**
     * Reports whether the HTML string in the class
     * has valid HTML or not.
     *
     * @return true if the HTML is valid, or otherwise false
     */
    public boolean isValid() {
        ArrayList<String> singleTags = new ArrayList<>(List.of(
                "area", "base", "br", "col", "!doctype", "embed", "hr",
                "img", "input", "link", "meta", "param", "source", "track", "wbr"
        ));
        Queue<String> foundTags = new LinkedList<>();       //tag queue for regex use
        Stack<String> tagValidation = new Stack<>();        //stack for the tag matching use
        buildTagQueue(foundTags);                           //build the tag queue
        System.out.println("All Tags : " + foundTags);      //print out all identified tags

        Queue<String> filteredTags = new LinkedList<>();    //filter tags found by exclusion list
        for (String tag : foundTags) {
            if (!singleTags.contains(tag)) filteredTags.add(tag);
        }

        for (String tag : filteredTags) {
            String leadChar = String.valueOf(tag.charAt(0));//identify if the tag is a closing tag

            if (leadChar.equals("/") && tagValidation.size() == 0) {
                return false;
            } else if (leadChar.equals("/") && (!tagValidation.peek().equals(tag.substring(1)))) {
                return false;
            } else if (leadChar.equals("/")) {
                tagValidation.pop();
                System.out.println("Tag Stack:" + tagValidation);
            } else {
                tagValidation.push(tag);
                System.out.println("Tag Stack: " + tagValidation);
            }
        }
        return tagValidation.size() == 0;                   //return if the stack is empty or not as boolean
    }

    private void buildTagQueue(Queue<String> foundTags) {
        Path filePath = Paths.get(path);
        try {
            String contents = Files.readString(filePath);
            RegexHelpers.findTags(contents.toLowerCase(), foundTags);
        } catch (IOException ex) {
            System.out.println("Error reading from file " + ex.getMessage());
        }
    }
}
