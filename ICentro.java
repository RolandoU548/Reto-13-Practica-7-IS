import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import java.awt.Dimension;

class Equipo {
        private String descripcion;
        private int cantidad;
        private double costoUnitario;
        private String fechaAdquisicion;
        private String nroFactura;
        private String ciResponsable;

        public Equipo(String descripcion, int cantidad, double costoUnitario, String fechaAdquisicion,
                        String nroFactura, String ciResponsable) {
                this.descripcion = descripcion;
                this.cantidad = cantidad;
                this.costoUnitario = costoUnitario;
                this.fechaAdquisicion = fechaAdquisicion;
                this.nroFactura = nroFactura;
                this.ciResponsable = ciResponsable;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public int getCantidad() {
                return cantidad;
        }

        public double getCostoUnitario() {
                return costoUnitario;
        }

        public String getFechaAdquisicion() {
                return fechaAdquisicion;
        }

        public String getNroFactura() {
                return nroFactura;
        }

        public String getCiResponsable() {
                return ciResponsable;
        }
}

class IReporte extends JFrame {
        public IReporte(ArrayList<Equipo> listaEquipos) {
                this.listaEquipos = listaEquipos;
                initComponents();
        }

        private void initComponents() {

                buttonGroup = new ButtonGroup();
                jRadioButton1 = new JRadioButton();
                jRadioButton2 = new JRadioButton();
                jLabel1 = new JLabel();
                jButton1 = new JButton();
                jLabel2 = new JLabel();
                jButton2 = new JButton();
                jTextField1 = new JTextField();
                jLabel3 = new JLabel();
                jLabel4 = new JLabel();
                jLabel5 = new JLabel();
                jMenuBar1 = new JMenuBar();
                jMenu1 = new JMenu();

                setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                buttonGroup.add(jRadioButton1);
                jRadioButton1.setText("Individual");
                jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jRadioButton1ActionPerformed(evt);
                        }
                });

                buttonGroup.add(jRadioButton2);
                jRadioButton2.setText("General");
                jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jRadioButton2ActionPerformed(evt);
                        }
                });

                jLabel1.setText("Tipo de reporte:");

                jButton1.setText("Continuar");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jLabel2.setText("C.I. del Responsable de equipos:");

                jButton2.setText("Totalizar");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jLabel3.setText("Totalización:");

                jLabel4.setText("___ equipos");

                jLabel5.setText("_________ Bs.");

                jMenuBar1.setForeground(new java.awt.Color(153, 153, 153));
                jMenuBar1.setPreferredSize(new java.awt.Dimension(316, 50));

                jMenu1.setBackground(new java.awt.Color(255, 255, 255));
                jMenu1.setForeground(new java.awt.Color(255, 255, 255));
                jMenu1.setText("Reporte del Inventario del Centro de Investigación");
                jMenu1.setForeground(new java.awt.Color(255, 255, 255));

                jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
                jMenuBar1.add(jMenu1);

                setJMenuBar(jMenuBar1);

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);

                cardLayout1 = new CardLayout();
                jPanel1 = new JPanel(cardLayout1);

                JPanel jPanel2 = new JPanel();
                jPanel2.add(jLabel2);
                jTextField1.setColumns(8);
                jPanel2.add(jTextField1);
                jPanel2.add(jButton2);
                jPanel1.add(jPanel2, "individual");

                JTable jTable1 = new JTable();
                int n = listaEquipos.size();
                Object[][] model = new Object[n][3];
                for (int i = 0; i < n; i++) {
                        Equipo equipo = listaEquipos.get(i);
                        model[i][0] = equipo.getCiResponsable();
                        model[i][1] = equipo.getCantidad();
                        model[i][2] = equipo.getCostoUnitario() * equipo.getCantidad();
                }
                jTable1.setModel(new DefaultTableModel(
                                model,
                                new String[] {
                                                "C.I. Responsable", "Cantidad Equipos", "Monto Total (Bs.)"
                                }) {
                        Class<?>[] types = new Class[] {
                                        java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
                        };

                        public Class<?> getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int row, int column) {
                                return false;
                        }
                });
                JScrollPane jPanel3 = new JScrollPane(jTable1);
                jPanel3.setPreferredSize(new Dimension(200, 75));
                jPanel1.add(jPanel3, "general");

                layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup().addGap(15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup().addComponent(jLabel1)
                                                                .addGap(30).addComponent(jRadioButton1).addGap(18)
                                                                .addComponent(jRadioButton2).addGap(92))
                                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jPanel1)
                                                                .addGroup(layout.createSequentialGroup().addGap(27)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                GroupLayout.Alignment.CENTER)
                                                                                                .addComponent(jLabel3)
                                                                                                .addComponent(jLabel4)
                                                                                                .addComponent(jLabel5))
                                                                                .addPreferredGap(
                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton1)))
                                                                .addGap(14)))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(17)
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.CENTER)
                                                                                .addComponent(jRadioButton1)
                                                                                .addComponent(jRadioButton2)
                                                                                .addComponent(jLabel1))
                                                                .addGap(18)
                                                                .addComponent(jPanel1)
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton1)
                                                                                                .addGap(14))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(18)
                                                                                                .addComponent(jLabel3)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jLabel4)
                                                                                                .addGap(8)
                                                                                                .addComponent(jLabel5)
                                                                                                .addContainerGap(34,
                                                                                                                Short.MAX_VALUE)))));
                setUndecorated(true);
                pack();
        }

        private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                jLabel4.setText("___ equipos");
                jLabel5.setText("_________ Bs.");
                jTextField1.setText("");
                cardLayout1.show(jPanel1, "individual");
        }

        private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
                int cantidadEquipos = 0;
                double precioEquipos = 0;
                for (Equipo equipo : listaEquipos) {
                        cantidadEquipos += equipo.getCantidad();
                        precioEquipos += equipo.getCantidad() * equipo.getCostoUnitario();
                }
                jLabel4.setText(cantidadEquipos + " equipos");
                jLabel5.setText(precioEquipos + " Bs.");
                cardLayout1.show(jPanel1, "general");
        }

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
                if (jTextField1.getText() != null && !jTextField1.getText().isEmpty()) {
                        int cantidadEquipos = 0;
                        double precioEquipos = 0;
                        for (Equipo equipo : listaEquipos) {
                                if (equipo.getCiResponsable().equals(jTextField1.getText())) {
                                        cantidadEquipos += equipo.getCantidad();
                                        precioEquipos += equipo.getCantidad() * equipo.getCostoUnitario();
                                }
                        }
                        jLabel4.setText(cantidadEquipos + " equipos");
                        jLabel5.setText(precioEquipos + " Bs.");
                }
        }

        private ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
        CardLayout cardLayout1;
        JPanel jPanel1;
        private ButtonGroup buttonGroup;
        private JButton jButton1;
        private JButton jButton2;
        private JLabel jLabel1;
        private JLabel jLabel2;
        private JLabel jLabel3;
        private JLabel jLabel4;
        private JLabel jLabel5;
        private JMenu jMenu1;
        private JMenuBar jMenuBar1;
        private JRadioButton jRadioButton1;
        private JRadioButton jRadioButton2;
        private JTextField jTextField1;
}

