

import java.sql.*;


public class Main {

    private static Dao dao = new Dao();
    private static Service service = new Service();
    public final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/students";
    public final static String CONNECTION_NAME = "root";
    public final static String CONNECTION_PASS = "nikucha666";

    public static void main(String[] args) {

        Driver driver;
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e1) {
            System.out.println("Драйвер не зарегистрировался");
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_URL,
                    CONNECTION_NAME, CONNECTION_PASS);
            //отображение всех студентов
            service.displayAllStudents(conn);
            //отображение всех студентов c с городами
            service.displayAllStudentsWithCity(conn);
            // добавление студента
            Student student = new Student("Oleg", "Artimena", 20, 7, "Любань");
            service.addStudentWithIdCity(conn, student);
            // удаление студента
            service.deleteStudent(conn, 2);
            //добавление города
            service.appendCity(conn, "Вилейка");
            // удаление города
            service.deleteCity(conn, "Ижевск");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}