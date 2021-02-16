package lab12;

import java.util.TreeMap;

class Faculty{
    private String name;
    private TreeMap<String, Student> students;
    
    public Faculty(String name){
        this.name = name;
        students = new TreeMap<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<String, Student> getStudents() {
        return students;
    }

    public void setStudents(TreeMap<String, Student> students) {
        this.students = students;
    }
    
    //Метод знаходження числа студетів на факультеті
    public int getNumberOfStudents(){
        return students.size();
    }
    
    //Методи додавання студента
    public void addStudent(Student student) throws StudentAlreadyInListException{
        if (student == null){
            throw new NullPointerException("Null value cannot be added");
        }
        String fullName = student.getFirstName() +" " + student.getLastName();
        if (students.containsKey(fullName)||students.containsValue(student)){
            throw new StudentAlreadyInListException("This student is already in the list");
        }
        students.put(fullName, student);
    }
    
    public void addStudent(String firstName, String lastName, String gradeBookId, double averageMark) throws StudentAlreadyInListException{
        Student student = new Student(firstName, lastName, gradeBookId, averageMark);
        addStudent(student);   
    }
    
    //Метод видалення студента
    public void removeStudent(String fullName) throws NoStudentsException{
        if (students.isEmpty()){
            throw new NoStudentsException("List of students of faculty: " + name + " is empty");
        }
        if (fullName == null){
            throw new NullPointerException("Null value cannot be removed");
        }
        students.remove(fullName);
    }
    
    @Override
    public String toString() {
        return "Name of the faculty: " + name + ". Number of students: " + getNumberOfStudents();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}    
}