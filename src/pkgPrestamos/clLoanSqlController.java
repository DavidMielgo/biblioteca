/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgPrestamos;

import java.sql.ResultSet;
import java.sql.SQLException;
import pkgConexiones.clConexionSingleton;

/**
 *
 * @author DavSosMie
 */
public class clLoanSqlController {

    public ResultSet getAllLoan() throws SQLException {
        String sql = new String("select * from prestamos ");
        return clConexionSingleton.getInstance().executeQuery(sql);
    }

}
