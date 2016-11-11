package pkgController;

import pkgVista.dlgStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pkgODT.clODTStudent;
import pkgSQLController.clStudentSQLController;
import pkgVista.frmMain;
import pkgVista.dlgLoan;

public class clStudentController implements ActionListener, DocumentListener {

    private dlgStudent studentDialogue;
    private ResultSet resultQuery;
    private clODTStudent student;
    private clStudentSQLController sqlController;

    public clStudentController(frmMain frmM) {
        studentDialogue = new dlgStudent(frmM, true, this);
        studentDialogue.setVisible(true);
    }

    public clStudentController(dlgLoan dialogueLoan) {
        studentDialogue = new dlgStudent(dialogueLoan, true, this);
        studentDialogue.setVisible(true);
        studentDialogue.getBtnSeleccion().setEnabled(true);
    }

    public clODTStudent getInfo() {
        student = new clODTStudent();
        student.setName(studentDialogue.getTxtNombre().getText());
        student.setSurname1(studentDialogue.getTxtApellido1().getText());
        student.setSurname2(studentDialogue.getTxtApellido2().getText());
        student.setDni(studentDialogue.getTxtDni().getText());
        student.setRegist(Integer.parseInt(studentDialogue.getTxtRegistro().getText()));
        return student;
    }

    private void backToWhite() {
        studentDialogue.getTxtRegistro().setText("");
        studentDialogue.getTxtDni().setText("");
        studentDialogue.getTxtNombre().setText("");
        studentDialogue.getTxtApellido1().setText("");
        studentDialogue.getTxtApellido2().setText("");
    }

    public void actualizarBotones() {
        studentDialogue.getBtnAltas().setEnabled(
                (!studentDialogue.getTxtDni().getText().equals("")
                || !studentDialogue.getTxtNombre().getText().equals("")
                || !studentDialogue.getTxtApellido1().getText().equals("")
                || !studentDialogue.getTxtApellido2().getText().equals(""))
                && studentDialogue.getTxtRegistro().getText().equals(""));
        studentDialogue.getBtnBajas().setEnabled(
                (!studentDialogue.getTxtDni().getText().equals("")
                || !studentDialogue.getTxtNombre().getText().equals("")
                || !studentDialogue.getTxtApellido1().getText().equals("")
                || !studentDialogue.getTxtApellido2().getText().equals(""))
                && !studentDialogue.getTxtRegistro().getText().equals(""));
        studentDialogue.getBtnModificaciones().setEnabled(
                (!studentDialogue.getTxtDni().getText().equals("")
                || !studentDialogue.getTxtNombre().getText().equals("")
                || !studentDialogue.getTxtApellido1().getText().equals("")
                || !studentDialogue.getTxtApellido2().getText().equals(""))
                && !studentDialogue.getTxtRegistro().getText().equals(""));
        studentDialogue.getBtnSearch().setEnabled(
                !studentDialogue.getTxtDni().getText().equals("")
                || !studentDialogue.getTxtNombre().getText().equals("")
                || !studentDialogue.getTxtApellido1().getText().equals("")
                || !studentDialogue.getTxtApellido2().getText().equals("")
                || !studentDialogue.getTxtRegistro().getText().equals(""));
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
        System.out.println("ah, a si que funcionaba para esto");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            clStudentSQLController studentSqlController = new clStudentSQLController();
            if (e.getActionCommand() == "btnAltas") {
                getInfo();
                studentSqlController.subscribe(student);
                studentDialogue.reset();
                studentDialogue.update();

            } else if (e.getActionCommand() == "btnBajas") {
                getInfo();
                studentSqlController.unsubscribe(student);
                studentDialogue.reset();
                studentDialogue.update();
            } else if (e.getActionCommand() == "btnModificar") {
                getInfo();
                studentSqlController.modify(student);
                studentDialogue.reset();
                studentDialogue.update();
            } else if (e.getActionCommand() == "btnSearch") {
                getInfo();
                sqlController.getStudentSearch(student);
                studentDialogue.update();
            } else if (e.getActionCommand() == "btnReset") {
                studentDialogue.update();
                backToWhite();
            } else if (e.getActionCommand().equals("btnSeleccion")) {
                getInfo();
                studentDialogue.dispose();
            } else {
                studentDialogue.dispose();
            }

        } catch (SQLException ex) {
            studentDialogue.showError("Ha habido un error en la consulta");
        }
    }

    public clStudentSQLController getSqlController() {
        return sqlController;
    }

    public clODTStudent getStudent() {
        return student;
    }
}
