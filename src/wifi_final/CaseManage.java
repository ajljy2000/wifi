package wifi_final;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CaseManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox combo_list;
	JScrollPane scrollPane;
	Testdb db=new Testdb();
	String[][] Cases;
	
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
	
	public CaseManage() {
		setBackground(Color.BLACK);
		
		setTitle("\u6848\u4EF6\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 479);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_btn = new JPanel();
		panel_btn.setBorder(new MatteBorder(2, 2, 0, 2, MainClass.btnColor));
		panel_btn.setBackground(Color.WHITE);
		panel_btn.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPane.add(panel_btn, BorderLayout.NORTH);
		
		JButton btn_create = new JButton("\u521B\u5EFA\u6848\u4EF6");
		btn_create.setForeground(MainClass.btnColor);
		btn_create.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btn_create.setBackground(Color.WHITE);
		btn_create.addActionListener(btn_createAction);
		panel_btn.add(btn_create);
		
		JButton btn_search = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		btn_search.setForeground(MainClass.btnColor);
		btn_search.setBackground(Color.WHITE);
		btn_search.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btn_search.setEnabled(false);
		panel_btn.add(btn_search);
		
		JPanel panel_table = new JPanel();
		panel_table.setBorder(new LineBorder(MainClass.btnColor, 2));
		panel_table.setBackground(Color.BLACK);
		contentPane.add(panel_table, BorderLayout.CENTER);
		panel_table.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		panel_table.add(scrollPane);
		
		JPanel panel_list = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_list.setBackground(Color.WHITE);
		contentPane.add(panel_list, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(MainClass.btnColor, 2));
		panel.setBackground(Color.WHITE);
		panel_list.add(panel);
		
		JLabel label = new JLabel("\u8BBE\u5907\u7F16\u53F7:");
		panel.add(label);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		combo_list = new JComboBox();
		combo_list.setForeground(Color.WHITE);
		panel.add(combo_list);
		combo_list.setBackground(MainClass.btnColor);
		combo_list.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JButton btn_deletedevice = new JButton("\u5220\u9664");
		btn_deletedevice.setForeground(Color.WHITE);
		panel.add(btn_deletedevice);
		btn_deletedevice.setBackground(MainClass.btnColor);
		btn_deletedevice.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btn_deletedevice.addActionListener(btn_deletedeviceAction);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		//视图数据初始化
		init();
	}
	
	public void init(){
		try {
			int count=db.countcase();
			System.out.println(count);
			
		
			Object[] header = new String[]{"案件号","案件名", "设备数量","调查人"};
	        Cases = new String[count][4];
	        combo_list.removeAllItems();
	        List<String> caseid=db.searchcasestring("caseid");
	        List<String> casename=db.searchcasestring("casename");
	       
	        List<String> name=db.searchcasestring("name");
	        for (int i = 0; i <count; i++) {
	            Cases[i][0] = caseid.get(i);
	            Cases[i][1] = casename.get(i);
	            Cases[i][2] = String.valueOf(db.countdevice(caseid.get(i)));
	            Cases[i][3] = name.get(i);
	            combo_list.addItem(Cases[i][0]);
	        }
	        
	        //构建表格数据模型
	        TableModel model = new DefaultTableModel(Cases, header) {
	        	public boolean isCellEditable(int row,int column)
	        	{
	        		if(column==3) return true;
	        		else return false;
	        	}
	        };
	        
	        //创建单元格渲染器暨鼠标事件监听器
	        //LinkCellRenderer renderer = new LinkCellRenderer();
			//创建表格对象
			table = new JTable(model);
			table.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			table.setBackground(Color.WHITE);
			table.addMouseListener(table_Mouse);
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setBackground(Color.WHITE);
			table.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 15));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); 
			//注入渲染器
			FitTableColumns(table);
			scrollPane.setViewportView(table);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ActionListener btn_createAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainClass.cc = new CaseCreate();
		}
	};
	
	public ActionListener btn_deletedeviceAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				db.deletecase(Cases[combo_list.getSelectedIndex()][0]);
				
				init();
				MainClass.cm.init();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	
	public MouseListener table_Mouse = new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			
			//System.out.print(row+" "+column);
			
			if(e.getClickCount() == 2){
				MainClass.dm = new DeviceManage(Cases[row]);
			}
		}
	};
	

	
}
