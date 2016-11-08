import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField isbnText;
	private JTextField titelText;

	private HashMap<String, String> books = new HashMap<String, String>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setTitle("Bokprogrammet");

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIsbn.setBounds(10, 11, 46, 14);
		contentPane.add(lblIsbn);

		JLabel lblTitel = new JLabel("Titel");
		lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTitel.setBounds(189, 11, 46, 14);
		contentPane.add(lblTitel);

		isbnText = new JTextField();
		isbnText.setBounds(20, 36, 130, 20);
		contentPane.add(isbnText);
		isbnText.setColumns(10);

		titelText = new JTextField();
		titelText.setBounds(199, 36, 130, 20);
		contentPane.add(titelText);
		titelText.setColumns(10);








		JTextArea displayArea = new JTextArea();
		displayArea.setEditable(false);
		displayArea.setBounds(20, 80, 312, 350);
		contentPane.add(displayArea);

		JLabel lblSkresultat = new JLabel("S\u00F6kresultat");
		lblSkresultat.setBounds(342, 174, 167, 14);
		contentPane.add(lblSkresultat);

		JButton btnLggTill = new JButton("L\u00E4gg till");
		btnLggTill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				books.put(isbnText.getText(), titelText.getText());
				displayArea.append(isbnText.getText() + " " + titelText.getText() + "\n");
			}
		});
		btnLggTill.setBounds(573, 35, 121, 23);
		contentPane.add(btnLggTill);

		JLabel label = new JLabel("");
		label.setBounds(352, 199, 312, 211);
		contentPane.add(label);

		JButton btnSkPIsbn = new JButton("S\u00F6k p\u00E5 ISBN");
		btnSkPIsbn.setBounds(573, 69, 121, 23);
		contentPane.add(btnSkPIsbn);
		btnSkPIsbn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String isbn = JOptionPane.showInputDialog(null, "Ange ISBN -nr");

				if(books.get(isbn) == null){
					label.setText("");
				}else{
					label.setText(isbn + " " + books.get(isbn));
				}



			}
		});

		JButton btnSkPTitel = new JButton("S\u00F6k p\u00E5 titel");
		btnSkPTitel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String titel = JOptionPane.showInputDialog(null, "Ange titel");



				for (String isbn : books.keySet()) {
					
					if(titel.equals(books.get(isbn))){
						label.setText(isbn + " " + books.get(isbn));
						break;
					}else{
						label.setText("");
					}
					
				}

			}
		});
		btnSkPTitel.setBounds(573, 103, 121, 23);
		contentPane.add(btnSkPTitel);

	}
}
