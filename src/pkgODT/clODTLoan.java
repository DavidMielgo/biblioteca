package pkgODT;

import java.sql.Date;


public class clODTLoan {
   private int id;
   private Date prestamos, devolucion;
   private String estado, idStudent, idBook;;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Date prestamos) {
        this.prestamos = prestamos;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Date devolucion) {
        this.devolucion = devolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }
    
    
}
