import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String userName = "root";
        String password = "alio";
        try {
            System.out.println("Connected");
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from student");
            int id;
            String name;
            String date;
            while (resultSet.next()) {
                id = resultSet.getInt("stId");
                name=resultSet.getString("stName").trim();
                date=resultSet.getString("stDate").trim();
                System.out.println("Id : " + id+" ,Name: "+name+" ,Date: "+date);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error has happen");
            e.printStackTrace();
        }
    }
}