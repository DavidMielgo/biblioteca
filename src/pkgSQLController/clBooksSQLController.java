package pkgSQLController;

import pkgODT.clODTBooks;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pkgConexiones.clConexionSingleton;

public class clBooksSQLController {


    private ResultSet resultQuery = null;
    private boolean controlAnd;

    public ResultSet getAllBooks() throws SQLException {

        String sql = new String("select * from libros");
        resultQuery = clConexionSingleton.getInstance().executeQuery(sql);

        return resultQuery;
    }

        public void subscribe(clODTBooks book) throws SQLException {
        String sql = "insert into libros (titulo, autor, editorial, asignatura, estado) values ('" + book.getTitulo() + "','" + book.getAutor() + "','"
                + book.getEditorial()+ "','" + book.getAsignatura()+ "','" + book.getEstado() + "');";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void unsubscribe(clODTBooks book) throws SQLException {
        String sql = "delete from libros where codigo = " + book.getCodigo()+ ";";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public void modify(clODTBooks book) throws SQLException {
        String sql = "update libros set titulo = '" + book.getTitulo() + "', autor = '" + book.getAutor()+ "', editorial = '" + book.getEditorial() + "', asignatura = '"
                + book.getAsignatura() + "', estado = '" + book.getEstado() + "' where codigo = '" + book.getCodigo()+ "';";
        clConexionSingleton.getInstance().executeSqlUpdate(sql);

    }

    public ResultSet getBookSearch(clODTBooks book) throws SQLException {
        String sql = "select * from libros where ";
        if (!book.getCodigo().equals("")) {
            sql = sql + "codigo = " + book.getCodigo()+ " and ";
        }
        if (!book.getTitulo().equals("")) {
            sql = sql + "titulo = '" + book.getTitulo()+ "' and ";
        } 
        if (!book.getAutor().equals("")) {
            sql = sql + "autor =  '" + book.getAutor()+ "' and ";
        }
        if (!book.getEditorial().equals("")) {
            sql = sql + " editorial = '" + book.getEditorial()+ "' and ";
        }
        if (!book.getAsignatura().equals("")) {
            sql = sql + "asignatura = '" + book.getAsignatura() + "' and ";
        }
        if (!book.getEstado().equals("")) {
            sql = sql + "estado = '" + book.getEstado()+ "' and ";
        }
        resultQuery = clConexionSingleton.getInstance().executeQuery(sql.substring(0, sql.length()-4));
        return resultQuery;
    } 
}
