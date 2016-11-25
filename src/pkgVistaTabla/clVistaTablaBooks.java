package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgODT.clODTBooks;
import pkgSQLController.clBooksSQLController;

public class clVistaTablaBooks extends AbstractTableModel {

    private clODTBooks book;
    private int row = -1;
    private clBooksSQLController sqlControl;
    private final String columns[] = {
        "Titulo",
        "Codigo",
        "Autor",
        "Editorial",
        "Asignatura",
        "Estado"
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
                if(rowIndex != row){
                    book = sqlControl.getBook(rowIndex + 1);
                    row = rowIndex;
                }
            switch (columnIndex + 1) {
                case 1:
                    return book.getCodigo();
                case 2:
                    return book.getTitulo();
                case 3:
                    return book.getAutor();
                case 4:
                    return book.getEditorial();
                case 5:
                    return book.getAsignatura();
                case 6:
                    return book.getEstado();

            }
        } catch (SQLException ex) {
            Logger.getLogger(clVistaTablaBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

}
