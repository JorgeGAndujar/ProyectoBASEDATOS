package csv_to_mysql;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class VentanaMostrarAlumnos extends javax.swing.JFrame {

    String[] cabecera = {"idAlumno", "NombreyApellido", "Sexo", "FechaNacimiento"};
    String[][] cuerpo = {};
    DefaultTableModel dtm = new DefaultTableModel(cuerpo, cabecera);

    ConexionMysql cm = new ConexionMysql("INSTITUTO");
    Connection conexion = cm.getConexion();

    public VentanaMostrarAlumnos() {
        initComponents();
        personalizarTable();
        personalizarVentana();

    }

    public void personalizarTable() {
        tblMostrar.setModel(dtm);
        //Obtener el tablecolimnModel del Jtable
        TableColumnModel columnModel = tblMostrar.getColumnModel();
        TableColumn column = columnModel.getColumn(1);

        //Establecer el ancho preferido, mínimo y máximo para la columna
        column.setPreferredWidth(200);
        column.setMinWidth(50);
        column.setMaxWidth(200);
    }

    public void personalizarVentana() {
        ImageIcon icono = new ImageIcon("image/cross1.png");
        Image image = icono.getImage();
        this.setIconImage(image);//Cambiar el icono de la ventana

        this.setTitle("GUI SWING");
        this.setResizable(false); //No se redimensione
        this.setLocationRelativeTo(null);//Colocar la ventana en el centro de la pantalla
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        cmdCargar = new javax.swing.JButton();
        cmdLimpiar = new javax.swing.JButton();
        cmdSalir = new javax.swing.JButton();
        cmdAñadir = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMostrar);

        cmdCargar.setText("CARGAR");
        cmdCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCargarActionPerformed(evt);
            }
        });

        cmdLimpiar.setText("LIMPIAR");
        cmdLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLimpiarActionPerformed(evt);
            }
        });

        cmdSalir.setText("SALIR");
        cmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalirActionPerformed(evt);
            }
        });

        cmdAñadir.setText("AÑADIR");
        cmdAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAñadirActionPerformed(evt);
            }
        });

        cmdGuardar.setText("GUARDAR");
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cmdCargar)
                .addGap(18, 18, 18)
                .addComponent(cmdLimpiar)
                .addGap(18, 18, 18)
                .addComponent(cmdSalir)
                .addGap(18, 18, 18)
                .addComponent(cmdAñadir)
                .addGap(18, 18, 18)
                .addComponent(cmdGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCargar)
                    .addComponent(cmdLimpiar)
                    .addComponent(cmdSalir)
                    .addComponent(cmdAñadir)
                    .addComponent(cmdGuardar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCargarActionPerformed
        limpiar();
        List<Alumno> alumnos_al = obtenerTodosLosRegistros();
        String[] filaBlanco = {"", "", "", ""};//AÑADIR UNA FILA EN BLANCO
        for (int i = 0; i < alumnos_al.size(); i++) {
            dtm.addRow(filaBlanco);
            Alumno alumno = alumnos_al.get(i);
            dtm.setValueAt(alumno.getIdAlumno(), i, 0);
            dtm.setValueAt(alumno.getNombreApellido(), i, 1);
            dtm.setValueAt(alumno.getSexo(), i, 2);
            dtm.setValueAt(alumno.getFechaNacimiento(), i, 3);
        }
    }//GEN-LAST:event_cmdCargarActionPerformed
    public List<Alumno> obtenerTodosLosRegistros() {
        List<Alumno> alumnos_al = new ArrayList<>();
        String sql = "SELECT * FROM Alumno";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String nombreApellido = rs.getString("nombre_apellido");
                String sexo = rs.getString("sexo");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                Alumno alumno = new Alumno(idAlumno, nombreApellido, sexo, fechaNacimiento);
                alumnos_al.add(alumno);
            }
        } catch (SQLException e) {
            alumnos_al = null;
        }
        return alumnos_al;
    }
    private void cmdLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_cmdLimpiarActionPerformed
    public void limpiar() {
        int numeroFilas = dtm.getRowCount();
        for (int j = 0; j < numeroFilas; j++) {
            dtm.removeRow(0);

        }
    }
    private void cmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalirActionPerformed
        dispose();
        System.exit(0);// TODO add your handling code here:
    }//GEN-LAST:event_cmdSalirActionPerformed

    private void cmdAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAñadirActionPerformed
        String[] filaBlanco = {"", "", "", ""};//AÑADIR UNA FILA EN BLANCO
        dtm.addRow(filaBlanco);

    }//GEN-LAST:event_cmdAñadirActionPerformed
    public boolean insertarAlumno(Alumno alumno) {
        boolean correcto = true;
        String sql = "INSERT INTO Alumno (idAlumno, nombre_apellido, sexo, fecha_nacimiento) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, alumno.getIdAlumno());
            ps.setString(2, alumno.getNombreApellido());
            ps.setString(3, alumno.getSexo());
            ps.setDate(4, alumno.getFechaNacimiento());

            ps.executeUpdate();
        } catch (SQLException e) {
            correcto = false;
            e.printStackTrace(); // Considera registrar la excepción en lugar de imprimirla
        }

        return correcto;
    }
    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        // Obtener los datos de los campos de texto
        int numeroFilas = dtm.getRowCount();
        for (int i = 0; i < numeroFilas; i++) {
            int idAlumno = Integer.parseInt(String.valueOf(dtm.getValueAt(i, 0)));
            String nombre_apellido = String.valueOf(dtm.getValueAt(i, 1));
            String sexo = String.valueOf(dtm.getValueAt(i, 2));
            String fechaNacimiento = String.valueOf(dtm.getValueAt(i, 3));
            Date fechaNacimientoDate = Date.valueOf(LocalDate.parse(fechaNacimiento));
            
            // Crear un objeto Alumno con los datos obtenidos
            Alumno alumno = new Alumno(idAlumno, nombre_apellido, sexo, fechaNacimientoDate);

            // Insertar el Alumno en la base de datos
            boolean resultado = insertarAlumno(alumno);

            if (resultado) {
                // Si la inserción es correcta, agregar el alumno al modelo de la tabla
                
                JOptionPane.showMessageDialog(this, "Alumno insertado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al insertar Alumno");
            }
        }

    }//GEN-LAST:event_cmdGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaMostrarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMostrarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMostrarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMostrarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMostrarAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAñadir;
    private javax.swing.JButton cmdCargar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdLimpiar;
    private javax.swing.JButton cmdSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMostrar;
    // End of variables declaration//GEN-END:variables
}
