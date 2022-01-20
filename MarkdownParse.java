// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;


public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        
        // verify that the open-close pattern is appropriate

        //Test2-file.md
        //We are correctly reading opening bracket
        //We then read the closing bracket but that takes us to the very end 
        //Then we look for an open paren but there are no more open paren
        //This results in an infinite loop (which is the error we are gett)

        Stack<String> parenParity = new Stack<>();
        //if we find an open bracket/parenthesis push into stack
        //if we find a closing bracket/parenthesis and the top of the stack is 
        /*
        .apng
        .avif
        .gif
        .jpg, .jpeg, .jfif, .pjpeg, .pjp
        .png
        .svg
        .webp
        */

        /*
        String myStr = "Hello";
        System.out.println(myStr.contains("Hel"));   // true
        System.out.println(myStr.contains("e"));     // true
        System.out.println(myStr.contains("Hi"));    // false
        */  
        
        String[] imageExtensions = { ".jpg", ".png", ".jpeg", ".raw", ".jfif", ".pjpeg", ".pjp", ".avif", ".gif", ".svg", ".webp" };

        int currentIndex = 0;
        int nextOpenBracket = 0;
        int nextCloseBracket = markdown.indexOf("]");
        int openParen = markdown.indexOf("(");
        int closeParen = 0;
        
        while(currentIndex < markdown.length()) {
            if (nextCloseBracket > openParen) break;
            nextOpenBracket = markdown.indexOf("[", currentIndex);
            nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            openParen = markdown.indexOf("(", nextCloseBracket);
            closeParen = markdown.indexOf(")", openParen);
            if (nextOpenBracket == -1 || nextCloseBracket == -1 || openParen == -1 || closeParen == -1) break;
            
            //run for loop and .contains on the substring?
            boolean check = false;
            for ( String s : imageExtensions ){
                if (markdown.substring(openParen+1, closeParen).contains(s)){
                    check = true;
                    break;  
                } 
            }

            if (check == false) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}