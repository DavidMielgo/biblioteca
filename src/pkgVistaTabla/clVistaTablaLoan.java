package pkgVistaTabla;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pkgODT.clODTLoan;
import pkgSQLController.clLoanSQLController;

public class clVistaTablaLoan extends AbstractTableModel {

    private clODTLoan loan;
    private int row = -1;
    private clLoanSQLController sqlControl;
    private final String columns[] = {
        "Id",
        "CodAlumno",
        "CodLibro",
        "Fecha Entrega",
        "Fecha Devolucion",
        "Estado"
    };

    public clVistaTablaLoan(clLoanSQLController auxSqlControl) {
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
                    loan = sqlControl.getLoan(rowIndex + 1);
                    row = rowIndex;
                }
            switch (columnIndex + 1) {
                case 1:
                    return loan.getId();
                case 2:
                    return loan.getIdStudent();
                case 3:
                    return loan.getIdBook();
                case 4:
                    return loan.getPrestamos();
                case 5:
                    return loan.getDevolucion();
                case 6:
                    return loan.getEstado();

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
