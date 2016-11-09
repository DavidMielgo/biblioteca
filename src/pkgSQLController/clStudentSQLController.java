package pkgSQLController;

import pkgODT.clODTStudent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgConexiones.clConexionSingleton;

public class clStudentSQLController {

    private boolean controlAnd = false;

    public ResultSet getAllStudent() throws SQLException {

        String sql = new String("select * from alumnos ");

        return clConexionSingleton.getInstance().executeQuery(sql); 
    }

    public void subscribe(clODTStudent student) throws SQLException {
        String sql = "insert into alumnos (dni,nombre,apellido1,apellido2) values ('" + student.getDni() + "','" + student.getName() + "','"
                + student.getSurname1() + "','" + student.getSurname2() + "');";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void unsubscribe(clODTStudent student) throws SQLException {
        String sql = "delete from alumnos where registro = " + student.getRegist() + ";";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void modify(clODTStudent student) throws SQLException {
        String sql = "update alumnos set dni = '" + student.getDni() + "', nombre = '" + student.getName() + "', apellido1 = '" + student.getSurname1() + "', apellido2 = '"
                + student.getSurname2() + "'where registro = '" + student.getRegist() + "';";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public ResultSet getStudentSearch(clODTStudent student) throws SQLException {
        String sql = "select * from alumnos where ";
        if (!student.getRegist().equals("")) {
            sql = sql + "registro = " + student.getRegist() + " and ";
        }
        if (!student.getDni().equals("")) {
            sql = sql + "dni = '" + student.getDni() + "' and ";
        }
        if (!student.getName().equals("")) {
            sql = sql + "nombre =  '" + student.getName() + "' and ";
        }
        if (!student.getSurname1().equals("")) {
            sql = sql + "apellido1 = '" + student.getSurname1() + "' and ";
        }
        if (!student.getSurname2().equals("")) {
            sql = sql + "apellido2 = '" + student.getSurname2() + "' and ";
        }
        //System.out.println(sql.substring(0, sql.length() - 4));
        return clConexionSingleton.getInstance().
                executeQuery(sql.substring(0, sql.length() - 4));
    }

}
