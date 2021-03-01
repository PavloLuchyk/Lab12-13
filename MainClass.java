package lab12;

public class MainClass {
	
	public static void main(String[] args) {
		DataProcessor kpi = new DataProcessor("NTUU KPI");
		printResults(kpi);
        kpi.testFill();
        printResults(kpi);
    }
    
    //Метод виводу результатів
    public static void printResults(DataProcessor institute){
        try{
            System.out.println("Task 1.Total number of students: " + institute.getTotalNumberOfStudents());
            System.out.println("Task 2.Faculty with the biggest number of students : " + institute.getbiggestFaculty());
            System.out.println("Task 3.List of student with the highest marks: " + institute.getStudentWithHighestMarks());
        } catch(NullPointerException | IllegalArgumentException | NoFacultiesException e){
            System.err.println("Exception! "+ e.getMessage());
        }
    }

    //Метод для демострації виняткових ситуацій
    public static void exceptionCheck(){
        try{
        	Faculty faculty = new Faculty("Faculty");
        	faculty.removeStudent("Ivan Ivanov");
        } catch(NoStudentsException e){
            System.err.println("Exception! "+ e.getMessage());
        }
        
        try {
        	Faculty faculty = new Faculty("AAA");
        	faculty.addStudent("Ivan", "Ivanov", "PR-213" , 95.6);
        	faculty.addStudent("Ivan", "Ivanov", "PR-213" , 95.6);
        } catch(StudentAlreadyInListException e) {
        	 System.err.println("Exception! "+ e.getMessage());
        }
        try {
        	Institute institute = new Institute("Institute");
        	institute.removeFaculty(new Faculty("AAA"));
        } catch (NoFacultiesException e) {
        	System.err.println("Exception! "+ e.getMessage());
        }
        try {
        	Institute institute = new Institute("Institute");
        	institute.addFaculty(new Faculty("AAA"));
        	institute.addFaculty(new Faculty("AAA"));
        } catch (FacultyAlreadyInListException e) {
        	System.err.println("Exception! "+ e.getMessage());
        }
    }

}
