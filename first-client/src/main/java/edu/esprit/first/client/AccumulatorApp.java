package edu.esprit.first.client;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.esprit.first.business.AccumulatorServiceRemote;
import edu.esprit.first.business.CalculatorServiceRemote;





public class AccumulatorApp extends JFrame{
	
	private AccumulatorServiceRemote proxy = getProxy();
	
	 
	
	 private JPanel panel = new JPanel();
	 private JLabel dxLabel = new JLabel("dx");
	 private JTextField dxField = new JTextField();
	 private JLabel resultLabel =  new JLabel();
	 private JButton submitButton = new JButton("x = ");
	 
	 public AccumulatorApp() {
		 
		 setTitle("Acc");
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 init();
		 setVisible(true);
		 pack();
	 }
	 
	 
	 
	 
	 private void init(){
		 
		 panel.setLayout(new GridLayout(2, 2));
		 panel.add(dxLabel);
		 panel.add(dxField);
		 panel.add(submitButton);
		 panel.add(resultLabel);
		 getContentPane().add(panel);
		 submitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int dx = Integer.parseInt(dxField.getText());
				resultLabel.setText(String.valueOf(proxy.accumulate(dx)));
			}
		});
	 }
	 
	 public static void main(String[] args) {
		 
		 EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				new AccumulatorApp();
				
			}
		});
	}
	 
	 private AccumulatorServiceRemote getProxy() {
			try{
				Context ctx = new InitialContext();
				proxy = (AccumulatorServiceRemote) ctx.lookup("/first-ejb/AccumulatorService!edu.esprit.first.business.AccumulatorServiceRemote");
			}catch(NamingException ex){
				ex.printStackTrace();
			}
			return proxy;
	}


}
