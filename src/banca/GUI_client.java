package banca;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import java.awt.GridLayout;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.*;

public class GUI_client {
	
	Client c;
	public GUI_client(){
		
	JFrame frame = new JFrame("Banca");
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(6,6));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(750,750);
	panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
	
	JTextField cnp_input = new JTextField("cnp");
	panel.add(cnp_input);
	JButton creaza_cont = new JButton("Cont nou");
	creaza_cont.addActionListener(new ActionListener() { 
		@Override
		public void actionPerformed(ActionEvent e) {
			c = new Client(cnp_input.getText());
			cnp_input.setText("Cont creat");
			Banca.adauga_client(c);
		} 
	});
	panel.add(creaza_cont);
	
	JTextField depunere = new JTextField("suma");
	panel.add(depunere);
	JTextField depunere_tip = new JTextField("moneda");
	panel.add(depunere_tip);
	JButton depune = new JButton("Depune");
	depune.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				c.depozit(NumberFormat.getInstance().parse(depunere.getText()).doubleValue(), depunere_tip.getText().toString() );
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			depunere.setText("Suma adaugata");
		} 
	});
	panel.add(depune); 
	JLabel empty_label = new JLabel("");
	panel.add(empty_label);
	
	JTextField retragere = new JTextField("suma");
	panel.add(retragere);
	JTextField retrage_tip = new JTextField("moneda");
	panel.add(retrage_tip);
	JButton retrage = new JButton("Retrage");
	retrage.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				c.retragere(NumberFormat.getInstance().parse(retragere.getText()).doubleValue(), retrage_tip.getText());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
			retragere.setText("Suma retrasa");
		} 
	});
	panel.add(retrage); 
	
	JButton lichideaza = new JButton("Lichideaza");
	lichideaza.addActionListener(new ActionListener() { 
		@Override
		public void actionPerformed(ActionEvent e) {
			c.lichidare();
		} 
	});
	panel.add(lichideaza);
	
	JLabel info_sold = new JLabel("Informatii sold conturi");
	JButton sold = new JButton("Sold");
	sold.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			info_sold.setText(c.get_sold());
		}
	});
	panel.add(info_sold);
	panel.add(sold);
	
  
	frame.add(panel);
	frame.pack(); 
	frame.setVisible(true);
		
	}
	
	
}
