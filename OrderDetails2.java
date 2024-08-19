package test1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class OrderDetails2 extends JDialog {

    private JTable table;
    private JLabel lblOrderDetails;
    private JLabel lblWholesalerDetails;

    public OrderDetails2(JFrame parent, int orderId, String wholesaler) {
        super(parent, "Order Details", true);

        setSize(538, 400);
        setBounds(100, 100, 200, 70);
        setBackground(new Color(225, 244, 181));

        // Initialize components
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 48, 333, 134);

        lblOrderDetails = new JLabel();
        lblOrderDetails.setBounds(20, 11, 333, 26);
        lblOrderDetails.setHorizontalAlignment(SwingConstants.CENTER);
        lblWholesalerDetails = new JLabel();
        lblWholesalerDetails.setBounds(30, 195, 248, 151);

        // Set layout to null for absolute positioning
        getContentPane().setLayout(null);

        // Create a border gap
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        contentPane.add(lblOrderDetails);
        contentPane.add(lblWholesalerDetails);
        contentPane.add(scrollPane);
        contentPane.setBackground(new Color(225, 244, 181));

        // Fetch and display order details
        fetchAndDisplayOrderDetails(orderId);

        // Fetch and display wholesaler details
        fetchAndDisplayWholesalerDetails(wholesaler);

        // Set dialog properties
        setSize(390, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void fetchAndDisplayOrderDetails(int orderId) {
        // Fetch order details
        String orderSql = "SELECT OrderDate, SupplyStatus FROM Order_details WHERE OrderID = ?";
        try (Connection conn = DatabaseHandler.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(orderSql)) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                lblOrderDetails.setText("Order ID: " + orderId + " Order Date: " + rs.getDate("OrderDate") + " Supply Status: " + rs.getString("SupplyStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Fetch and display ordered medicines
        String orderedMedicineSql = "SELECT M.MedName, O.PackagesOrdered, O.PricePerPackage FROM Ordered_Medicine O JOIN Dosage M ON M.MedicineID = O.MedicineID  WHERE O.OrderID = ?";
        try (Connection conn = DatabaseHandler.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(orderedMedicineSql)) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            // Populate table model
            DefaultTableModel model = new DefaultTableModel(new Object[]{"MedName", "Packages Ordered", "Price Per Package"}, 0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("MedName"), rs.getInt("PackagesOrdered"), rs.getDouble("PricePerPackage")});
            }
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fetchAndDisplayWholesalerDetails(String wholesaler) {
        // Fetch wholesaler details
        String wholesalerSql = "SELECT * FROM Wholesalers WHERE Name = ?";
        try (Connection conn = DatabaseHandler.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(wholesalerSql)) {
            pstmt.setString(1, wholesaler);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                lblWholesalerDetails.setText("<html>Wholesaler Details:<br/><span style='font-weight: normal;'>Name: " + rs.getString("NAME") +
                        "<br/>State: " + rs.getString("STATE") +
                        "<br/>City: " + rs.getString("CITY") +
                        "<br/>Street: " + rs.getString("STREET") +
                        "<br/>Pincode: " + rs.getString("PINCODE") +
                        "<br/>Email: " + rs.getString("EMAIL") +
                        "<br/>Phno: " + rs.getString("PHNO") + "</span></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
