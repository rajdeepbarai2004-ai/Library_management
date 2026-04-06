import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Library Management System");
        setSize(400, 400);
        setLayout(null);

        JButton addBook = new JButton("Add Book");
        JButton viewBooks = new JButton("View Books");
        JButton issueBook = new JButton("Issue Book");
        JButton returnBook = new JButton("Return Book");

        addBook.setBounds(100, 50, 200, 30);
        viewBooks.setBounds(100, 100, 200, 30);
        issueBook.setBounds(100, 150, 200, 30);
        returnBook.setBounds(100, 200, 200, 30);

        add(addBook);
        add(viewBooks);
        add(issueBook);
        add(returnBook);

        addBook.addActionListener(e -> new AddBook());
        viewBooks.addActionListener(e -> new ViewBooks());
        issueBook.addActionListener(e -> new IssueBook());
        returnBook.addActionListener(e -> new ReturnBook());

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
