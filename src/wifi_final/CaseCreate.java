package wifi_final;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CaseCreate extends JFrame {

	private JPanel contentPane;
	private JTextField txt_casename;
	private JTextField txt_casesearcher;
	Testdb db=new Testdb();

	public CaseCreate() {
		setTitle("\u6848\u4EF6\u521B\u5EFA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 185);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_caseinfo = new JPanel();
		panel_caseinfo.setBorder(new LineBorder(new Color(0, 127, 255), 2));
		panel_caseinfo.setBackground(Color.WHITE);
		contentPane.add(panel_caseinfo, BorderLayout.CENTER);
		panel_caseinfo.setLayout(new GridLayout(2, 1, 3, 0));
		
		JPanel panel_caseinfo1 = new JPanel();
		panel_caseinfo1.setBackground(Color.WHITE);
		panel_caseinfo.add(panel_caseinfo1);
		panel_caseinfo1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_casename = new JLabel(" \u6848\u4EF6\u540D:");
		lbl_casename.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_caseinfo1.add(lbl_casename, BorderLayout.WEST);
		
		txt_casename = new JTextField();
		txt_casename.setBackground(SystemColor.textHighlightText);
		txt_casename.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_caseinfo1.add(txt_casename, BorderLayout.CENTER);
		txt_casename.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_caseinfo1.add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_caseinfo2 = new JPanel();
		panel_caseinfo2.setBackground(Color.WHITE);
		panel_caseinfo.add(panel_caseinfo2);
		panel_caseinfo2.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_casesearcher = new JLabel(" \u8C03\u67E5\u4EBA:");
		lbl_casesearcher.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_caseinfo2.add(lbl_casesearcher, BorderLayout.WEST);
		
		txt_casesearcher = new JTextField();
		txt_casesearcher.setBackground(SystemColor.textHighlightText);
		txt_casesearcher.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_caseinfo2.add(txt_casesearcher, BorderLayout.CENTER);
		txt_casesearcher.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_caseinfo2.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_btn = new JPanel();
		panel_btn.setBorder(new MatteBorder(0, 2, 2, 2, MainClass.btnColor));
		panel_btn.setBackground(Color.WHITE);
		panel_btn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		contentPane.add(panel_btn, BorderLayout.SOUTH);
		
		JButton btn_set = new JButton("\u521B  \u5EFA");
		btn_set.setForeground(Color.WHITE);
		btn_set.setBackground(MainClass.btnColor);
		btn_set.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btn_set.addActionListener(btn_setAction);
		panel_btn.add(btn_set);
		
		JButton btn_reset = new JButton("\u91CD  \u7F6E");
		btn_reset.setForeground(Color.WHITE);
		btn_reset.setBackground(MainClass.btnColor);
		btn_reset.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btn_reset.addActionListener(btn_resetAction);
		panel_btn.add(btn_reset);
		
		this.setLocationRelativeTo(null);
		this.addWindowListener(windowAdapter);
		this.setVisible(true);
	}
	
	public ActionListener btn_setAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Calendar cal=Calendar.getInstance();      
			String y=String.valueOf(cal.get(Calendar.YEAR));      
			String m=String.valueOf(cal.get(Calendar.MONTH)+1);
			if(m.length()==1) m="0"+m;
			String d=String.valueOf(cal.get(Calendar.DATE)); 
			if(d.length()==1) d="0"+d;
			String h=String.valueOf(cal.get(Calendar.HOUR_OF_DAY));   
			if(h.length()==1) h="0"+h;
			String mi=String.valueOf(cal.get(Calendar.MINUTE));
			if(mi.length()==1) mi="0"+mi;
			String s=String.valueOf(cal.get(Calendar.SECOND));
			if(s.length()==1) s="0"+s;
			String caseid=y+m+d+h+mi+s;
			String casename=txt_casename.getText();
			String name=txt_casesearcher.getText();
			try {
				db.inserttotal(caseid, casename, name);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//ÊÓÍ¼Êý¾ÝË¢ÐÂ
			MainClass.cm.init();
			
			MainClass.cc.dispose();
		}
	};
	
	public ActionListener btn_resetAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txt_casename.setText("");
			txt_casesearcher.setText("");
		}
	};
	
	public WindowAdapter windowAdapter = new WindowAdapter() {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowOpened(e);
			MainClass.cm.setEnabled(false);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosed(e);
			MainClass.cm.setEnabled(true);
		}
		
	};
}
