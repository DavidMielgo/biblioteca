package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgODT.clODTStudent;
import pkgSQLController.clStudentSQLController;

public class clVistaTablaStudent extends AbstractTableModel {

    private clODTStudent student;
    private clStudentSQLController sqlControl;
    private int row = -1;
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
            if(rowIndex != row){
                student = sqlControl.getAlumno(rowIndex + 1);
                row = rowIndex;
            }
            switch (columnIndex + 1) {
                case 1:
                    return student.getRegist();
                case 2:
                    return student.getDni();
                case 3:
                    return student.getName();
                case 4:
                    return student.getSurname1();
                case 5:
                    return student.getSurname2();
            }

        } catch (SQLException ex) {
            Logger.getLogger(clVistaTablaStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

}
