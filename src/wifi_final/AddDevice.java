package wifi_final;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddDevice extends JFrame {

	private JPanel contentPane;
	private JTextField txt_devicename;
	private JTextField txt_devicepwd;
	private JComboBox combo_list;
	Testdb db=new Testdb();
	String[] Case = new String[4];
	String[] type= {"»ªÎªAX3","Ð¡Ã×"};
	public AddDevice(String[] Case) {
		
		this.Case = Case;
		
		setTitle("\u6DFB\u52A0\u8BBE\u5907");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 503, 198);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 127, 255), 2));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{85, 342, 0};
		gbl_panel.rowHeights = new int[]{10, 10, 10, 10, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.BASELINE;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(" \u8BBE\u5907\u540D:");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_2.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.BASELINE;
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		txt_devicename = new JTextField();
		txt_devicename.setBackground(SystemColor.textHighlightText);
		txt_devicename.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_3.add(txt_devicename, BorderLayout.CENTER);
		txt_devicename.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.BASELINE;
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel(" \u8BBE\u5907\u7C7B\u578B:");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_1, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.BASELINE;
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 1;
		panel.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		combo_list = new JComboBox();
		combo_list.setModel(new DefaultComboBoxModel(new String[] {"\u534E\u4E3AAX3", "\u5C0F\u7C73"}));
		panel_6.add(combo_list, BorderLayout.NORTH);
		combo_list.removeAllItems();
		combo_list.addItem(type[0]);
		combo_list.addItem(type[1]);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.BASELINE;
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel(" \u5BC6\u7801:");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_2, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.BASELINE;
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 2;
		panel.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		txt_devicepwd = new JTextField();
		txt_devicepwd.setBackground(new Color(255, 255, 255));
		txt_devicepwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_7.add(txt_devicepwd, BorderLayout.CENTER);
		txt_devicepwd.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setLayout(new FlowLayout(FlowLayout.RIGHT));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.anchor = GridBagConstraints.BASELINE;
		gbc_panel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 3;
		panel.add(panel_8, gbc_panel_8);
		
		JButton btn_set = new JButton("\u521B  \u5EFA");
		btn_set.setForeground(Color.WHITE);
		btn_set.setBackground(MainClass.btnColor);
		btn_set.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btn_set.addActionListener(btn_setAction);
		panel_8.add(btn_set);
		
		JButton btn_reset = new JButton("\u91CD  \u7F6E");
		btn_reset.setForeground(Color.WHITE);
		btn_reset.setBackground(MainClass.btnColor);
		btn_reset.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btn_reset.addActionListener(btn_resetAction);
		
		panel_8.add(btn_reset);
		
		this.setLocationRelativeTo(null);
		this.addWindowListener(windowAdapter);
		this.setVisible(true);
		
	}
	
	public ActionListener btn_setAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				Random random = new Random();
				int count=random.nextInt(100);
				String deviceid;
				if(count<10)
				{
					deviceid=Case[0]+"0"+String.valueOf(count);
				}
				else
				{
					deviceid=Case[0]+String.valueOf(count);
				}
			
				while(db.searchdevice(deviceid)==true)
				{
					count=random.nextInt(100);
					if(count<10)
					{
						deviceid=Case[0]+"0"+String.valueOf(count);
					}
					else
					{
						deviceid=Case[0]+String.valueOf(count);
					}
				}
				String devicename=txt_devicename.getText();
				String devicetype=type[combo_list.getSelectedIndex()];
				String password=txt_devicepwd.getText();
			
				db.insertdevice(Case[0], deviceid, devicename, devicetype, password);
				
				
				//ÊÓÍ¼Êý¾ÝË¢ÐÂ
				MainClass.dm.init();
				MainClass.cm.init();
				
				MainClass.ad.dispose();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	public ActionListener btn_resetAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txt_devicename.setText("");
			
			txt_devicepwd.setText("");
		}
	};
	
	public WindowAdapter windowAdapter = new WindowAdapter() {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowOpened(e);
			MainClass.dm.setEnabled(false);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosed(e);
			MainClass.dm.setEnabled(true);
		}
		
	};
}
