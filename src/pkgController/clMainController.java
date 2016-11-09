package pkgController;

import pkgController.clLoanController;
import pkgVista.frmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgController.clBooksController;
import pkgController.clStudentController;

public class clMainController implements ActionListener {

    private frmMain frmMain;

    public void clCreateFrm() {
        frmMain = new frmMain();
        frmMain.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "btnStudent") {

            clStudentController studentController = new clStudentController(frmMain);

        } else if (e.getActionCommand() == "btnBooks") {
           
            clBooksController BooksController = new clBooksController(frmMain);

        } else if (e.getActionCommand() == "btnLoan") {
            
            clLoanController loanController = new clLoanController(frmMain);
            
        } else if (e.getActionCommand() == "btnReports") {

        } else {
            System.exit(0);
        }
    }
}
