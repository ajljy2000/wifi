package wifi_final;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;


import javax.swing.event.ChangeEvent;

import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class Login {

	JFrame frame;
	String[] Device;
	String flag;
	
	Selenium selenium=new Selenium();
	Seleniummi seleniummi=new Seleniummi();
	Testdb db=new Testdb();
	TestThread testthread=new TestThread();
	/**
	 * Launch the application.
	 */
	
		
	
	/**
	 * Create the application.
	 */
	public Login(String[] Device) {
		this.Device=Device;
		
		frame = new JFrame("路由器取证");
		frame.setForeground(Color.CYAN);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 364, 147);
		frame.setLocation(750,300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u7A0D\u540E...");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_2.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_2.add(panel_8, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_2.add(panel_9, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setIndeterminate(true);
		panel_3.add(progressBar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel_3.add(panel, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_3.add(panel_4, BorderLayout.EAST);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_3.add(panel_6, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(MainClass.btnColor);
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(cancel_button);
		panel_5.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel_5.add(btnNewButton);
		
		
		frame.addWindowListener(windowAdapter);
		init();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void init() {
		testthread.start();
	}
	
	
	
	public ActionListener cancel_button=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			testthread.interrupt();
			frame.dispose();
			try {
				db.deletedeviceinfo(Device[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MainClass.dci.setEnabled(true);
		}
	};
	
	public WindowAdapter windowAdapter = new WindowAdapter() {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowOpened(e);
			MainClass.dci.setEnabled(false);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
			super.windowClosed(e);
			
			MainClass.dci.setEnabled(true);
			
		}
		
	};
	class UsePython{
		
        public synchronized  void useselenium(String[] Device) {
        	boolean deviceflag = false;
        	try {
				deviceflag=db.checkdeviceflag(Device[4]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	if(deviceflag==false)
        	{
        		if(Device[2].equals("华为AX3"))
        		{
        			selenium.go(Device);
    				while(selenium.flag==0) {
    					if(selenium.errorflag==1) {
    						JOptionPane.showMessageDialog(null, "提取失败，请重新尝试！", "错误",JOptionPane.WARNING_MESSAGE); 
    						frame.dispose();
    						return ;
    					}
    					try {
    						Thread.sleep(2000);
    					} catch (InterruptedException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    				}
        		}
        		if(Device[2].equals("小米"))
        		{
        			seleniummi.go(Device);
    				while(seleniummi.flag==0) {
    					if(seleniummi.errorflag==1) {
    						JOptionPane.showMessageDialog(null, "提取失败，请重新尝试！", "错误",JOptionPane.WARNING_MESSAGE); 
    						frame.dispose();
    						return ;
    					}
    					try {
    						Thread.sleep(2000);
    					} catch (InterruptedException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    				}
        		}
			
				String sql_flag="update device set flag='1' where deviceid='"+Device[4]+"'";
				try {
					db.update(sql_flag);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
			frame.dispose();
			EvidenceInfo window = new EvidenceInfo(Device);
			window.readsql(Device);
			window.getrusult(Device);
			window.frame.setVisible(true);
        }
	}
	class TestThread extends Thread {
        public void run() {
        	UsePython test = new UsePython();
            test.useselenium(Device);
        }
	}
}

