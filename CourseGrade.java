/**********************************************************************
 * @file CourseGrade.java
 * @brief This is a program about course grade
 * @author Alantis Green
 * @date: 1/29/2023
 * @acknowledgement: Just me
 **********************************************************************
 */
import java.io.*;

public class CourseGrade {
    public static void main(String[] args) throws IOException {
        // creating a variable for the student grade which located in the index's 234
        int MidTerm1;
        int MidTerm2;
        int FinalScore;
        int Students = 0;
        double averages;
        double midTermTotal = 0;
        double midTermTotal2 = 0;
        double FinalTotal = 0;
        double average;
        String letterGrade;
        String line = "";
        String s = null;
        /// use a buffered reader becuase it's quicker
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alant\\Downloads\\StudentInfo (2).tsv"));
        // using a file writer to output the console into a new file
        FileWriter writer = new FileWriter("StudentInfo22.txt");

        // creating a while loop to loop throught the entire file
        while ((line = br.readLine()) != null) {
            String[] Values = line.split("\t");
            MidTerm1 = Integer.parseInt(Values[2]);
            MidTerm2 = Integer.parseInt(Values[3]);
            FinalScore = Integer.parseInt(Values[4]);
            // caulate the midterm total with final score for the student
            midTermTotal += MidTerm1;
            midTermTotal2 += MidTerm2;
            FinalTotal += FinalScore;
            Students += 1;
            average = MidTerm1 + MidTerm2 + FinalScore;
            average /= 3;

            // create conditional statements for the letter grade
            if (average >= 90) letterGrade = "A";

            else if (average >= 80) letterGrade = "B";

            else if (average >= 70) letterGrade = "C";

            else if (average >= 60) letterGrade = "D";

            else letterGrade = "F";

            // using the string format to output the data in the required order
            writer.write(String.format("%s\t%s\t%d\t%d\t%d\t%s\r\n", Values[0], Values[1], MidTerm1, MidTerm2, FinalScore, letterGrade));
            writer.write(String.format("\r\nAverages: Midterm1 %.2f, Midterm2 %.2f, Final %.2f\n", midTermTotal / Students, midTermTotal2 / Students, FinalTotal / Students));


        }
        // don't forget to close the writer and reader/.
        br.close();
        writer.close();

    }
}