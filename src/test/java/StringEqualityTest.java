import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class StringEqualityTest {

	@Test
	public void stringConstantsWillWork() {
		String foo = "a";
		String bar = "a";

		assertTrue(foo == bar);
	}

	@Test
	public void stringConstantAndStreamedDataWontWork() throws IOException {
		String foo = "a"; // foo and baz are string literals and java stores these in the string constant pool
		String baz = "a"; // this means that they both share the same address and == works for string value equality
		String bar = null; // this string is going to be stored outside of the constant pool, so the underlying memory
							// address is different and == will not work for string value equality

		InputStream is = this.getClass().getResourceAsStream("javainput.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(is);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		bar = bufferedReader.readLine();

		assertTrue(foo == baz);
		assertFalse(foo == bar);
		assertTrue(foo.equals(bar));
	}
}
