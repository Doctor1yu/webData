import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseConnectionTest {

    @Test
    public void testDatabaseConnection() {
        // 数据库连接信息
        String url = "jdbc:mysql://47.76.54.29:3306/bishe";
        String username = "root";
        String password = "zyn20030527";

        // 尝试建立连接
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // 断言连接不为空
            assertNotNull(connection, "数据库连接失败");
            System.out.println("数据库连接成功！");
        } catch (SQLException e) {
            // 如果连接失败，抛出异常
            throw new RuntimeException("无法连接到数据库", e);
        }
    }
} 