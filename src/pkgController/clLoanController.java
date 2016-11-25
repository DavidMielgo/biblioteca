/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgController;

import pkgVista.dlgLoan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkgVista.frmMain;
import pkgODT.clODTStudent;


/**
 *
 * @author DavSosMie
 */
public class clLoanController implements ActionListener{

    private dlgLoan loanDialogue;
    private clODTStudent student;
    
    public clLoanController(frmMain frmM) {
        loanDialogue = new dlgLoan(frmM, true, this);
        loanDialogue.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("btnBuscar")){
            clStudentController studentController = new clStudentController(loanDialogue);
            student = studentController.getStudent();
            fillFieldStudent();
        }else {
            loanDialogue.dispose();
        }
    }
    
    public void fillFieldStudent(){
        loanDialogue.getTxtRegistro().setText("" + student.getRegist());
        loanDialogue.getTxtDni().setText(student.getDni());
        loanDialogue.getTxtNombre().setText(student.getName());
        loanDialogue.getTxtApellido1().setText(student.getSurname1());
        loanDialogue.getTxtApellido2().setText(student.getSurname2());
    }
}
