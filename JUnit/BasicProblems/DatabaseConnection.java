package JUnit.BasicProblems;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }
}

public class DatabaseConnectionTest {
    private DatabaseConnection connection;

    @BeforeEach
    public void setUp() {
        connection = new DatabaseConnection();
        connection.connect();
    }

    @AfterEach
    public void tearDown() {
        connection.disconnect();
    }

    @Test
    public void testConnectionEstablished() {
        assertTrue(connection.isConnected());
    }

    @Test
    public void testConnectionClosed() {
        connection.disconnect();
        assertFalse(connection.isConnected());
    }

    @Test
    public void testAnotherConnectionTest(){
        assertTrue(connection.isConnected());
    }
}