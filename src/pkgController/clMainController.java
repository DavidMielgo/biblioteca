package pkgController;

import pkgVista.frmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class clMainController implements ActionListener {

    private frmMain frmMain;

    public void clCreateFrm() {
        frmMain = new frmMain();
        frmMain.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btnStudent")) {

            clStudentController studentController = new clStudentController(frmMain);

        } else if (e.getActionCommand().equals("btnBooks")) {
           
            clBooksController BooksController = new clBooksController(frmMain);

        } else if (e.getActionCommand().equals("btnLoan")) {
            
            clLoanController loanController = new clLoanController(frmMain);
            
        } else if (e.getActionCommand().equals("btnReports")) {

        } else {
            System.exit(0);
        }
    }
}
