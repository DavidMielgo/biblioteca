/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgSQLController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgConexiones.clConexionSingleton;
import pkgODT.clODTLoan;
import pkgODT.clODTStudent;

public class clLoanSQLController {

    private ResultSet resultQuery;

    public void getStudentLoan(clODTStudent student) throws SQLException {
        String sql = new String("select * from prestamos where codAlumno = '" + student.getRegist() + "'");
        resultQuery = clConexionSingleton.getInstance().executeQuery(sql);
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

    public clODTLoan getLoan(int row) throws SQLException {
        clODTLoan loan = new clODTLoan();
        resultQuery.absolute(row);
        loan.setId(resultQuery.getInt(1));
        loan.setIdStudent(resultQuery.getString(2));
        loan.setIdBook(resultQuery.getString(3));
        loan.setPrestamos(resultQuery.getDate(4));
        loan.setDevolucion(resultQuery.getDate(5));
        loan.setEstado(resultQuery.getString(6));
        return loan;
    }

    public ResultSet getResultQuery() {
        return resultQuery;
    }
}
