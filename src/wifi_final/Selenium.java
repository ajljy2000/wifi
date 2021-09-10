package wifi_final;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement; 

public class Selenium {
	WebDriver driver;
	String url="http://192.168.3.1";
	String gateway,dns,dns1,dns2,port_name,port_ip,port_device,port_type,port_in,port_out,dmz_device,dmz_ip;
	String product_name,product_id,product_edition,EMUI_Route_edition,online_time,run_time,wan_mac,lan_mac,wan_ip,lan_ip,ip_begin,ip_end,usetime;
	String way_24G,mode_24G,bind_24G,ax_24G,ssid_24G,wmm_24G,way_5G,mode_5G,bind_5G,ax_5G,ssid_5G,wmm_5G,timezone;
	List<String> upnp_outip,upnp_inip,upnp_type,upnp_out,upnp_in,upnp_describe,blacklist_name,blacklist_mac,whitelist_name,whitelist_mac;
	List<WebElement> list_linename,list_lineip,list_linemac,list_linetime,list_5Gname,list_5Gip,list_5Gmac,list_5Gtime;
	List<WebElement> list_24Gname,list_24Gip,list_24Gmac,list_24Gtime,list_offlinename,list_offlineip,list_offlinemac,list_offlinetime;
	List<WebElement> list_upnp,list_upnp1,list_blacklist1,list_blacklist2,list_whitelist1,list_whitelist2,port2,port3;
	WebElement a,b,c,d,port,port1,port4,port_cancelbutton;
	String sql_huaweitotal,sql_huaweilist;
	int flag=0,errorflag=0;
	
	public static void main(String args[]) throws Exception
	{
	
		Selenium selenium=new Selenium();
		String[] Device= {"1","ljy's wifi","华为AX3","13588820793","2021031019254513"};
		
		selenium.go(Device);
	}
	
