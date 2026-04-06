import javax.swing.*;
import java.sql.*;

public class AddBook extends JFrame {
    JTextField name, author, quantity;

    public AddBook() {
        setTitle("Add Book");
        setSize(300, 300);
        setLayout(null);

        name = new JTextField();
        author = new JTextField();
        quantity = new JTextField();

        JButton addBtn = new JButton("Add");

        name.setBounds(50, 50, 200, 25);
        author.setBounds(50, 90, 200, 25);
        quantity.setBounds(50, 130, 200, 25);
        addBtn.setBounds(100, 180, 100, 30);

        add(name); add(author); add(quantity); add(addBtn);

        addBtn.addActionListener(e -> addBook());

        setVisible(true);
    }

    void addBook() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books(name,author,quantity) VALUES(?,?,?)"
            );

            ps.setString(1, name.getText());
            ps.setString(2, author.getText());
            ps.setInt(3, Integer.parseInt(quantity.getText()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Added");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
