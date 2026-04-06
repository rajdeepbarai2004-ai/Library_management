import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class ReturnBook extends JFrame {
    JTextField issueId;

    public ReturnBook() {
        setTitle("Return Book");
        setSize(300, 200);
        setLayout(null);

        issueId = new JTextField();
        JButton returnBtn = new JButton("Return");

        issueId.setBounds(50, 50, 200, 25);
        returnBtn.setBounds(100, 100, 100, 30);

        add(issueId); add(returnBtn);

        returnBtn.addActionListener(e -> returnBook());

        setVisible(true);
    }

    void returnBook() {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE issued_books SET return_date=? WHERE id=?"
            );

            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, Integer.parseInt(issueId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book Returned");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