public class ICentro extends JFrame {
        public static void main(String[] args) {
                new ICentro().setVisible(true);
        }

        public ICentro() {
                initComponents();
        }

        private void initComponents() {
                jFrame1 = new JFrame();
                jTextField1 = new JTextField();
                jTextField2 = new JTextField();
                jLabel1 = new JLabel();
                jLabel2 = new JLabel();
                jLabel3 = new JLabel();
                jLabel4 = new JLabel();
                jLabel5 = new JLabel();
                jLabel6 = new JLabel();
                jLabel7 = new JLabel();
                jLabel8 = new JLabel();
                jButton1 = new JButton();
                jButton2 = new JButton();
                jButton3 = new JButton();
                jTextField3 = new JTextField();
                jTextField4 = new JTextField();
                jTextField5 = new JTextField();
                jTextField6 = new JTextField();
                jMenuBar1 = new JMenuBar();
                jMenu1 = new JMenu();

                GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
                jFrame1.getContentPane().setLayout(jFrame1Layout);
                jFrame1Layout.setHorizontalGroup(
                                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 400, Short.MAX_VALUE));
                jFrame1Layout.setVerticalGroup(
                                jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 300, Short.MAX_VALUE));

                setDefaultCloseOperation(EXIT_ON_CLOSE);

                jLabel1.setText("Ingrese data del equipo:");

                jLabel2.setText("Descripción:");

                jLabel3.setText("Cantidad:");

                jLabel4.setText("Costo unitario (Bs.):");

                jLabel5.setText("Fecha de adquisición:");

                jLabel6.setText("dd/mm/aaaa");

                jLabel7.setText("Nro. de factura:");

                jLabel8.setText("C.I. del Responsable del equipo:");

                jButton1.setText("Generar Reporte");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jButton2.setText("Registrar data");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jButton3.setText("Salir");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                jMenuBar1.setPreferredSize(new java.awt.Dimension(300, 40));
                jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));

                jMenu1.setText("Registro y Control de Equipos en Centro de Investigación");
                jMenu1.setForeground(new java.awt.Color(255, 255, 255));
                jMenuBar1.add(jMenu1);

                setJMenuBar(jMenuBar1);

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);

                layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                                GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addContainerGap().addComponent(jButton2).addGap(18)
                                                .addComponent(jButton1).addGap(18).addComponent(jButton3).addGap(18))
                                .addGroup(layout.createSequentialGroup().addGap(44).addGroup(layout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1)
                                                .addGroup(layout.createSequentialGroup().addComponent(jLabel8)
                                                                .addGap(18).addComponent(jTextField6,
                                                                                GroupLayout.PREFERRED_SIZE, 75,
                                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2).addComponent(jLabel3)).addGap(18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jTextField1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                490,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jTextField2,
                                                                                                                50,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(300)
                                                                                                .addComponent(jTextField3))))
                                                .addComponent(jLabel6)
                                                .addGroup(layout.createSequentialGroup().addComponent(jLabel5)
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(180)
                                                                                                .addComponent(jLabel4))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(18)
                                                                                                .addComponent(jTextField4)
                                                                                                .addGap(18)
                                                                                                .addComponent(jLabel7)))
                                                                .addGap(18).addComponent(jTextField5)))
                                                .addGap(60, 60, 60)));
                layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup().addGap(28).addComponent(jLabel1).addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2))
                                .addGap(35)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(40)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5).addComponent(jLabel7)
                                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel6)
                                .addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel8)
                                                .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(65)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton2).addComponent(jButton1).addComponent(jButton3))
                                .addContainerGap(22, Short.MAX_VALUE)));
                setUndecorated(true);
                pack();
                setResizable(false);
                setLocationRelativeTo(null);
        }

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                try (FileWriter fw = new FileWriter("report.txt", false);
                                BufferedWriter bw = new BufferedWriter(fw);
                                PrintWriter out = new PrintWriter(bw)) {
                        for (Equipo equipo : listaEquipos) {
                                out.println(equipo.getDescripcion() + "#" + equipo.getCantidad() + "#"
                                                + equipo.getCostoUnitario() + "#'"
                                                + equipo.getFechaAdquisicion().substring(0, 2) + "'/'"
                                                + equipo.getFechaAdquisicion().substring(3, 5) + "'/'"
                                                + equipo.getFechaAdquisicion().substring(6, 10) + "'#"
                                                + equipo.getNroFactura() + "#"
                                                + equipo.getCiResponsable() + ";");
                        }
                } catch (IOException e) {
                        System.err.println(e.getMessage());
                }
                IReporte IReporte = new IReporte(listaEquipos);
                IReporte.setLocationRelativeTo(this);
                IReporte.setVisible(true);
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
                if (jTextField1.getText() != null && jTextField2.getText() != null
                                && jTextField3.getText() != null &&
                                jTextField4.getText() != null && jTextField5.getText() != null
                                && jTextField6.getText() != null && !jTextField1.getText().isEmpty()
                                && !jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty()
                                && !jTextField4.getText().isEmpty() && !jTextField5.getText().isEmpty()
                                && !jTextField6.getText().isEmpty()) {
                        Equipo equipo = new Equipo(jTextField1.getText(), Integer.parseInt(jTextField2.getText()),
                                        Double.parseDouble(jTextField3.getText()), jTextField4.getText(),
                                        jTextField5.getText(),
                                        jTextField6.getText());
                        listaEquipos.add(equipo);
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                        jTextField4.setText("");
                        jTextField5.setText("");
                        jTextField6.setText("");
                }
        }

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                System.exit(0);
        }

        private ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
        private JButton jButton1;
        private JButton jButton2;
        private JButton jButton3;
        private JFrame jFrame1;
        private JLabel jLabel1;
        private JLabel jLabel2;
        private JLabel jLabel3;
        private JLabel jLabel4;
        private JLabel jLabel5;
        private JLabel jLabel6;
        private JLabel jLabel7;
        private JLabel jLabel8;
        private JMenu jMenu1;
        private JMenuBar jMenuBar1;
        private JTextField jTextField1;
        private JTextField jTextField2;
        private JTextField jTextField3;
        private JTextField jTextField4;
        private JTextField jTextField5;
        private JTextField jTextField6;
}