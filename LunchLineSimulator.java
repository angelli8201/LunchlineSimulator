//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #1
//CSE 214 (R03)
//TA Kevin Cheng

import java.util.Scanner;

/**
 * The LunchLineSimulator class creates two instances of the StudentLine
 * object and provides an interface for a user to manipulate the list
 *
 *
 * @author Angel Li
 * Angel.Li@stonybrook.edu
 * 112784616
 */
public class LunchLineSimulator {
    private static StudentLine realityA;
    private static StudentLine realityB;
    private static int counter;

    public static void main(String[] args){
        StudentLine line1 = new StudentLine();
        StudentLine line2 = new StudentLine();
        Scanner input = new Scanner(System.in);
        String selection;
        System.out.println("Welcome to the Middle School where you are the " +
                "master of the lunch line, You are "+
                "in Reality A.\n");

        do {
            System.out.println("A) Add a student to the line at the end \n" +
                    "C) Have a new student cut a friend\n" +
                    "T) Have two students trade places\n" +
                    "B) Have the bully remove a student\n" +
                    "U) Update a student's money amount\n" +
                    "S) Serve a student\n" +
                    "P) Print the current reality's lunch line\n" +
                    "O) Switch to the other reality\n" +
                    "E) Check if the realities are equal\n" +
                    "D) Duplicate this reality into the other reality\n" +
                    "Q) Quit middle school and move on to real life.");
            System.out.print("Pick an option: ");
            selection = input.next();

            switch (selection) {
                case "A":
                case "a":
                    try {
                        System.out.println("Please enter student name: ");
                        String s = input.next();
                        System.out.println("Please enter student amount: ");
                        double d = input.nextDouble();
                        Student s1 = new Student(s, d);
                        line1.addStudent(line1.numStudents() + 1, s1);
                        System.out.println(s1.getName() + " has been added to the" +
                                " " + "line in position " +
                                line1.numStudents() + ". " + s1.getName() + " has $" + s1.getMoney());
                        System.out.println("");
                    }catch(DeanException ex1){
                        System.out.println("You tried to add a student to a " +
                                "full line. Dean Mean has picked up the " +
                                "student and given them a healthy dose of " +
                                "detention.");
                    }
                    break;

                 case "C":
                 case "c":
                     try {
                         System.out.println("Please enter student name: ");
                         String str = input.next();
                         System.out.println("Please enter student amount: ");
                         double a = input.nextDouble();
                         System.out.println("Please enter position: ");
                         Student s2 = new Student(str, a);
                         int i = input.nextInt();
                         if(line1.getStudent(i) == null)
                             throw new ArrayIndexOutOfBoundsException();
                         line1.addStudent(i, s2);
                         System.out.println(s2.getName() + " has cut " +
                                 line1.getStudent(i + 1).getName() +
                                 " and is now in position " + i + "." + s2.getName() + " has "
                                 + "$" +s2.getMoney());
                         System.out.println("");
                     }catch(ArrayIndexOutOfBoundsException ex){
                         System.out.println("You tried cutting a student that" +
                                 " does not exist. The line was not updated.");
                     }catch(DeanException ex1){
                         System.out.println("Dean");
                     }

                     break;

                case "T":
                case "t":
                    try {
                        System.out.println("Please enter student1 index: ");
                        int index1 = input.nextInt();
                        System.out.println("Please enter student2 index: ");
                        int index2 = input.nextInt();
                        line1.swapStudents(index1, index2);
                        System.out.println(line1.getStudent(index1).getName() +
                                " has " +
                                " traded " +
                                "places with " + line1.getStudent(index2).getName());
                    }catch(Exception ex3){
                        System.out.println("At least one of the students does" +
                                " not exist. The line was not updated.");
                    }
                    break;

                case "P":
                case "p":
                    System.out.println(line1.toString());
                    break;

                case "B":
                case "b":
                    try {
                        System.out.println("Please enter student index: ");
                        int r = input.nextInt();
                        String name = line1.getStudent(r).getName();
                        line1.removeStudent(r);
                        System.out.println("The bully has stolen " + name + "'s " +
                                "money, and " + name + " has left, feeling hangry.");
                        System.out.println("");
                    }catch(ArrayIndexOutOfBoundsException ex1 ){
                        System.out.println("You tried bullying a student that" +
                                " does not exist. The line was not updated");
                    }catch(EmptyLineException ex){
                        System.out.println("There are no students on the " +
                                "lunch line.");
                    }

                    break;

                case "U":
                case "u":
                    try {
                        System.out.println("Please enter student index: ");
                        int ind = input.nextInt();
                        System.out.println("Please enter new money amount: ");
                        double mon = input.nextDouble();
                        line1.getStudent(ind).setMoney(mon);
                        System.out.println("As a result of a shady transaction " +
                                "with the floor " + line1.getStudent(ind).getName() +
                                " now has $" + line1.getStudent(ind).getMoney());
                        System.out.println("");
                    }catch(ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Student does not exist. Nothing " +
                                "has been updated.");
                    }catch(NegativeAmount ex){
                        System.out.println("You can't have debt in middle " +
                                "school. The lunch line was not updated.");
                    }
                    break;

                case "S":
                case "s":
                    try {
                        String name1 = line1.getStudent(1).getName();
                        line1.removeStudent(1);
                        System.out.println(name1 + " has been served today's" +
                                " special: Bouncy \"Chicken Nuggets\". We hope " + name1
                                + " lives to see another day!");

                        System.out.println("");
                    }catch(EmptyLineException ex1) {
                        System.out.println("There are no students on the " +
                                "lunch line.");
                    }catch(ArrayIndexOutOfBoundsException ex2){
                        System.out.println("There are no students on the " +
                                "lunch line.");
                    }
                    break;

                case "O":
                case "o":
                    StudentLine temp = line2.clone();
                    line2 = line1;
                    line1 = temp;
                    counter ++;
                    if(counter % 2 != 0) {
                        System.out.println("You are in Reality B.");
                    }
                    else {
                        System.out.println("You are in Reality A");
                    }
                    break;

                case "E":
                case "e":

                    String strx = (line1.equals(line2)? "equal": "not equal");
                    System.out.println("The realities are " + strx +".");
                break;

                case "D":
                case "d":
                    String x = (counter % 2 != 0? "Reality B":"Reality A");
                    String y = (counter % 2 == 0? "Reality B":"Reality A");
                    line2 = line1.clone();
                    System.out.println(x + " has been copied into "+ y);

                    break;

                case "Q":
                case "q":
                    System.out.println("You are now leaving the Middle School Lunch Line " +
                            "Simulator. We congratulate you on your decision to do " +
                            "something more productive with your time.");
                    break;

            default:
                System.out.println("");
                System.out.println(selection +" is not a menu option. " +
                        "Please try again:");
                System.out.println("");
            }

        }while(!selection.equalsIgnoreCase("Q"));

    }
}
