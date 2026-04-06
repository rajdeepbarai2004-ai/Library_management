import javax.swing.*;
import java.sql.*;

public class ViewBooks extends JFrame {

    JTextArea area;

    public ViewBooks() {
        setTitle("View Books");
        setSize(400, 400);

        area = new JTextArea();
        add(new JScrollPane(area));

        displayBooks();

        setVisible(true);
    }

    void displayBooks() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                area.append(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("author") + " " +
                    rs.getInt("quantity") + "\n"
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
