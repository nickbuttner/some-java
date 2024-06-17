package test;

import static org.mockito.Mockito.*;

import dao.DatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDatabaseConnectionMock {

    private DatabaseConnection dbConnection;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;

    @BeforeEach
    public void setUp() throws SQLException, ClassNotFoundException {
        // Mock the necessary classes
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);

        // Setup the DatabaseConnection instance with mocked environment variables
        dbConnection = spy(new DatabaseConnection() {
            @Override
            public void connect(String query, Object... params) {
                try {
                    Class.forName(driver);
                    // Use the mocked connection instead of the real one
                    when(DriverManager.getConnection(url, username, password)).thenReturn(mockConnection);
                    when(mockConnection.prepareStatement(query)).thenReturn(mockPreparedStatement);
                    
                    for (int i = 0; i < params.length; i++) {
                        mockPreparedStatement.setObject(i + 1, params[i]);
                    }

                    mockPreparedStatement.execute();
                    mockConnection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public ResultSet consult(String query) {
                try {
                    Class.forName(driver);
                    when(DriverManager.getConnection(url, username, password)).thenReturn(mockConnection);
                    when(mockConnection.prepareStatement(query)).thenReturn(mockPreparedStatement);
                    return mockPreparedStatement.executeQuery();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    @Test
    public void testConnect() throws SQLException {
        // Arrange
        String query = "INSERT INTO products (name, price) VALUES (?, ?)";

        // Act
        dbConnection.connect(query, "Test Product", 10.0);

        // Assert
        verify(mockPreparedStatement, times(1)).execute();
        verify(mockConnection, times(1)).close();
    }
}
