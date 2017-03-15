import java.util.ArrayList;

import org.junit.runner.*;
import org.junit.runner.notification.*;
public class CS1632D3WebTestRunner {
	public static void main(String[] args) {

		ArrayList<Class> classesToTest = new ArrayList<Class>();
		ArrayList<Failure> failures = new ArrayList<Failure>();

		//Add test classes
		
		classesToTest.add(WelcomePageTests.class);
		classesToTest.add(FactorialPageTests.class);
		classesToTest.add(FibPageTests.class);
		classesToTest.add(HelloPageTests.class);
		classesToTest.add(CathyPageTests.class);
		
		// For all test classes added, loop through and use JUnit
		// to run them.
		
		for (Class c: classesToTest) {
		    Result r = JUnitCore.runClasses(c);

		    // Gather failures for this class.
		    for (Failure f : r.getFailures()) {
		    	failures.add(f);
		    }
		}
		
		// After completion, print the result.
		
		if (failures.size() != 0) {
		    System.out.println(failures.size() + " tests failed. Check below for details.");
		    for (Failure f : failures) {
		    	System.out.println(f.toString());
		    }
		} else {
		    System.out.println("\nALL TESTS PASSED");
		} 
	}
}
