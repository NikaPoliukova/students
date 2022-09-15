public class StudentDTO {
    private String nameStudent;
    private String surname;
    private int age;
    private int group;
    private int idStudent;
    private int idCity;

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

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public StudentDTO(String nameStudent, String surname, int age, int group, int idCity) {

        this.nameStudent = nameStudent;
        this.surname = surname;
        this.age = age;
        this.group = group;
        this.idCity = idCity;
    }

    public StudentDTO() {
    }
}
