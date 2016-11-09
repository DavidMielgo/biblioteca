package pkgVistaTabla;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;



public class clVistaTabla extends AbstractTableModel {

    ResultSet resultQuery;
    ResultSetMetaData metaDato; //contiene información sobre la estructura de un ResulSet,especialmente sobre sus nom campos
    int nColumna;
    int nFilas;

    public clVistaTabla(ResultSet rs) {
        this.resultQuery = rs;
        try {
            metaDato = rs.getMetaData();
            resultQuery.last();
            nFilas = resultQuery.getRow();
            nColumna = metaDato.getColumnCount();

        } catch (SQLException ex) {
        }
    }

    @Override
    public int getRowCount() {
        return nFilas;

    }

    @Override
    public int getColumnCount() {
        return nColumna;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            resultQuery.absolute(rowIndex + 1);
            Object o = resultQuery.getObject(columnIndex + 1);
            return o;
        } catch (SQLException ex) {
            return ex.toString();
        }

    }

}
