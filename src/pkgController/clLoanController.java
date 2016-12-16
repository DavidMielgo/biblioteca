package pkgController;

import pkgVista.dlgLoan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgODT.clODTBooks;
import pkgVista.frmMain;
import pkgODT.clODTStudent;
import pkgSQLController.clLoanSQLController;

public class clLoanController implements ActionListener {

    private dlgLoan loanDialogue;
    private clODTStudent student;
    private clLoanSQLController sqlController = new clLoanSQLController();

    public clLoanController(frmMain frmM) {
        loanDialogue = new dlgLoan(frmM, true, this);
        loanDialogue.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("btnBuscar")) {
                clStudentController studentController = new clStudentController(loanDialogue);
                student = studentController.getStudent();
                fillFieldStudent();
                sqlController.getStudentLoan(student);
                loanDialogue.update();
            } else if (e.getActionCommand().equals("btnAdd")) {
                clNewLoanController newLoanController = new clNewLoanController(loanDialogue, false);
                
            } else {
                loanDialogue.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(clLoanController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void fillFieldStudent() {
        loanDialogue.getTxtRegistro().setText("" + student.getRegist());
        loanDialogue.getTxtDni().setText(student.getDni());
        loanDialogue.getTxtNombre().setText(student.getName());
        loanDialogue.getTxtApellido1().setText(student.getSurname1());
        loanDialogue.getTxtApellido2().setText(student.getSurname2());
    }

    public clLoanSQLController getSqlController() {
        return sqlController;
    }

    public void actualizarLibro(String estado, int cod) throws SQLException{
        sqlController.actualizarEstadoLibro(estado, "" + cod);
    }
     public void darAltaPrestamo(clODTBooks book, String estado, String fecha) throws SQLException{
        sqlController.darAltaPrestamo(loanDialogue.getTxtRegistro().getText(), book, estado, fecha);
    }
    
}
