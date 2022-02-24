import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.nio.file.*;
import java.io.IOException;

public class MarkdownParseTest {

    List<String> strList;

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
        
    }

    @Test
    public void testSubtraction(){
    	assertEquals(0, 1-1);
    }

    @Test
    public void testGetLinks1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents= Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);
        assertEquals(this.strList, List.of("https://something.com", "some-page.html"));
    }

    @Test
    public void testGetLinks2() throws IOException {
        Path fileName = Path.of("test-file2.md");
	    String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(this.strList, List.of("https://something.com", "some-page.html"));
    }

    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

    @Test
    public void testGetLink4() throws IOException {
        Path fileName = Path.of("test-file4.md");
	    String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

    @Test
    public void testGetLink5() throws IOException {
        Path fileName = Path.of("test-file5.md");
	    String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

    @Test
    public void testGetLink6() throws IOException {
        Path fileName = Path.of("test-file6.md");
	    String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of("page.com"), this.strList );
    }

    @Test
    public void testGetLink7() throws IOException {
        Path fileName = Path.of("test-file7.md");
	    String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

    @Test
    public void testGetLink8() throws IOException {
        Path fileName = Path.of("test-file8.md");
	    String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

    @Test
    public void testGetLinks9() throws IOException {
        Path fileName = Path.of("test-file9.md");
        String contents= Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);
        assertEquals(List.of(), this.strList);
    }
}
