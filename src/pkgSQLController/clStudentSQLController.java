package pkgSQLController;

import pkgODT.clODTStudent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgConexiones.clConexionSingleton;

public class clStudentSQLController {

    private ResultSet resultQuery;

    public void getAllStudent() throws SQLException {

        String sql = new String("select * from alumnos ");
        resultQuery = clConexionSingleton.getInstance().executeQuery(sql);
    }

    public void subscribe(clODTStudent student) throws SQLException {
        String sql = "insert into alumnos (dni,nombre,apellido1,apellido2) values ('" + student.getDni() + "','" + student.getName() + "','"
                + student.getSurname1() + "','" + student.getSurname2() + "');";

        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void unsubscribe(clODTStudent student) throws SQLException {
        String sql = "delete from alumnos where registro = " + student.getRegist() + ";";
        System.out.println(sql);
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void modify(clODTStudent student) throws SQLException {
        String sql = "update alumnos set dni = '" + student.getDni() + "', nombre = '" + student.getName() + "', apellido1 = '" + student.getSurname1() + "', apellido2 = '"
                + student.getSurname2() + "'where registro = '" + student.getRegist() + "';";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public int NumeroRegistros() {
        try {
            int fila = -1;
            if (resultQuery.last()) {
                fila = resultQuery.getRow();
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(clStudentSQLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void getStudentSearch(clODTStudent student) throws SQLException {
        String sql = "select * from alumnos where ";

        if (student.getRegist() >= 0) {
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
        resultQuery = clConexionSingleton.getInstance().
                executeQuery(sql.substring(0, sql.length() - 4));
    }

    public clODTStudent getAlumno(int row) throws SQLException {
        clODTStudent student = new clODTStudent();
        resultQuery.absolute(row);
        student.setRegist(resultQuery.getInt(1));
        student.setDni(resultQuery.getString(2));
        student.setName(resultQuery.getString(3));
        student.setSurname1(resultQuery.getString(4));
        student.setSurname2(resultQuery.getString(5));
        return student;
    }

    public ResultSet getResultQuery() {
        return resultQuery;
    }

}
