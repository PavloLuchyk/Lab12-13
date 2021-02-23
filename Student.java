package lab12;

class Student implements Comparable<Student>{
    
    private String firstName;
    private String lastName;
    private String gradebookId;
    private double averageMark;
     
    public Student(String firstName, String lastName, String gradebookId, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradebookId = gradebookId;
        this.averageMark = averageMark;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGradebookId() {
        return gradebookId;
    }

    public double getAverageMark() {
        return averageMark;
    }
    
    public void setAverageMark(double averageMark) {
    	this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return " gradebook's Id: " + gradebookId + ", average mark= " + averageMark + "\n";
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hashCode(gradebookId);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gradebookId == null) ? 0 : gradebookId.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Student other = (Student) obj;
		if (Double.doubleToLongBits(averageMark) != Double.doubleToLongBits(other.averageMark))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gradebookId == null) {
			if (other.gradebookId != null)
				return false;
		} else if (!gradebookId.equals(other.gradebookId))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


	@Override
	public int compareTo(Student o) {
		int result = firstName.compareToIgnoreCase(o.getFirstName());
		if (result!=0) {
			return result;
		} else {
			return lastName.compareToIgnoreCase(o.getLastName());
		}
	}    
}