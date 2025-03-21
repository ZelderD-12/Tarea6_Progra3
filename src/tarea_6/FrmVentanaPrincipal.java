package tarea_6;


import arbol.SimuladorArbolBinario;
import java.awt.Color;
import static java.awt.SystemColor.control;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
public class FrmVentanaPrincipal extends javax.swing.JFrame {
   
    private SimuladorArbolBinario simuladorBinario; // Árbol binario
    private SimuladorArbolBinario simuladorAVL;     // Árbol AVL 
    private ArrayList<Integer> numeros;
    private Control controlador; // Controlador para manejar el hilo
     String ArbolSeleccionado = "AVL";


    public FrmVentanaPrincipal() {
        initComponents();
        simuladorBinario = new SimuladorArbolBinario();
        simuladorAVL = new SimuladorArbolBinario();
        txaNumeros.setEditable(false);
        txaNumeros.setBackground(Color.WHITE);
        txaNumeros.setForeground(Color.BLACK);
         
        System.out.println(ArbolSeleccionado);
    }
    
    private ArrayList<Integer> leerNumerosDeTextArea(JTextArea textArea) {
        ArrayList<Integer> numeros = new ArrayList<>();
        String texto = textArea.getText(); // Obtiene el texto del TextArea

        // Divide el texto en partes usando espacios, comas o saltos de línea como separadores
        String[] partes = texto.split("[\\s,\n]+");

        // Recorre las partes y convierte a números enteros
        for (String parte : partes) {
            try {
                int numero = Integer.parseInt(parte.trim()); // Convierte a entero
                numeros.add(numero); // Agrega el número al ArrayList
            } catch (NumberFormatException e) {
                // Ignora partes que no sean números
                System.out.println("Parte no válida: " + parte);
            }
        }

        return numeros;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        srcollAVL = new javax.swing.JScrollPane();
        panelAVL = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOrdenamientos = new javax.swing.JTextArea();
        srcollBinario1 = new javax.swing.JScrollPane();
        panelBinario1 = new javax.swing.JPanel();
        btnstart = new javax.swing.JButton();
        btnstop = new javax.swing.JButton();
        txtcantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaNumeros = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnTXT = new javax.swing.JButton();
        btnDB = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtarearepetidos = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBitacora = new javax.swing.JTextPane();
        btnseleccionado = new javax.swing.JButton();
        btnRecorridos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelAVLLayout = new javax.swing.GroupLayout(panelAVL);
        panelAVL.setLayout(panelAVLLayout);
        panelAVLLayout.setHorizontalGroup(
            panelAVLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        panelAVLLayout.setVerticalGroup(
            panelAVLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        srcollAVL.setViewportView(panelAVL);

        jPanel1.add(srcollAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 430, 240));

        txtOrdenamientos.setColumns(20);
        txtOrdenamientos.setRows(5);
        jScrollPane2.setViewportView(txtOrdenamientos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 380, 110));

        javax.swing.GroupLayout panelBinario1Layout = new javax.swing.GroupLayout(panelBinario1);
        panelBinario1.setLayout(panelBinario1Layout);
        panelBinario1Layout.setHorizontalGroup(
            panelBinario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        panelBinario1Layout.setVerticalGroup(
            panelBinario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        srcollBinario1.setViewportView(panelBinario1);

        jPanel1.add(srcollBinario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 430, 240));

        btnstart.setText("Start");
        btnstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstartActionPerformed(evt);
            }
        });
        jPanel1.add(btnstart, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 120, 50));

        btnstop.setText("Stop");
        btnstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstopActionPerformed(evt);
            }
        });
        jPanel1.add(btnstop, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 120, 50));
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 120, -1));

        txaNumeros.setColumns(20);
        txaNumeros.setRows(5);
        jScrollPane1.setViewportView(txaNumeros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 140, 200));

        jLabel1.setText("Números:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        btnTXT.setText("Subir TXT");
        btnTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTXTActionPerformed(evt);
            }
        });
        jPanel1.add(btnTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 110, 40));

        btnDB.setText("Cargar DB");
        btnDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDBActionPerformed(evt);
            }
        });
        jPanel1.add(btnDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 110, 40));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        BtnAgregar.setText("Insertar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 80, -1));

        txtarearepetidos.setColumns(20);
        txtarearepetidos.setRows(5);
        jScrollPane3.setViewportView(txtarearepetidos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 170, 200));

        jLabel2.setText("Repetidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 70, -1));

        jScrollPane4.setViewportView(txtBitacora);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 380, 60));

        btnseleccionado.setText("AVL");
        btnseleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnseleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 110, -1));

        btnRecorridos.setText("Recorridos");
        btnRecorridos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecorridosActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecorridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 310, -1));

        jLabel3.setText("Arbol Seleccionado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstartActionPerformed
         numeros = leerNumerosDeTextArea(txaNumeros); 
        if (controlador != null && controlador.isAlive()) {
            controlador.detener(); 
        }
        controlador = new Control(numeros, srcollAVL, panelAVL,srcollBinario1,panelBinario1,txtarearepetidos); 
        controlador.start(); 
    }//GEN-LAST:event_btnstartActionPerformed

    private void btnstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstopActionPerformed
        if (controlador != null) {
            controlador.detener(); // Detiene el hilo
        }
    }//GEN-LAST:event_btnstopActionPerformed

    private void btnTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTXTActionPerformed
        // TODO add your handling code here:
        BitacoraAplicación.agregaraccion("Se selecciona el botón para subir un archivo .txt .");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo TXT");
        BitacoraAplicación.agregaraccion("Se abre el selector de archivos.");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            BitacoraAplicación.agregaraccion("El archivo ha sido seleccionado.");
            File archivo = fileChooser.getSelectedFile();
            
            BitacoraAplicación.agregaraccion("Se evalúa si es un archivo .txt legible.");
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                StringBuilder contenido = new StringBuilder();
                
                BitacoraAplicación.agregaraccion("Se empiezan a leer todas sus líneas.");
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }

                txaNumeros.setText(contenido.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                BitacoraAplicación.agregaraccion("Ocurrio un error al leer el archivo .txt .");
            }
        }
    }//GEN-LAST:event_btnTXTActionPerformed

    private void btnDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDBActionPerformed
        // TODO add your handling code here:
        // Método para solicitar datos obligatorios
        BitacoraAplicación.agregaraccion("Se selecciona el botón para cargar datos desde una base de datos.");
        BitacoraAplicación.agregaraccion("Se solicitan datos para conectarse a la base de datos.");
        BitacoraAplicación.agregaraccion("Se solicita ingresar un host.");
        String host = solicitarDato("Ingrese el HOST:");
        BitacoraAplicación.agregaraccion("Se solicita ingresar un puerto.");
        String puerto = solicitarDato("Ingrese el PUERTO:");
        BitacoraAplicación.agregaraccion("Se solicita ingresar un nombre de usuario.");
        String user = solicitarDato("Ingrese el USER:");
        BitacoraAplicación.agregaraccion("Se solicita ingresar una contraseña.");
        String password = solicitarDato("Ingrese el PASSWORD:");
        BitacoraAplicación.agregaraccion("Se solicita ingresar el nombre de la base de datos.");
        String nombreBD = solicitarDato("Ingrese el Nombre de la BD:");
        BitacoraAplicación.agregaraccion("Se solicita ingresar un nombre de una tabla ubiacada dentro de la base de datos.");
        String nombreTabla = solicitarDato("Ingrese el Nombre de la Tabla:");
        BitacoraAplicación.agregaraccion("Se solicita ingresar el nombre de una columna ubicada dentro de la tabla.");
        String nombreColumna = solicitarDato("Ingrese el Nombre de la Columna:");

        // Construimos la URL de conexión
        BitacoraAplicación.agregaraccion("Se construye una cadena de conexión con los datos proporcionados.");
        String url = "jdbc:mysql://" + host + ":" + puerto + "/" + nombreBD;
        
        BitacoraAplicación.agregaraccion("Se evalúa si es posible conectarse con la base de datos.");
        try {
            // Intentamos conectar a la base de datos
            Connection con = DriverManager.getConnection(url, user, password);
            BitacoraAplicación.agregaraccion("Se confirma que la conexión se realizó exitosamente.");
            JOptionPane.showMessageDialog(this, "CONEXIÓN EXITOSA", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Ejecutamos la consulta para obtener los datos de la columna
            BitacoraAplicación.agregaraccion("Se ejecuta una consulta de búsqueda dentro de la base de datos.");
            String query = "SELECT " + nombreColumna + " FROM " + nombreTabla;
            Statement stmt = con.createStatement();
            BitacoraAplicación.agregaraccion("Los datos obtenidos de la búsqueda se guardan en una tabla temporal a nivel interno en el programa.");
            ResultSet rs = stmt.executeQuery(query);
            
            BitacoraAplicación.agregaraccion("Se reconstruyen los resultados en un nuevo objeto para ser legibles y capaces de mostrar en el programa.");
            // Construimos el texto para el JTextArea
            StringBuilder datos = new StringBuilder();
            while (rs.next()) {
                datos.append(rs.getString(1)).append("\n");
            }

            // Mostramos los datos en el JTextArea
            BitacoraAplicación.agregaraccion("Se muestran los resultados en el programa.");
            txaNumeros.setText(datos.toString());

            // Cerramos la conexión
            rs.close();
            BitacoraAplicación.agregaraccion("Se cierra la tabla temporal a nivel interno.");
            BitacoraAplicación.agregaraccion("Se cierra el ejecutor de consultas.");
            stmt.close();
            BitacoraAplicación.agregaraccion("Se cierra la conexión.");
            con.close();

        } catch (SQLException e) {
            BitacoraAplicación.agregaraccion("La conexión a la base de datos falló.");
            JOptionPane.showMessageDialog(this, "Error al conectar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDBActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
      if (txtcantidad.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int numero = Integer.parseInt(txtcantidad.getText().trim());

        // Llama al método insertar de la clase Control
        controlador.insertar(numero);

        txtcantidad.setText("");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
         if (txtcantidad.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int numero = Integer.parseInt(txtcantidad.getText().trim());

        // Llama al método eliminar de la clase Control
        controlador.eliminar(numero);

        txtcantidad.setText("");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
       if (txtcantidad.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int numero = Integer.parseInt(txtcantidad.getText().trim());

        // Llama al método buscar de la clase Control
        String resultado = controlador.buscar(numero);

        // Muestra el resultado en un cuadro de diálogo
        JOptionPane.showMessageDialog(this, resultado, "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);

        txtcantidad.setText("");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void btnseleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionadoActionPerformed
        if (btnseleccionado.getText() == "AVL") {
            btnseleccionado.setText("Binario");
            ArbolSeleccionado = "BinarioNoEquilibrado";
            System.out.println(ArbolSeleccionado);
        }
        else{
             btnseleccionado.setText("AVL");
            ArbolSeleccionado = "AVL";
            System.out.println(ArbolSeleccionado);
        }
    }//GEN-LAST:event_btnseleccionadoActionPerformed

    private void btnRecorridosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorridosActionPerformed
      controlador.escribirRecorridos(txtOrdenamientos, ArbolSeleccionado);
    }//GEN-LAST:event_btnRecorridosActionPerformed

    // Método para solicitar datos y evitar valores vacíos
    private String solicitarDato(String mensaje) {
        String dato;
        do {
            dato = JOptionPane.showInputDialog(null, mensaje, "Conexión a la Base de Datos", JOptionPane.QUESTION_MESSAGE);
            if (dato == null || dato.trim().isEmpty()) {
                BitacoraAplicación.agregaraccion("Se intentó avanzar sin ingresar los datos solicitados.");
                JOptionPane.showMessageDialog(null, "Este campo es obligatorio. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (dato == null || dato.trim().isEmpty());
        return dato;
    }

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
            java.util.logging.Logger.getLogger(FrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton btnDB;
    private javax.swing.JButton btnRecorridos;
    private javax.swing.JButton btnTXT;
    private javax.swing.JButton btnseleccionado;
    private javax.swing.JButton btnstart;
    private javax.swing.JButton btnstop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelAVL;
    private javax.swing.JPanel panelBinario1;
    private javax.swing.JScrollPane srcollAVL;
    private javax.swing.JScrollPane srcollBinario1;
    private javax.swing.JTextArea txaNumeros;
    private javax.swing.JTextPane txtBitacora;
    private javax.swing.JTextArea txtOrdenamientos;
    private javax.swing.JTextArea txtarearepetidos;
    private javax.swing.JTextField txtcantidad;
    // End of variables declaration//GEN-END:variables
}
