package lab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;



/*
 * mohamed saeed
 * 11/17/2022
 * make a panel with window builder and have it add what the user selected to the text area
 */
public class lab9 extends JFrame {

	private JPanel contentPane; //main panel
	private JTextField nameTextField;//the textfield where the name goes
	private JTextArea textF;// the main text field where everything gets added
	private JComboBox genderBox; // the gender selection either male or female
	private JCheckBox acceptTerms;  // terms of condition button

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab9 frame = new lab9(); // main frame
					frame.setVisible(true); //makes visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lab9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);//bounders of window
		contentPane = new JPanel(); //main panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  //no jthings within this range

		setContentPane(contentPane); 
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Application Form");//application form title
		lblNewLabel.setBounds(13, 5, 171, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JLabel name = new JLabel("Name:"); // the name label
		name.setBounds(13, 42, 51, 19);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(name);

		nameTextField = new JTextField();//textfield where user writes name
		nameTextField.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameTextField.setBounds(103, 41, 221, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Gender:");//gender label
		lblNewLabel_1_2.setBounds(13, 72, 61, 19);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel_1_2);

		genderBox = new JComboBox(); //selection between genders
		genderBox.setBackground(SystemColor.activeCaption);
		genderBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		genderBox.setModel(new DefaultComboBoxModel(new String[] { " ", "Male", "Female" }));//three options
		genderBox.setBounds(103, 72, 221, 22);
		panel.add(genderBox);

		acceptTerms = new JCheckBox("Accept Terms and Conditions"); //button for terms and conditions 
		acceptTerms.setBackground(UIManager.getColor("Button.background"));
		acceptTerms.setForeground(new Color(0, 0, 0));
		acceptTerms.setHorizontalAlignment(SwingConstants.CENTER);
		acceptTerms.setFont(new Font("Tahoma", Font.BOLD, 15));
		acceptTerms.setBounds(13, 98, 414, 23);
		panel.add(acceptTerms);

		JButton insertB = new JButton("Insert a record"); //button to add the infomation given to the text area
		insertB.setBackground(new Color(255, 255, 255));
		insertB.setForeground(new Color(0, 0, 0));
		insertB.setFont(new Font("Tahoma", Font.BOLD, 15));
		insertB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		insertB.setBounds(61, 219, 321, 23);//bounders of button and buttonlistener
		insertB.addActionListener(new ButtonListener());
		panel.add(insertB);

		textF = new JTextArea();
		textF.setText("Mina Maleki, Female");//preset name and gender
		textF.setBounds(13, 128, 403, 90);
		panel.add(textF);
	}

	private class ButtonListener implements ActionListener { // allows the button to have actions
		public void actionPerformed(ActionEvent e) {
			if (acceptTerms.isSelected() && !(nameTextField.getText().equals("")) && genderBox.getSelectedIndex() != 0) {
				textF.append("\n" + nameTextField.getText() + ", " + genderBox.getSelectedItem());//appended if evething is selected 
			}else if (!(acceptTerms.isSelected())){//prints error if acception terms is not selected 
				JOptionPane.showMessageDialog(null, "please select terms of condition");
			}else if (nameTextField.getText().equals("")){//error if text is empty
				JOptionPane.showMessageDialog(null, "please enter you name ");
			}else if (genderBox.getSelectedIndex() == 0){//error if nothing is selected in gender boxes
				JOptionPane.showMessageDialog(null, "please select gender");
			}
		}
	}
}