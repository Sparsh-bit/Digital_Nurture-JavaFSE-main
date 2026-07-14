import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TransactionHandling {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance REAL)");
            stmt.execute("INSERT OR IGNORE INTO accounts VALUES (1, 1000.0), (2, 500.0)");
            
            System.out.println("Starting transfer...");
            
            // Turn off auto-commit
            conn.setAutoCommit(false);
            
            String updateSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                
                // Debit account 1
                pstmt.setDouble(1, -200.0);
                pstmt.setInt(2, 1);
                pstmt.executeUpdate();
                
                // Credit account 2
                pstmt.setDouble(1, 200.0);
                pstmt.setInt(2, 2);
                pstmt.executeUpdate();
                
                // Deliberate error simulation can go here
                
                // Commit if everything succeeds
                conn.commit();
                System.out.println("Transfer successful! Changes committed.");
                
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Transaction failed! Rolled back changes.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}