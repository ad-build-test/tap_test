import org.tap4j.consumer.TapConsumerFactory;
import org.tap4j.model.TestResult;
import org.tap4j.consumer.TapConsumer;
import org.tap4j.consumer.TapConsumerException;
import org.tap4j.util.StatusValues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.tap4j.model.TestSet;
import org.tap4j.util.StatusValues;

public class TapLogConsumer {

    public static void main(String[] args) {
        // Path to the existing TAP log file
        String filePath = "../test.log";  // Adjust to your file path

        // Read and parse the TAP log file
        try {
            File tapFile = new File(filePath);
            parseTapResult(tapFile);
        } catch (TapConsumerException e) {
            System.err.println("Error parsing the TAP log file: " + e.getMessage());
        }
    }

    // Method to parse and display the TAP results using TapConsumerFactory
    private static void parseTapResult(File tapOutput) throws TapConsumerException{
        TapConsumer consumer = TapConsumerFactory.makeTap13Consumer();
        
        // Parse the TAP output
        TestSet testSet = consumer.load(tapOutput);
        
        System.out.println( "Number of tests found: " + testSet.getNumberOfTestResults() );
        System.out.println( "Any failure? " + testSet.containsNotOk() );
        printTestSummary(testSet);
        // // Print details of each test
        // for (TestResult test : tests) {
        //     System.out.println("Test Name: " + test.getDescription());
        //     System.out.println("Test Result: " + (test.isOk() ? "Passed" : "Failed"));
            
        //     // If the test failed, print the error message (if present)
        //     if (!test.isOk()) {
        //         System.out.println("  Error Message: " + test.getFailureMessage());
        //     }
        // }
    }

    // Method to generate and print test summary
    private static void printTestSummary(TestSet testSet) {
        int totalTests = testSet.getNumberOfTestResults();  // Get total number of tests
        int passedTests = 0;

        // Iterate over the test results to count passed tests
        for (TestResult testResult : testSet.getTestResults()) {
            if (testResult.getStatus() == StatusValues.OK) {
                passedTests++;  // Increment for each passed test
            }
        }

        // Output the summary in the form "passed n of m tests"
        System.out.println("Test Summary: Passed " + passedTests + " of " + totalTests + " tests");
    }

}
