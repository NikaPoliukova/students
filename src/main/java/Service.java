import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Service {
    private static Dao dao = new Dao();

    public Student addStudentWithIdCity(Connection connection, Student student) throws SQLException {
        Dao dao = new Dao();
        int cityID = dao.getIdCity(connection, student.getNameCity());
        if (cityID == 0) {
            dao.addCity(connection, student.getNameCity());
            cityID = dao.getIdCity(connection, student.getNameCity());
        }
        StudentDTO studentDTO = student.toStudentDTO(cityID);
        boolean isAdded = dao.addStudent(connection, studentDTO);
        if (isAdded) {
            return student;
        }
        throw new RuntimeException("student not add");
    }

    public List<Student> displayAllStudents(Connection conn) throws SQLException {
        System.out.println(dao.showAllStudents(conn));
        return dao.showAllStudents(conn);
    }

    public List<Student> displayAllStudentsWithCity(Connection connection) throws SQLException {
        System.out.println(dao.showAllStudentsWithCity(connection));
        return dao.showAllStudentsWithCity(connection);
    }

    public void deleteStudent(Connection conn, int id_student) {
        if (dao.removeStudent(conn, id_student) == 0) {
            System.out.println("Student is not found");
        } else {
            System.out.println("Student delete");
        }
    }

    public void appendCity(Connection conn, String nameCity) throws SQLException {
        if (dao.addCity(conn, nameCity) == 0) {
            System.out.println("City is added");
        } else {
            System.out.println("This city already added");
        }
    }
    public void deleteCity(Connection conn,  String name){
        if (dao.removeCity(conn, name) == 0) {
            System.out.println("City is not found");
        } else {
            System.out.println("City delete");
        }
    }
}

