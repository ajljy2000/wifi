package wifi_final;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;



import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class DeviceManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lbl_casename;
	private JLabel lbl_casesearcher;
	private JComboBox combo_list;
	
	public Testdb db=new Testdb();
	public String[] Case = new String[4];
	public String[][] Devices;
	
	
	public DeviceManage(String[] Case) {
		
		this.Case = Case;
		
		
		setTitle("\u8BBE\u5907\u5217\u8868");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(MainClass.btnColor, 1, true));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_caseinfo = new JPanel();
		panel_caseinfo.setBorder(new MatteBorder(1, 1, 0, 1, MainClass.btnColor));
		panel_caseinfo.setBackground(Color.WHITE);
		panel.add(panel_caseinfo);
		panel_caseinfo.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_caseinfo.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lbl1 = new JLabel("\u6848\u4F8B\u53F7:");
		lbl1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(lbl1);
		
		lbl_casename = new JLabel("");
		lbl_casename.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(lbl_casename);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_caseinfo.add(panel_2);
		
		JLabel lbl2 = new JLabel("\u8C03\u67E5\u4EBA:");
		lbl2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_2.add(lbl2);
		
		lbl_casesearcher = new JLabel("");
		lbl_casesearcher.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_2.add(lbl_casesearcher);
		
		JPanel panel_deviceinfo = new JPanel();
		panel_deviceinfo.setBorder(new LineBorder(MainClass.btnColor));
		contentPane.add(panel_deviceinfo, BorderLayout.CENTER);
		panel_deviceinfo.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		panel_deviceinfo.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_3.add(panel_5, BorderLayout.EAST);
		
		JButton btn_adddecive = new JButton("\u6DFB\u52A0\u8BBE\u5907");
		btn_adddecive.setForeground(Color.WHITE);
		btn_adddecive.setBackground(MainClass.btnColor);
		btn_adddecive.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_5.add(btn_adddecive);
		btn_adddecive.addActionListener(btn_adddeviceAction);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 127, 255), 2));
		panel_6.setBackground(Color.WHITE);
		panel_3.add(panel_6, BorderLayout.WEST);
		
		JLabel label = new JLabel("\u8BBE\u5907\u7F16\u53F7:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_6.add(label);
		
		combo_list = new JComboBox();
		combo_list.setBackground(MainClass.btnColor);
		combo_list.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_6.add(combo_list);
		
		JButton btn_deletedevice = new JButton("\u5220\u9664");
		btn_deletedevice.setForeground(Color.WHITE);
		btn_deletedevice.setBackground(MainClass.btnColor);
		btn_deletedevice.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btn_deletedevice.addActionListener(btn_deletedeviceAction);
		panel_6.add(btn_deletedevice);
		
		this.setLocationRelativeTo(null);
		this.addWindowListener(windowAdapter);
		this.setVisible(true);
		
		//视图数据初始化
		init();
	}
	
	public void init(){
		try {
			int count=db.countdevice(Case[0]);
			combo_list.removeAllItems();
			Object[] header = new String[]{"设备编号","设备名", "设备类型","密码"};
	        Devices = new String[count][5];
	        List<String> deivceid=db.searchdevicestring(Case[0],"deviceid");
	        List<String> devicename=db.searchdevicestring(Case[0],"devicename");
	        List<String> devicetype=db.searchdevicestring(Case[0],"devicetype");
	        List<String> devicepwd=db.searchdevicestring(Case[0],"password");
	        for (int i = 0; i <count; i++) {
	        	Devices[i][0] = String.valueOf(i+1);
	        	Devices[i][1] = devicename.get(i);
	        	Devices[i][2] = devicetype.get(i);
	        	Devices[i][3] = devicepwd.get(i);
	        	Devices[i][4] = deivceid.get(i);
	        	combo_list.addItem(Devices[i][0]);
	        }
	        //构建表格数据模型
	        TableModel model = new DefaultTableModel(Devices, header) {
	        	public boolean isCellEditable(int row,int column)
	        	{
	        		return false;
	        	}
	        };
			//创建表格对象
			table = new JTable(model);
			table.setBackground(Color.WHITE);
			table.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			table.addMouseListener(table_Mouse);
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setBackground(Color.WHITE);
			table.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 15));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); 
			FitTableColumns(table);
			scrollPane.setViewportView(table);
			
			
			lbl_casename.setText(Case[0].toString());
			lbl_casesearcher.setText(Case[3].toString());
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ActionListener btn_deletedeviceAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				db.deletedevice(Devices[combo_list.getSelectedIndex()][4]);
				init();
				MainClass.cm.init();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	public ActionListener btn_adddeviceAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MainClass.ad = new AddDevice(Case);
		}
	};
	
	public MouseListener table_Mouse = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			
			if(e.getClickCount() == 2){
				MainClass.dci = new DeviceCaseInfo(Case, Devices[row]);
			}
			
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
	
	public void FitTableColumns(JTable myTable){
		 JTableHeader header = myTable.getTableHeader();
		       int rowCount = myTable.getRowCount();
		       Enumeration columns = myTable.getColumnModel().getColumns();
		       while(columns.hasMoreElements()){
		           TableColumn column = (TableColumn)columns.nextElement();
		           int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
		           int width = (int)myTable.getTableHeader().getDefaultRenderer()
		                   .getTableCellRendererComponent(myTable, column.getIdentifier()
		                         , false, false, -1, col).getPreferredSize().getWidth();
		          for(int row = 0; row<rowCount; row++){
		              int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
		                myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
		              width = Math.max(width, preferedWidth);
		          }
		          header.setResizingColumn(column); // 此行很重要
		          column.setWidth(width+myTable.getIntercellSpacing().width);
		      }
	}

}
 