	public boolean ElementExist(WebDriver a,By locator)
    {
        try {
            a.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
	
	public void go(String[] Device) 
	{
		Testdb db=new Testdb();
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\ajljy2000\\AppData\\Local\\Programs\\Python\\Python37\\geckodriver.exe");
        //chromedriver为谷歌浏览器的驱动程序
        //System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
        
        //获得Firefox浏览器的控制权
		 FirefoxOptions firefoxOptions=new FirefoxOptions();
		 firefoxOptions.addArguments("-headless");
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        //谷歌浏览器驱动
        //WebDriver driver = new ChromeDriver();
        //IE浏览器驱动
        //WebDriver driver = new InternetExplorerDriver();
        
        driver.manage().window().maximize();//浏览器最大化
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//超时等待30秒
		System.out.println("start selenium");
        //geckodriver为火狐浏览器的驱动程序

        //向浏览器发送网址
		try {
			driver.get(url);
		}
		catch(Exception e)
        {
        	System.out.println("Wrong");
        	driver.quit();
        	this.errorflag=1;
        	return ;
        }
        //登录
        try {
        WebElement loginbox = driver.findElement(By.xpath("//*[@id=\"userpassword_ctrl\"]"));
        loginbox.sendKeys(Device[3]);
        WebElement loginbotton = driver.findElement(By.xpath("//*[@id=\"loginbtn\"]"));
        loginbotton.click();
        }
        catch(Exception e)
        {
        	System.out.println("Wrong");
        	
        }
        try 
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        
        
        //终端管理界面
        try
        {
        WebElement content1_botton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/ul/li[4]/div"));
        content1_botton.click();
        }
        catch(Exception e)
        {
        	System.out.println("Wrong");
        	driver.quit();
        	this.errorflag=1;
        	return ;
        }
        try 
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        
      //有线连接用户
        try {
        WebElement content2_botton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div"));
        content2_botton.click();
        
        WebElement content3_botton = driver.findElement(By.xpath("//*[@id=\"online_selectlist_SmallSelectBoxScrollItemID\"]"));
        content3_botton.click();
       
        list_linename=driver.findElements(By.xpath("//div[@class=\"hostname\"]//p"));
        list_lineip=driver.findElements(By.xpath("//div[@class=\"IP\"]//span"));
        list_linemac=driver.findElements(By.xpath("//div[@class=\"MAC\"]"));
        list_linetime=driver.findElements(By.xpath("//div[@class=\"deviceTime\"]"));
        
		for(int i=0;i<list_linename.size();i++)
        {
        	a=list_linename.get(i);
        	b=list_lineip.get(i);
        	c=list_linemac.get(i);
        	d=list_linetime.get(i);
        	sql_huaweilist="insert into huaweilist (deviceid,flag_line,list_linename,list_lineip,list_linemac,list_linetime) values('"+Device[4]+"','1','"+a.getAttribute("innerHTML")+"','"+b.getAttribute("innerHTML")+"','"+c.getAttribute("innerHTML")+"','"+d.getAttribute("innerHTML").trim()+"')";
        	System.out.println(sql_huaweilist);
        	db.update(sql_huaweilist);
        }
        }
        catch(Exception ie) {
        	System.out.println("online Wrong");
        	WebElement content2_botton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div"));
            content2_botton.click();
        }
      
       
        
        //2.4G用户
        try {
        WebElement content4_botton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div"));
        content4_botton.click();
        WebElement content5_botton = driver.findElement(By.xpath("//*[@id=\"24G_selectlist_SmallSelectBoxScrollItemID\"]"));
        content5_botton.click(); 
        list_24Gname=driver.findElements(By.xpath("//div[@class=\"hostname\"]//p"));
        list_24Gip=driver.findElements(By.xpath("//div[@class=\"IP\"]//span"));
        list_24Gmac=driver.findElements(By.xpath("//div[@class=\"MAC\"]"));
        list_24Gtime=driver.findElements(By.xpath("//div[@class=\"deviceTime\"]"));
		for(int i=0;i<list_24Gname.size();i++)
        {
        	a=list_24Gname.get(i);
        	b=list_24Gip.get(i);
        	c=list_24Gmac.get(i);
        	d=list_24Gtime.get(i);
        	sql_huaweilist="insert into huaweilist (deviceid,flag_24G,list_24Gname,list_24Gip,list_24Gmac,list_24Gtime) values('"+Device[4]+"','1','"+a.getAttribute("innerHTML")+"','"+b.getAttribute("innerHTML")+"','"+c.getAttribute("innerHTML")+"','"+d.getAttribute("innerHTML").trim()+"')";
        	System.out.println(sql_huaweilist);
        	db.update(sql_huaweilist);
        }
        }
        catch(Exception ie) {
        	System.out.println("2.4G Wrong");
        	WebElement content4_botton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div"));
            content4_botton.click();
        }
        
        //5G用户
        try {
        WebElement content6_botton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div"));
        content6_botton.click();
        
        WebElement content7_botton = driver.findElement(By.xpath("//*[@id=\"5G_selectlist_SmallSelectBoxScrollItemID\"]"));
        content7_botton.click();
        
        list_5Gname=driver.findElements(By.xpath("//div[@class=\"hostname\"]//p"));
        list_5Gip=driver.findElements(By.xpath("//div[@class=\"IP\"]//span"));
        list_5Gmac=driver.findElements(By.xpath("//div[@class=\"MAC\"]"));
        list_5Gtime=driver.findElements(By.xpath("//div[@class=\"deviceTime\"]"));
       
        for(int i=0;i<list_5Gname.size();i++)
        {
        	a=list_5Gname.get(i);
        	b=list_5Gip.get(i);
        	c=list_5Gmac.get(i);
        	d=list_5Gtime.get(i);
        	sql_huaweilist="insert into huaweilist (deviceid,flag_5G,list_5Gname,list_5Gip,list_5Gmac,list_5Gtime) values('"+Device[4]+"','1','"+a.getAttribute("innerHTML")+"','"+b.getAttribute("innerHTML")+"','"+c.getAttribute("innerHTML")+"','"+d.getAttribute("innerHTML").trim()+"')";
        	System.out.println(sql_huaweilist);
        	db.update(sql_huaweilist);
        }
        }
        catch(Exception ie) {
        	System.out.println("5G Wrong");
        	WebElement content6_botton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div"));
            content6_botton.click();
        }
       
        
      //离线用户
        try {
        WebElement content8_botton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div"));
        content8_botton.click();
        
        WebElement content9_botton = driver.findElement(By.xpath("//*[@id=\"offline_selectlist_SmallSelectBoxScrollItemID\"]"));
        content9_botton.click();
        
        list_offlinename=driver.findElements(By.xpath("//div[@class=\"hostname\"]//p"));
        list_offlineip=driver.findElements(By.xpath("//div[@class=\"IP\"]//span"));
        list_offlinemac=driver.findElements(By.xpath("//div[@class=\"MAC\"]"));
        list_offlinetime=driver.findElements(By.xpath("//div[@class=\"deviceTime\"]"));
		for(int i=0;i<list_offlinename.size();i++)
        {
        	a=list_offlinename.get(i);
        	b=list_offlineip.get(i);
        	c=list_offlinemac.get(i);
        	d=list_offlinetime.get(i);
        	sql_huaweilist="insert into huaweilist (deviceid,flag_offline,list_offlinename,list_offlineip,list_offlinemac,list_offlinetime) values('"+Device[4]+"','1','"+a.getAttribute("innerHTML")+"','"+b.getAttribute("innerHTML")+"','"+c.getAttribute("innerHTML")+"','"+d.getAttribute("innerHTML").trim()+"')";
        	System.out.println(sql_huaweilist);
        	db.update(sql_huaweilist);
        }
        }
        catch(Exception ie) {
        	System.out.println("offline Wrong");
        	WebElement content8_botton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div"));
            content8_botton.click();
        }
  
        //路由器信息界面
        try {
        WebElement content10_botton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/ul/li[5]/div"));
        content10_botton.click();
        }
        catch(Exception ie) {}
        
        try 
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        
        //产品名称
        try {
        WebElement product_text = driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_product_name_label_ctrl\"]"));
        product_name=product_text.getAttribute("innerHTML");
        System.out.println(product_name);
        }
        catch(Exception ie) {}
        
        //序列号
        try {
        WebElement product_text1 = driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_device_id_label_ctrl\"]"));
        product_id=product_text1.getAttribute("innerHTML");
        System.out.println(product_id);
        }
        catch(Exception ie) {}
        
        //软件版本
        try {
        WebElement product_text2 = driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_software_label_ctrl\"]"));
        product_edition=product_text2.getAttribute("innerHTML");
        System.out.println(product_edition);
        }
        catch(Exception ie) {}
        
        //EMUI Router 版本
        try {
        WebElement product_text3 = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div/div[2]/div[5]/div[2]"));
        EMUI_Route_edition=product_text3.getAttribute("innerHTML");
        System.out.println(EMUI_Route_edition);
        }
        catch(Exception ie) {}
 
        //WAN MAC地址
        try {
        WebElement product_text6 = driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_macAddress_label_ctrl\"]"));
        wan_mac=product_text6.getAttribute("innerHTML");
        System.out.println(wan_mac);
        }
        catch(Exception ie) {}
        
        //LAN MAC地址
        try {
        WebElement product_text7 = driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_lan_mac_label_ctrl\"]"));
        lan_mac=product_text7.getAttribute("innerHTML");
        System.out.println(lan_mac);
        }
        catch(Exception ie) {}
        
        //WAN IP地址
        try {
        WebElement product_text8 = driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_IPAddress_label_ctrl\"]"));
        wan_ip=product_text8.getAttribute("innerHTML");
        System.out.println(wan_ip);
        }
        catch(Exception ie) {}
        
        //LAN IP地址
        try {
        WebElement product_text9= driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_lan_ip_label_ctrl\"]"));
        lan_ip=product_text9.getAttribute("innerHTML");
        System.out.println(lan_ip);
        }
        catch(Exception ie) {}
        
        //默认网关
        try {
        WebElement product_text10 = driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_gatewayAddress_label_ctrl\"]"));
        gateway=product_text10.getAttribute("innerHTML");
        System.out.println(gateway);
        }
        catch(Exception ie) {}
        
        //DNS服务器
        try {
        WebElement product_text11 = driver.findElement(By.xpath("//*[@id=\"deviceinfo_view_data_edit_deviceinfo_dnsAddress_label_ctrl\"]"));
        dns=product_text11.getAttribute("innerText");
        
        String[] product_text11_cut = dns.split("\n");
        dns2="";
        dns1=product_text11_cut[0];
        System.out.println(dns1);
        dns2=product_text11_cut[1];
        System.out.println("dns------");
        System.out.println(dns2);
        }
        catch(Exception ie) {
        	System.out.println("dns wrong");
        }
        
       
        try 
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        
        try {
        	driver.findElement(By.xpath("//*[@id=\"netsettingsparent_menuId\"]")).click();
        	ip_begin=driver.findElement(By.xpath("//*[@id=\"miniprange_ctrl\"]")).getAttribute("value");
        	ip_end=driver.findElement(By.xpath("//*[@id=\"maxiprange_ctrl\"]")).getAttribute("value");
        	usetime=driver.findElement(By.xpath("//*[@id=\"lan_view_data_edit_lan_LeaseDuration_selectlist_parenselect\"]")).getAttribute("innerHTML");
        	System.out.println(ip_begin);
        	System.out.println(ip_end);
        	System.out.println(usetime);
        }
        catch(Exception ie) {
        	
        }
   
      //UPNP
        try {
        	WebElement content13_botton = driver.findElement(By.xpath(" //*[@id=\"upnp_menuId\"]"));
            content13_botton.click();
            list_upnp=driver.findElements(By.xpath("//div[@class=\"border_top\"]")); 
            System.out.println(list_upnp.size());
            upnp_outip= new ArrayList();
            upnp_inip= new ArrayList();
            upnp_type= new ArrayList();
            upnp_out= new ArrayList();
            upnp_in= new ArrayList();
            upnp_describe= new ArrayList();
            for(int i=1;i<list_upnp.size();i++)
            {
            	
            	list_upnp1=list_upnp.get(i).findElements(By.xpath("./div"));
            
            	upnp_outip.add(list_upnp1.get(0).getAttribute("innerHTML"));
        		
            	upnp_inip.add(list_upnp1.get(1).getAttribute("innerHTML"));
            	upnp_type.add(list_upnp1.get(2).getAttribute("innerHTML"));
            	upnp_out.add(list_upnp1.get(3).getAttribute("innerHTML"));
        		upnp_in.add(list_upnp1.get(4).getAttribute("innerHTML"));
        	
        		upnp_describe.add(list_upnp1.get(5).getAttribute("innerHTML"));
        		
            }
            
        }
        catch(Exception ie) {
        	System.out.println("no upnp");
        }
        System.out.println(upnp_outip);
        System.out.println(upnp_inip);
        System.out.println(upnp_type);
        System.out.println(upnp_out);
        System.out.println(upnp_in);
        System.out.println(upnp_describe);
        
        try {
        	for(int i=0;i<upnp_outip.size();i++)
            {
            	sql_huaweilist="insert into huaweilist (deviceid,flag_upnp,upnpout_ip,upnp_inip,upnp_type,upnp_out,upnp_in,upnp_describe) values(,'"+Device[4]+"','1','"+upnp_outip.get(i)+"','"+upnp_inip.get(i)+"','"+upnp_type.get(i)+"','"+upnp_out.get(i)+"','"+upnp_in.get(i)+"','"+upnp_describe.get(i)+"')";
            	System.out.println(sql_huaweilist);
            	db.update(sql_huaweilist);
            }
        }
        catch(Exception ie) {}
     
        //2.4G、5G WIFI
        try {
        	WebElement content14_botton = driver.findElement(By.xpath("//*[@id=\"wifisettingsparent_menuId\"]"));
            content14_botton.click();
          
            WebElement content15_botton = driver.findElement(By.xpath("//*[@id=\"wlanadvance_menuId\"]"));
            content15_botton.click();
            
          //信道
        	WebElement wifi_text1 = driver.findElement(By.xpath("//*[@id=\"wifi_channel24g_ctrl_selectlist_parenselect\"]"));
            way_24G=wifi_text1.getAttribute("innerHTML");
            
            System.out.println(way_24G);
            //带宽
            WebElement wifi_text3 = driver.findElement(By.xpath("//*[@id=\"wifi_bind_set_ctrl_selectlist_parenselect\"]"));
            bind_24G=wifi_text3.getAttribute("innerHTML");
            System.out.println(bind_24G);
            WebElement wifi_text7 = driver.findElement(By.xpath("//*[@id=\"wifi_channel5g_ctrl_selectlist_parenselect\"]"));
            way_5G=wifi_text7.getAttribute("innerHTML");
            System.out.println(way_5G);
            
            WebElement wifi_text9 = driver.findElement(By.xpath("//*[@id=\"wifi_5gbind_set_ctrl_selectlist_parenselect\"]"));
            bind_5G=wifi_text9.getAttribute("innerHTML");
            System.out.println(bind_5G);
        }
        catch(Exception ie) {
        	
        }
        
        
      
        try {
        	WebElement content16_botton = driver.findElement(By.xpath("//*[@id=\"wlanaccess_menuId\"]"));
            content16_botton.click();
            
            WebElement wlanaccess_text1 = driver.findElement(By.xpath("//*[@id=\"wlaneco_open_on\"]"));
            
            WebElement wlanaccess_botton1 = driver.findElement(By.xpath("//*[@id=\"wlan_access_blankctrl_checkbox_ctrl_checkbox_ctrl\"]"));
            wlanaccess_botton1.click();
            blacklist_name= new ArrayList();
            blacklist_mac= new ArrayList();
            list_blacklist1=driver.findElements(By.xpath("//*[@class=\"pull-left listname border_1px_right ellipsis\"]"));   
            list_blacklist2=driver.findElements(By.xpath("//*[@class=\"pull-left listmac border_1px_right\"]")); 
            for(int i=0;i<list_blacklist1.size();i++)
            {
            	blacklist_name.add(list_blacklist1.get(i).getAttribute("innerHTML"));
            	blacklist_mac.add(list_blacklist2.get(i).getAttribute("innerHTML"));
            }
            System.out.println(blacklist_name);
            System.out.println(blacklist_mac);         
        }
        catch(Exception ie) {
        	System.out.println("wlan access blacklist wrong");
        }
        
        try {
        	for(int i=0;i<blacklist_name.size();i++)
            {
            	sql_huaweilist="insert into huaweilist (deviceid,flag_blacklist,blacklist_name,blacklist_mac) values('"+Device[4]+"','1','"+blacklist_name.get(i)+"','"+blacklist_mac.get(i)+"')";
            	System.out.println(sql_huaweilist);
            	db.update(sql_huaweilist);
            }
        }
        catch(Exception ie) {}
        
        try {
        	WebElement wlanaccess_botton2 = driver.findElement(By.xpath("//*[@id=\"wlan_access_whitectrl_checkbox_ctrl_checkbox_ctrl\"]"));
            wlanaccess_botton2.click();
          
            list_whitelist1=driver.findElements(By.xpath("//*[@class=\"pull-left listname border_1px_right ellipsis\"]"));   
            list_whitelist2=driver.findElements(By.xpath("//*[@class=\"pull-left listmac border_1px_right\"]")); 
           
            whitelist_name= new ArrayList();
            whitelist_mac= new ArrayList();
            for(int i=0;i<list_whitelist1.size();i++)
            {
            	whitelist_name.add(list_whitelist1.get(i).getAttribute("innerHTML").trim());
            	whitelist_mac.add(list_whitelist2.get(i).getAttribute("innerHTML"));
            }
            System.out.println(whitelist_name);
            System.out.println(whitelist_mac);  
        }
        catch(Exception ie) {
        	System.out.println("wlan access whitelist wrong");
        	
        }
        
        try {
        	for(int i=0;i<whitelist_name.size();i++)
            {
            	sql_huaweilist="insert into huaweilist (deviceid,flag_whitelist,whitelist_name,whitelist_mac) values('"+Device[4]+"','1','"+whitelist_name.get(i)+"','"+whitelist_mac.get(i)+"')";
            	System.out.println(sql_huaweilist);
            	db.update(sql_huaweilist);
            }
        }
        catch(Exception ie) {}
        
        
      //端口转发
        try {
        	WebElement content19_botton = driver.findElement(By.xpath("//*[@id=\"safesettingsparent_menuId\"]"));
            content19_botton.click();
          
            WebElement content20_botton = driver.findElement(By.xpath("//*[@id=\"nat_menuId\"]"));
            content20_botton.click();
            
            port=driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div[1]/div"));
            
        	port2=port.findElements(By.xpath("//*[@class=\"border_top listtable height_70\"]"));
        	for(int i=0;i<port2.size();i++)
        	{
        		port3= new ArrayList();
        		port3=port2.get(i).findElements(By.xpath("./div"));
        	
        		String str="//*[@id=\"InternetGatewayDevice_Services_X_Portmapping_"+String.valueOf(i+1)+"__on\"]";
				if(ElementExist(driver,By.xpath(str)))
				{
					port_name=port3.get(1).getAttribute("innerHTML");
	        		System.out.println(port_name);//服务名
	        		port_device=port3.get(2).getAttribute("innerHTML");
	        		System.out.println(port_device);//设备
					port4=port3.get(4).findElement(By.xpath("./div[1]"));
					port4.click();
					JavascriptExecutor executor= (JavascriptExecutor) driver;
					executor.executeScript("document.getElementById(\"service_deviceip_ctrl\").removeAttribute(\"readonly\")") ;
					port_ip=driver.findElement(By.xpath("//*[@id=\"service_deviceip_ctrl\"]")).getAttribute("value");
					System.out.println(port_ip);//主机IP
					port_type=driver.findElement(By.xpath("//*[@id=\"service_protype_selectlist_parenselect\"]")).getAttribute("innerHTML");
					System.out.println(port_type);//协议类型
					
					executor.executeScript("document.getElementById(\"service_pmsrcport_ctrl\").removeAttribute(\"readonly\")") ;
					port_in=driver.findElement(By.xpath("//*[@id=\"service_pmsrcport_ctrl\"]")).getAttribute("value");
					System.out.println(port_in);//内部端口
					
					executor.executeScript("document.getElementById(\"service_pmdesport_ctrl\").removeAttribute(\"readonly\")") ;
					port_out=driver.findElement(By.xpath("//*[@id=\"service_pmdesport_ctrl\"]")).getAttribute("value");
					System.out.println(port_out);//外部端口
					
					sql_huaweilist="insert into huaweilist (deviceid,flag_port,port_name,port_device,port_ip,port_type,port_in,port_out) values('"+Device[4]+"','1','"+port_name+"','"+port_device+"','"+port_ip+"','"+port_type+"','"+port_in+"','"+port_out+"')";
	            	System.out.println(sql_huaweilist);
	            	db.update(sql_huaweilist);
	            	
					driver.findElement(By.xpath("//*[@id=\"calcelservice\"]")).click();	
					
					port=driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div[1]/div"));
		        	port2=port.findElements(By.xpath("//*[@class=\"border_top listtable height_70\"]"));
					
				}
				else
				{
					System.out.println("false");
				}
        	}

        }
        catch(Exception ie) {	
        }
        
        //DMZ
        try {
        	driver.findElement(By.xpath("//*[@id=\"dmz_menuId\"]")).click();
        	driver.findElement(By.xpath("//*[@id=\"dmz_open_on\"]"));
        	dmz_device=driver.findElement(By.xpath("//*[@id=\"dmz_view_data_edit_dmz_HostIPAddress_ctrl_selectlist_parenselect_selectlist_parenselect\"]")).getAttribute("innerHTML");
			System.out.println(dmz_device);//DMZ主机
           
			JavascriptExecutor executor= (JavascriptExecutor) driver;
			executor.executeScript("document.getElementById(\"dmz_view_data_edit_dmz_deviceip_ctrl\").removeAttribute(\"readonly\")") ;
			dmz_ip=driver.findElement(By.xpath("//*[@id=\"dmz_view_data_edit_dmz_deviceip_ctrl\"]")).getAttribute("value");
			System.out.println(dmz_ip);//主机IP
			sql_huaweilist="insert into huaweilist (deviceid,flag_dmz,dmz_device,port_ip) values('"+Device[4]+"','1','"+dmz_device+"','"+dmz_ip+"')";
        	System.out.println(sql_huaweilist);
        	db.update(sql_huaweilist);
           
        }
        catch(Exception ie) {	
        }
        
        //时区
        try {
        	WebElement content17_botton = driver.findElement(By.xpath("//*[@id=\"systemsettingsparent_menuId\"]"));
            content17_botton.click();
          
            WebElement content18_botton = driver.findElement(By.xpath("//*[@id=\"sntp_menuId\"]"));
            content18_botton.click();
            WebElement time_text1 = driver.findElement(By.xpath("//*[@id=\"sntp_select_selectlist_parenselect\"]"));
            timezone=time_text1.getAttribute("innerText");
            System.out.println(timezone);
        }
        catch(Exception ie) {	
        }
        
        try {
        sql_huaweitotal="insert into huaweitotal values('"+Device[4]+"','"+product_name+"','"+product_id+"','"+product_edition+"','"+EMUI_Route_edition+"','"+wan_mac+"','"+lan_mac+"','"+wan_ip+"','"+lan_ip+"','"+gateway+"','"+dns1+"','"+dns2+"','"+ip_begin+"','"+ip_end+"','"+usetime+"','"+way_24G+"','"+bind_24G+"','"+way_5G+"','"+bind_5G+"','"+timezone+"')";
        System.out.println(sql_huaweitotal);
        db.update(sql_huaweitotal);
        }
        catch(Exception ie) {	
        }
        flag=1;
        driver.quit();
        System.out.println("end selenium");
	}
}
