 String url = "jdbc:mysql://localhost:3306/testdb";
        String userName = "root";
        String password = "alio";
        try (Connection connection = DriverManager.getConnection(url, userName, password);) {
            System.out.println("Connection Successful");
            String sql = "insert into person(ID,fName,lName,address,city) "
                    + "values(?,?);";

            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString((int)0,"hello prepare name");
            statement.setString(1,"hello prepare desc");
            int numOfRows = statement.executeUpdate(sql);
            System.out.println(numOfRows);

            String query="select * from person";
            ResultSet set=statement.executeQuery(query);
            while (set.next()){
                System.out.println(set.getInt("ID")+" "+set.getString("fName"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
