package pkgController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgVista.dlgLoan;
import pkgVista.dlgNewLoan;

public class clNewLoanController implements ActionListener {
private dlgNewLoan newLoanDialogue;
    public clNewLoanController(dlgLoan loanDialogue) {
        newLoanDialogue = new dlgNewLoan(loanDialogue, true, this);
        newLoanDialogue.setVisible(true);
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btnBuscar")){
            clBooksController booksController = new clBooksController(newLoanDialogue);
            
            
            
            
        }else if(e.getActionCommand().equals("btnCancelar")){
            newLoanDialogue.dispose();
            
        }
    }
}
