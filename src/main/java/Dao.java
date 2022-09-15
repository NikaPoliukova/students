import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Dao {
    private static final String SELECT_All_STUDENTS = "SELECT id_student, name_student, surname," +
            "student_group,age FROM students";
    private static final String SELECT_All_STUDENTS_WITH_CITY =
            "SELECT * FROM students join cities ON students.id_city=cities.id_city";
    private static final String DELETE_STUDENT = "delete from students where id_student = ?";
    private final static String ADD_STUDENT = "INSERT INTO students (name_student," +
            " surname, student_group, age, id_city )" +
            "VALUES( ?, ?, ?, ?, ?)";
    private final static String GET_CITY = "SELECT id_city FROM cities where name_city=?";
    //private final static String CHECK_STUDENT = "SELECT EXISTS(SELECT id_student FROM students WHERE id_student=?)";
    private final static String ADD_CITY = "INSERT cities (name_city) VALUES(?)";
    private final static String DELETE_CITY = "DELETE FROM cities WHERE name_city =?";


    public List<Student> showAllStudents(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery
                (SELECT_All_STUDENTS);
        List<Student> studentList = new ArrayList<>();
        Student student;
        while (rs.next()) {
            student = new Student();
            student.setNameStudent(rs.getString("name_student"));
            student.setSurname(rs.getString("surname"));
            student.setAge(rs.getInt("age"));
            student.setGroup(rs.getInt("student_group"));
            student.setIdStudent(rs.getInt("id_student"));
            studentList.add(student);
        }
        return studentList;
    }

    public List<Student> showAllStudentsWithCity(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery
                (SELECT_All_STUDENTS_WITH_CITY);
        List<Student> studentList = new ArrayList<>();
        Student student;
        while (rs.next()) {
            student = new Student();
            student.setNameStudent(rs.getString("name_student"));
            student.setSurname(rs.getString("surname"));
            student.setAge(rs.getInt("age"));
            student.setGroup(rs.getInt("student_group"));
            student.setIdStudent(rs.getInt("id_student"));
            student.setNameCity(rs.getString("name_city"));
            studentList.add(student);
        }
        return studentList;
    }

    public boolean addStudent(Connection conn, StudentDTO student) {
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_STUDENT);
            ps.setString(1, student.getNameStudent());
            ps.setString(2, student.getSurname());
            ps.setInt(3, student.getGroup());
            ps.setInt(4, student.getAge());
            ps.setInt(5, student.getIdCity());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("не удалось добавить");
        }
        return true;
    }

    public Integer removeStudent(Connection conn, int id_student) {
        int result = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_STUDENT);
            ps.setInt(1, id_student);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Integer getIdCity(Connection connection, String cityName) {
        int idCity = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(GET_CITY);
            ps.setString(1, cityName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idCity = rs.getInt("id_city");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("город не найден");
        }
        return idCity;
    }

    public Integer addCity(Connection conn, String nameCity) throws SQLException {
        int result = getIdCity(conn, nameCity);
        if (result == 0) {
            PreparedStatement ps = conn.prepareStatement(ADD_CITY);
            ps.setString(1, nameCity);
            ps.executeUpdate();
            System.out.println("City is added");
        }
        if (result == 1) {
            System.out.println("This city already added");
        }
        return result;
    }

    public Integer removeCity(Connection conn, String name) {
        int  result=0;
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_CITY);
            ps.setString(1, name);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("город не удален");
        }
        return result;
    }
}