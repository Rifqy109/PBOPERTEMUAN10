import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Import untuk fungsionalitas kalkulator
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AplikasiKalkulator extends JFrame implements ActionListener {

    // --- Deklarasi Komponen ---
    JTextField txtDisplay;
    JPanel panelDisplay;

    // Baris 1
    JButton btn8, btn7, btn9, btnPlus, btnMinus;
    // Baris 2
    JButton btn4, btn5, btn6, btnKali, btnBagi;
    // Baris 3
    JButton btn1, btn2, btn3, btnEquals, btnPersen;
    // Baris 4
    JButton btnTitik, btn0, btnC, btnB, btnE;
    
    // Engine untuk menghitung string
    private ScriptEngine engine;

    public AplikasiKalkulator() {
        initComponents();
        
        // Inisialisasi ScriptEngine untuk kalkulator
        ScriptEngineManager mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("JavaScript");
    }

    private void initComponents() {
        // --- Pengaturan JFrame ---
        setTitle("Aplikasi Kalkulator");
        setSize(350, 460); // Atur ukuran frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Tampilkan di tengah layar
        getContentPane().setLayout(null); // Gunakan layout absolut

        // --- Panel Display (Merah Muda) ---
        panelDisplay = new JPanel();
        panelDisplay.setBounds(20, 20, 290, 50);
        panelDisplay.setBackground(new Color(255, 204, 204)); // Warna Pink
        panelDisplay.setLayout(new BorderLayout()); // Agar text field bisa memenuhi panel
        getContentPane().add(panelDisplay);

        txtDisplay = new JTextField();
        txtDisplay.setEditable(false); // Tidak bisa diketik manual
        txtDisplay.setBackground(Color.WHITE);
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT); // Teks rata kanan
        txtDisplay.setFont(new Font("Tahoma", Font.BOLD, 24));
        panelDisplay.add(txtDisplay, BorderLayout.CENTER);

        // --- Definisi Tombol ---
        // Mengatur posisi (x, y) dan ukuran (lebar, tinggi)
        int btnWidth = 50;
        int btnHeight = 50;
        int hGap = 10;
        int vGap = 10;
        int startX = 20;
        int startY = 90;

        // --- Baris 1 (8, 7, 9, +, -) ---
        btn8 = new JButton("8");
        btn8.setBounds(startX, startY, btnWidth, btnHeight);
        getContentPane().add(btn8);

        btn7 = new JButton("7");
        btn7.setBounds(startX + (btnWidth + hGap), startY, btnWidth, btnHeight);
        getContentPane().add(btn7);

        btn9 = new JButton("9");
        btn9.setBounds(startX + 2 * (btnWidth + hGap), startY, btnWidth, btnHeight);
        getContentPane().add(btn9);

        btnPlus = new JButton("+");
        btnPlus.setBounds(startX + 3 * (btnWidth + hGap), startY, btnWidth, btnHeight);
        getContentPane().add(btnPlus);

        btnMinus = new JButton("-");
        btnMinus.setBounds(startX + 4 * (btnWidth + hGap), startY, btnWidth, btnHeight);
        getContentPane().add(btnMinus);

        // --- Baris 2 (4, 5, 6, *, /) ---
        int row2Y = startY + (btnHeight + vGap);
        btn4 = new JButton("4");
        btn4.setBounds(startX, row2Y, btnWidth, btnHeight);
        getContentPane().add(btn4);

        btn5 = new JButton("5");
        btn5.setBounds(startX + (btnWidth + hGap), row2Y, btnWidth, btnHeight);
        getContentPane().add(btn5);

        btn6 = new JButton("6");
        btn6.setBounds(startX + 2 * (btnWidth + hGap), row2Y, btnWidth, btnHeight);
        getContentPane().add(btn6);

        btnKali = new JButton("*");
        btnKali.setBounds(startX + 3 * (btnWidth + hGap), row2Y, btnWidth, btnHeight);
        getContentPane().add(btnKali);

        btnBagi = new JButton("/");
        btnBagi.setBounds(startX + 4 * (btnWidth + hGap), row2Y, btnWidth, btnHeight);
        getContentPane().add(btnBagi);

        // --- Baris 3 (1, 2, 3, =, %) ---
        int row3Y = row2Y + (btnHeight + vGap);
        btn1 = new JButton("1");
        btn1.setBounds(startX, row3Y, btnWidth, btnHeight);
        getContentPane().add(btn1);

        btn2 = new JButton("2");
        btn2.setBounds(startX + (btnWidth + hGap), row3Y, btnWidth, btnHeight);
        getContentPane().add(btn2);

        btn3 = new JButton("3");
        btn3.setBounds(startX + 2 * (btnWidth + hGap), row3Y, btnWidth, btnHeight);
        getContentPane().add(btn3);

        btnEquals = new JButton("=");
        btnEquals.setBounds(startX + 3 * (btnWidth + hGap), row3Y, btnWidth, btnHeight);
        getContentPane().add(btnEquals);

        btnPersen = new JButton("%");
        btnPersen.setBounds(startX + 4 * (btnWidth + hGap), row3Y, btnWidth, btnHeight);
        getContentPane().add(btnPersen);

        // --- Baris 4 (., 0, C, B, E) ---
        int row4Y = row3Y + (btnHeight + vGap);
        btnTitik = new JButton(".");
        btnTitik.setBounds(startX, row4Y, btnWidth, btnHeight);
        getContentPane().add(btnTitik);

        btn0 = new JButton("0");
        btn0.setBounds(startX + (btnWidth + hGap), row4Y, btnWidth, btnHeight);
        getContentPane().add(btn0);

        btnC = new JButton("C");
        btnC.setBounds(startX + 2 * (btnWidth + hGap), row4Y, btnWidth, btnHeight);
        getContentPane().add(btnC);

        btnB = new JButton("B");
        btnB.setBounds(startX + 3 * (btnWidth + hGap), row4Y, btnWidth, btnHeight);
        getContentPane().add(btnB);

        btnE = new JButton("E");
        btnE.setBounds(startX + 4 * (btnWidth + hGap), row4Y, btnWidth, btnHeight);
        getContentPane().add(btnE);
        
        
        // --- Mendaftarkan Semua Tombol ke ActionListener ---
        // Gunakan 'this' karena class ini meng-implement ActionListener
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnTitik.addActionListener(this);
        
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnKali.addActionListener(this);
        btnBagi.addActionListener(this);
        btnPersen.addActionListener(this);
        
        btnEquals.addActionListener(this);
        btnC.addActionListener(this);
        btnB.addActionListener(this);
        btnE.addActionListener(this);
    }
    
    // --- Method untuk Menangani Klik Tombol ---
    @Override
    public void actionPerformed(ActionEvent e) {
        // Dapatkan teks dari tombol yang diklik
        String command = e.getActionCommand();
        String currentText = txtDisplay.getText();

        switch (command) {
            case "C":
                // Clear
                txtDisplay.setText("");
                break;
            case "E":
                // Exit
                System.exit(0);
                break;
            case "B":
                // Backspace
                if (!currentText.isEmpty()) {
                    txtDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
                break;
            case "=":
                // Hitung (Evaluate)
                try {
                    // Gunakan ScriptEngine untuk mengevaluasi string matematika
                    String result = engine.eval(currentText).toString();
                    txtDisplay.setText(result);
                } catch (ScriptException ex) {
                    // Tangani jika ada error (misal: "1+/5")
                    txtDisplay.setText("Error");
                }
                break;
            default:
                // Tombol angka, titik, dan operator
                // Tambahkan teks tombol ke display
                txtDisplay.setText(currentText + command);
                break;
        }
    }

    // --- Main Method untuk Menjalankan Aplikasi ---
    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (EDT)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiKalkulator().setVisible(true);
            }
        });
    }
}