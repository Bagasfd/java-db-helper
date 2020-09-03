import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DB
{
    // Connection
    private Connection conn = null;

    protected void MySQLConnect(String username, String password, String dbname) {
        try {
            String url = "jdbc:mysql://localhost:3306/" + dbname + "?user=" + username + "&password=" + password;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            this.conn = DriverManager.getConnection(url);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    protected void MySQLDisconnect() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected ResultSet get(String table)
    {
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + table);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected ResultSet get_where(String table, Map where)
    {
        String whereString = "";

        for (Object key : where.keySet())
        {
            whereString += key + "='"+ where.get(key) +"' AND ";
        }

        whereString = whereString.substring(0, whereString.length() - 5);

        try {
            Statement stmt = this.conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + table + " WHERE " + whereString);

            return result;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void insert(String table, Map data) {
        String fields = "";
        String insert = "";

        for(Object key : data.keySet())
        {
            fields += key + ",";
            insert += "'"+ data.get(key) +"',";
        }

        fields = fields.substring(0, fields.length() - 1);
        insert = insert.substring(0, insert.length() - 1);

        try {
            Statement stmt = this.conn.createStatement();

            stmt.executeUpdate("INSERT INTO " + table + "("+ fields +") VALUES("+ insert +")");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void update(String table, Map data, Map where)
    {
        String setString = "";
        String whereString = "";

        for(Object key : data.keySet())
        {
            setString += key + "='"+ data.get(key) +"',";
        }

        for(Object key : where.keySet())
        {
            whereString += key + "='"+ where.get(key) +"' AND ";
        }

        setString = setString.substring(0, setString.length() - 1);
        whereString = whereString.substring(0, whereString.length() - 5);

        try {
            Statement stmt = this.conn.createStatement();

            stmt.executeUpdate("UPDATE " + table + " SET " + setString + " WHERE " + whereString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    protected void delete(String table, Map where)
    {
        String whereString = "";

        for(Object key : where.keySet())
        {
            whereString += key + "='"+ where.get(key) +"' AND ";
        }

        whereString = whereString.substring(0, whereString.length() - 5);

        try {
            Statement stmt = this.conn.createStatement();

            stmt.executeUpdate("DELETE FROM " + table + " WHERE " + whereString);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}


