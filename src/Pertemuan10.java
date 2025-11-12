import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pertemuan10 extends JFrame {

    // --- Deklarasi Komponen GUI ---
    // Panel
    JPanel panelNama;
    JPanel panelNilai;
    JPanel panelHasil;

    // Label
    JLabel lblNamaLengkap;
    JLabel lblTugasMurni;
    JLabel lblUTS;
    JLabel lblUAS;
    
    // Label untuk Panel Hasil (Static)
    JLabel lblStaticNama;
    JLabel lblStaticRata;
    JLabel lblStaticGrade;
    JLabel lblStaticHasil;

    // Label untuk Panel Hasil (Dinamis/Output)
    JLabel lblOutputNama;
    JLabel lblOutputRata;
    JLabel lblOutputGrade;
    JLabel lblOutputHasil;

    // Text Field
    JTextField txtNamaLengkap;
    JTextField txtTugasMurni;
    JTextField txtUTS;
    JTextField txtUAS;

    // Button
    JButton btnHitung;
    JButton btnBersihkan;
    JButton btnSimpan;
    JButton btnKeluar;

    public Pertemuan10() {
        Components();
    }

    private void Components() {
        // --- Pengaturan JFrame ---
        setTitle("Aplikasi Penentu Nilai Mahasiswa");
        setSize(620, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Tampilkan di tengah layar
        getContentPane().setLayout(null); // Gunakan layout absolut

        // --- Panel Nama (Merah Muda) ---
        panelNama = new JPanel();
        panelNama.setBounds(10, 10, 580, 70);
        panelNama.setBackground(new Color(255, 204, 204)); // Warna Pink/Merah Muda
        panelNama.setLayout(null);
        getContentPane().add(panelNama);

        lblNamaLengkap = new JLabel("Nama Lengkap");
        lblNamaLengkap.setBounds(20, 25, 100, 20);
        panelNama.add(lblNamaLengkap);

        txtNamaLengkap = new JTextField();
        txtNamaLengkap.setBounds(130, 25, 430, 20);
        panelNama.add(txtNamaLengkap);

        // --- Panel Nilai (Hijau) ---
        panelNilai = new JPanel();
        panelNilai.setBounds(10, 90, 280, 230);
        panelNilai.setBackground(new Color(204, 255, 204)); // Warna Hijau Muda
        panelNilai.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Nilai", TitledBorder.LEFT, TitledBorder.TOP));
        panelNilai.setLayout(null);
        getContentPane().add(panelNilai);

        lblTugasMurni = new JLabel("Tugas Murni");
        lblTugasMurni.setBounds(20, 40, 100, 20);
        panelNilai.add(lblTugasMurni);

        txtTugasMurni = new JTextField();
        txtTugasMurni.setBounds(130, 40, 130, 20);
        panelNilai.add(txtTugasMurni);

        lblUTS = new JLabel("Nilai UTS");
        lblUTS.setBounds(20, 80, 100, 20);
        panelNilai.add(lblUTS);

        txtUTS = new JTextField();
        txtUTS.setBounds(130, 80, 130, 20);
        panelNilai.add(txtUTS);

        lblUAS = new JLabel("Nilai UAS");
        lblUAS.setBounds(20, 120, 100, 20);
        panelNilai.add(lblUAS);

        txtUAS = new JTextField();
        txtUAS.setBounds(130, 120, 130, 20);
        panelNilai.add(txtUAS);

        // --- Panel Hasil (Kuning) ---
        panelHasil = new JPanel();
        panelHasil.setBounds(310, 90, 280, 230);
        panelHasil.setBackground(new Color(255, 255, 204)); // Warna Kuning Muda
        panelHasil.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Hasil", TitledBorder.LEFT, TitledBorder.TOP));
        panelHasil.setLayout(null);
        getContentPane().add(panelHasil);

        lblStaticNama = new JLabel("Nama");
        lblStaticNama.setBounds(20, 40, 100, 20);
        panelHasil.add(lblStaticNama);

        lblOutputNama = new JLabel("");
        lblOutputNama.setBounds(130, 40, 130, 20);
        panelHasil.add(lblOutputNama);

        lblStaticRata = new JLabel("Nilai Rata-rata");
        lblStaticRata.setBounds(20, 80, 100, 20);
        panelHasil.add(lblStaticRata);

        lblOutputRata = new JLabel("");
        lblOutputRata.setBounds(130, 80, 130, 20);
        panelHasil.add(lblOutputRata);

        lblStaticGrade = new JLabel("Grade");
        lblStaticGrade.setBounds(20, 120, 100, 20);
        panelHasil.add(lblStaticGrade);

        lblOutputGrade = new JLabel("");
        lblOutputGrade.setBounds(130, 120, 130, 20);
        panelHasil.add(lblOutputGrade);

        lblStaticHasil = new JLabel("Hasil");
        lblStaticHasil.setBounds(20, 160, 100, 20);
        panelHasil.add(lblStaticHasil);

        lblOutputHasil = new JLabel("");
        lblOutputHasil.setBounds(130, 160, 130, 20);
        panelHasil.add(lblOutputHasil);

        // --- Tombol-Tombol ---
        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(40, 340, 100, 30);
        getContentPane().add(btnHitung);

        btnBersihkan = new JButton("Bersihkan");
        btnBersihkan.setBounds(150, 340, 100, 30);
        getContentPane().add(btnBersihkan);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(360, 340, 100, 30);
        getContentPane().add(btnSimpan);

        btnKeluar = new JButton("Keluar");
        btnKeluar.setBounds(470, 340, 100, 30);
        getContentPane().add(btnKeluar);

        // --- Fungsionalitas Tombol (Action Listeners) ---

        // Tombol HITUNG
        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 1. Ambil Nama
                    String nama = txtNamaLengkap.getText();
                    if (nama.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nama Lengkap tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // 2. Ambil Nilai
                    double tugas = Double.parseDouble(txtTugasMurni.getText());
                    double uts = Double.parseDouble(txtUTS.getText());
                    double uas = Double.parseDouble(txtUAS.getText());

                    // 3. Hitung Rata-rata
                    double rataRata = (tugas + uts + uas) / 3;

                    // 4. Tentukan Grade dan Hasil
                    String grade;
                    String hasil;
                    if (rataRata >= 90) {
                        grade = "A";
                    } else if (rataRata >= 80) {
                        grade = "B";
                    } else if (rataRata >= 70) {
                        grade = "C";
                    } else if (rataRata >= 60) {
                        grade = "D";
                    } else {
                        grade = "E";
                    }

                    if (rataRata >= 70) {
                        hasil = "Lulus";
                    } else {
                        hasil = "Tidak Lulus";
                    }

                    // 5. Tampilkan Hasil
                    lblOutputNama.setText(nama);
                    lblOutputRata.setText(String.format("%.2f", rataRata)); // Format 2 angka desimal
                    lblOutputGrade.setText(grade);
                    lblOutputHasil.setText(hasil);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input nilai harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Tombol BERSIHKAN
        btnBersihkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNamaLengkap.setText("");
                txtTugasMurni.setText("");
                txtUTS.setText("");
                txtUAS.setText("");

                lblOutputNama.setText("");
                lblOutputRata.setText("");
                lblOutputGrade.setText("");
                lblOutputHasil.setText("");
                
                txtNamaLengkap.requestFocus(); // Fokuskan kursor kembali ke Nama Lengkap
            }
        });

        // Tombol SIMPAN
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fungsionalitas simpan biasanya ke database atau file
                // Untuk contoh ini, kita tampilkan pesan saja
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan (simulasi).");
            }
        });

        // Tombol KELUAR
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tampilkan dialog konfirmasi
                int pilihan = JOptionPane.showConfirmDialog(null, 
                        "Apakah Anda yakin ingin keluar?", 
                        "Konfirmasi Keluar", 
                        JOptionPane.YES_NO_OPTION);
                
                if (pilihan == JOptionPane.YES_OPTION) {
                    System.exit(0); // Keluar dari aplikasi
                }
            }
        });
    }

    // --- Main Method untuk Menjalankan Aplikasi ---
    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (EDT) untuk keamanan thread
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pertemuan10().setVisible(true);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

