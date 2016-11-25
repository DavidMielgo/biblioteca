package pkgVista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pkgController.clStudentController;
import pkgSQLController.clStudentSQLController;
import pkgVistaTabla.clVistaTablaStudent;

public class dlgStudent extends javax.swing.JDialog {

    private clStudentSQLController sqlControl;
    private clVistaTablaStudent clVistaTablaStudent;

    public dlgStudent(java.awt.Frame parent, boolean modal, clStudentController StudentController) {
        super(parent, modal);
        try {
            initComponents();
            disableAll();
            btnAddActionListener(StudentController);
            txtAddDocumentListener(StudentController);
            sqlControl = StudentController.getSqlController();
            sqlControl.getAllStudent();
            clVistaTablaStudent = new clVistaTablaStudent(sqlControl);
            TablaAlumnos.setModel(clVistaTablaStudent);
        } catch (SQLException ex) {
            Logger.getLogger(dlgStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public dlgStudent(javax.swing.JDialog parent, boolean modal, clStudentController StudentController) {
        super(parent, modal);
        try {
            initComponents();
            disableAll();
            btnAddActionListener(StudentController);
            txtAddDocumentListener(StudentController);
            sqlControl = StudentController.getSqlController();
            sqlControl.getAllStudent();
            clVistaTablaStudent = new clVistaTablaStudent(sqlControl);
            TablaAlumnos.setModel(clVistaTablaStudent);
        } catch (SQLException ex) {
            Logger.getLogger(dlgStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void disableAll() {
        btnAltas.setEnabled(false);
        btnBajas.setEnabled(false);
        btnModificaciones.setEnabled(false);
        btnSearch.setEnabled(false);
        btnSeleccion.setEnabled(false);

    }

    private void btnAddActionListener(clStudentController StudentController) {
        btnAltas.addActionListener(StudentController);
        btnBajas.addActionListener(StudentController);
        btnModificaciones.addActionListener(StudentController);
        btnSalir.addActionListener(StudentController);
        btnSearch.addActionListener(StudentController);
        btnReset.addActionListener(StudentController);
        btnSeleccion.addActionListener(StudentController);
    }

    private void txtAddDocumentListener(clStudentController StudentController) {
        txtRegistro.getDocument().addDocumentListener(StudentController);
        txtDni.getDocument().addDocumentListener(StudentController);
        txtNombre.getDocument().addDocumentListener(StudentController);
        txtApellido1.getDocument().addDocumentListener(StudentController);
        txtApellido2.getDocument().addDocumentListener(StudentController);
    }

    public void update() {
        clVistaTablaStudent = new clVistaTablaStudent(sqlControl);
        TablaAlumnos.setModel(clVistaTablaStudent);
    }

    public void reset(){
        try {
            sqlControl.getAllStudent();
        } catch (SQLException ex) {
            
        }
    }
    
    public void showError(String parameter) {
        JOptionPane.showMessageDialog(null, parameter);
    }

    public JTextField getTxtApellido1() {
        return txtApellido1;
    }

    public void setTxtApellido1(JTextField txtApellido1) {
        this.txtApellido1 = txtApellido1;
    }

    public JTextField getTxtApellido2() {
        return txtApellido2;
    }

    public void setTxtApellido2(JTextField txtApellido2) {
        this.txtApellido2 = txtApellido2;
    }

    public JTextField getTxtDni() {
        return txtDni;
    }

    public void setTxtDni(JTextField txtDni) {
        this.txtDni = txtDni;
    }

    public void setTextDni(String dni) {
        this.txtDni.setText(dni);
    }

    public void setTextName(String name) {
        this.txtNombre.setText(name);
    }

    public void setTextApellido1(String surname1) {
        this.txtApellido1.setText(surname1);
    }

    public void setTextApellido2(String surname2) {
        this.txtApellido2.setText(surname2);
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtRegistro() {
        return txtRegistro;
    }

    public void setTxtRegistro(JTextField txtRegistro) {
        this.txtRegistro = txtRegistro;
    }

    public JButton getBtnAltas() {
        return btnAltas;
    }

    public void setBtnAltas(JButton btnAltas) {
        this.btnAltas = btnAltas;
    }

    public JButton getBtnBajas() {
        return btnBajas;
    }

    public void setBtnBajas(JButton btnBajas) {
        this.btnBajas = btnBajas;
    }

    public JButton getBtnModificaciones() {
        return btnModificaciones;
    }

    public void setBtnModificaciones(JButton btnModificaciones) {
        this.btnModificaciones = btnModificaciones;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JButton getBtnSeleccion() {
        return btnSeleccion;
    }

    public void setBtnSeleccion(JButton btnSeleccion) {
        this.btnSeleccion = btnSeleccion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAlumnos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtRegistro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAltas = new javax.swing.JButton();
        btnBajas = new javax.swing.JButton();
        btnModificaciones = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnSeleccion = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAlumnos);

        jLabel1.setText("Dni");

        jLabel2.setText("Registro");

        jLabel3.setText("Nombre");

        txtNombre.setToolTipText("");

        jLabel4.setText("Apellido1");

        jLabel5.setText("Apellido2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtDni)
                    .addComponent(txtRegistro)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre)
                    .addComponent(jLabel4)
                    .addComponent(txtApellido1)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAltas.setText("Altas");
        btnAltas.setActionCommand("btnAltas");
        btnAltas.setMaximumSize(new java.awt.Dimension(90, 25));
        btnAltas.setMinimumSize(new java.awt.Dimension(90, 25));
        btnAltas.setPreferredSize(new java.awt.Dimension(99, 25));

        btnBajas.setText("Bajas");
        btnBajas.setActionCommand("btnBajas");
        btnBajas.setMinimumSize(new java.awt.Dimension(90, 25));
        btnBajas.setPreferredSize(new java.awt.Dimension(70, 25));

        btnModificaciones.setText("Modificar");
        btnModificaciones.setActionCommand("btnModificar");

        btnSalir.setText("Salir");
        btnSalir.setActionCommand("btnSalir");
        btnSalir.setMaximumSize(new java.awt.Dimension(90, 25));
        btnSalir.setMinimumSize(new java.awt.Dimension(90, 25));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Usuarios.png"))); // NOI18N

        btnSearch.setText("Buscar");
        btnSearch.setActionCommand("btnSearch");

        btnSeleccion.setText("seleccionar");
        btnSeleccion.setActionCommand("btnSeleccion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAltas, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(btnModificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSeleccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(btnBajas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificaciones)
                    .addComponent(btnSeleccion))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnReset.setText("reset");
        btnReset.setActionCommand("btnReset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnReset)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAlumnosMouseClicked
        Mostrar_datos(TablaAlumnos.getSelectedRow());
    }//GEN-LAST:event_TablaAlumnosMouseClicked
    private void Mostrar_datos(int fila) {

        txtDni.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 1)));
        txtRegistro.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 0)));
        txtNombre.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 2)));
        txtApellido1.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 3)));
        txtApellido2.setText(String.valueOf(TablaAlumnos.getValueAt(fila, 4)));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAlumnos;
    private javax.swing.JButton btnAltas;
    private javax.swing.JButton btnBajas;
    private javax.swing.JButton btnModificaciones;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSeleccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRegistro;
    // End of variables declaration//GEN-END:variables
}
