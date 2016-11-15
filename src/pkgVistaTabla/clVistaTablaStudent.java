/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgSQLController.clStudentSQLController;

/**
 *
 * @author DavSosMie
 */
public class clVistaTablaStudent extends AbstractTableModel {

    private clStudentSQLController sqlControl;
    private final String columns[] = {
        "Registro",
        "Dni",
        "Nombre",
        "Apellido1",
        "Apellido2"
    };

    public clVistaTablaStudent(clStudentSQLController auxSqlControl) {
        sqlControl = auxSqlControl;
    }

    @Override
    public int getRowCount() {
        try {
            return sqlControl.NumeroRegistros();
            
            
        } catch (Exception ex) {
            Logger.getLogger(clVistaTablaStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        try {
            switch (columnIndex + 1) {
                case 1:
                    return sqlControl.getAlumno(rowIndex + 1).getRegist();
                case 2:
                    return sqlControl.getAlumno(rowIndex + 1).getDni();
                case 3:
                    return sqlControl.getAlumno(rowIndex + 1).getName();
                case 4:
                    return sqlControl.getAlumno(rowIndex + 1).getSurname1();
                case 5:
                    return sqlControl.getAlumno(rowIndex + 1).getSurname2();
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(clVistaTablaStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
            return "";
    }
}
