import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCBasicDemo {
    public static void main(String[] args) {
        // NOTE: Requires SQLite JDBC driver jar in the classpath
        String url = "jdbc:sqlite:students.db";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
             
            System.out.println("Connected to SQLite database!");
            
            // Create table
            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT)");
            
            // Insert dummy data (ignoring errors if exists)
            stmt.execute("INSERT OR IGNORE INTO students VALUES (1, 'Alice'), (2, 'Bob')");
            
            // SELECT
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("Students in DB:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " - Name: " + rs.getString("name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}