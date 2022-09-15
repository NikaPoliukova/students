public class Student {
    private String nameStudent;
    private String surname;
    private int age;
    private int group;
    private int idStudent;
    private String nameCity;

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public Student(String nameStudent, String surname, int age, int group, String nameCity) {
        this.nameStudent = nameStudent;
        this.surname = surname;
        this.age = age;
        this.group = group;
        this.nameCity = nameCity;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name= " + nameStudent + "\n" +
                "surname= '" + surname + "\n" +
                "age= " + age + "\n" +
                "group= " + group + "\n" +
                "id_student= " + idStudent + "\n" +
                "city ='" + nameCity + '}' + "\n";
    }

    public StudentDTO toStudentDTO(int cityID) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setNameStudent(this.getNameStudent());
        studentDTO.setSurname(this.getSurname());
        studentDTO.setGroup(this.getGroup());
        studentDTO.setAge(this.getAge());
        studentDTO.setIdCity(cityID);
        return studentDTO;
    }
}
