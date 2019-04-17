package JV2_Session1112;

import java.sql.*;
public class Main {
    public static void main(String[] args) {
        try {
            // Bước 2: Thong bao driver nào muốn sử dụng
            Class.forName("com.mysql.jdbc.Driver");

            //Bước 3: Tạo kết nối
            String URL = "jdbc:mysql://localhost:3306/T1808M";
            Connection conn = DriverManager.getConnection(URL,"nguyenthao","minhquan1525");

            //Bước 4: Thực thi truy vấn
            Statement statement = conn.createStatement();

            // Xóa 1 sinh viên bằng ID
            String delete_sql = "DELETE FROM student WHERE ID=13";
            statement.executeUpdate (delete_sql);

            // Chỉnh sửa thông tin sinh viên bằng ID
            String set_sql = "UPDATE student SET Name='Minh Bu', Age= 23, Mark=80 WHERE ID=3";
            statement.executeUpdate(set_sql);

            // Thêm 1 sinh viên
//            String insert_sql = "INSERT INTO student (name,age,mark) VALUES('PewPew',20,50)";
//            statement.executeUpdate(insert_sql);

            String sql = "SELECT * FROM student";
            ResultSet rs = statement.executeQuery(sql);


            while (rs.next()){
                System.out.println("ID: "+rs.getString("id"));
                System.out.println("Name: "+rs.getString("name"));
                System.out.println("Age: "+rs.getString("age"));
                System.out.println("Mark: "+rs.getString("mark"));
            }

        }catch (Exception e){}
    }
}
