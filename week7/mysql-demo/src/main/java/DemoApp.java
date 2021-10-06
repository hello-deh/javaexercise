import org.springframework.jdbc.object.SqlCall;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class DemoApp {
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/demo_ds_0";

    static final String USER = "root";
    static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Connection conn = null;
        try {
//            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

//            int insertNum = 100;
//            List<Tuple.ThreeTuple<String, String, String>> dataset = new ArrayList<>(insertNum);
//            for (int i = 0; i < insertNum; ++i) {
//                String dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
//                Tuple.ThreeTuple<String, String, String> tuple = new Tuple.ThreeTuple<>(String.valueOf(i), "xiaoyaozi#"+i, dt);
//                dataset.add(tuple);
//            }
//
//            long startime = System.currentTimeMillis();
//            SqlOperator.insertBatch3(conn, "userinfo", dataset);
//            System.out.format("time cost of v3 insert %d\n", (System.currentTimeMillis() - startime) / 1000);
//
//            startime = System.currentTimeMillis();
//            SqlOperator.insertBatchV2(conn, "userinfo", dataset);
//            System.out.format("time cost of v2 insert %d\n", (System.currentTimeMillis() - startime) / 1000);
//
//            startime = System.currentTimeMillis();
//            SqlOperator.insertBatchV1(conn, "userinfo", dataset);
//            System.out.format("time cost of v1 insert %d\n", (System.currentTimeMillis() - startime) / 1000);



        } catch ( SQLException e) {
            e.printStackTrace();
        } finally {

            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");

    }
}
