package pkgBooks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pkgMain.frmMain;

public class clBooksController implements ActionListener, DocumentListener {

    private dlgBooks booksDialogue;
    private ResultSet resultQuery;
    
    public clBooksController(frmMain frmM) {
        booksDialogue = new dlgBooks(frmM, true, this);
        booksDialogue.setVisible(true);
    }

    public clBooksController() {
    }
    

    public clODTBooks getInfo() {
        clODTBooks book = new clODTBooks();
        book.setCodigo(booksDialogue.getTxtCodigo().getText());
        book.setAutor(booksDialogue.getTxtAutor().getText());
        book.setAsignatura(booksDialogue.getTxtAsignatura().getText());
        book.setEditorial(booksDialogue.getTxtEditorial().getText());
        book.setEstado(booksDialogue.getTxtEstado().getText());
        book.setTitulo(booksDialogue.getTxtTitulo().getText());

        return book;
    }

    private void backToWhite(){
        booksDialogue.getTxtCodigo().setText("");
        booksDialogue.getTxtAutor().setText("");
        booksDialogue.getTxtAsignatura().setText("");
        booksDialogue.getTxtEditorial().setText("");
        booksDialogue.getTxtEstado().setText("");
        booksDialogue.getTxtTitulo().setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            clBooksSQLController bookSqlController = new clBooksSQLController();
            if (e.getActionCommand() == "btnAltas") {
                clODTBooks student = getInfo();
                bookSqlController.subscribe(student);
                booksDialogue.update();
            } else if (e.getActionCommand() == "btnBajas") {
                clODTBooks student = getInfo();
                bookSqlController.unsubscribe(student);
                booksDialogue.update();
            } else if (e.getActionCommand() == "btnModificar") {
                clODTBooks student = getInfo();
                bookSqlController.modify(student);
                booksDialogue.update();
            
            } else if (e.getActionCommand() == "btnBuscar") {
                clODTBooks student = getInfo();
                resultQuery = bookSqlController.getBookSearch(student);
                resultQuery.next();
                booksDialogue.updateBook(resultQuery);
            
            }else if (e.getActionCommand() == "btnReset") {
                booksDialogue.update();
                backToWhite();
            } else {
                booksDialogue.dispose();
            }
        } catch (SQLException sQLException) {
            booksDialogue.showError("Ha habido un error en la consulta");
        }
    }

    public void actualizarBotones() {
        booksDialogue.getBtnAltas().setEnabled(
                (!booksDialogue.getTxtAsignatura().getText().equals("")
                ||!booksDialogue.getTxtAutor().getText().equals("")
                ||!booksDialogue.getTxtEditorial().getText().equals("")
                ||!booksDialogue.getTxtEstado().getText().equals("")
                ||!booksDialogue.getTxtTitulo().getText().equals(""))
                && booksDialogue.getTxtCodigo().getText().equals(""));
        booksDialogue.getBtnBajas().setEnabled(
                (!booksDialogue.getTxtAsignatura().getText().equals("")
                ||!booksDialogue.getTxtAutor().getText().equals("")
                ||!booksDialogue.getTxtEditorial().getText().equals("")
                ||!booksDialogue.getTxtEstado().getText().equals("")
                ||!booksDialogue.getTxtTitulo().getText().equals(""))
                &&!booksDialogue.getTxtCodigo().getText().equals(""));
        booksDialogue.getBtnModificaciones().setEnabled(
                (!booksDialogue.getTxtAsignatura().getText().equals("")
                ||!booksDialogue.getTxtAutor().getText().equals("")
                ||!booksDialogue.getTxtEditorial().getText().equals("")
                ||!booksDialogue.getTxtEstado().getText().equals("")
                ||!booksDialogue.getTxtTitulo().getText().equals(""))
                &&!booksDialogue.getTxtCodigo().getText().equals(""));
        booksDialogue.getBtnBuscar().setEnabled(
                !booksDialogue.getTxtAsignatura().getText().equals("")
                ||!booksDialogue.getTxtAutor().getText().equals("")
                ||!booksDialogue.getTxtEditorial().getText().equals("")
                ||!booksDialogue.getTxtEstado().getText().equals("")
                ||!booksDialogue.getTxtCodigo().getText().equals("")
                ||!booksDialogue.getTxtTitulo().getText().equals(""));
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        actualizarBotones();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        actualizarBotones();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

}
