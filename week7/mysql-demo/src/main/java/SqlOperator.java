import java.sql.*;
import java.util.List;

public class SqlOperator {
    public static void insert(Connection conn, String sql) {
        Statement statement = null;
        try {
            System.out.println(" 实例化Statement对象...");
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void insertBatchV1(Connection conn, String tabname, List<Tuple.ThreeTuple<String, String, String>> datas) {
        Statement statement = null;
        try {
            System.out.println(" 实例化Statement对象...");
            statement = conn.createStatement();
            for (Tuple.ThreeTuple<String, String, String> tuple: datas) {
                String sql = String.format("replace into %s(userid, username, registertime) values('%s','%s','%s')", tabname, tuple.first, tuple.second, tuple.third);
                statement.executeUpdate(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void insertBatchV2(Connection conn, String tabname, List<Tuple.ThreeTuple<String, String, String>> datas) {
        PreparedStatement statement = null;
        try {
            System.out.println(" 实例化PreparedStatement对象...");
            statement = conn.prepareStatement(String.format("replace into %s(userid, username, registertime) values(?,?,?)", tabname));
            for (Tuple.ThreeTuple<String, String, String> tuple: datas) {
                statement.setString(1, tuple.first);
                statement.setString(2, tuple.second);
                statement.setString(3, tuple.third);
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void insertBatch3(Connection conn, String tabname, List<Tuple.ThreeTuple<String, String, String>> datas) {
        PreparedStatement statement = null;
        try {
            conn.setAutoCommit(false);
            System.out.println(" 实例化PreparedStatement对象...");
            statement = conn.prepareStatement(String.format("replace into %s(userid, username, registertime) values(?,?,?)", tabname));
            for (Tuple.ThreeTuple<String, String, String> tuple: datas) {
                statement.setString(1, tuple.first);
                statement.setString(2, tuple.second);
                statement.setString(3, tuple.third);
                statement.addBatch();
            }
            statement.executeBatch();
            conn.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static ResultSet query(Statement statement, String sql) {
        try {
            ResultSet rs = statement.executeQuery(sql);
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
