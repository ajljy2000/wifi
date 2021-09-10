package wifi_final;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 
public class Testdb {
	public static void main(String args[]) throws Exception {
		Testdb db=new Testdb();
		db.createhuaweitotal();
		db.createdevice();
		db.createxiaomilist();
		db.createhuaweilist();
		db.createxiaomitotal();
		db.createtotal();
		
	}
	
	public void createtotal() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		stmt.executeUpdate("CREATE TABLE total(caseid STRING,casename STRING,name STRING,primary key(caseid))"); 
		System.out.println("total have created!");
		stmt.close();
		conn.close();
	}
	public int countcase() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from total ";
		ResultSet rs = stmt.executeQuery(sql);  
		int count=0;
		while (rs.next()) {  
			count=count+1;
        }  
		stmt.close();
		conn.close();
		return count;
	}
	
	public List<String> searchcasestring(String str1) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from total";
		ResultSet rs = stmt.executeQuery(sql);  
		List<String> str= new ArrayList();
		while (rs.next()) {  
			str.add(rs.getString(str1));
        }  
		stmt.close();
		conn.close();
		return str;
	} 
	public String searchcasestringname(String caseid) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from total where caseid='"+caseid+"'";
		ResultSet rs = stmt.executeQuery(sql);  
		String str;
		rs.next(); 
			str=rs.getString("name");
			stmt.close();
			conn.close();
		return str;
	} 
	public List<Integer> searchcaseint(String str1) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from total";
		ResultSet rs = stmt.executeQuery(sql);  
		List<Integer> str= new ArrayList();
		int i;
		while (rs.next()) {  
			str.add(rs.getInt(str1));
        }  
		stmt.close();
		conn.close();
		return str;
	} 
	public void inserttotal(String caseid,String casename,String name) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="insert into total(caseid,casename,name) values ('"+caseid+"','"+casename+"','"+name+"')";
		System.out.println(sql);
		stmt.executeUpdate(sql); 
		System.out.println("total have inserted!");
		stmt.close();
		conn.close();
	}
	public void createdevice() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		
		stmt.executeUpdate("CREATE TABLE device(caseid STRING,deviceid STRING,devicename STRING,devicetype STRING,password STRING,flag STRING,primary key(deviceid))"); 
		System.out.println("device have created!");
		stmt.close();
		conn.close();
		
	}
	public int countdevice(String caseid) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from device where caseid='"+caseid+"'";
		ResultSet rs = stmt.executeQuery(sql);  
		int count=0;
		while (rs.next()) {  
			count=count+1;
        }  
		stmt.close();
		conn.close();
		return count;
	}
	
	public boolean searchdevice(String deviceid) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from device where deviceid='"+deviceid+"'";
		ResultSet rs = stmt.executeQuery(sql);  
		if (rs.next()) { 
			stmt.close();
			conn.close();
			return true;
        }  
		stmt.close();
		conn.close();
		return false;
	} 
	public boolean checkdeviceflag(String deviceid) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from device where deviceid='"+deviceid+"'";
		ResultSet rs = stmt.executeQuery(sql);  
		rs.next();
		String flag=rs.getString("flag");
		if(flag.equals("1"))
		{
			stmt.close();
			conn.close();
			return true;
		}
		stmt.close();
		conn.close();
		return false;
	} 
	
	
	
	public void insertdevice(String caseid,String deviceid,String devicename,String devicetype,String password) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="insert into device(caseid,deviceid,devicename,devicetype,password,flag) values ('"+caseid+"','"+deviceid+"','"+devicename+"','"+devicetype+"','"+password+"','0')";
		System.out.println(sql);
		stmt.executeUpdate(sql); 
		System.out.println("device have inserted!");
		stmt.close();
		conn.close();
	}
	
	public List<String> searchdevicestring(String caseid,String column) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from device where caseid='"+caseid+"'";
		ResultSet rs = stmt.executeQuery(sql);  
		List<String> str= new ArrayList();
		while (rs.next()) {  
			str.add(rs.getString(column));
        }  
		stmt.close();
		conn.close();
		return str;
	} 
	
	public void createhuaweitotal() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		
			stmt.executeUpdate("CREATE TABLE huaweitotal(deviceid STRING,product_name STRING,product_id STRING,product_edition STRING,EMUI_Route_edition STRING,wan_mac STRING,lan_mac STRING,wan_ip STRING,lan_ip STRING,gateway STRING,dns1 STRING,dns2 STRING,ip_begin STRING,ip_end STRING,usetime STRING,way_24G STRING,bind_24G STRING,way_5G STRING,bind_5G STRING,timezone STRING,primary key(deviceid))"); 
			System.out.println("huaweitotal have created!");
			stmt.close();
			conn.close();
	}
	public void createxiaomitotal() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		
		stmt.executeUpdate("CREATE TABLE xiaomitotal(deviceid STRING,routermodel STRING,routerversion STRING,routermac STRING,routersn STRING,way_24G STRING,width_24G STRING,way_5G STRING,width_5G STRING,line_ip STRING,wangguan STRING,dns1 STRING,dns2 STRING,ip_begin STRING,ip_end STRING,usetime STRING,timezone STRING,primary key(deviceid))"); 
		System.out.println("xiaomitotal have created!");
		stmt.close();
		conn.close();
	}
	public void createhuaweilist() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("CREATE TABLE huaweilist(deviceid String,flag_line STRING,list_linename STRING,list_lineip STRING,list_linemac STRING,list_linetime STRING,flag_24G STRING,list_24Gname STRING,list_24Gip STRING,list_24Gmac STRING,list_24Gtime STRING,flag_5G STRING,list_5Gname STRING,list_5Gip STRING,list_5Gmac STRING,list_5Gtime STRING,flag_offline STRING,list_offlinename STRING,list_offlineip STRING,list_offlinemac STRING,list_offlinetime STRING,flag_upnp STRING,upnp_outip STRING,upnp_inip STRING,upnp_type STRING,upnp_out STRING,upnp_in STRING,upnp_describe STRING,flag_blacklist STRING,blacklist_name STRING,blacklist_mac STRING,flag_whitelist STRING,whitelist_name STRING,whitelist_mac STRING,flag_port STRING,port_name STRING,port_device STRING,port_ip STRING,port_type STRING,port_in STRING,port_out STRING,flag_dmz STRING,dmz_device STRING,dmz_ip STRING) "); 
		System.out.println("huaweilist have created!");
		stmt.close();
		conn.close();
		
	}
	public void createxiaomilist() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("CREATE TABLE xiaomilist(deviceid String,flag_line STRING,list_linename STRING,list_lineip STRING,list_linemac STRING,list_linetime STRING,flag_24G STRING,list_24Gname STRING,list_24Gip STRING,list_24Gmac STRING,list_24Gtime STRING,flag_5G STRING,list_5Gname STRING,list_5Gip STRING,list_5Gmac STRING,list_5Gtime STRING,flag_upnp STRING,upnp_type STRING,upnp_name STRING,upnp_ip STRING,upnp_in STRING,upnp_out STRING,flag_blacklist STRING,blacklist_name STRING,blacklist_mac STRING,flag_whitelist STRING,whitelist_name STRING,whitelist_mac STRING,flag_port STRING,port_name STRING,port_type STRING,port_out STRING,port_ip STRING,port_in STRING,flag_dmz STRING,dmz_ip STRING) "); 
		System.out.println("huaweilist have created!");
		stmt.close();
		conn.close();
	}
	public void update(String sql)throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		stmt.executeUpdate(sql); 
		System.out.println("updated!");
		stmt.close();
		conn.close();
	}
	
	public String select(String deviceid,String rolename)throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from huaweitotal where deviceid='"+deviceid+"'";
		ResultSet rs = stmt.executeQuery(sql);  
		String str;
		rs.next();
		str=rs.getString(rolename);
		stmt.close();
		conn.close();
		return str;
		
	}
	
	public String selectxiaomitotal(String deviceid,String rolename)throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from xiaomitotal where deviceid='"+deviceid+"'";
		ResultSet rs = stmt.executeQuery(sql);  
		String str;
		rs.next();
		str=rs.getString(rolename);
		stmt.close();
		conn.close();
		return str;
		
	}
	
	public List<String> selecthuaweilist(String deviceid,String rolename,String flag)throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from huaweilist where deviceid="+deviceid+" and "+flag+"='1'";
		ResultSet rs = stmt.executeQuery(sql);  
		List<String> str= new ArrayList();
		while (rs.next()) {  
			str.add(rs.getString(rolename));
        }  
		stmt.close();
		conn.close();
		return str;
		
	}
	
	public List<String> selectxiaomilist(String deviceid,String rolename,String flag)throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from xiaomilist where deviceid="+deviceid+" and "+flag+"='1'";
		ResultSet rs = stmt.executeQuery(sql);  
		List<String> str= new ArrayList();
		while (rs.next()) {  
			str.add(rs.getString(rolename));
        }  
		stmt.close();
		conn.close();
		return str;
		
	}
	
	public void deletedevice(String deviceid) throws Exception{
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="delete from device where deviceid = '"+deviceid+"' ";
		System.out.println(sql);
		String sql1="delete from huaweilist where deviceid = '"+deviceid+"' ";
		System.out.println(sql);
		String sql2="delete from huaweitotal where deviceid = '"+deviceid+"' ";
		System.out.println(sql);
		stmt.executeUpdate(sql); 
		stmt.executeUpdate(sql1); 
		stmt.executeUpdate(sql2); 
		System.out.println("device have deleted!");
		stmt.close();
		conn.close();
	}
	
	public void deletedeviceinfo(String deviceid) throws Exception{
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql1="delete from huaweilist where deviceid = '"+deviceid+"' ";
		String sql2="delete from huaweitotal where deviceid = '"+deviceid+"' ";
		stmt.executeUpdate(sql1); 
		stmt.executeUpdate(sql2); 
		System.out.println("deviceinfo have deleted!");
		stmt.close();
		conn.close();
	}
	
	public void deletedevicelist(String caseid) throws Exception{
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		String sql="select * from device where caseid='"+caseid+"'";
		ResultSet rs = stmt.executeQuery(sql);  
		List<String> deviceid= new ArrayList();
		while (rs.next()) {  
			deviceid.add(rs.getString("deviceid"));
        }  
		for(int i=0;i<deviceid.size();i++)
		{
			this.deletedevice(deviceid.get(i));
		}
		System.out.println("device have deleted!");
		stmt.close();
		conn.close();
	}
	
	public void deletecase(String caseid) throws Exception{
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/result.db");
		Statement stmt = conn.createStatement(); 
		this.deletedevicelist(caseid);
		String sql="delete from total where caseid = '"+caseid+"' ";
		System.out.println(sql);
		stmt.executeUpdate(sql); 
		System.out.println("case have deleted!");
		stmt.close();
		conn.close();
	}
	
	//DELETE FROM `vmsg`.`user` WHERE (`id` = '12');
	
}

