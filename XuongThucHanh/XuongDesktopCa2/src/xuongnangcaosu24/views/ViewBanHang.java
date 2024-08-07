/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package xuongnangcaosu24.views;

import java.util.ArrayList;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import xuongnangcaosu24.entity.ChiTietSP;
import xuongnangcaosu24.entity.HoaDon;
import xuongnangcaosu24.entity.HoaDonChiTiet;
import xuongnangcaosu24.repositories.ChiTietSPRepository;
import xuongnangcaosu24.repositories.HoaDonChiTietRepository;
import xuongnangcaosu24.repositories.HoaDonRepository;
import xuongnangcaosu24.responses.ChiTietSPResponse;
import xuongnangcaosu24.responses.HoaDonChiTietResponse;

/**
 *
 * @author syn
 */
public class ViewBanHang extends javax.swing.JPanel {
    HoaDonRepository hoaDonRepository;
    HoaDonChiTietRepository hoaDonChiTietRepository;
    ChiTietSPRepository chiTietSPRepository;
    DefaultTableModel dtmHoaDon;
    DefaultTableModel dtmGioHang;
    DefaultTableModel dtmSanPham;
    /**
     * Creates new form ViewBanHang
     */
    public ViewBanHang() {
        initComponents();
        hoaDonRepository = new HoaDonRepository();
        hoaDonChiTietRepository = new HoaDonChiTietRepository();
        chiTietSPRepository = new ChiTietSPRepository();
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        dtmGioHang = (DefaultTableModel) tblGioHang.getModel();
        dtmSanPham = (DefaultTableModel) tblSanPham.getModel();
        showTableHoaDon(hoaDonRepository.getAllHDChuaThanhToan());
        showTableChiTietSP(chiTietSPRepository.getAllSPCT());
    }

    public void showTableHoaDon(ArrayList<HoaDon> danhSach) {
        dtmHoaDon.setRowCount(0);
        for(HoaDon hoaDon: danhSach) {
            dtmHoaDon.addRow(new Object[]{
                        hoaDon.getId(),
                        hoaDon.getSdt(),
                        hoaDon.getTongTien(),
                    });
        }
    }
    public void showTableHoaDonChiTiet(ArrayList<HoaDonChiTietResponse> danhSach) {
        dtmGioHang.setRowCount(0);
        for(HoaDonChiTietResponse hdct: danhSach) {
            dtmGioHang.addRow(new Object[]{
                        hdct.getIdChiTietSP(),
                        hdct.getTenSanPham(),
                        hdct.getSoLuong(),
                        hdct.getDonGia()
                    });
        }
    }
    
    public void showTableChiTietSP(ArrayList<ChiTietSPResponse> danhSach) {
        dtmSanPham.setRowCount(0);
        for(ChiTietSPResponse ctsp: danhSach) {
            dtmSanPham.addRow(new Object[]{
                        ctsp.getId(),
                        ctsp.getTenSanPham(),
                        ctsp.getMauSac(),
                        ctsp.getSoLuongTon(),
                        ctsp.getGiaBan()
                    });
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDSP", "Ten SP", "Mau Sac", "So luong ton", "Gia ban"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SDT", "TongTien"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDSP", "Ten SP", "So Luong", "Don Gia"
            }
        ));
        jScrollPane4.setViewportView(tblGioHang);

        jLabel1.setText("Hoa don");

        jLabel2.setText("Gio hang");

        jLabel3.setText("San pham");

        jLabel4.setText("Tong tien");

        btnThanhToan.setText("Thanh toan");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setText("Tao hoa don");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel5.setText("SDT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThanhToan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongTien))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(47, 47, 47)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addComponent(btnTaoHoaDon))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnTaoHoaDon))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(btnThanhToan))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int tongTien = 0;
        for(int i = 0; i < tblGioHang.getRowCount(); i++) {
            tongTien += Integer.valueOf(tblGioHang.getValueAt(i, 3).toString());
        }
        // Bug: Can nhan them so luong san pham
        hoaDonRepository.thanhToan(
                HoaDon.builder()
                .Id(Integer.valueOf(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString()))
                .TongTien(tongTien).build()
        );
        showTableHoaDon(hoaDonRepository.getAllHDChuaThanhToan());
        dtmGioHang.setRowCount(0);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        String sdt = txtSDT.getText();
        hoaDonRepository.taoHoaDon(sdt);
        showTableHoaDon(hoaDonRepository.getAllHDChuaThanhToan());
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int idHoaDon = Integer.valueOf(tblHoaDon.getValueAt(
                tblHoaDon.getSelectedRow()
                , 0).toString());
        showTableHoaDonChiTiet(hoaDonChiTietRepository.getAllByIdHoaDon(idHoaDon));
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int soLuongSanPham = Integer.valueOf(JOptionPane.showInputDialog("Moi nhap so luong SP: "));
        int idHoaDon = Integer.valueOf(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString());
        int idSPCT = Integer.valueOf(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0).toString());
        int giaBan = Integer.valueOf(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 4).toString());
        HoaDonChiTiet hdct = HoaDonChiTiet.builder()
                .IdHoaDon(idHoaDon)
                .IdChiTietSP(idSPCT)
                .SoLuong(soLuongSanPham)
                .DonGia(giaBan).build();
        int soLuongConLai = Integer.valueOf(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 3).toString()) - soLuongSanPham;
        hoaDonChiTietRepository.addHDCT(hdct);
        ChiTietSP ctsp = ChiTietSP.builder()
                .SoLuongTon(soLuongConLai)
                .Id(Integer.valueOf(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0).toString())).build();
        chiTietSPRepository.updateSoLuongByIDCTSP(ctsp);
        showTableChiTietSP(chiTietSPRepository.getAllSPCT());
        showTableHoaDonChiTiet(hoaDonChiTietRepository.getAllByIdHoaDon(idHoaDon));
        
    }//GEN-LAST:event_tblSanPhamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
