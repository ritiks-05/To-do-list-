package T;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class taskdemo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
    private LinkedList<String> task=new LinkedList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taskdemo frame = new taskdemo();
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
	public taskdemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("🚀 Task - Manager 🚀 ");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel.setBounds(179, 10, 192, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  # Enter TaskName  - ");
		lblNewLabel_1.setBackground(new Color(248, 248, 255));
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(207, 101, 161, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(0, 131, 104, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dashboard");
		btnNewButton_1.setBounds(0, 184, 104, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Settings");
		btnNewButton_2.setBounds(0, 241, 104, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout !");
		btnNewButton_3.setBounds(0, 300, 104, 21);
		contentPane.add(btnNewButton_3);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		table.setBounds(207, 187, 322, 205);
		contentPane.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("TaskList ✅");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel_2.setBounds(332, 164, 114, 30);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(355, 103, 91, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Please Enter task !");
				}
				
				else
				{	
					String tasklist= textField.getText().trim();
					task.add(tasklist);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{tasklist});
                    JOptionPane.showMessageDialog(null, "Inserted successfully ✅ ");
                    textField.setText("");
				}
			}
		});
		btnNewButton_4.setBounds(207, 402, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_4_2 = new JButton("Delete");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow(); // Get selected row from JTable

		        if (selectedRow != -1) { // Check if a row is actually selected
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            String taskToRemove = (String) model.getValueAt(selectedRow, 0); // Get task text

		            task.remove(taskToRemove); // Remove from LinkedList
		            model.removeRow(selectedRow); // Remove from JTable

		            JOptionPane.showMessageDialog(null, "Task deleted successfully!");
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a task to delete.");
		        }
				
				
			}
		});
		btnNewButton_4_2.setBounds(442, 402, 85, 21);
		contentPane.add(btnNewButton_4_2);
		
		JLabel lblNewLabel_3 = new JLabel("\"Hard work pays off 🔥\"");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 370, 192, 17);
		contentPane.add(lblNewLabel_3);
	}
}
