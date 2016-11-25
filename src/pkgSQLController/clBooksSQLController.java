package pkgSQLController;

import pkgODT.clODTBooks;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgConexiones.clConexionSingleton;

public class clBooksSQLController {

    private ResultSet resultQuery = null;
    private boolean controlAnd;

    public void getAllBooks() throws SQLException {

        String sql = new String("select * from libros");
        resultQuery = clConexionSingleton.getInstance().executeQuery(sql);
    }

    public void subscribe(clODTBooks book) throws SQLException {
        String sql = "insert into libros (titulo, autor, editorial, asignatura, estado) values ('" + book.getTitulo() + "','" + book.getAutor() + "','"
                + book.getEditorial() + "','" + book.getAsignatura() + "','" + book.getEstado() + "');";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void unsubscribe(clODTBooks book) throws SQLException {
        String sql = "delete from libros where codigo = " + book.getCodigo() + ";";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void modify(clODTBooks book) throws SQLException {
        String sql = "update libros set titulo = '" + book.getTitulo() + "', autor = '" + book.getAutor() + "', editorial = '" + book.getEditorial() + "', asignatura = '"
                + book.getAsignatura() + "', estado = '" + book.getEstado() + "' where codigo = '" + book.getCodigo() + "';";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void getBookSearch(clODTBooks book) throws SQLException {
        String sql = "select * from libros where ";
        
        if (book.getCodigo() >= 0) {
            sql = sql + "codigo = " + book.getCodigo() + " and ";
        }
        if (!book.getTitulo().equals("")) {
            sql = sql + "titulo = '" + book.getTitulo() + "' and ";
        }
        if (!book.getAutor().equals("")) {
            sql = sql + "autor =  '" + book.getAutor() + "' and ";
        }
        if (!book.getEditorial().equals("")) {
            sql = sql + " editorial = '" + book.getEditorial() + "' and ";
        }
        if (!book.getAsignatura().equals("")) {
            sql = sql + "asignatura = '" + book.getAsignatura() + "' and ";
        }
        if (!book.getEstado().equals("")) {
            sql = sql + "estado = '" + book.getEstado() + "' and ";
        }
        System.out.println(sql.substring(0, sql.length() - 4));
        resultQuery = clConexionSingleton.getInstance().executeQuery(sql.substring(0, sql.length() - 4));

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

        public clODTBooks getBook(int row) throws SQLException {
        clODTBooks books = new clODTBooks();
        resultQuery.absolute(row);
        books.setCodigo(resultQuery.getInt(1));
        books.setTitulo(resultQuery.getString(2));
        books.setAutor(resultQuery.getString(3));
        books.setEditorial(resultQuery.getString(4));
        books.setAsignatura(resultQuery.getString(5));
        books.setEstado(resultQuery.getString(6));
        return books;
    }
    
    public ResultSet getResultQuery() {
        return resultQuery;
    }

}
