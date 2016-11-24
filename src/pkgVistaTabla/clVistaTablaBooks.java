package pkgVistaTabla;

import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;
import pkgSQLController.clBooksSQLController;

public class clVistaTablaBooks extends AbstractTableModel {

    private clBooksSQLController sqlControl;
    private final String columns[] = {
        "Registro",
        "Dni",
        "Nombre",
        "Apellido1",
        "Apellido2"
    };

    public clVistaTablaBooks(clBooksSQLController auxSqlControl) {
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
            switch (columnIndex + 1) {
                case 1:
                    return sqlControl.getAlumno(rowIndex + 1).getCodigo();
                case 2:
                    return sqlControl.getAlumno(rowIndex + 1).getTitulo();
                case 3:
                    return sqlControl.getAlumno(rowIndex + 1).getAutor();
                case 4:
                    return sqlControl.getAlumno(rowIndex + 1).getEditorial();
                case 5:
                    return sqlControl.getAlumno(rowIndex + 1).getAsignatura();
                case 6:
                    return sqlControl.getAlumno(rowIndex + 1).getEstado();    
                
            }
            

        } catch (SQLException ex) {
            
        }
                    
            return "";
    }
}
