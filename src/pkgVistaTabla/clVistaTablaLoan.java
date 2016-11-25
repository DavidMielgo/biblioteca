package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgSQLController.clBooksSQLController;

public class clVistaTablaLoan extends AbstractTableModel {

    private clBooksSQLController sqlControl;
    private final String columns[] = {
        "Titulo",
        "Codigo",
        "Autor",
        "Editorial",
        "Asignatura",
        "Estado"
    };

    public clVistaTablaLoan(clBooksSQLController auxSqlControl) {
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
                    return sqlControl.getBook(rowIndex + 1).getCodigo();
                case 2:
                    return sqlControl.getBook(rowIndex + 1).getTitulo();
                case 3:
                    return sqlControl.getBook(rowIndex + 1).getAutor();
                case 4:
                    return sqlControl.getBook(rowIndex + 1).getEditorial();
                case 5:
                    return sqlControl.getBook(rowIndex + 1).getAsignatura();
                case 6:
                    return sqlControl.getBook(rowIndex + 1).getEstado();

            }
        } catch (SQLException ex) {
            Logger.getLogger(clVistaTablaLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

}
