import java.sql.Driver;
import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "JDBC:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC" +
                "&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","server");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("Id persona: " + resultado.getInt("id_persona"));
                System.out.print(" Nombre:"+resultado.getString("nombre"));
                System.out.print(" Apellido:"+resultado.getString("apellido"));
                System.out.print(" Email:"+resultado.getString("email"));
                System.out.print(" Telefono:"+resultado.getString("telefono"));
                System.out.println("");

            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
