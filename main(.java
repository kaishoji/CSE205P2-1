/*************************************************************************************************
* CLASS: ClassName (Main.java)
*
* DESCRIPTION
* A description of the contents of this file.
*
* COURSE AND PROJECT INFORMATION
* CSE205 Object Oriented Programming and Data Structures, Spring 2022 Session A
* Project Number: 2
*
* AUTHOR: Justin Fernandes, Asurite ID: 1223222572, jferna56@asu.edu
* AUTHOR: Kai Ohsawa, Asurite ID: 121643600, kaishoji.oh@gmail.com
* AUTHOR: Tony Wen, Asurite ID: 1222943787, tewen@asu.edu
******************************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
	/**
     * Instantiate a Main object and call run() on the object. Note that essentially now, run()
     * becomes the starting point of execution for the program.
     */
	public static void main(String[] args) throws FileNotFoundException
	{		
		Main mainObject = new Main();
		mainObject.run();
	}

    /**
     *  Calls other methods to implement the sw requirements.
     *
     * PSEUDOCODE
     * Declare ArrayList<Student> object named studentList and initialize it to null
     *
     * -- In the try-catch block we try to read the list of students from p2-students.txt
     * -- storing the students in the studentList list. If we cannot open the input file for
     * -- reading, then we output an error message and terminate the program.
     * try
     *     studentList = readFile()
     * catch (FileNotFoundException)
     *     Print "Sorry, could not open 'p2-students.txt' for reading. Stopping."
     *     Call System.exit(-1)
     * end try-catch
     *
     * -- Calculate the tuition for each Student in studentList
     * calcTuition(studentList)
     *
     * -- Sort the students in studentList into ascending order based on student identifier
     * -- Note that Sorter.insertionSort() is a static/class method so we do not have to instantiate
     * -- an object of the Sorter class, we just write class-name.static-method-name() to call a
     * -- static method in a class.
     * Call Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING) to sort the list
     *
     * -- In the try-catch block we try to write the list of students and their calculated tuitions
     * -- to p2-tuition.txt If we cannot open the output file for writing, then we output an error
     * -- message and terminate the program.
     * try
     *     writeFile(studentList)
     * catch (FileNotFoundException)
     *     Print "Sorry, could not open 'p2-tuition.txt' for writing. Stopping."
     *     Call System.exit(-1)
     * end try-catch
     */
    private void run() throws FileNotFoundException
    {
    	ArrayList<Student> studentList = new ArrayList<>();
    	
    	try
    	{
    		studentList = readFile("p2-students.txt");
    	}
    	catch (FileNotFoundException pException)//terminates the program if the file can not be found
		  {
			System.out.println("Sorry, could not open 'p2-students.txt' for reading. Stopping.");
			System.exit(-1);
		  }
    	
    	calcTuition(studentList);
    		    	    	
    	Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);
    	
    	try
		  {
			writeFile("p2-tuition.txt", studentList);
		  }
		  catch (FileNotFoundException pException)
		  {
			System.out.println("Sorry, could not open 'p2-tuition.txt' for writing. Stopping.");
			System.exit(-1);
		  }
    }

    /**
     * Calculates the tuition for each Student in pStudentList. Write an enhanced for loop that
     * iterates over each Student in pStudentList. For each Student, call calcTuition() on that
     * Student object. Note: this is a polymorphic method call. What does that mean?
     *
     * PSEUDOCODE
     * Enhanced ForEach student in pStudentList Do
     *     student.calcTuition()
     * End Enhanced ForEach
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
        for (Student student : pStudentList) {
            student.calcTuition();
        }
    }

    /**
     * Reads the student information from "p2-students.txt" and returns the list of students as
     * an ArrayList<Student> object. Note that this method throws FileNotFoundException if the
     * input file could not be opened. The exception is caught and handled in run().
     *
     * PSEUDOCODE
     * Declare and create an ArrayList<Student> object named studentList
     * Open "p2-students.txt" for reading using a Scanner object named in
     * While in.hasNext() returns true Do
     *     String studentType <= read next string from in
     *     If studentType is "C" Then
     *         studentList.add(readOnCampusStudent(in))
     *     Else
     *         studentList.add(readOnlineStudent(in))
     *     End If
     * End While
     * Close the scanner
     * Return studentList
     */
    private ArrayList<Student> readFile(String pFilename) throws FileNotFoundException
    {
    	ArrayList<Student> studentList = new ArrayList<>();
    	Scanner in = new Scanner(new File(pFilename));
    	while (in.hasNext())
    	{
    		String studentType;
    		if (studentType.equals("C"))
    		{
    			studentList.add(readOnCampusStudent(in));
    		}
    		else
    		{
    			studentList.add(readOnlineStudent(in));
    		}
    	}
    	in.close();
    	return studentList;
    }

    /**
     * Reads the information for an on-campus student from the input file.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
     * Declare String object named res and assign pIn.next() to res
     * Declare double variable named fee and assign pIn.nextDouble() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If res.equals("R") Then
     *    Call setResidency(OnCampusStudent.RESIDENT) on student
     * Else
     *    Call setResidency(OnCampusStudent.NON_RESIDENT) on student
     * End If
     * Call setProgramFee(fee) on student
     * Call setCredits(credits) on student
     * Return student
     * 
     */
    private  ArrayList<Student> readOnCampusStudent(Scanner pIn)
    {
    	String id = pIn.next();
    	String lname = pIn.next();
    	String fname = pIn.next();
    	//Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
    	String res = pIn.next();
    	double fee = pIn.nextDouble();
    	int credits = pIn.nextInt();
    	if (res.equals("R"))
    	{
    		Student.setResidency(onCampusStudent.RESIDENT);
    	}
    	else
    	{
    		Student.setResidency(onCampuStudent.NON_RESIDENT);
    	}
    	Student.setProgramFee(fee);
    	Student.setCredits(credits);    	
    }

    /**
     * Reads the information for an online student from the input file.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnlineStudent student. Pass id, fname, lname as params to the ctor.,
     * Declare String object named fee and assign pIn.next() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If fee.equals("T")) Then
     *     Call setTechFee(true) on student
     * Else
     *     Call setTechFee(false) on student
     * End If
     * Call setCredits(credits) on student
     * Return student
     */
    ???

    /**
     * Writes the output to "p2-tuition.txt" per the software requirements. Note that this method
     * throws FileNotFoundException if the output file could not be opened. The exception is caught
     * and handled in run().
     *
     * PSEUDOCODE
     * Declare and create a PrintWriter object named out, opening "p2-tuition.txt" for writing
     * Enhanced ForEach student in pStudentList Do
     *     Using out.printf() output the student information per SW Requiremment 3
     * End Enhanced ForEach
     * Close the output file
     */
    private void writeFile(String pFilename, ArrayList<Integer> pStudentList) throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter(new File(pFilename));
		for(String : pStudentList)
		{
			out.printf()
		}
		out.close();
	}


}