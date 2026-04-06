import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class IssueBook extends JFrame {
    JTextField bookId, student;

    public IssueBook() {
        setTitle("Issue Book");
        setSize(300, 250);
        setLayout(null);

        bookId = new JTextField();
        student = new JTextField();

        JButton issueBtn = new JButton("Issue");

        bookId.setBounds(50, 50, 200, 25);
        student.setBounds(50, 90, 200, 25);
        issueBtn.setBounds(100, 140, 100, 30);

        add(bookId); add(student); add(issueBtn);

        issueBtn.addActionListener(e -> issueBook());

        setVisible(true);
    }

    void issueBook() {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO issued_books(book_id,student_name,issue_date) VALUES(?,?,?)"
            );

            ps.setInt(1, Integer.parseInt(bookId.getText()));
            ps.setString(2, student.getText());
            ps.setDate(3, Date.valueOf(LocalDate.now()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book Issued");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
