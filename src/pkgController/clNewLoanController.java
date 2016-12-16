package pkgController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgODT.clODTBooks;
import pkgVista.dlgLoan;
import pkgVista.dlgNewLoan;

public class clNewLoanController implements ActionListener {

    private dlgNewLoan newLoanDialogue;
    private clLoanController loanController;
    private clODTBooks book;
    private Boolean toModify = false;

    public clNewLoanController(dlgLoan loanDialogue, Boolean paraModify) {
        newLoanDialogue = new dlgNewLoan(loanDialogue, true, this);
        newLoanDialogue.setVisible(true);
        toModify = paraModify;
    }

    public void fillFieldBook() {
        newLoanDialogue.getTxtCodigo().setText("" + book.getCodigo());
        newLoanDialogue.getTxtTitulo().setText(book.getTitulo());
        newLoanDialogue.getTxtAutor().setText(book.getAutor());
        newLoanDialogue.getTxtAsignatura().setText(book.getAsignatura());
        newLoanDialogue.getTxtEditorial().setText(book.getEditorial());
        newLoanDialogue.getTxtEstado().setText(book.getEstado());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("btnBuscar")) {
                clBooksController booksController = new clBooksController(newLoanDialogue);
                book = booksController.getBook();
                fillFieldBook();
            } else if (e.getActionCommand().equals("btnAceptar")) {
                if (newLoanDialogue.getTxtCodigo().equals("")) {
                    newLoanDialogue.showError("primero debe seleccionar un libro");
                }
                if (toModify) {
                    loanController.actualizarLibro(newLoanDialogue.getTxtEstado().getText(),
                            Integer.parseInt(newLoanDialogue.getTxtCodigo().getText()));
                }else{
                    System.out.println(book.getCodigo());
                    System.out.println(newLoanDialogue.getTxtEstado().getText());
                    System.out.println(newLoanDialogue.getTxtFechaDev().getText());
                    loanController.darAltaPrestamo(book, newLoanDialogue.getTxtEstado().getText(), newLoanDialogue.getTxtFechaDev().getText());
                }
            } else if (e.getActionCommand().equals("btnCancelar")) {
                newLoanDialogue.dispose();

            }
        } catch (SQLException ex) {
            Logger.getLogger(clNewLoanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
