package lab12;

import java.util.HashSet;

class Institute{
    private String name;
    private HashSet<Faculty> faculties;
    
    public Institute(String name){
        this.name = name;
        this.faculties = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Faculty> getFaculties() {
        return faculties;
    }
    
    //Метод додавання факультету
    public void addFaculty(Faculty faculty) throws FacultyAlreadyInListException{
        if (faculty == null){
            throw new NullPointerException("Faculty cannot be null!");
        }
        if (faculties.contains(faculty)){
            throw new FacultyAlreadyInListException("This faculty already exists!");
        }
        faculties.add(faculty);
    }
    
    //Метод видалення факультету
    public void removeFaculty(Faculty faculty) throws NoFacultiesException{
        if (faculty == null){
            throw new NullPointerException("Null value cannot be removed");
        }
        if (faculties.isEmpty()) {
        	throw new NoFacultiesException("There is no faculties");
        }
        faculties.remove(faculty);
    }
    
    @Override
   public String toString(){
        return "Name ot the institute: " + name + ". List of the faculties: " + faculties;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faculties == null) ? 0 : faculties.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Institute other = (Institute) obj;
		if (faculties == null) {
			if (other.faculties != null)
				return false;
		} else if (!faculties.equals(other.faculties))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}