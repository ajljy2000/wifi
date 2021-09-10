package wifi_final;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class DeviceCaseInfo extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_caseresearcher;
	private JLabel lbl_searchtime;
	private JLabel lbl_routertype;
	private JLabel lbl_routepwd;
	private JLabel lbl_casenum;
	
	String[] Case;
	String[] Device;
	
	public DeviceCaseInfo(String[] Case,String[] Device) {
		setTitle("\u6848\u4EF6\u8BBE\u5907\u5177\u4F53\u4FE1\u606F");
		
		this.Case = Case;
		this.Device = Device;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 288);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 350, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.WEST;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.VERTICAL;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\u6848\u4EF6\u7F16\u53F7:");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_1, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.textHighlightText);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lbl_casenum = new JLabel((String) null);
		lbl_casenum.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		lbl_casenum.setBackground(SystemColor.textHighlightText);
		panel_1.add(lbl_casenum);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.anchor = GridBagConstraints.WEST;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.VERTICAL;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\u8C03\u67E5\u4EBA\u5458:");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_8.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(SystemColor.textHighlightText);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lbl_caseresearcher = new JLabel("");
		lbl_caseresearcher.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_4.add(lbl_caseresearcher, BorderLayout.WEST);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.anchor = GridBagConstraints.WEST;
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.VERTICAL;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 2;
		panel.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\u8C03\u67E5\u65F6\u95F4:");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_9.add(lblNewLabel_2, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(SystemColor.textHighlightText);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 2;
		panel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		lbl_searchtime = new JLabel("");
		lbl_searchtime.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_5.add(lbl_searchtime, BorderLayout.WEST);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.anchor = GridBagConstraints.WEST;
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.VERTICAL;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 3;
		panel.add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\u8DEF\u7531\u5668\u578B\u53F7:");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_10.add(lblNewLabel_3, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(SystemColor.textHighlightText);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		lbl_routertype = new JLabel("");
		lbl_routertype.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_3.add(lbl_routertype, BorderLayout.WEST);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.anchor = GridBagConstraints.WEST;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.VERTICAL;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 4;
		panel.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("\u8DEF\u7531\u5668\u7BA1\u7406\u5BC6\u7801:");
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_11.add(lblNewLabel_4, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.textHighlightText);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 4;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lbl_routepwd = new JLabel("");
		lbl_routepwd.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		panel_2.add(lbl_routepwd, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.BASELINE;
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 5;
		panel.add(panel_6, gbc_panel_6);
		
		JButton btn_pwdhack = new JButton("Wifi\u5BC6\u7801\u7834\u89E3");
		btn_pwdhack.setBackground(Color.WHITE);
		btn_pwdhack.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btn_pwdhack.addMouseListener(pwdhack_Mouse);
		panel_6.add(btn_pwdhack);
		
		JButton btn_evidencestart = new JButton("\u5F00\u59CB\u53D6\u8BC1");
		btn_evidencestart.setBackground(Color.WHITE);
		btn_evidencestart.addMouseListener(evidencestart_Mouse);
		btn_evidencestart.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_6.add(btn_evidencestart);
		
		this.setLocationRelativeTo(null);
		this.addWindowListener(windowAdapter);
		this.setVisible(true);
		
		init();
	}
	
	public void init(){
		lbl_casenum.setText(Case[0]);
		lbl_caseresearcher.setText(Case[3]);
		lbl_searchtime.setText(Case[0].substring(0, 8));
		lbl_routertype.setText(Device[2]);
		lbl_routepwd.setText(Device[3]);
	}
	public MouseListener pwdhack_Mouse = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			try {
				
				Runtime.getRuntime().exec("wifi.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	};
	
	public MouseListener evidencestart_Mouse = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			Login login=new Login(Device);
			login.frame.setVisible(true);
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
