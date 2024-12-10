import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDealershipTest {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Before
    public void setUp() throws SQLException {
        conn = Mockito.mock(Connection.class);
        ps = Mockito.mock(PreparedStatement.class);
        rs = Mockito.mock(ResultSet.class);
    }

    @Test
    public void testAddModel() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        CarModel.addModel(conn, 1, 1, "ModelX", 1, 10000);
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testRemoveModel() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.getUpdateCount()).thenReturn(1);
        CarModel.removeModel(conn, 1);
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testGetLatestModel() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.executeQuery()).thenReturn(rs);
        Mockito.when(rs.isBeforeFirst()).thenReturn(true);
        Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getString(1)).thenReturn("BrandX");
        Mockito.when(rs.getInt(2)).thenReturn(1);
        Mockito.when(rs.getString(3)).thenReturn("ModelX");
        Mockito.when(rs.getInt(4)).thenReturn(1);
        Mockito.when(rs.getFloat(5)).thenReturn(10000f);

        ResultSet result = CarModel.getLatestModel(conn, 1);
        assertNotNull(result);
    }

    @Test
    public void testUpdateModel() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.getUpdateCount()).thenReturn(1);
        CarModel.updateModel(conn, 1, 2, 15000);
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testAddCar() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Car.addCar(conn, 1, 1, "VIN123", "Red", "2022-01-01");
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testRemoveCar() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.getUpdateCount()).thenReturn(1);
        Car.removeCar(conn, 1);
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testViewCarDetails() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.executeQuery()).thenReturn(rs);
        Mockito.when(rs.isBeforeFirst()).thenReturn(true);
        Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getString(1)).thenReturn("ModelX");
        Mockito.when(rs.getString(2)).thenReturn("VIN123");
        Mockito.when(rs.getInt(3)).thenReturn(1);
        Mockito.when(rs.getInt(5)).thenReturn(1);
        Mockito.when(rs.getString(6)).thenReturn("Red");

        ResultSet result = Car.viewCarDetails(conn, 1);
        assertNotNull(result);
    }

    @Test
    public void testChangeCarColour() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.getUpdateCount()).thenReturn(1);
        Car.changeCarColour(conn, 1, "Blue");
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testAddCustomer() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Customer.addCustomer(conn, 1, "John", "Doe", "john.doe@example.com", 1234567890L);
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testRemoveCustomer() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.getUpdateCount()).thenReturn(1);
        Customer.removeCustomer(conn, 1234567890L);
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testViewCustomerDetails() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.executeQuery()).thenReturn(rs);
        Mockito.when(rs.isBeforeFirst()).thenReturn(true);
        Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt(1)).thenReturn(1);
        Mockito.when(rs.getString(2)).thenReturn("John");
        Mockito.when(rs.getString(3)).thenReturn("Doe");
        Mockito.when(rs.getString(5)).thenReturn("john.doe@example.com");

        ResultSet result = Customer.viewCustomerDetails(conn, 1);
        assertNotNull(result);
    }

    @Test
    public void testUpdateCustomer() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.getUpdateCount()).thenReturn(1);
        Customer.updateCustomer(conn, 1234567890L, 9876543210L, "john.doe@example.com");
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testAddCustomerCar() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        CustomerCar.addCustomerCar(conn, 1, 1, 1, "2022-01-01", 20000);
        Mockito.verify(ps, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testViewCustomerCars() throws SQLException {
        Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(ps);
        Mockito.when(ps.executeQuery()).thenReturn(rs);
        Mockito.when(rs.isBeforeFirst()).thenReturn(true);
        Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getInt(1)).thenReturn(1);
        Mockito.when(rs.getString(2)).thenReturn("ModelX");
        Mockito.when(rs.getString(3)).thenReturn("VIN123");
        Mockito.when(rs.getInt(4)).thenReturn(1);
        Mockito.when(rs.getInt(5)).thenReturn(1);
        Mockito.when(rs.getString(6)).thenReturn("Red");
        Mockito.when(rs.getString(7)).thenReturn("2022-01-01");

        ResultSet result = CustomerCar.viewCustomerCars(conn, 1);
        assertNotNull(result);
    }
}