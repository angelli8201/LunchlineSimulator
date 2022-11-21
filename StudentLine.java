//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #1
//CSE 214 (R03)
//TA Kevin Cheng

/**
 * The StudentLine class implements an array of Student objects
 *
 *
 * @author Angel Li
 * Angel.Li@stonybrook.edu
 * 112784616
 */
public class StudentLine {
    private Student[] students;
    private int studentCount;
    final int CAPACITY = 20;

    /**
     * This is a constructor used to create a StudentLine object.
     * The object points to an array of 20 students. The zeroth index is null
     * so that first student is stored internally as index 1.
     */
    public StudentLine() {
        students = new Student[CAPACITY + 1];
        studentCount = 0;
        students[0] = null;
    }

    /**
     * The method gets the number of students on the lunch line
     *
     * @return
     *  The number of students on the lunch line
     */
    public int numStudents() {
        return studentCount;
    }

    /**
     * The method gets the reference to the student at the given index
     *
     * @param index
     *  Represents the position number on the lunch line
     * @return
     *  Gives the name and money amount of the student at the given index
     * @throws ArrayIndexOutOfBoundsException
     *  Exception if the index is invalid because of no student at that position
     */
    public Student getStudent(int index) throws ArrayIndexOutOfBoundsException {
        if(students[index] == null)
            throw new ArrayIndexOutOfBoundsException();
        return students[index];
    }

    /**
     * The method adds a student with the given parameters on the lunch line
     *
     * @param index
     *  Represents the position on the lunch line
     * @param student
     *  Represents a Student object with its own data members
     * @throws ArrayIndexOutOfBoundsException
     *  Exception if trying to add student to the lunch line at an index that
     *  would create a hole in the line
     * @throws DeanException
     *  Exception if trying to add student to a full lunch line
     */
    public void addStudent(int index, Student student) throws
            ArrayIndexOutOfBoundsException,DeanException {

        if (index> 1 && students[index - 1] == null && students[index] == null)
            throw new ArrayIndexOutOfBoundsException();

        if(index==21)
            throw new DeanException();
        if (students[index] == null) {
            students[index] = student;
            studentCount++;
            return;
        }
        Student[] s2 = new Student[CAPACITY + 1];
        s2[0] = null;
        for (int i = students.length - 1; i > 0; i--) {
            if (i > index)
                s2[i] = students[i-1];
            else if (i == index)
                s2[i] = student;
            else
                s2[i] = students[i];
        }
        students = s2;
        studentCount++;
        return;
    }

    /**
     * The method removes a student on the lunch line
     * @param index
     *  Represents the position on the lunch line
     * @return
     *  Gives the student that was removed on the lunch line
     * @throws ArrayIndexOutOfBoundsException
     *  Exception if trying to remove student at index where there isn't a
     *  student
     * @throws EmptyLineException
     *  Exception if trying to remove a student on an empty lunch line
     */
    public Student removeStudent(int index) throws
            ArrayIndexOutOfBoundsException,EmptyLineException{
        if(index>1) {
            if (students[index] == null || students[index - 1] == null)
                throw new ArrayIndexOutOfBoundsException();
        }
        if(students[1] == null)
            throw new EmptyLineException();
        Student studentx = students[index];
        Student[] temp = new Student[CAPACITY+1];
        temp[0]= null;
        for(int i = 1,j =1; i <= students.length - 1 ;i++) {
            if (i != index)
                temp[j++] = students[i];
        }
        students =  temp;
        studentCount--;
        return studentx;
    }

    /**
     * The method swaps the position on the lunch line of two Student objects
     *
     * @param index1
     *  Represents the position of the first student that is to be swapped
     * @param index2
     *  Represents the position of the second student that is to be swapped
     * @throws ArrayIndexOutOfBoundsException
     *  Exception if trying to swap the position of two students when at
     *  least one of the positions does not have a Student object
     */
    public void swapStudents(int index1, int index2) throws
            ArrayIndexOutOfBoundsException{
        if(students[index1]==null || students[index2]==null)
            throw new ArrayIndexOutOfBoundsException();
        Student temp = students[index1];
        students[index1] = students[index2];
        students[index2] = temp;
    }

    /**
     * The method creates a deep copy of a StudentLine object
     *
     * @return
     *  Returns a clone of the StudentLine object
     * @throws ArrayIndexOutOfBoundsException
     *  Exception when trying to clone an empty StudentLine object
     */
    public StudentLine clone() throws ArrayIndexOutOfBoundsException{
       StudentLine lineCopy = new StudentLine();
       for(int j=1;j<=studentCount;j++) {
           try {
               lineCopy.addStudent(j,new Student(students[j].getName(),
                       students[j].getMoney()));
           } catch (DeanException e) {
           }
       }
       return lineCopy;
    }

    /**
     * The method checks to see if two StudentLine objects are equal
     *
     * @param o
     *  Represents an object and used to compare with a StudentLine object
     * @return
     *  Returns true if the object is an instance of StudentLine and contains
     *  the same students (with the same name and balances)
     */
    public boolean equals(Object o) {
        boolean b = false;
        if (o instanceof StudentLine) {
            StudentLine line1 = (StudentLine) o;
            if(studentCount == line1.studentCount) {
                for (int i = 1; i <= studentCount; i++) {
                    if (students[i].getName() == line1.getStudent(i).getName() &&
                            students[i].getMoney() == line1.getStudent(i).getMoney())
                        b = true;
                    else
                        return false;
                }
            }
            return b;
        }
        return false;
    }

    /**
     * The method gives a printable representation of the StudentLine
     * @return
     *  Returns list of all the Student objects of the StudentLine object
     */
    public String toString(){
        String s = "";
        for (int i = 1; i <= studentCount; i++)
            System.out.format("%d.%10s%10.2f%n",i,students[i].getName(),
                    students[i].getMoney());

        return s;

    }

}







