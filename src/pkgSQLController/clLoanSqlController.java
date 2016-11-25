/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgSQLController;

import java.sql.ResultSet;
import java.sql.SQLException;
import pkgConexiones.clConexionSingleton;
import pkgODT.clODTStudent;

/**
 *
 * @author DavSosMie
 */
public class clLoanSqlController {

    public void getAllLoan() throws SQLException {
        String sql = new String("select * from prestamos ");
        clConexionSingleton.getInstance().executeQuery(sql);
    }
    
    public void getStudentLoan(clODTStudent student) throws SQLException{
        String sql = new String ("select * from prestamos where codAlumno = " + student.getRegist());
        clConexionSingleton.getInstance().executeQuery(sql);
    }

}
