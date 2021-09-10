package wifi_final;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Panel;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;

public class EvidenceInfo {

	 JFrame frame;
	private JScrollPane scrollPane;
	private JTree tree;
	private JPanel panel;
	private CardLayout c1;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JTextField textField_productname;
	private JTextField textField_productid;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_14;
	private JScrollPane scrollPane_linedevice;
	private JScrollPane scrollPane_5Gdevice;
	private JTextArea textArea_5Gdevice;
	private JScrollPane scrollPane_offlinedevice;
	private JTextArea textArea_offlinedevice;
	private JScrollPane scrollPane_upnp;
	private JTable table_upnp,table_blacklist,table_whitelist,table_port,table_linedevice,table_5Gdevice,table_24Gdevice,table_offlinedevice;
	private JPanel panel_2;
	private JLabel lblNewLabel_17;
	private JPanel panel_18;
	private JButton btnNewButton;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_14;
	private JTextField textField_EMUIedition;
	private JPanel panel_15;
	private JPanel panel_16;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_18;
	private JTextField textField_wanip;
	private JTextField textField_lanip;
	private JTextField textField_gateway;
	private JTextField textField_dns1;
	private JTextField textField_dns2;
	private StringBuilder sb = new StringBuilder();
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField_24Gway;
	private JTextField textField_24Gbind;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_23;
	private JTextField textField_5Gway;
	private JTextField textField_5Gbind;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_26;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private JTextField textField_iprange;
	private JTextField textField_usetime;
	private JPanel panel_19;
	private JLabel lblNewLabel_19;
	private JTextField textField_timezone;
	private JScrollPane scrollPane_blacklist;
	private JTextArea textArea_blacklist;
	private JScrollPane scrollPane_whitelist;
	private JTextArea textArea_whitelist;
	private JScrollPane scrollPane_24Gdevice;
	private JTextArea textArea_24Gdevice;
	private JPanel panel_17;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField textField_wanmac;
	private JTextField textField_lanmac;
	private JScrollPane scrollPane_port;
	private JPanel panel_5;
	private JPanel panel_9;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel_10;
	private JTextField textField_dmzdevice;
	private JTextField textField_dmzip;
	private JTextField textField_productedition;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_20;
	private JPanel panel_13;
	private JTextField textField_routermodel;
	private JTextField textField_routerversion;
	private JTextField textField_routermac;
	private JTextField textField_routersn;
	/**
	 * Launch the application.
	 */
	
	
	public void readsql(String[] Device) {
		Testdb db=new Testdb();
        
      if(Device[2].equals("华为AX3"))
      {
    	  
      
    	try {
    		DefaultTableModel model = new DefaultTableModel();
            String[] columnTitle = {"设备名称","IP地址","MAC地址","在线时长"};
            model.setColumnIdentifiers(columnTitle);
            List<String> str1= new ArrayList();
            List<String> str2= new ArrayList();
            List<String> str3= new ArrayList();
            List<String> str4= new ArrayList();
            str1=db.selecthuaweilist(Device[4],"list_linename", "flag_line");
            str2=db.selecthuaweilist(Device[4],"list_lineip", "flag_line");	
    		str3=db.selecthuaweilist(Device[4],"list_linemac", "flag_line");	
    		str4=db.selecthuaweilist(Device[4],"list_linetime", "flag_line");	
            
            for(int i=0;i<str1.size();i++)
            {
            	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
            	data.add(str1.get(i));
            	data.add(str2.get(i));
            	data.add(str3.get(i));
            	data.add(str4.get(i));
  			  	model.addRow(data); 
            }
            table_linedevice = new JTable(model);
            //table_linedevice.setEnabled(false);
    		scrollPane_linedevice.setViewportView(table_linedevice);
    	} 
    	catch (Exception e) {
            e.printStackTrace();
        }
    	
    	try {
    		DefaultTableModel model = new DefaultTableModel();
            String[] columnTitle = {"设备名称","IP地址","MAC地址","在线时长"};
            model.setColumnIdentifiers(columnTitle);
            List<String> str1= new ArrayList();
            List<String> str2= new ArrayList();
            List<String> str3= new ArrayList();
            List<String> str4= new ArrayList();
            str1=db.selecthuaweilist(Device[4],"list_24Gname", "flag_24G");	
    		str2=db.selecthuaweilist(Device[4],"list_24Gip", "flag_24G");	
    		str3=db.selecthuaweilist(Device[4],"list_24Gmac", "flag_24G");	
    		str4=db.selecthuaweilist(Device[4],"list_24Gtime", "flag_24G");
            
            for(int i=0;i<str1.size();i++)
            {
            	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
            	data.add(str1.get(i));
            	data.add(str2.get(i));
            	data.add(str3.get(i));
            	data.add(str4.get(i));
  			  	model.addRow(data); 
            }
            table_24Gdevice = new JTable(model);
            //table_24Gdevice.setEnabled(false);
    		scrollPane_24Gdevice.setViewportView(table_24Gdevice);
    	} 
    	catch (Exception e) {
            e.printStackTrace();
        }
    	
         try {  
        	 DefaultTableModel model = new DefaultTableModel();
             String[] columnTitle = {"设备名称","IP地址","MAC地址","在线时长"};
             model.setColumnIdentifiers(columnTitle);
             List<String> str1= new ArrayList();
             List<String> str2= new ArrayList();
             List<String> str3= new ArrayList();
             List<String> str4= new ArrayList();
             str1=db.selecthuaweilist(Device[4],"list_5Gname", "flag_5G");	
     		str2=db.selecthuaweilist(Device[4],"list_5Gip", "flag_5G");	
     		str3=db.selecthuaweilist(Device[4],"list_5Gmac", "flag_5G");	
     		str4=db.selecthuaweilist(Device[4],"list_5Gtime", "flag_5G");
             
             for(int i=0;i<str1.size();i++)
             {
             	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
             	data.add(str1.get(i));
             	data.add(str2.get(i));
             	data.add(str3.get(i));
             	data.add(str4.get(i));
   			  	model.addRow(data); 
             }
             table_5Gdevice = new JTable(model);
             //table_5Gdevice.setEnabled(false);
     		scrollPane_5Gdevice.setViewportView(table_5Gdevice);
         } 
         catch (Exception e) {
             e.printStackTrace();
         }
         
         try {
        	 DefaultTableModel model = new DefaultTableModel();
             String[] columnTitle = {"设备名称","IP地址","MAC地址","在线时长"};
             model.setColumnIdentifiers(columnTitle);
             List<String> str1= new ArrayList();
             List<String> str2= new ArrayList();
             List<String> str3= new ArrayList();
             List<String> str4= new ArrayList();
             str1=db.selecthuaweilist(Device[4],"list_offlinename", "flag_offline");	
       		str2=db.selecthuaweilist(Device[4],"list_offlineip", "flag_offline");	
       		str3=db.selecthuaweilist(Device[4],"list_offlinemac", "flag_offline");	
       		str4=db.selecthuaweilist(Device[4],"list_offlinetime", "flag_offline");	
             
             for(int i=0;i<str1.size();i++)
             {
             	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
             	data.add(str1.get(i));
             	data.add(str2.get(i));
             	data.add(str3.get(i));
             	data.add(str4.get(i));
   			  	model.addRow(data); 
             }
             table_offlinedevice = new JTable(model);
             //table_offlinedevice.setEnabled(false);
     		scrollPane_offlinedevice.setViewportView(table_offlinedevice);
        	 
         } 
         catch (Exception e) {
             e.printStackTrace();
         }
     
         
         
         
         
            //产品名称
         try {
            textField_productname.setText(db.select(Device[4],"product_name"));
            textField_productname.setEditable(false);
            //序列号
            textField_productid.setText(db.select(Device[4],"product_id"));
            textField_productid.setEditable(false);
            //软件版本
            textField_productedition.setText(db.select(Device[4],"product_edition"));
            textField_productedition.setEditable(false);
            //EMUI Router 版本
            textField_EMUIedition.setText(db.select(Device[4],"EMUI_Route_edition"));
            textField_EMUIedition.setEditable(false);
            
            //WAN MAC
            textField_wanmac.setText(db.select(Device[4],"wan_mac"));
            textField_wanmac.setEditable(false);
            //LAN MAC
            textField_lanmac.setText(db.select(Device[4],"lan_mac"));
            textField_lanmac.setEditable(false);
            //WAN IP
            textField_wanip.setText(db.select(Device[4],"wan_ip"));
            textField_wanip.setEditable(false);
            //LAN IP
            textField_lanip.setText(db.select(Device[4],"lan_ip"));
            textField_lanip.setEditable(false);
            //默认网关
            textField_gateway.setText(db.select(Device[4],"gateway"));
            textField_gateway.setEditable(false);
            //DNS服务器
            textField_dns1.setText(db.select(Device[4],"dns1"));
            textField_dns1.setEditable(false);
            textField_dns2.setText(db.select(Device[4],"dns2"));
            textField_dns2.setEditable(false);
         }
         catch (Exception e) {
             e.printStackTrace();
         }
         
         try {
            String ip="192.168.3."+db.select(Device[4],"ip_begin")+"-"+db.select(Device[4],"ip_end");
            textField_iprange.setText(ip);
            textField_iprange.setEditable(false);
            
            textField_usetime.setText(db.select(Device[4],"usetime"));
            textField_usetime.setEditable(false);
         }
         catch (Exception e) {
             e.printStackTrace();
         }
         try {
            //upnp
            DefaultTableModel model = new DefaultTableModel();
            String[] columnTitle = {"远程主机","内部主机","协议类型","外部端口","内部端口","应用描述"};
            model.setColumnIdentifiers(columnTitle);
            List<String> str1= new ArrayList();
            List<String> str2= new ArrayList();
            List<String> str3= new ArrayList();
            List<String> str4= new ArrayList();
            List<String> str5= new ArrayList();
            List<String> str6= new ArrayList();
           
            str1=db.selecthuaweilist(Device[4],"upnp_outip", "flag_upnp");
            str2=db.selecthuaweilist(Device[4],"upnp_inip", "flag_upnp");
            str3=db.selecthuaweilist(Device[4],"upnp_type", "flag_upnp");
            str4=db.selecthuaweilist(Device[4],"upnp_out", "flag_upnp");
            str5=db.selecthuaweilist(Device[4],"upnp_in", "flag_upnp");
            str6=db.selecthuaweilist(Device[4],"upnp_describe", "flag_upnp");
            for(int i=0;i<str1.size();i++)
            {
            	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
            	data.add(str1.get(i));
            	data.add(str2.get(i));
            	data.add(str3.get(i));
            	data.add(str4.get(i));
            	data.add(str5.get(i));
            	data.add(str6.get(i));
  			  	model.addRow(data); 
            }
            table_upnp = new JTable(model);
            //table_upnp.setEnabled(false);
    		scrollPane_upnp.setViewportView(table_upnp);
         }
         catch (Exception e) {
             e.printStackTrace();
         }
         
         try {
             //port
             DefaultTableModel model = new DefaultTableModel();
             String[] columnTitle = {"服务名","主机名","主机IP","服务类型","内部端口","外部端口"};
             model.setColumnIdentifiers(columnTitle);
             List<String> str1= new ArrayList();
             List<String> str2= new ArrayList();
             List<String> str3= new ArrayList();
             List<String> str4= new ArrayList();
             List<String> str5= new ArrayList();
             List<String> str6= new ArrayList();
            
             str1=db.selecthuaweilist(Device[4],"port_name", "flag_port");
             str2=db.selecthuaweilist(Device[4],"port_device", "flag_port");
             str3=db.selecthuaweilist(Device[4],"port_ip", "flag_port");
             str4=db.selecthuaweilist(Device[4],"port_type", "flag_port");
             str5=db.selecthuaweilist(Device[4],"port_in", "flag_port");
             str6=db.selecthuaweilist(Device[4],"port_out", "flag_port");
             for(int i=0;i<str1.size();i++)
             {
             	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
             	data.add(str1.get(i));
             	data.add(str2.get(i));
             	data.add(str3.get(i));
             	data.add(str4.get(i));
             	data.add(str5.get(i));
             	data.add(str6.get(i));
   			  	model.addRow(data); 
             }
             table_port = new JTable(model);
            // table_port.setEnabled(false);
     		scrollPane_port.setViewportView(table_port);
          }
          catch (Exception e) {
              e.printStackTrace();
          }
         
         try {
             
             textField_dmzdevice.setText(db.selecthuaweilist(Device[4],"dmz_device", "flag_dmz").get(0));
             textField_dmzdevice.setEditable(false);
             
             textField_dmzip.setText(db.selecthuaweilist(Device[4],"dmz_ip", "flag_dmz").get(0));
             textField_dmzip.setEditable(false);
          }
          catch (Exception e) {
              e.printStackTrace();
          }

         try {
            //WI-FI高级
            //2.4G WI-FI
            //2.4G Wi-Fi 信道
            textField_24Gway.setText(db.select(Device[4],"way_24G"));
            textField_24Gway.setEditable(false);
            
           
            
            //Wi-Fi 频宽
            textField_24Gbind.setText(db.select(Device[4],"bind_24G"));
            textField_24Gbind.setEditable(false);
            
          
            
            //5G WI-FI
            //5G Wi-Fi 信道
            textField_5Gway.setText(db.select(Device[4],"way_5G"));
            textField_5Gway.setEditable(false);
            
        
            //Wi-Fi 频宽
            textField_5Gbind.setText(db.select(Device[4],"bind_5G"));
            textField_5Gbind.setEditable(false);
            
           
         }
         catch (Exception e) {
             e.printStackTrace();
         }
         try {
        	//blacklist
             DefaultTableModel model = new DefaultTableModel();
             String[] columnTitle = {"设备名","设备MAC地址"};
             model.setColumnIdentifiers(columnTitle);
             List<String> str1= new ArrayList();
             List<String> str2= new ArrayList();

             str1=db.selecthuaweilist(Device[4],"blacklist_name", "flag_blacklist");	
       		str2=db.selecthuaweilist(Device[4],"blacklist_mac", "flag_blacklist");	
       		
             for(int i=0;i<str1.size();i++)
             {
             	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
             	data.add(str1.get(i));
             	data.add(str2.get(i));
             	
   			  	model.addRow(data); 
             }
             table_blacklist = new JTable(model);
            // table_blacklist.setEnabled(false);
     		scrollPane_blacklist.setViewportView(table_blacklist);
        	 
  	 
         } 
         catch (Exception e) {
             e.printStackTrace();
         }
         
         
         try {
        	//whitelist
             DefaultTableModel model = new DefaultTableModel();
             String[] columnTitle = {"设备名","设备MAC地址"};
             model.setColumnIdentifiers(columnTitle);
             List<String> str1= new ArrayList();
             List<String> str2= new ArrayList();

             str1=db.selecthuaweilist(Device[4],"whitelist_name", "flag_whitelist");	
        		str2=db.selecthuaweilist(Device[4],"whitelist_mac", "flag_whitelist");	
       		
             for(int i=0;i<str1.size();i++)
             {
             	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
             	data.add(str1.get(i));
             	data.add(str2.get(i));
             	
   			  	model.addRow(data); 
             }
             table_whitelist = new JTable(model);
           //  table_whitelist.setEnabled(false);
     		scrollPane_whitelist.setViewportView(table_whitelist);
        	 
        	 
        	 
          } 
          catch (Exception e) {
              e.printStackTrace();
          }
          textArea_whitelist.setEditable(false);
         
         
         try {
            //时区
            textField_timezone.setText(db.select(Device[4],"timezone"));
            textField_timezone.setEditable(false);
         }
         catch (Exception e) {
             e.printStackTrace();
         }
      }
      else
      {
    	  
          
      	try {
      		DefaultTableModel model = new DefaultTableModel();
              String[] columnTitle = {"设备名称","IP地址","MAC地址","在线时长"};
              model.setColumnIdentifiers(columnTitle);
              List<String> str1= new ArrayList();
              List<String> str2= new ArrayList();
              List<String> str3= new ArrayList();
              List<String> str4= new ArrayList();
              str1=db.selectxiaomilist(Device[4],"list_linename", "flag_line");
              str2=db.selectxiaomilist(Device[4],"list_lineip", "flag_line");	
      		str3=db.selectxiaomilist(Device[4],"list_linemac", "flag_line");	
      		str4=db.selectxiaomilist(Device[4],"list_linetime", "flag_line");	
              
              for(int i=0;i<str1.size();i++)
              {
              	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
              	data.add(str1.get(i));
              	data.add(str2.get(i));
              	data.add(str3.get(i));
              	data.add(str4.get(i));
    			  	model.addRow(data); 
              }
              table_linedevice = new JTable(model);
              //table_linedevice.setEnabled(false);
      		scrollPane_linedevice.setViewportView(table_linedevice);
      	} 
      	catch (Exception e) {
              e.printStackTrace();
          }
      	
      	try {
      		DefaultTableModel model = new DefaultTableModel();
              String[] columnTitle = {"设备名称","IP地址","MAC地址","在线时长"};
              model.setColumnIdentifiers(columnTitle);
              List<String> str1= new ArrayList();
              List<String> str2= new ArrayList();
              List<String> str3= new ArrayList();
              List<String> str4= new ArrayList();
              str1=db.selectxiaomilist(Device[4],"list_24Gname", "flag_24G");	
      		str2=db.selectxiaomilist(Device[4],"list_24Gip", "flag_24G");	
      		str3=db.selectxiaomilist(Device[4],"list_24Gmac", "flag_24G");	
      		str4=db.selectxiaomilist(Device[4],"list_24Gtime", "flag_24G");
              
              for(int i=0;i<str1.size();i++)
              {
              	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
              	data.add(str1.get(i));
              	data.add(str2.get(i));
              	data.add(str3.get(i));
              	data.add(str4.get(i));
    			  	model.addRow(data); 
              }
              table_24Gdevice = new JTable(model);
             // table_24Gdevice.setEnabled(false);
      		scrollPane_24Gdevice.setViewportView(table_24Gdevice);
      	} 
      	catch (Exception e) {
              e.printStackTrace();
          }
      	
           try {  
          	 DefaultTableModel model = new DefaultTableModel();
               String[] columnTitle = {"设备名称","IP地址","MAC地址","在线时长"};
               model.setColumnIdentifiers(columnTitle);
               List<String> str1= new ArrayList();
               List<String> str2= new ArrayList();
               List<String> str3= new ArrayList();
               List<String> str4= new ArrayList();
               str1=db.selectxiaomilist(Device[4],"list_5Gname", "flag_5G");	
       		str2=db.selectxiaomilist(Device[4],"list_5Gip", "flag_5G");	
       		str3=db.selectxiaomilist(Device[4],"list_5Gmac", "flag_5G");	
       		str4=db.selectxiaomilist(Device[4],"list_5Gtime", "flag_5G");
               
               for(int i=0;i<str1.size();i++)
               {
               	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
               	data.add(str1.get(i));
               	data.add(str2.get(i));
               	data.add(str3.get(i));
               	data.add(str4.get(i));
     			  	model.addRow(data); 
               }
               table_5Gdevice = new JTable(model);
               
              // table_5Gdevice.setEnabled(false);
       		scrollPane_5Gdevice.setViewportView(table_5Gdevice);
           } 
           catch (Exception e) {
               e.printStackTrace();
           }

              
           try {
        	 //产品型号
              textField_routermodel.setText(db.selectxiaomitotal(Device[4],"routermodel"));
              textField_productname.setEditable(false);
              //路由器版本
              textField_routerversion.setText(db.selectxiaomitotal(Device[4],"routerversion"));
              textField_routerversion.setEditable(false);
              //路由器mac
              textField_routermac.setText(db.selectxiaomitotal(Device[4],"routermac"));
              textField_routermac.setEditable(false);
              //路由器序列号
              textField_routersn.setText(db.selectxiaomitotal(Device[4],"routersn"));
              textField_routersn.setEditable(false);
              
              
           
              //IP
              textField_lanip.setText(db.selectxiaomitotal(Device[4],"line_ip"));
              textField_lanip.setEditable(false);
              //默认网关
              textField_gateway.setText(db.selectxiaomitotal(Device[4],"wangguan"));
              textField_gateway.setEditable(false);
              //DNS服务器
              textField_dns1.setText(db.selectxiaomitotal(Device[4],"dns1"));
              textField_dns1.setEditable(false);
              textField_dns2.setText(db.selectxiaomitotal(Device[4],"dns2"));
              textField_dns2.setEditable(false);
           }
           catch (Exception e) {
               e.printStackTrace();
           }
           
           try {
              String ip="192.168.31."+db.selectxiaomitotal(Device[4],"ip_begin")+"-"+db.selectxiaomitotal(Device[4],"ip_end");
              textField_iprange.setText(ip);
              textField_iprange.setEditable(false);
              
              textField_usetime.setText(db.selectxiaomitotal(Device[4],"usetime")+"分钟");
              textField_usetime.setEditable(false);
           }
           catch (Exception e) {
               e.printStackTrace();
           }
           try {
              //upnp
              DefaultTableModel model = new DefaultTableModel();
              String[] columnTitle = {"协议","应用名称","客户端ip","内部端口","外部端口"};
              model.setColumnIdentifiers(columnTitle);
              List<String> str1= new ArrayList();
              List<String> str2= new ArrayList();
              List<String> str3= new ArrayList();
              List<String> str4= new ArrayList();
              List<String> str5= new ArrayList();
              
             
              str1=db.selectxiaomilist(Device[4],"upnp_type", "flag_upnp");
              str2=db.selectxiaomilist(Device[4],"upnp_name", "flag_upnp");
              str3=db.selectxiaomilist(Device[4],"upnp_ip", "flag_upnp");
              str4=db.selectxiaomilist(Device[4],"upnp_in", "flag_upnp");
              str5=db.selectxiaomilist(Device[4],"upnp_out", "flag_upnp");
              
              for(int i=0;i<str1.size();i++)
              {
              	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
              	data.add(str1.get(i));
              	data.add(str2.get(i));
              	data.add(str3.get(i));
              	data.add(str4.get(i));
              	data.add(str5.get(i));
              
    			  	model.addRow(data); 
              }
              table_upnp = new JTable(model);
              //table_upnp.setEnabled(false);
      		scrollPane_upnp.setViewportView(table_upnp);
           }
           catch (Exception e) {
               e.printStackTrace();
           }
           
           try {
               //port
               DefaultTableModel model = new DefaultTableModel();
               String[] columnTitle = {"名称","协议","外部端口","内部IP地址","内部端口"};
               model.setColumnIdentifiers(columnTitle);
               List<String> str1= new ArrayList();
               List<String> str2= new ArrayList();
               List<String> str3= new ArrayList();
               List<String> str4= new ArrayList();
               List<String> str5= new ArrayList();
               
              
               str1=db.selectxiaomilist(Device[4],"port_name", "flag_port");
               str2=db.selectxiaomilist(Device[4],"port_type", "flag_port");
               str3=db.selectxiaomilist(Device[4],"port_out", "flag_port");
               str4=db.selectxiaomilist(Device[4],"port_ip", "flag_port");
               str5=db.selectxiaomilist(Device[4],"port_in", "flag_port");
               
               for(int i=0;i<str1.size();i++)
               {
               	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
               	data.add(str1.get(i));
               	data.add(str2.get(i));
               	data.add(str3.get(i));
               	data.add(str4.get(i));
               	data.add(str5.get(i));
               
     			  	model.addRow(data); 
               }
               table_port = new JTable(model);
               //table_port.setEnabled(false);
       		scrollPane_port.setViewportView(table_port);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
           
           try {
               
               textField_dmzip.setText(db.selectxiaomilist(Device[4],"dmz_dmzip", "flag_dmz").get(0));
               textField_dmzip.setEditable(false);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

           try {
              //WI-FI高级
              //2.4G WI-FI
              //2.4G Wi-Fi 信道
              textField_24Gway.setText(db.selectxiaomitotal(Device[4],"way_24G"));
              textField_24Gway.setEditable(false);
              
             
              
              //Wi-Fi 频宽
              textField_24Gbind.setText(db.selectxiaomitotal(Device[4],"width_24G"));
              textField_24Gbind.setEditable(false);
              
            
              
              //5G WI-FI
              //5G Wi-Fi 信道
              textField_5Gway.setText(db.selectxiaomitotal(Device[4],"way_5G"));
              textField_5Gway.setEditable(false);
              
          
              //Wi-Fi 频宽
              textField_5Gbind.setText(db.selectxiaomitotal(Device[4],"width_5G"));
              textField_5Gbind.setEditable(false);
              
             
           }
           catch (Exception e) {
               e.printStackTrace();
           }
           try {
          	//blacklist
               DefaultTableModel model = new DefaultTableModel();
               String[] columnTitle = {"设备名","设备MAC地址"};
               model.setColumnIdentifiers(columnTitle);
               List<String> str1= new ArrayList();
               List<String> str2= new ArrayList();

               str1=db.selectxiaomilist(Device[4],"blacklist_name", "flag_blacklist");	
         		str2=db.selectxiaomilist(Device[4],"blacklist_mac", "flag_blacklist");	
         		
               for(int i=0;i<str1.size();i++)
               {
               	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
               	data.add(str1.get(i));
               	data.add(str2.get(i));
               	
     			  	model.addRow(data); 
               }
               table_blacklist = new JTable(model);
              // table_blacklist.setEnabled(false);
       		scrollPane_blacklist.setViewportView(table_blacklist);
          	 
    	 
           } 
           catch (Exception e) {
               e.printStackTrace();
           }
           
           
           try {
          	//whitelist
               DefaultTableModel model = new DefaultTableModel();
               String[] columnTitle = {"设备名","设备MAC地址"};
               model.setColumnIdentifiers(columnTitle);
               List<String> str1= new ArrayList();
               List<String> str2= new ArrayList();

               str1=db.selectxiaomilist(Device[4],"whitelist_name", "flag_whitelist");	
          		str2=db.selectxiaomilist(Device[4],"whitelist_mac", "flag_whitelist");	
         		
               for(int i=0;i<str1.size();i++)
               {
               	Vector data = new Vector(); // 数据行向量集，因为列表不止一行，往里面添加数据行向量，添加方法add(row)
               	data.add(str1.get(i));
               	data.add(str2.get(i));
               	
     			  	model.addRow(data); 
               }
               table_whitelist = new JTable(model);
              // table_whitelist.setEnabled(false);
       		scrollPane_whitelist.setViewportView(table_whitelist);
          	 
          	 
          	 
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
            textArea_whitelist.setEditable(false);
           
           
           try {
              //时区
              textField_timezone.setText(db.selectxiaomitotal(Device[4],"timezone"));
              textField_timezone.setEditable(false);
           }
           catch (Exception e) {
               e.printStackTrace();
           }
      }
    }
	
	
	public void getrusult(String[] Device) {
		Testdb db=new Testdb();
		List<String> str1= new ArrayList();
        List<String> str2= new ArrayList();
        List<String> str3= new ArrayList();
        List<String> str4= new ArrayList();
        List<String> str5= new ArrayList();
        List<String> str6= new ArrayList();
       
        if(Device[2].equals("华为AX3"))
        {
		try {
			
            sb.append("<html>");
    		sb.append("<head>");
    		sb.append("<title>");
    		sb.append("取证结果显示");
    		sb.append("</title>");
    		sb.append("</head>");
    		sb.append("<body>");
    		sb.append("<center>");
    		sb.append("<div>");
    		sb.append("<div style=\"display:inline;margin-right:-5px;\">");
    		sb.append("<image src=\"image\\001.jpg\" width=500px height=67px>");
    		sb.append("</div>");
    		sb.append("<div style=\"display:inline\">");
    		sb.append("<image src=\"image\\002.jpg\" width=950px height=67px >");
    		sb.append("</div>");
    		sb.append("</div>");
    		sb.append("</center>");
    		sb.append("<br>");
    		sb.append("<div>");
    		sb.append("<table border=0 width=30%>");
    		sb.append("<tr>");
    		sb.append("<th colspan=2>");
    		sb.append("<b>");
    		sb.append("路由器基本信息");
    		sb.append("</b>");
    		sb.append("</th>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("产品名称");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"product_name"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("序列号");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"product_id"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("软件版本");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"product_edition"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("EMUI Router版本");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"EMUI_Route_edition"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("WAN MAC");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"wan_mac"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("LAN MAC");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"lan_mac"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("WAN IP");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"wan_ip"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("LAN IP");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"lan_ip"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("默认网关");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"gateway"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("DNS1");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"dns1"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("DNS2");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"dns2"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		
    		
    		
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("DHCP ip范围");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append("192.168.3."+db.select(Device[4],"ip_begin")+"-"+db.select(Device[4],"ip_end"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("DHCP ip有效时长");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"usetime"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("时区信息");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.select(Device[4],"timezone"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("</tr>");
    		
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("DMZ主机");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.selecthuaweilist(Device[4],"dmz_device", "flag_dmz"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td align=\"left\">");
    		sb.append("DMZ主机ip");
    		sb.append("</td>");
    		sb.append("<td align=\"left\">");
    		sb.append(db.selecthuaweilist(Device[4],"dmz_ip", "flag_dmz"));
    		sb.append("</td>");
    		sb.append("</tr>");
    		
    		
    		
    		sb.append("</table>");
    		sb.append("</div>");
    		sb.append("<br>");
    		sb.append("<div>");
    		sb.append("<table border=1 width=1250px>");
    		sb.append("<tr>");
    		sb.append("<th colspan=4 bgcolor=\"#00FFFF\">");
    		sb.append("有线连接设备信息");
    		sb.append("</th>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td>");
    		sb.append("设备名字");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备IP");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备MAC");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备在线时间");
    		sb.append("</td>");
    		sb.append("</tr>");
    		
    		
    		str1=db.selecthuaweilist(Device[4],"list_linename", "flag_line");	
    		str2=db.selecthuaweilist(Device[4],"list_lineip", "flag_line");	
    		str3=db.selecthuaweilist(Device[4],"list_linemac", "flag_line");	
    		str4=db.selecthuaweilist(Device[4],"list_linetime", "flag_line");	
    		
    		for(int i=0;i<str1.size();i++)
    		{
            	//设备名字
            	sb.append("<tr>");
        		sb.append("<td>");
        		sb.append(str1.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备IP
        		sb.append(str2.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备MAC
        		sb.append(str3.get(i).substring(7));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备在线时长
        		sb.append(str4.get(i));
        		sb.append("</td>");
        		sb.append("</tr>");
            }
    		sb.append("</table>");
    		sb.append("</div>");
    		sb.append("<br>");
    		sb.append("<div>");
    		sb.append("<table border=1 width=1250px>");
    		sb.append("<tr>");
    		sb.append("<th colspan=4 bgcolor=\"#00FFFF\">");
    		sb.append("2.4G连接设备信息");
    		sb.append("</th>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td>");
    		sb.append("设备名字");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备IP");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备MAC");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备在线时间");
    		sb.append("</td>");
    		sb.append("</tr>");
    		str1=db.selecthuaweilist(Device[4],"list_24Gname", "flag_24G");	
    		str2=db.selecthuaweilist(Device[4],"list_24Gip", "flag_24G");	
    		str3=db.selecthuaweilist(Device[4],"list_24Gmac", "flag_24G");	
    		str4=db.selecthuaweilist(Device[4],"list_24Gtime", "flag_24G");	
    		
    		for(int i=0;i<str1.size();i++)
    		{
            	//设备名字
            	sb.append("<tr>");
        		sb.append("<td>");
        		sb.append(str1.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备IP
        		sb.append(str2.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备MAC
        		sb.append(str3.get(i).substring(7));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备在线时长
        		sb.append(str4.get(i));
        		sb.append("</td>");
        		sb.append("</tr>");
            }
    		sb.append("</table>");
    		sb.append("</div>");
    		sb.append("<br>");
    		sb.append("<div>");
    		sb.append("<table border=1 width=1250px>");
    		sb.append("<tr>");
    		sb.append("<th colspan=4 bgcolor=\"#00FFFF\">");
    		sb.append("5G连接设备信息");
    		sb.append("</th>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td>");
    		sb.append("设备名字");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备IP");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备MAC");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备在线时间");
    		sb.append("</td>");
    		sb.append("</tr>");
    		str1=db.selecthuaweilist(Device[4],"list_5Gname", "flag_5G");	
    		str2=db.selecthuaweilist(Device[4],"list_5Gip", "flag_5G");	
    		str3=db.selecthuaweilist(Device[4],"list_5Gmac", "flag_5G");	
    		str4=db.selecthuaweilist(Device[4],"list_5Gtime", "flag_5G");	
    		
    		for(int i=0;i<str1.size();i++)
    		{
            	//设备名字
            	sb.append("<tr>");
        		sb.append("<td>");
        		sb.append(str1.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备IP
        		sb.append(str2.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备MAC
        		sb.append(str3.get(i).substring(7));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备在线时长
        		sb.append(str4.get(i));
        		sb.append("</td>");
        		sb.append("</tr>");
            }
    		sb.append("</table>");
    		sb.append("</div>");
    		sb.append("<br>");
    		sb.append("<div>");
    		sb.append("<table border=1 width=1250px>");
    		sb.append("<tr>");
    		sb.append("<th colspan=4 bgcolor=\"#00FFFF\">");
    		sb.append("离线连接设备信息");
    		sb.append("</th>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td>");
    		sb.append("设备名字");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备IP");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备MAC");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("设备在线时间");
    		sb.append("</td>");
    		sb.append("</tr>");
    		str1=db.selecthuaweilist(Device[4],"list_offlinename", "flag_offline");	
    		str2=db.selecthuaweilist(Device[4],"list_offlineip", "flag_offline");	
    		str3=db.selecthuaweilist(Device[4],"list_offlinemac", "flag_offline");	
    		str4=db.selecthuaweilist(Device[4],"list_offlinetime", "flag_offline");	
    		
    		for(int i=0;i<str1.size();i++)
    		{
            	//设备名字
            	sb.append("<tr>");
        		sb.append("<td>");
        		sb.append(str1.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备IP
        		sb.append(str2.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备MAC
        		sb.append(str3.get(i).substring(7));
        		sb.append("</td>");
        		sb.append("<td>");
        		//设备在线时长
        		sb.append(str4.get(i));
        		sb.append("</td>");
        		sb.append("</tr>");
            }
    		sb.append("</table>");
    		sb.append("</div>");
    		sb.append("<br>");
    		sb.append("<div>");
    		sb.append("<table border=1 width=1250px>");
    		sb.append("<tr>");
    		sb.append("<th colspan=6 bgcolor=\"#00FFFF\">");
    		sb.append("upnp端口映射");
    		sb.append("</th>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td>");
    		sb.append("远程主机");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("内部主机");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("协议类型");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("外部端口");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("内部端口");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("应用描述");
    		sb.append("</td>");
    		sb.append("</tr>");
    		str1=db.selecthuaweilist(Device[4],"upnp_outip", "flag_upnp");	
    		str2=db.selecthuaweilist(Device[4],"upnp_inip", "flag_upnp");	
    		str3=db.selecthuaweilist(Device[4],"upnp_type", "flag_upnp");	
    		str4=db.selecthuaweilist(Device[4],"upnp_out", "flag_upnp");	
    		str5=db.selecthuaweilist(Device[4],"upnp_in", "flag_upnp");	
    		str6=db.selecthuaweilist(Device[4],"upnp_describe", "flag_upnp");	
    		for(int i=0;i<str1.size();i++)
            {
    			sb.append("<tr>");
        		sb.append("<td>");
        		//远程主机
        		sb.append(str1.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//内部主机
        		sb.append(str2.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//协议类型
        		sb.append(str3.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//外部端口
        		sb.append(str4.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//内部端口
        		sb.append(str5.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//应用描述
        		sb.append(str6.get(i));
        		sb.append("</td>");
        		sb.append("</tr>");
  			  	
            }
    		sb.append("</table>");
    		sb.append("</div>");
    		
    		sb.append("<br>");
    		sb.append("<div>");
    		sb.append("<table border=1 width=1250px>");
    		sb.append("<tr>");
    		sb.append("<th colspan=6 bgcolor=\"#00FFFF\">");
    		sb.append("端口转发");
    		sb.append("</th>");
    		sb.append("</tr>");
    		sb.append("<tr>");
    		sb.append("<td>");
    		sb.append("服务名");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("主机名");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("主机ip");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("服务类型");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("内部端口");
    		sb.append("</td>");
    		sb.append("<td>");
    		sb.append("外部端口");
    		sb.append("</td>");
    		sb.append("</tr>");
    		str1=db.selecthuaweilist(Device[4],"port_name", "flag_port");
            str2=db.selecthuaweilist(Device[4],"port_device", "flag_port");
            str3=db.selecthuaweilist(Device[4],"port_ip", "flag_port");
            str4=db.selecthuaweilist(Device[4],"port_type", "flag_port");
            str5=db.selecthuaweilist(Device[4],"port_in", "flag_port");
            str6=db.selecthuaweilist(Device[4],"port_out", "flag_port");
    		for(int i=0;i<str1.size();i++)
            {
    			sb.append("<tr>");
        		sb.append("<td>");
        		//服务名
        		sb.append(str1.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//主机名
        		sb.append(str2.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//主机ip
        		sb.append(str3.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//服务类型
        		sb.append(str4.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//内部端口
        		sb.append(str5.get(i));
        		sb.append("</td>");
        		sb.append("<td>");
        		//外部端口
        		sb.append(str6.get(i));
        		sb.append("</td>");
        		sb.append("</tr>");
  			  	
            }
    		sb.append("</table>");
    		sb.append("</div>");
    		
    		sb.append("</body>");
    		sb.append("</html>");
	}
		catch (Exception e) {
            e.printStackTrace();
            //lblNewLabel_22.setText("导出失败！");
        }
        }
        else
        {
        	try {
    			
                sb.append("<html>");
        		sb.append("<head>");
        		sb.append("<title>");
        		sb.append("取证结果显示");
        		sb.append("</title>");
        		sb.append("</head>");
        		sb.append("<body>");
        		sb.append("<center>");
        		sb.append("<div>");
        		sb.append("<div style=\"display:inline;margin-right:-5px;\">");
        		sb.append("<image src=\"pic\\下载.jpg\" width=500px>");
        		sb.append("</div>");
        		sb.append("<div style=\"display:inline\">");
        		sb.append("<image src=\"pic\\开头.jpg\" width=950px height=67px >");
        		sb.append("</div>");
        		sb.append("</div>");
        		sb.append("</center>");
        		sb.append("<br>");
        		sb.append("<div>");
        		sb.append("<table border=0 width=30%>");
        		sb.append("<tr>");
        		sb.append("<th colspan=2>");
        		sb.append("<b>");
        		sb.append("路由器基本信息");
        		sb.append("</b>");
        		sb.append("</th>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("路由器型号");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"routermodel"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("系统ROM版本");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"routerversion"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("路由器mac地址");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"routermac"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("路由器序列号");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"routersn"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("LAN IP");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"line_ip"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("默认网关");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"wangguan"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("DNS1");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"dns1"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("DNS2");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"dns2"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		
        		
        		
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("DHCP ip范围");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append("192.168.31."+db.selectxiaomitotal(Device[4],"ip_begin")+"-"+db.selectxiaomitotal(Device[4],"ip_end"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("DHCP ip有效时长");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"usetime"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("时区信息");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomitotal(Device[4],"timezone"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		sb.append("</tr>");
        		
        		
        		sb.append("<tr>");
        		sb.append("<td align=\"left\">");
        		sb.append("DMZ主机ip");
        		sb.append("</td>");
        		sb.append("<td align=\"left\">");
        		sb.append(db.selectxiaomilist(Device[4],"dmz_ip", "flag_dmz"));
        		sb.append("</td>");
        		sb.append("</tr>");
        		
        		
        		
        		sb.append("</table>");
        		sb.append("</div>");
        		sb.append("<br>");
        		sb.append("<div>");
        		sb.append("<table border=1 width=1250px>");
        		sb.append("<tr>");
        		sb.append("<th colspan=4 bgcolor=\"#00FFFF\">");
        		sb.append("有线连接设备信息");
        		sb.append("</th>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td>");
        		sb.append("设备名字");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备IP");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备MAC");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备在线时间");
        		sb.append("</td>");
        		sb.append("</tr>");
        		
        		
        		str1=db.selectxiaomilist(Device[4],"list_linename", "flag_line");	
        		str2=db.selectxiaomilist(Device[4],"list_lineip", "flag_line");	
        		str3=db.selectxiaomilist(Device[4],"list_linemac", "flag_line");	
        		str4=db.selectxiaomilist(Device[4],"list_linetime", "flag_line");	
        		
        		for(int i=0;i<str1.size();i++)
        		{
                	//设备名字
                	sb.append("<tr>");
            		sb.append("<td>");
            		sb.append(str1.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备IP
            		sb.append(str2.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备MAC
            		sb.append(str3.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备在线时长
            		sb.append(str4.get(i));
            		sb.append("</td>");
            		sb.append("</tr>");
                }
        		sb.append("</table>");
        		sb.append("</div>");
        		sb.append("<br>");
        		sb.append("<div>");
        		sb.append("<table border=1 width=1250px>");
        		sb.append("<tr>");
        		sb.append("<th colspan=4 bgcolor=\"#00FFFF\">");
        		sb.append("2.4G连接设备信息");
        		sb.append("</th>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td>");
        		sb.append("设备名字");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备IP");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备MAC");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备在线时间");
        		sb.append("</td>");
        		sb.append("</tr>");
        		str1=db.selectxiaomilist(Device[4],"list_24Gname", "flag_24G");	
        		str2=db.selectxiaomilist(Device[4],"list_24Gip", "flag_24G");	
        		str3=db.selectxiaomilist(Device[4],"list_24Gmac", "flag_24G");	
        		str4=db.selectxiaomilist(Device[4],"list_24Gtime", "flag_24G");	
        		
        		for(int i=0;i<str1.size();i++)
        		{
                	//设备名字
                	sb.append("<tr>");
            		sb.append("<td>");
            		sb.append(str1.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备IP
            		sb.append(str2.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备MAC
            		sb.append(str3.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备在线时长
            		sb.append(str4.get(i));
            		sb.append("</td>");
            		sb.append("</tr>");
                }
        		sb.append("</table>");
        		sb.append("</div>");
        		sb.append("<br>");
        		sb.append("<div>");
        		sb.append("<table border=1 width=1250px>");
        		sb.append("<tr>");
        		sb.append("<th colspan=4 bgcolor=\"#00FFFF\">");
        		sb.append("5G连接设备信息");
        		sb.append("</th>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td>");
        		sb.append("设备名字");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备IP");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备MAC");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("设备在线时间");
        		sb.append("</td>");
        		sb.append("</tr>");
        		str1=db.selectxiaomilist(Device[4],"list_5Gname", "flag_5G");	
        		str2=db.selectxiaomilist(Device[4],"list_5Gip", "flag_5G");	
        		str3=db.selectxiaomilist(Device[4],"list_5Gmac", "flag_5G");	
        		str4=db.selectxiaomilist(Device[4],"list_5Gtime", "flag_5G");	
        		
        		for(int i=0;i<str1.size();i++)
        		{
                	//设备名字
                	sb.append("<tr>");
            		sb.append("<td>");
            		sb.append(str1.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备IP
            		sb.append(str2.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备MAC
            		sb.append(str3.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//设备在线时长
            		sb.append(str4.get(i));
            		sb.append("</td>");
            		sb.append("</tr>");
                }
        		sb.append("</table>");
        		sb.append("</div>");
        		
        		sb.append("<br>");
        		sb.append("<div>");
        		sb.append("<table border=1 width=1250px>");
        		sb.append("<tr>");
        		sb.append("<th colspan=5 bgcolor=\"#00FFFF\">");
        		sb.append("upnp端口映射");
        		sb.append("</th>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td>");
        		sb.append("协议");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("应用名称");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("客户端ip");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("内部端口");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("外部端口");
        		sb.append("</td>");
        		
        		sb.append("</tr>");
        		str1=db.selectxiaomilist(Device[4],"upnp_type", "flag_upnp");	
        		str2=db.selectxiaomilist(Device[4],"upnp_name", "flag_upnp");	
        		str3=db.selectxiaomilist(Device[4],"upnp_ip", "flag_upnp");	
        		str4=db.selectxiaomilist(Device[4],"upnp_in", "flag_upnp");	
        		str5=db.selectxiaomilist(Device[4],"upnp_out", "flag_upnp");	
        			
        		for(int i=0;i<str1.size();i++)
                {
        			sb.append("<tr>");
            		sb.append("<td>");
            		//协议
            		sb.append(str1.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//应用名
            		sb.append(str2.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//ip
            		sb.append(str3.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//内部端口
            		sb.append(str4.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		//外部端口
            		sb.append(str5.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		
      			  	
                }
        		sb.append("</table>");
        		sb.append("</div>");
        		
        		sb.append("<br>");
        		sb.append("<div>");
        		sb.append("<table border=1 width=1250px>");
        		sb.append("<tr>");
        		sb.append("<th colspan=5 bgcolor=\"#00FFFF\">");
        		sb.append("端口转发");
        		sb.append("</th>");
        		sb.append("</tr>");
        		sb.append("<tr>");
        		sb.append("<td>");
        		sb.append("名称");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("协议");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("外部端口");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("内部IP地址");
        		sb.append("</td>");
        		sb.append("<td>");
        		sb.append("内部端口");
        		sb.append("</td>");
        		
        		sb.append("</tr>");
        		str1=db.selectxiaomilist(Device[4],"port_name", "flag_port");
                str2=db.selectxiaomilist(Device[4],"port_type", "flag_port");
                str3=db.selectxiaomilist(Device[4],"port_out", "flag_port");
                str4=db.selectxiaomilist(Device[4],"port_ip", "flag_port");
                str5=db.selectxiaomilist(Device[4],"port_in", "flag_port");
                
        		for(int i=0;i<str1.size();i++)
                {
        			sb.append("<tr>");
            		sb.append("<td>");
            		
            		sb.append(str1.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		
            		sb.append(str2.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		
            		sb.append(str3.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            	
            		sb.append(str4.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		
            		sb.append(str5.get(i));
            		sb.append("</td>");
            		sb.append("<td>");
            		
            		
      			  	
                }
        		sb.append("</table>");
        		sb.append("</div>");
        		
        		sb.append("</body>");
        		sb.append("</html>");
    	}
    		catch (Exception e) {
                e.printStackTrace();
                //lblNewLabel_22.setText("导出失败！");
            }
        }
		
	}
	public void writerusult() {
		
		
		//获取系统时间
		PrintStream printStream = null ;
		Calendar cal=Calendar.getInstance();      
		int y=cal.get(Calendar.YEAR);      
		int m=cal.get(Calendar.MONTH)+1;      
		int d=cal.get(Calendar.DATE);      
		int h=cal.get(Calendar.HOUR_OF_DAY);      
		int mi=cal.get(Calendar.MINUTE);    
		//创建html文件
		try {
            printStream= new PrintStream(new FileOutputStream("取证报告"+String.valueOf(y)+String.valueOf(m)+String.valueOf(d)+String.valueOf(h)+String.valueOf(mi)+".html"));//路径默认在项目根目录下
           } 
		catch (FileNotFoundException e) {
               e.printStackTrace();
           }
		try {
    		printStream.println(sb.toString());
    		printStream.close();
    		
            //lblNewLabel_22.setText("导出成功！");
		}
		
		catch (Exception e) {
            e.printStackTrace();
            //lblNewLabel_22.setText("导出失败！");
        }
		
	}
	
	public void deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
        }
    }
	/**
	 * Create the application.
	 */
	public EvidenceInfo(String[] Device) {
		
		initialize(Device);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] Device) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("\u53D6\u8BC1\u7ED3\u679C");
		frame.setLocation(750,300);
		frame.setBounds(100, 100, 1500, 800);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{159, 176, 176, 0};
		gridBagLayout.rowHeights = new int[]{366, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		panel_17 = new JPanel();
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(0, 0, 0, 5);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 0;
		gbc_panel_17.gridy = 0;
		frame.getContentPane().add(panel_17, gbc_panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_17.add(scrollPane);
		
		tree = new JTree();
		tree.setFont(new Font("宋体", Font.PLAIN, 20));
		tree.setBorder(new LineBorder(MainClass.btnColor, 2));
		tree.setBackground(Color.WHITE);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			    if (node == null) {
			     return;
			    }
			    
			    if (node.toString().equals("有线连接设备信息")) {
			    	
			    	c1.show(panel,"scrollpanel_linedevice");	
			    }
			    if (node.toString().equals("2.4G连接设备信息")) {
			    	
			    	c1.show(panel,"scrollPanel_24Gdevice");	
			    }
			    if (node.toString().equals("5G连接设备信息")) {
			    	
			    	c1.show(panel,"scrollpanel_5Gdevice");	
			    }
			    if (node.toString().equals("离线设备信息")) {
			    	
			    	c1.show(panel,"scrollpanel_offlinedevice");	
			    }
			    if (node.toString().equals("基本信息")) {
			    	if(Device[2].equals("华为AX3"))
			    	{
			    		c1.show(panel,"panel6");
			    	}
			    	else
			    	{
			    		c1.show(panel,"panel11");
			    	}
			    }
			    if (node.toString().equals("IPv4")) {
			    	
			    	c1.show(panel,"panel14");	
			    }
			    if (node.toString().equals("时区信息")) {
			    	
			    	c1.show(panel,"panel19");	
			    }
			    if (node.toString().equals("DHCP服务器信息")) {
			    	
			    	c1.show(panel,"panel24");	
			    }
			    if (node.toString().equals("UPnP端口映射")) {
			    	
			    	c1.show(panel,"scrollpanel_upnp");	
			    }
			    if (node.toString().equals("端口转发")) {
			    	
			    	c1.show(panel,"scrollPanel_port");	
			    }
			    if (node.toString().equals("DMZ")) {
			    	
			    	c1.show(panel,"panel_5");	
			    }
			    if (node.toString().equals("2.4G WI-FI")) {
			    	
			    	c1.show(panel,"panel1");	
			    }
			    if (node.toString().equals("5G WI-FI")) {
			    	
			    	c1.show(panel,"panel20");	
			    }
			    if (node.toString().equals("黑名单列表")) {
			    	
			    	c1.show(panel,"scrollpanel_blacklist");	
			    }
			    if (node.toString().equals("白名单列表")) {
			    	
			    	c1.show(panel,"scrollPanel_whitelist");	
			    }
			    if (node.toString().equals("导出结果")) {
			    	
			    	c1.show(panel,"panel18");	
			    }
			    
			    
			}
		});
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("\u53D6\u8BC1\u7ED3\u679C") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("\u8BBE\u5907\u8FDE\u63A5\u4FE1\u606F");
						node_1.add(new DefaultMutableTreeNode("\u6709\u7EBF\u8FDE\u63A5\u8BBE\u5907\u4FE1\u606F"));
						node_1.add(new DefaultMutableTreeNode("2.4G\u8FDE\u63A5\u8BBE\u5907\u4FE1\u606F"));
						node_1.add(new DefaultMutableTreeNode("5G\u8FDE\u63A5\u8BBE\u5907\u4FE1\u606F"));
						node_1.add(new DefaultMutableTreeNode("\u79BB\u7EBF\u8BBE\u5907\u4FE1\u606F"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("\u8DEF\u7531\u5668\u4FE1\u606F");
						node_1.add(new DefaultMutableTreeNode("\u57FA\u672C\u4FE1\u606F"));
						node_1.add(new DefaultMutableTreeNode("IPv4"));
						node_1.add(new DefaultMutableTreeNode("\u65F6\u533A\u4FE1\u606F"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("\u7F51\u7EDC\u4FE1\u606F");
						node_1.add(new DefaultMutableTreeNode("DHCP\u670D\u52A1\u5668\u4FE1\u606F"));
						node_1.add(new DefaultMutableTreeNode("UPnP\u7AEF\u53E3\u6620\u5C04"));
						node_1.add(new DefaultMutableTreeNode("\u7AEF\u53E3\u8F6C\u53D1"));
						node_1.add(new DefaultMutableTreeNode("DMZ"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("WI-FI\u4FE1\u606F");
						node_2 = new DefaultMutableTreeNode("WIFI\u9AD8\u7EA7\u4FE1\u606F");
							node_2.add(new DefaultMutableTreeNode("2.4G WI-FI"));
							node_2.add(new DefaultMutableTreeNode("5G WI-FI"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("WI-FI\u8BBF\u95EE\u63A7\u5236\u4FE1\u606F");
							node_2.add(new DefaultMutableTreeNode("\u9ED1\u540D\u5355\u5217\u8868"));
							node_2.add(new DefaultMutableTreeNode("\u767D\u540D\u5355\u5217\u8868"));
						node_1.add(node_2);
					add(node_1);
					add(new DefaultMutableTreeNode("\u5BFC\u51FA\u7ED3\u679C"));
				}
			}
		));
		
		
		
		scrollPane.setViewportView(tree);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		c1=new CardLayout(0,0);
		panel.setLayout(c1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2, "panel_2");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_17 = new JLabel("\u00B7\u53D6\u8BC1\u5DF2\u5B8C\u6210\uFF0C\u8BF7\u70B9\u51FB\u5DE6\u4FA7\u83DC\u5355\u8FDB\u884C\u67E5\u770B");
		lblNewLabel_17.setForeground(Color.BLACK);
		lblNewLabel_17.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		panel_2.add(lblNewLabel_17, BorderLayout.NORTH);
		
		panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_11.setBackground(Color.WHITE);
		panel.add(panel_11, "panel11");
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{128, 266, 0};
		gbl_panel_11.rowHeights = new int[]{197, 0, 0};
		gbl_panel_11.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_11.setLayout(gbl_panel_11);
		
		panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.VERTICAL;
		gbc_panel_12.anchor = GridBagConstraints.WEST;
		gbc_panel_12.insets = new Insets(0, 0, 5, 5);
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 0;
		panel_11.add(panel_12, gbc_panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[]{0, 0, 131, 0};
		gbl_panel_12.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_12.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_12.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_12.setLayout(gbl_panel_12);
		
		lblNewLabel_4 = new JLabel("\u8DEF\u7531\u5668\u578B\u53F7\uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridwidth = 3;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_12.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_9 = new JLabel("\u7CFB\u7EDFROM\u7248\u672C\uFF1A");
		lblNewLabel_9.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridwidth = 3;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 1;
		panel_12.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("MAC\u5730\u5740\uFF1A");
		lblNewLabel_10.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 2;
		panel_12.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		lblNewLabel_20 = new JLabel("\u8DEF\u7531\u5668\u5E8F\u5217\u53F7\uFF1A");
		lblNewLabel_20.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_20.gridx = 2;
		gbc_lblNewLabel_20.gridy = 3;
		panel_12.add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.gridx = 1;
		gbc_panel_13.gridy = 0;
		panel_11.add(panel_13, gbc_panel_13);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[]{0, 0};
		gbl_panel_13.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_13.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_13.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_13.setLayout(gbl_panel_13);
		
		textField_routermodel = new JTextField();
		textField_routermodel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_routermodel.setEditable(false);
		textField_routermodel.setColumns(10);
		textField_routermodel.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_routermodel = new GridBagConstraints();
		gbc_textField_routermodel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_routermodel.insets = new Insets(0, 0, 5, 0);
		gbc_textField_routermodel.gridx = 0;
		gbc_textField_routermodel.gridy = 0;
		panel_13.add(textField_routermodel, gbc_textField_routermodel);
		
		textField_routerversion = new JTextField();
		textField_routerversion.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_routerversion.setEditable(false);
		textField_routerversion.setColumns(10);
		textField_routerversion.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_routerversion = new GridBagConstraints();
		gbc_textField_routerversion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_routerversion.insets = new Insets(0, 0, 5, 0);
		gbc_textField_routerversion.gridx = 0;
		gbc_textField_routerversion.gridy = 1;
		panel_13.add(textField_routerversion, gbc_textField_routerversion);
		
		textField_routermac = new JTextField();
		textField_routermac.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_routermac.setEditable(false);
		textField_routermac.setColumns(10);
		textField_routermac.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_routermac = new GridBagConstraints();
		gbc_textField_routermac.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_routermac.insets = new Insets(0, 0, 5, 0);
		gbc_textField_routermac.gridx = 0;
		gbc_textField_routermac.gridy = 2;
		panel_13.add(textField_routermac, gbc_textField_routermac);
		
		textField_routersn = new JTextField();
		textField_routersn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_routersn.setEditable(false);
		textField_routersn.setColumns(10);
		textField_routersn.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_routersn = new GridBagConstraints();
		gbc_textField_routersn.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_routersn.insets = new Insets(0, 0, 5, 0);
		gbc_textField_routersn.gridx = 0;
		gbc_textField_routersn.gridy = 3;
		panel_13.add(textField_routersn, gbc_textField_routersn);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_6.setBackground(Color.WHITE);
		panel.add(panel_6, "panel6");
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{128, 266, 0};
		gbl_panel_6.rowHeights = new int[]{197, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.WEST;
		gbc_panel_7.fill = GridBagConstraints.VERTICAL;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_6.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 131, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		lblNewLabel_5 = new JLabel("\u4EA7\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridwidth = 3;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_7.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("\u5E8F\u5217\u53F7\uFF1A");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridwidth = 3;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 1;
		panel_7.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		lblNewLabel_12 = new JLabel("\u8F6F\u4EF6\u7248\u672C\uFF1A");
		lblNewLabel_12.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_12.gridx = 2;
		gbc_lblNewLabel_12.gridy = 2;
		panel_7.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		lblNewLabel_14 = new JLabel("EMUI Router\u7248\u672C\uFF1A");
		lblNewLabel_14.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_14.gridx = 2;
		gbc_lblNewLabel_14.gridy = 3;
		panel_7.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		lblNewLabel_7 = new JLabel("WAN MAC\u5730\u5740\uFF1A");
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 4;
		panel_7.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("LAN MAC\u5730\u5740\uFF1A");
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 5;
		panel_7.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 0;
		panel_6.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		textField_productname = new JTextField();
		textField_productname.setBackground(Color.WHITE);
		textField_productname.setEditable(false);
		textField_productname.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_productname.setColumns(10);
		GridBagConstraints gbc_textField_productname = new GridBagConstraints();
		gbc_textField_productname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_productname.insets = new Insets(0, 0, 5, 0);
		gbc_textField_productname.gridx = 0;
		gbc_textField_productname.gridy = 0;
		panel_8.add(textField_productname, gbc_textField_productname);
		
		textField_productid = new JTextField();
		textField_productid.setBackground(Color.WHITE);
		textField_productid.setEditable(false);
		textField_productid.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_productid.setColumns(10);
		GridBagConstraints gbc_textField_productid = new GridBagConstraints();
		gbc_textField_productid.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_productid.insets = new Insets(0, 0, 5, 0);
		gbc_textField_productid.gridx = 0;
		gbc_textField_productid.gridy = 1;
		panel_8.add(textField_productid, gbc_textField_productid);
		
		textField_productedition = new JTextField();
		textField_productedition.setBackground(Color.WHITE);
		textField_productedition.setEditable(false);
		textField_productedition.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_productedition.setColumns(10);
		GridBagConstraints gbc_textField_productedition = new GridBagConstraints();
		gbc_textField_productedition.insets = new Insets(0, 0, 5, 0);
		gbc_textField_productedition.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_productedition.gridx = 0;
		gbc_textField_productedition.gridy = 2;
		panel_8.add(textField_productedition, gbc_textField_productedition);
		
		
		
		textField_EMUIedition = new JTextField();
		textField_EMUIedition.setBackground(Color.WHITE);
		textField_EMUIedition.setEditable(false);
		textField_EMUIedition.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_EMUIedition.setColumns(10);
		GridBagConstraints gbc_textField_EMUIedition = new GridBagConstraints();
		gbc_textField_EMUIedition.insets = new Insets(0, 0, 5, 0);
		gbc_textField_EMUIedition.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_EMUIedition.gridx = 0;
		gbc_textField_EMUIedition.gridy = 3;
		panel_8.add(textField_EMUIedition, gbc_textField_EMUIedition);
		
		textField_wanmac = new JTextField();
		textField_wanmac.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_wanmac.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_wanmac = new GridBagConstraints();
		gbc_textField_wanmac.insets = new Insets(0, 0, 5, 0);
		gbc_textField_wanmac.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_wanmac.gridx = 0;
		gbc_textField_wanmac.gridy = 4;
		panel_8.add(textField_wanmac, gbc_textField_wanmac);
		textField_wanmac.setColumns(10);
		
		textField_lanmac = new JTextField();
		textField_lanmac.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_lanmac.setBackground(Color.WHITE);
		GridBagConstraints gbc_textField_lanmac = new GridBagConstraints();
		gbc_textField_lanmac.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_lanmac.gridx = 0;
		gbc_textField_lanmac.gridy = 5;
		panel_8.add(textField_lanmac, gbc_textField_lanmac);
		textField_lanmac.setColumns(10);
		
		panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_14.setBackground(Color.WHITE);
		panel.add(panel_14, "panel14");
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[]{131, 205, 0};
		gbl_panel_14.rowHeights = new int[]{162, 0, 0};
		gbl_panel_14.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_14.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_14.setLayout(gbl_panel_14);
		
		panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.anchor = GridBagConstraints.EAST;
		gbc_panel_15.fill = GridBagConstraints.VERTICAL;
		gbc_panel_15.insets = new Insets(0, 0, 5, 5);
		gbc_panel_15.gridx = 0;
		gbc_panel_15.gridy = 0;
		panel_14.add(panel_15, gbc_panel_15);
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_15.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_15.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_15.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_15.setLayout(gbl_panel_15);
		
		lblNewLabel_11 = new JLabel("WAN IP:");
		lblNewLabel_11.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.gridwidth = 2;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 2;
		gbc_lblNewLabel_11.gridy = 0;
		panel_15.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		lblNewLabel_13 = new JLabel("LAN IP:");
		lblNewLabel_13.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_13.gridwidth = 2;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_13.gridx = 2;
		gbc_lblNewLabel_13.gridy = 1;
		panel_15.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		lblNewLabel_15 = new JLabel("\u9ED8\u8BA4\u7F51\u5173:");
		lblNewLabel_15.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_15.gridwidth = 2;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_15.gridx = 2;
		gbc_lblNewLabel_15.gridy = 2;
		panel_15.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("DNS1:");
		lblNewLabel_16.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_16.gridwidth = 2;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_16.gridx = 2;
		gbc_lblNewLabel_16.gridy = 3;
		panel_15.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		lblNewLabel_18 = new JLabel("DNS2:");
		lblNewLabel_18.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.gridwidth = 2;
		gbc_lblNewLabel_18.gridx = 2;
		gbc_lblNewLabel_18.gridy = 4;
		panel_15.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.insets = new Insets(0, 0, 5, 0);
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 1;
		gbc_panel_16.gridy = 0;
		panel_14.add(panel_16, gbc_panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[]{0, 0};
		gbl_panel_16.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_16.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_16.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_16.setLayout(gbl_panel_16);
		
		textField_wanip = new JTextField();
		textField_wanip.setBackground(Color.WHITE);
		textField_wanip.setEditable(false);
		textField_wanip.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_wanip = new GridBagConstraints();
		gbc_textField_wanip.insets = new Insets(0, 0, 5, 0);
		gbc_textField_wanip.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_wanip.gridx = 0;
		gbc_textField_wanip.gridy = 0;
		panel_16.add(textField_wanip, gbc_textField_wanip);
		textField_wanip.setColumns(10);
		
		textField_lanip = new JTextField();
		textField_lanip.setBackground(Color.WHITE);
		textField_lanip.setEditable(false);
		textField_lanip.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_lanip = new GridBagConstraints();
		gbc_textField_lanip.insets = new Insets(0, 0, 5, 0);
		gbc_textField_lanip.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_lanip.gridx = 0;
		gbc_textField_lanip.gridy = 1;
		panel_16.add(textField_lanip, gbc_textField_lanip);
		textField_lanip.setColumns(10);
		
		textField_gateway = new JTextField();
		textField_gateway.setBackground(Color.WHITE);
		textField_gateway.setEditable(false);
		textField_gateway.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_gateway = new GridBagConstraints();
		gbc_textField_gateway.insets = new Insets(0, 0, 5, 0);
		gbc_textField_gateway.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_gateway.gridx = 0;
		gbc_textField_gateway.gridy = 2;
		panel_16.add(textField_gateway, gbc_textField_gateway);
		textField_gateway.setColumns(10);
		
		textField_dns1 = new JTextField();
		textField_dns1.setBackground(Color.WHITE);
		textField_dns1.setEditable(false);
		textField_dns1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_dns1 = new GridBagConstraints();
		gbc_textField_dns1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_dns1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dns1.gridx = 0;
		gbc_textField_dns1.gridy = 3;
		panel_16.add(textField_dns1, gbc_textField_dns1);
		textField_dns1.setColumns(10);
		
		textField_dns2 = new JTextField();
		textField_dns2.setBackground(Color.WHITE);
		textField_dns2.setEditable(false);
		textField_dns2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_dns2 = new GridBagConstraints();
		gbc_textField_dns2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dns2.gridx = 0;
		gbc_textField_dns2.gridy = 4;
		panel_16.add(textField_dns2, gbc_textField_dns2);
		textField_dns2.setColumns(10);
		
		scrollPane_linedevice = new JScrollPane();
		scrollPane_linedevice.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane_linedevice, "scrollpanel_linedevice");
		
		scrollPane_5Gdevice = new JScrollPane();
		panel.add(scrollPane_5Gdevice, "scrollpanel_5Gdevice");
		
		textArea_5Gdevice = new JTextArea();
		textArea_5Gdevice.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane_5Gdevice.setViewportView(textArea_5Gdevice);
		
		scrollPane_offlinedevice = new JScrollPane();
		panel.add(scrollPane_offlinedevice, "scrollpanel_offlinedevice");
		
		textArea_offlinedevice = new JTextArea();
		textArea_offlinedevice.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane_offlinedevice.setViewportView(textArea_offlinedevice);
		
		scrollPane_upnp = new JScrollPane();
		panel.add(scrollPane_upnp, "scrollpanel_upnp");	
		
		scrollPane_blacklist = new JScrollPane();
		scrollPane_blacklist.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_blacklist.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane_blacklist, "scrollpanel_blacklist");
		
		textArea_blacklist = new JTextArea();
		textArea_blacklist.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane_blacklist.setViewportView(textArea_blacklist);
		
		panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_18.setBackground(Color.WHITE);
		panel.add(panel_18, "panel18");
		GridBagLayout gbl_panel_18 = new GridBagLayout();
		gbl_panel_18.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_18.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_18.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_18.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_18.setLayout(gbl_panel_18);
		
		btnNewButton = new JButton("\u5BFC\u51FA\u7ED3\u679C");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				writerusult();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 6;
		panel_18.add(btnNewButton, gbc_btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "panel1");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{131, 137, 0};
		gbl_panel_1.rowHeights = new int[]{178, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		lblNewLabel = new JLabel("Wi-Fi \u4FE1\u9053\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Wi-Fi \u9891\u5BBD\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		textField_24Gway = new JTextField();
		textField_24Gway.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_24Gway = new GridBagConstraints();
		gbc_textField_24Gway.insets = new Insets(0, 0, 5, 0);
		gbc_textField_24Gway.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_24Gway.gridx = 0;
		gbc_textField_24Gway.gridy = 0;
		panel_4.add(textField_24Gway, gbc_textField_24Gway);
		textField_24Gway.setColumns(10);
		
		textField_24Gbind = new JTextField();
		textField_24Gbind.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_24Gbind = new GridBagConstraints();
		gbc_textField_24Gbind.insets = new Insets(0, 0, 5, 0);
		gbc_textField_24Gbind.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_24Gbind.gridx = 0;
		gbc_textField_24Gbind.gridy = 1;
		panel_4.add(textField_24Gbind, gbc_textField_24Gbind);
		textField_24Gbind.setColumns(10);
		
		panel_24 = new JPanel();
		panel_24.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_24.setBackground(Color.WHITE);
		panel.add(panel_24, "panel24");
		GridBagLayout gbl_panel_24 = new GridBagLayout();
		gbl_panel_24.columnWidths = new int[]{137, 137, 0};
		gbl_panel_24.rowHeights = new int[]{69, 0, 0};
		gbl_panel_24.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_24.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_24.setLayout(gbl_panel_24);
		
		panel_25 = new JPanel();
		panel_25.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.insets = new Insets(0, 0, 5, 5);
		gbc_panel_25.gridx = 0;
		gbc_panel_25.gridy = 0;
		panel_24.add(panel_25, gbc_panel_25);
		GridBagLayout gbl_panel_25 = new GridBagLayout();
		gbl_panel_25.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_25.rowHeights = new int[]{0, 0, 0};
		gbl_panel_25.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_25.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_25.setLayout(gbl_panel_25);
		
		lblNewLabel_28 = new JLabel("IP\u5730\u5740\u5206\u914D\u8303\u56F4\uFF1A");
		lblNewLabel_28.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
		gbc_lblNewLabel_28.gridwidth = 4;
		gbc_lblNewLabel_28.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_28.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_28.gridx = 0;
		gbc_lblNewLabel_28.gridy = 0;
		panel_25.add(lblNewLabel_28, gbc_lblNewLabel_28);
		
		lblNewLabel_29 = new JLabel("\u79DF\u671F\uFF1A");
		lblNewLabel_29.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
		gbc_lblNewLabel_29.gridwidth = 2;
		gbc_lblNewLabel_29.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_29.gridx = 2;
		gbc_lblNewLabel_29.gridy = 1;
		panel_25.add(lblNewLabel_29, gbc_lblNewLabel_29);
		
		panel_26 = new JPanel();
		panel_26.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_26 = new GridBagConstraints();
		gbc_panel_26.fill = GridBagConstraints.BOTH;
		gbc_panel_26.insets = new Insets(0, 0, 5, 0);
		gbc_panel_26.gridx = 1;
		gbc_panel_26.gridy = 0;
		panel_24.add(panel_26, gbc_panel_26);
		GridBagLayout gbl_panel_26 = new GridBagLayout();
		gbl_panel_26.columnWidths = new int[]{0, 0};
		gbl_panel_26.rowHeights = new int[]{0, 0, 0};
		gbl_panel_26.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_26.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_26.setLayout(gbl_panel_26);
		
		textField_iprange = new JTextField();
		textField_iprange.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_iprange = new GridBagConstraints();
		gbc_textField_iprange.insets = new Insets(0, 0, 5, 0);
		gbc_textField_iprange.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_iprange.gridx = 0;
		gbc_textField_iprange.gridy = 0;
		panel_26.add(textField_iprange, gbc_textField_iprange);
		textField_iprange.setColumns(10);
		
		textField_usetime = new JTextField();
		textField_usetime.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_usetime = new GridBagConstraints();
		gbc_textField_usetime.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_usetime.gridx = 0;
		gbc_textField_usetime.gridy = 1;
		panel_26.add(textField_usetime, gbc_textField_usetime);
		textField_usetime.setColumns(10);
		
		panel_20 = new JPanel();
		panel_20.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_20.setBackground(Color.WHITE);
		panel.add(panel_20, "panel20");
		GridBagLayout gbl_panel_20 = new GridBagLayout();
		gbl_panel_20.columnWidths = new int[]{137, 137, 0};
		gbl_panel_20.rowHeights = new int[]{184, 0, 0};
		gbl_panel_20.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_20.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_20.setLayout(gbl_panel_20);
		
		panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.insets = new Insets(0, 0, 5, 5);
		gbc_panel_21.gridx = 0;
		gbc_panel_21.gridy = 0;
		panel_20.add(panel_21, gbc_panel_21);
		GridBagLayout gbl_panel_21 = new GridBagLayout();
		gbl_panel_21.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_21.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_21.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_21.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_21.setLayout(gbl_panel_21);
		
		lblNewLabel_21 = new JLabel("Wi-Fi \u4FE1\u9053\uFF1A");
		lblNewLabel_21.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.gridwidth = 4;
		gbc_lblNewLabel_21.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_21.gridx = 0;
		gbc_lblNewLabel_21.gridy = 0;
		panel_21.add(lblNewLabel_21, gbc_lblNewLabel_21);
		
		lblNewLabel_23 = new JLabel("Wi-Fi\u9891\u5BBD\uFF1A");
		lblNewLabel_23.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.gridwidth = 2;
		gbc_lblNewLabel_23.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_23.gridx = 2;
		gbc_lblNewLabel_23.gridy = 1;
		panel_21.add(lblNewLabel_23, gbc_lblNewLabel_23);
		
		panel_22 = new JPanel();
		panel_22.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_22 = new GridBagConstraints();
		gbc_panel_22.fill = GridBagConstraints.BOTH;
		gbc_panel_22.insets = new Insets(0, 0, 5, 0);
		gbc_panel_22.gridx = 1;
		gbc_panel_22.gridy = 0;
		panel_20.add(panel_22, gbc_panel_22);
		GridBagLayout gbl_panel_22 = new GridBagLayout();
		gbl_panel_22.columnWidths = new int[]{0, 0};
		gbl_panel_22.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_22.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_22.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_22.setLayout(gbl_panel_22);
		
		textField_5Gway = new JTextField();
		textField_5Gway.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_5Gway = new GridBagConstraints();
		gbc_textField_5Gway.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5Gway.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5Gway.gridx = 0;
		gbc_textField_5Gway.gridy = 0;
		panel_22.add(textField_5Gway, gbc_textField_5Gway);
		textField_5Gway.setColumns(10);
		
		textField_5Gbind = new JTextField();
		textField_5Gbind.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_5Gbind = new GridBagConstraints();
		gbc_textField_5Gbind.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5Gbind.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5Gbind.gridx = 0;
		gbc_textField_5Gbind.gridy = 1;
		panel_22.add(textField_5Gbind, gbc_textField_5Gbind);
		textField_5Gbind.setColumns(10);
		
		panel_19 = new JPanel();
		panel_19.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_19.setBackground(Color.WHITE);
		panel.add(panel_19, "panel19");
		GridBagLayout gbl_panel_19 = new GridBagLayout();
		gbl_panel_19.columnWidths = new int[]{131, 0, 0};
		gbl_panel_19.rowHeights = new int[]{38, 0, 0};
		gbl_panel_19.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_19.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_19.setLayout(gbl_panel_19);
		
		lblNewLabel_19 = new JLabel("\u65F6\u533A:");
		lblNewLabel_19.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 0;
		gbc_lblNewLabel_19.gridy = 0;
		panel_19.add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		textField_timezone = new JTextField();
		textField_timezone.setBackground(Color.WHITE);
		textField_timezone.setEditable(false);
		textField_timezone.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_timezone.setColumns(10);
		GridBagConstraints gbc_textField_timezone = new GridBagConstraints();
		gbc_textField_timezone.insets = new Insets(0, 0, 5, 0);
		gbc_textField_timezone.fill = GridBagConstraints.BOTH;
		gbc_textField_timezone.gridx = 1;
		gbc_textField_timezone.gridy = 0;
		panel_19.add(textField_timezone, gbc_textField_timezone);
		
		scrollPane_whitelist = new JScrollPane();
		panel.add(scrollPane_whitelist, "scrollPanel_whitelist");
		
		textArea_whitelist = new JTextArea();
		textArea_whitelist.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane_whitelist.setViewportView(textArea_whitelist);
		
		scrollPane_port = new JScrollPane();
		panel.add(scrollPane_port, "scrollPanel_port");
		
		scrollPane_24Gdevice = new JScrollPane();
		panel.add(scrollPane_24Gdevice, "scrollPanel_24Gdevice");
		
		textArea_24Gdevice = new JTextArea();
		textArea_24Gdevice.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane_24Gdevice.setViewportView(textArea_24Gdevice);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(MainClass.btnColor, 2, true));
		panel_5.setBackground(Color.WHITE);
		panel.add(panel_5, "panel_5");
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{137, 137, 0};
		gbl_panel_5.rowHeights = new int[]{184, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 0;
		panel_5.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		lblNewLabel_2 = new JLabel("DMZ\u4E3B\u673A\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridwidth = 4;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_9.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u4E3B\u673AIP\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 1;
		panel_9.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 0;
		panel_5.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{0, 0};
		gbl_panel_10.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_10.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		textField_dmzdevice = new JTextField();
		textField_dmzdevice.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_dmzdevice.setColumns(10);
		GridBagConstraints gbc_textField_dmzdevice = new GridBagConstraints();
		gbc_textField_dmzdevice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dmzdevice.insets = new Insets(0, 0, 5, 0);
		gbc_textField_dmzdevice.gridx = 0;
		gbc_textField_dmzdevice.gridy = 0;
		panel_10.add(textField_dmzdevice, gbc_textField_dmzdevice);
		
		textField_dmzip = new JTextField();
		textField_dmzip.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_dmzip.setColumns(10);
		GridBagConstraints gbc_textField_dmzip = new GridBagConstraints();
		gbc_textField_dmzip.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dmzip.insets = new Insets(0, 0, 5, 0);
		gbc_textField_dmzip.gridx = 0;
		gbc_textField_dmzip.gridy = 1;
		panel_10.add(textField_dmzip, gbc_textField_dmzip);
	
		frame.addWindowListener(new WindowAdapter() {

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
			
		});
		
	}
}
