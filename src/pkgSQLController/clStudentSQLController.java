package pkgSQLController;


import pkgODT.clODTStudent;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgConexiones.clConexionSingleton;

public class clStudentSQLController {

    private boolean controlAnd = false;
    clODTStudent student = new clODTStudent();
    public static final int COLUMN_ALUMNO_REGISTRO = 0;
    public static final int COLUMN_ALUMNO_DNI = 1;
    public static final int COLUMN_ALUMNO_NOMBRE = 2;
    public static final int COLUMN_ALUMNO_APELLIDO1 = 3;
    public static final int COLUMN_ALUMNO_APELLIDO2 = 4;
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
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void modify(clODTStudent student) throws SQLException {
        String sql = "update alumnos set dni = '" + student.getDni() + "', nombre = '" + student.getName() + "', apellido1 = '" + student.getSurname1() + "', apellido2 = '"
                + student.getSurname2() + "'where registro = '" + student.getRegist() + "';";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void getStudentSearch(clODTStudent student) throws SQLException {
        String sql = "select * from alumnos where ";
        String registro = "" + student.getRegist();
        if (!registro.equals("")) {
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

        public clODTStudent getAlumno(int row) throws Exception {
        clODTStudent alumno;
        if (resultQuery.absolute(row)) {

            alumno = new clODTStudent();

            int registro = resultQuery.getInt(COLUMN_ALUMNO_REGISTRO + 1);
            String dni = resultQuery.getString(COLUMN_ALUMNO_DNI + 1);
            String nombre = resultQuery.getString(COLUMN_ALUMNO_NOMBRE + 1);
            String apellido1 = resultQuery.getString(COLUMN_ALUMNO_APELLIDO1 + 1);
            String apellido2 = resultQuery.getString(COLUMN_ALUMNO_APELLIDO2 + 1);

            alumno.setRegist(resultQuery.getInt(COLUMN_ALUMNO_REGISTRO + 1));
            alumno.setDni(resultQuery.getString(COLUMN_ALUMNO_DNI + 1));
            alumno.setName(resultQuery.getString(COLUMN_ALUMNO_NOMBRE + 1));
            alumno.setSurname1(apellido1);
            alumno.setSurname2(apellido2);

            //esto es por si, y lo comento
            //alumno = new Alumno(dni, registro, nombre, apellido1, apellido2);
        }
        return student;
    }

    public ResultSet getResultQuery() {
        return resultQuery;
    }
        
    
    
    
}
