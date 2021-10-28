package banca;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.BorderLayout;

public class GUI_fisc extends JFrame {

	private static JTextArea fisc_label = new JTextArea(10,50);
	private Fisc f = new Fisc();
	
	public GUI_fisc(){
		
		JFrame frame = new JFrame("Fisc");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,6));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,750);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		 
		JTextField cnp = new JTextField("CNP");
		panel.add(cnp);
		JButton add = new JButton("Monitorizeaza");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.adauga_monitorizare(cnp.getText());
			}
		});
		panel.add(add);
		JButton remove = new JButton("Elimina");
		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.elimina_monitorizare(cnp.getText());
			}
		});
		panel.add(remove);
		
		fisc_label.setEditable(false);
		panel.add(fisc_label);
 
		
		frame.add(panel);
		frame.pack(); 
		frame.setVisible(true);
		 
	}
	
	public static void add_toLabel(String s) {
		String old_s = fisc_label.getText();
		s = s + "\n" + old_s;
		fisc_label.setText(s);
		System.out.println("executat");
	}
}
