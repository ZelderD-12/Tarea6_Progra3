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
        BitacoraAplicación.agregartextarea(txabitacora);
        BitacoraAplicación.leerbitacora();
        this.setTitle("Arbol no Equilibrado y Equilibrado");
        simuladorBinario = new SimuladorArbolBinario();
        simuladorAVL = new SimuladorArbolBinario();
        txaNumeros.setEditable(false);
        txaNumeros.setBackground(Color.WHITE);
        txaNumeros.setForeground(Color.BLACK);
        BitacoraAplicación.agregaraccion("Iniciando el programa.");

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
        btnseleccionado = new javax.swing.JButton();
        btnRecorridos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txabitacora = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
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

        jPanel1.add(srcollAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 430, 230));

        txtOrdenamientos.setColumns(20);
        txtOrdenamientos.setRows(5);
        jScrollPane2.setViewportView(txtOrdenamientos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 380, 110));

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

        jPanel1.add(srcollBinario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 430, 220));

        btnstart.setBackground(new java.awt.Color(255, 204, 51));
        btnstart.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        btnstart.setForeground(new java.awt.Color(102, 51, 0));
        btnstart.setText("Start");
        btnstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstartActionPerformed(evt);
            }
        });
        jPanel1.add(btnstart, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 120, 30));

        btnstop.setBackground(new java.awt.Color(255, 204, 51));
        btnstop.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        btnstop.setForeground(new java.awt.Color(102, 51, 0));
        btnstop.setText("Stop");
        btnstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstopActionPerformed(evt);
            }
        });
        jPanel1.add(btnstop, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 120, 30));
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 120, -1));

        txaNumeros.setColumns(20);
        txaNumeros.setRows(5);
        jScrollPane1.setViewportView(txaNumeros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, 200));

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 0));
        jLabel1.setText("Bitácora");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, -1, -1));

        btnTXT.setBackground(new java.awt.Color(255, 204, 51));
        btnTXT.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        btnTXT.setForeground(new java.awt.Color(102, 51, 0));
        btnTXT.setText("Subir TXT");
        btnTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTXTActionPerformed(evt);
            }
        });
        jPanel1.add(btnTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 110, 40));

        btnDB.setBackground(new java.awt.Color(255, 204, 51));
        btnDB.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        btnDB.setForeground(new java.awt.Color(102, 51, 0));
        btnDB.setText("Cargar DB");
        btnDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDBActionPerformed(evt);
            }
        });
        jPanel1.add(btnDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 110, 40));

        BtnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        BtnEliminar.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        BtnEliminar.setForeground(new java.awt.Color(102, 51, 0));
        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 120, 30));

        BtnAgregar.setBackground(new java.awt.Color(153, 153, 255));
        BtnAgregar.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(102, 51, 0));
        BtnAgregar.setText("Insertar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 120, 30));

        BtnBuscar.setBackground(new java.awt.Color(153, 153, 255));
        BtnBuscar.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        BtnBuscar.setForeground(new java.awt.Color(102, 51, 0));
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 120, 30));

        txtarearepetidos.setColumns(20);
        txtarearepetidos.setRows(5);
        jScrollPane3.setViewportView(txtarearepetidos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 170, 200));

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText("Numeros Repetidos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 170, -1));

        btnseleccionado.setBackground(new java.awt.Color(255, 204, 51));
        btnseleccionado.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        btnseleccionado.setForeground(new java.awt.Color(102, 51, 0));
        btnseleccionado.setText("AVL");
        btnseleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnseleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 110, -1));

        btnRecorridos.setBackground(new java.awt.Color(255, 204, 51));
        btnRecorridos.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        btnRecorridos.setForeground(new java.awt.Color(102, 51, 0));
        btnRecorridos.setText("Recorridos");
        btnRecorridos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecorridosActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecorridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 310, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 51, 0));
        jLabel3.setText("Arbol Seleccionado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        txabitacora.setEditable(false);
        txabitacora.setColumns(20);
        txabitacora.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        txabitacora.setRows(5);
        jScrollPane5.setViewportView(txabitacora);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 1029, 210));

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 0));
        jLabel4.setText("Listado de numeros");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 150, -1));

        jLabel5.setFont(new java.awt.Font("Britannic Bold", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 51, 0));
        jLabel5.setText("Árboles");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstartActionPerformed
        BitacoraAplicación.agregaraccion("Botón iniciar presionado.");
        BitacoraAplicación.agregaraccion("Leyendo el contenido ingresado.");
        numeros = leerNumerosDeTextArea(txaNumeros);
        if (controlador != null && controlador.isAlive()) {
            BitacoraAplicación.agregaraccion("Contenido nulo.");
            controlador.detener();
        }
        controlador = new Control(numeros, srcollAVL, panelAVL, srcollBinario1, panelBinario1, txtarearepetidos);
        BitacoraAplicación.agregaraccion("Iniciando la operación.");
        controlador.start();
    }//GEN-LAST:event_btnstartActionPerformed

    private void btnstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstopActionPerformed
        if (controlador != null) {
            BitacoraAplicación.agregaraccion("Deteniendo la generación del árbol.");
            controlador.detener(); // Detiene el hilo
        }
    }//GEN-LAST:event_btnstopActionPerformed

    private void btnTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTXTActionPerformed
        // TODO add your handling code here:
        BitacoraAplicación.agregaraccion("Eligiendo arhcivo .txt a evaluar.");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo TXT");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                StringBuilder contenido = new StringBuilder();

                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                BitacoraAplicación.agregaraccion("Leyendo y almacenando el contenido del txt.");
                txaNumeros.setText(contenido.toString());
            } catch (IOException e) {
                BitacoraAplicación.agregaraccion("Error al leer el archivo.");
                JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnTXTActionPerformed

    private void btnDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDBActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Obtener datos con verificación de cancelación
            String host = solicitarDato("Ingrese el HOST:");
            if (host == null) {
                return; // Si se canceló, salir inmediatamente
            }
            String puerto = solicitarDato("Ingrese el PUERTO:");
            if (puerto == null) {
                return;
            }

            String user = solicitarDato("Ingrese el USER:");
            if (user == null) {
                return;
            }

            String password = solicitarDato("Ingrese el PASSWORD:");
            if (password == null) {
                return;
            }

            String nombreBD = solicitarDato("Ingrese el Nombre de la BD:");
            if (nombreBD == null) {
                return;
            }

            String nombreTabla = solicitarDato("Ingrese el Nombre de la Tabla:");
            if (nombreTabla == null) {
                return;
            }

            String nombreColumna = solicitarDato("Ingrese el Nombre de la Columna:");
            if (nombreColumna == null) {
                return;
            }

            // Construcción de la URL de conexión
            String url = "jdbc:mysql://" + host + ":" + puerto + "/" + nombreBD + "?useSSL=false&serverTimezone=UTC";

            // Intentamos conectar a la base de datos
            Connection con = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(this, "CONEXIÓN EXITOSA", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Ejecutamos la consulta
            String query = "SELECT " + nombreColumna + " FROM " + nombreTabla;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Mostrar datos en el JTextArea
            StringBuilder datos = new StringBuilder();
            while (rs.next()) {
                datos.append(rs.getString(1)).append("\n");
            }
            txaNumeros.setText(datos.toString());

            // Cerrar conexiones
            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error: No se encontró el driver JDBC de MySQL.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDBActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        if (txtcantidad.getText().trim().isEmpty()) {
            BitacoraAplicación.agregaraccion("Se detecta una inserción nula.");
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int numero = Integer.parseInt(txtcantidad.getText().trim());
            BitacoraAplicación.agregaraccion("Empezando la inserción.");
            // Llama al método insertar de la clase Control
            controlador.insertar(numero);

            txtcantidad.setText("");
        } catch (NumberFormatException e) {
            BitacoraAplicación.agregaraccion("Número inválido.");
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if (txtcantidad.getText().trim().isEmpty()) {
            BitacoraAplicación.agregaraccion("Se detecta una eliminación nula.");
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int numero = Integer.parseInt(txtcantidad.getText().trim());
            BitacoraAplicación.agregaraccion("Empezando la eliminación.");
            // Llama al método eliminar de la clase Control
            controlador.eliminar(numero);

            txtcantidad.setText("");
        } catch (NumberFormatException e) {
            BitacoraAplicación.agregaraccion("Valor inválido.");
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        if (txtcantidad.getText().trim().isEmpty()) {
            BitacoraAplicación.agregaraccion("Se detecta una búsqueda nula.");
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int numero = Integer.parseInt(txtcantidad.getText().trim());
            BitacoraAplicación.agregaraccion("Empezando la búsqueda.");
            // Llama al método buscar de la clase Control
            String resultado = controlador.buscar(numero);

            // Muestra el resultado en un cuadro de diálogo
            BitacoraAplicación.agregaraccion("Fin de la búsqueda.");
            JOptionPane.showMessageDialog(this, resultado, "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);

            txtcantidad.setText("");
        } catch (NumberFormatException e) {
            BitacoraAplicación.agregaraccion("Número inválido.");
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void btnseleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionadoActionPerformed
        if (btnseleccionado.getText() == "AVL") {
            btnseleccionado.setText("Binario");
            BitacoraAplicación.agregaraccion("Creando árbol AVL.");
            ArbolSeleccionado = "BinarioNoEquilibrado";
            System.out.println(ArbolSeleccionado);
        } else {
            BitacoraAplicación.agregaraccion("Creando árbol binario.");
            btnseleccionado.setText("AVL");
            ArbolSeleccionado = "AVL";
            System.out.println(ArbolSeleccionado);
        }
    }//GEN-LAST:event_btnseleccionadoActionPerformed

    private void btnRecorridosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorridosActionPerformed
        BitacoraAplicación.agregaraccion("Iniciando recorridos.");
        controlador.escribirRecorridos(txtOrdenamientos, ArbolSeleccionado);
    }//GEN-LAST:event_btnRecorridosActionPerformed

    private String solicitarDato(String mensaje) {
        String dato = JOptionPane.showInputDialog(null, mensaje, "Conexión a la Base de Datos", JOptionPane.QUESTION_MESSAGE);

        // Si el usuario presiona "Cancelar" o cierra la ventana, se interrumpe la solicitud
        if (dato == null) {
            return null; // Devuelve null para cancelar la operación
        }

        // Si el usuario deja el campo vacío, seguir pidiendo el dato
        while (dato.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Este campo es obligatorio. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            dato = JOptionPane.showInputDialog(null, mensaje, "Conexión a la Base de Datos", JOptionPane.QUESTION_MESSAGE);

            // Si el usuario cancela en el segundo intento, salir
            if (dato == null) {
                return null;
            }
        }

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelAVL;
    private javax.swing.JPanel panelBinario1;
    private javax.swing.JScrollPane srcollAVL;
    private javax.swing.JScrollPane srcollBinario1;
    private javax.swing.JTextArea txaNumeros;
    public javax.swing.JTextArea txabitacora;
    private javax.swing.JTextArea txtOrdenamientos;
    private javax.swing.JTextArea txtarearepetidos;
    private javax.swing.JTextField txtcantidad;
    // End of variables declaration//GEN-END:variables
}
