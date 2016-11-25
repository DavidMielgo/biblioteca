package pkgController;

import pkgVista.dlgBooks;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pkgSQLController.clBooksSQLController;
import pkgODT.clODTBooks;
import pkgVista.frmMain;

public class clBooksController implements ActionListener, DocumentListener {

    private dlgBooks booksDialogue;
    private clODTBooks book;
    private clBooksSQLController sqlController = new clBooksSQLController();
    
    public clBooksController(frmMain frmM) {
        booksDialogue = new dlgBooks(frmM, true, this);
        booksDialogue.setVisible(true);
    }    

    public void getInfo() {
        book = new clODTBooks();
        if(!booksDialogue.getTxtCodigo().getText().equals("")){
            book.setCodigo(Integer.parseInt
                (booksDialogue.getTxtCodigo().getText()));
        }else{
            book.setCodigo(-1);
        }
        book.setAutor(booksDialogue.getTxtAutor().getText());
        book.setAsignatura(booksDialogue.getTxtAsignatura().getText());
        book.setEditorial(booksDialogue.getTxtEditorial().getText());
        book.setEstado(booksDialogue.getTxtEstado().getText());
        book.setTitulo(booksDialogue.getTxtTitulo().getText());
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
            
            if (e.getActionCommand().equals("btnAltas")) {
                getInfo();
                sqlController.subscribe(book);
                booksDialogue.reset();
                booksDialogue.update();
            } else if (e.getActionCommand().equals("btnBajas")) {
                getInfo();
                sqlController.unsubscribe(book);
                booksDialogue.reset();
                booksDialogue.update();
            } else if (e.getActionCommand().equals("btnModificar")) {
                getInfo();
                sqlController.modify(book);
                booksDialogue.reset();
                booksDialogue.update();
            } else if (e.getActionCommand().equals("btnBuscar")) {
                getInfo();
                sqlController.getBookSearch(book);
                booksDialogue.update();
            }else if (e.getActionCommand().equals("btnReset")) {
                booksDialogue.reset();
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

    public clODTBooks getBook() {
        return book;
    }

    public clBooksSQLController getSqlController() {
        return sqlController;
    }

    
    
}
