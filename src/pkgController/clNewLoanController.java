package pkgController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgODT.clODTBooks;
import pkgVista.dlgLoan;
import pkgVista.dlgNewLoan;

public class clNewLoanController implements ActionListener {
private dlgNewLoan newLoanDialogue;
private clODTBooks book;

    public clNewLoanController(dlgLoan loanDialogue) {
        newLoanDialogue = new dlgNewLoan(loanDialogue, true, this);
        newLoanDialogue.setVisible(true);
    }  

    public void fillFieldBook() {
        newLoanDialogue.getTxtCodigo().setText("" + book.getCodigo());
        newLoanDialogue.getTxtTitulo().setText(book.getTitulo());
        newLoanDialogue.getTxtAutor().setText(book.getAutor());
        newLoanDialogue.getTxtAsignatura().setText(book.getAsignatura());
        newLoanDialogue.getTxtEditorial().setText(book.getEditorial());
        newLoanDialogue.getTxtEstado().setText(book.getEditorial());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btnBuscar")){
            clBooksController booksController = new clBooksController(newLoanDialogue);
            book = booksController.getBook();
            fillFieldBook();
        }else if(e.getActionCommand().equals("btnCancelar")){
            newLoanDialogue.dispose();
            
        }
    }
}
