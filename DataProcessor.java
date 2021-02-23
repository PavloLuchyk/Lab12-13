package lab12;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;

public class DataProcessor {
		private Institute institute;
		
		public DataProcessor(String name) {
			institute = new Institute(name);
		}
	    
	   //Метод знаходження загального числа студентів
	   public int getTotalNumberOfStudents() throws NoFacultiesException{
		   HashSet<Faculty> faculties = institute.getFaculties();
	       if (faculties.isEmpty()){
	    	   throw new NoFacultiesException("There is no faculties");
	       }
	       int number = 0;
	       for (Faculty faculty: faculties){
	          number += faculty.getNumberOfStudents();
	       }
	       return number;
	   }
	   
	   //Метод знаходження факультету з найбільшим числом студентів
	   public Faculty getbiggestFaculty() throws NoFacultiesException{
		   HashSet<Faculty> faculties = institute.getFaculties();
	       if (faculties.isEmpty()){
	           throw new NoFacultiesException("There is no faculties");
	       }
	       Faculty max = new Faculty("Empty");
	       Faculty faculty;
	       for(Iterator<Faculty> i = faculties.iterator(); i.hasNext();){
	           faculty = i.next();
	           if (max.getNumberOfStudents() < faculty.getNumberOfStudents()){
	               max = faculty;
	           }
	       }
	       return max;
	   }
	   
	   //Метод знаходження студентів з найвищими балами
	   public TreeMap<String, Student> getStudentWithHighestMarks() throws NoFacultiesException{
		   HashSet<Faculty> faculties = institute.getFaculties();
	       if (faculties.isEmpty()){
	    	   throw new NoFacultiesException("There is no faculties");
	       }
	       TreeMap<String, Student> highMarks = new TreeMap<>();
	       for(Iterator i = faculties.iterator(); i.hasNext();){
	           Object obj = i.next();
	           if (obj instanceof Faculty){
	                Faculty faculty = (Faculty) obj;
	                TreeMap<String, Student> students = faculty.getStudents();
	                for (Iterator j = students.entrySet().iterator(); j.hasNext(); ){
	                    Object o = j.next();
	                    if (o instanceof Map.Entry) {
	                    	Map.Entry setObject = (Map.Entry)o;
	                    	if (setObject.getValue() instanceof Student){
	                    		Student student = (Student)setObject.getValue();
	                    		if (student.getAverageMark() >= 95 && student.getAverageMark() <= 100){
	                    			highMarks.put(student.getFirstName()+" "+student.getLastName(),student);
	                    		}
	                    	}
	                } 	
	                }
	           }
	       }
	       return highMarks;
	   }
	    
	   
	   //Метод тестового заповнення
	   public void testFill(){
		   try {
			   Faculty fict = new Faculty("FICT");
			   fict.addStudent(new Student("Ivan", "Ivanov", "IT-321", 90.1));
			   fict.addStudent(new Student("Petro", "Fedorenko", "IT-232", 95.9));
			   fict.addStudent(new Student("Ivan", "Oleksandrenko", "IT-21", 75));
			   fict.addStudent("Anastasiya", "Vasileva", "IL -001", 95.0);
			   fict.addStudent("Anna", "Makarenko", "UI-301", 100.0);
			   Faculty iasa = new Faculty("IASA");
			   iasa.addStudent(new Student("Valeriy", "Mensa", "KA-123", 96.7));
			   iasa.addStudent(new Student("Petro", "Melenko", "AK-901", 80.5));
			   iasa.addStudent(new Student("Vasyl", "Romanko", "PH-21", 75));
			   Faculty iat = new Faculty("IAT");
			   iat.addStudent(new Student("Serhiy", "Korolev", "RE-1", 100.0));
			   iat.addStudent(new Student("Volodymyr", "Lidovskiy", "Am-321", 95.91));
			   iat.addStudent(new Student("Ihor", "Molochar", "KE-3223", 60));
			   iat.addStudent(new Student("Oleksiy", "Dovbush", "AE-434", 86.1));	       
	    	   institute.addFaculty(fict);
	    	   institute.addFaculty(iasa);
	    	   institute.addFaculty(iat);
	       } catch(FacultyAlreadyInListException | StudentAlreadyInListException e) {
	    	   System.err.println("Exception! " + e.getMessage());
	       }
	   }

}
