package test;

import jframe.Admin;
import jframe.DBConnection;
import jframe.DatabaseAdmin;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({DBConnection.class, DriverManager.class})
public class DatabaseAdminTest {

    @InjectMocks
    private DatabaseAdmin admin = new DatabaseAdmin();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registedAdminGotResult() throws SQLException {
        Statement statement = mock(Statement.class);
        Connection connection = mock(Connection.class);
        ResultSet rs = mock(ResultSet.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(anyInt())).thenReturn(1);
        admin.setConnection(connection);
        assertTrue(admin.registedAdmin("EMAIL"));
    }

    @Test
    public void registedAdminFalseBD() throws SQLException {
        Statement statement = mock(Statement.class);
        Connection connection = mock(Connection.class);
        ResultSet rs = mock(ResultSet.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(anyInt())).thenReturn(1);
        admin.setConnection(connection);
        assertTrue(admin.registedAdmin("EMAIL"));
    }

    @Test
    void newAdminOK() throws SQLException {
        Statement statement = mock(Statement.class);
        Connection connection = mock(Connection.class);
        ResultSet rs = mock(ResultSet.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeUpdate(anyString())).thenReturn(1);
        when(rs.next()).thenReturn(false);
        admin.setConnection(connection);
        assertTrue(admin.newAdmin(getAdminOk()));
    }

    @Test
    void newAdminFalse() throws SQLException {
        Statement statement = mock(Statement.class);
        Connection connection = mock(Connection.class);
        ResultSet rs = mock(ResultSet.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeUpdate(anyString())).thenReturn(0);
        when(rs.next()).thenReturn(false);
        admin.setConnection(connection);
        assertTrue(!admin.newAdmin(getAdminOk()));
    }

    private Admin getAdminOk() {
        Admin admin = new Admin();
        admin.setPassword("123");
        admin.setEmail("123");
        admin.setName("123");
        admin.setPhoneNumber(123);
        return admin;
    }

    @Test
    void checkLoginOk() throws SQLException {
        Statement statement = mock(Statement.class);
        Connection connection = mock(Connection.class);
        ResultSet rs = mock(ResultSet.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(anyInt())).thenReturn(1);
        admin.setConnection(connection);
        assertTrue(admin.checkLogin("EMAIL", "PASSWORD"));
    }

    @Test
    void checkLoginError() throws SQLException {
        Statement statement = mock(Statement.class);
        Connection connection = mock(Connection.class);
        ResultSet rs = mock(ResultSet.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(anyInt())).thenReturn(0);
        admin.setConnection(connection);
        assertTrue(!admin.checkLogin("EMAIL", "PASSWORD"));
    }
}