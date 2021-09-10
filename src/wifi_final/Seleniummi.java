package wifi_final;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.openqa.selenium.By;
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



public class Seleniummi {
	String url = "http://192.168.31.1/";
	String routermodel,routerversion,routermac,routersn,wifi_24Gname,wifi_5Gname,line_type,line_ip,yanma,wangguan;
	String gateway,dns,dns1,dns2,devicetype,ip_begin,ip_end,usetime,dmz,sql_xiaomilist;
	String[] dnsarray;
	String name_24G,encryption_24G,pwd_24G,way_24G,width_24G,strength_24G,name_5G,encryption_5G,pwd_5G,way_5G,width_5G,strength_5G,timezone;
	List<String> device_name,device_ip,device_mac,device_time,port_name,port_type,port_out,port_ip,port_in,port6,port7,port8,port9,port10,upnp_type,upnp_name,upnp_ip,upnp_in,upnp_out,blacklist_name,blacklist_mac,whitelist_name,whitelist_mac;
	List<WebElement> list_device,list_linename,list_lineip,list_linemac,list_linetime,list_5Gname,list_5Gip,list_5Gmac,list_5Gtime;
	List<WebElement> list_24Gname,list_24Gip,list_24Gmac,list_24Gtime,list_offlinename,list_offlineip,list_offlinemac,list_offlinetime;
	List<WebElement> list_port,list_port1,list_port2,list_port3,list_upnp,list_upnp1,list_upnp2,list_upnp3,list_blacklist1,list_blacklist2,list_whitelist1,list_whitelist2;
	WebElement a,b,c,d;
	int flag=0,errorflag=0;
	public static void main(String args[]) throws Exception
	{
	
		Seleniummi selenium=new Seleniummi();
		String[] Device= {"1", "ljy's wifi","小米","13588820793","2021031019254513"};
		
		selenium.go(Device);
	}
	public void go(String[] Device) {
		System.out.println("start selenium");
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");

		FirefoxOptions firefoxOptions=new FirefoxOptions();
		 firefoxOptions.addArguments("-headless");
       WebDriver driver = new FirefoxDriver(firefoxOptions);
		driver.manage().window().maximize();//浏览器最大化
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//超时等待30秒
        Testdb db=new Testdb();
        try {
        	driver.get(url);
        }
        catch(Exception e){
        	driver.quit();
        	this.errorflag=1;
        	return ;
        }
        
        
        //登录
        try {
            WebElement loginbox = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            loginbox.sendKeys(Device[3]);
            WebElement loginbotton = driver.findElement(By.xpath("//*[@id=\"btnRtSubmit\"]"));
            loginbotton.click();
            }
        catch(Exception e)
        {
        	System.out.println("Wrong");
        	
        }
        try {
            Thread.sleep(3000);
        } 
        catch(InterruptedException ie) {}
        //主界面信息
       
        try {
        	routermodel = driver.findElement(By.xpath("//*[@id=\"routermodel\"]")).getAttribute("innerHTML");
        	System.out.println("路由器型号："+routermodel);
        	routerversion = driver.findElement(By.xpath("//*[@id=\"routerversion\"]")).getAttribute("innerHTML");
        	System.out.println("系统ROM版本："+routerversion);
        	routermac = driver.findElement(By.xpath("//*[@id=\"routermac\"]")).getAttribute("innerHTML");
        	System.out.println("MAC地址："+routermac);
        	routersn = driver.findElement(By.xpath("//*[@id=\"routersn\"]")).getAttribute("innerHTML");
        	System.out.println("路由器序列号："+routersn);
        }
        catch(Exception e) {
        	System.out.println("Wrong");
        	driver.quit();
        	this.errorflag=1;
        	return ;
        }
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        // 连接设备界面
        try {
        	WebElement button2 = driver.findElement(By.xpath("//*[@id=\"doc\"]/div[2]/div/div[1]/p"));
        	button2.click();
            }
        catch(Exception e)
        {
        	System.out.println("Wrong");
          
        }
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
  
        list_device=driver.findElements(By.xpath("//*[@id=\"devicesTables\"]/table"));
        
        for(int count=0;count<list_device.size();count++)
        {
        	devicetype=list_device.get(count).findElement(By.xpath("./thead/tr/th[1]")).getAttribute("innerHTML");
        	
        	if(devicetype.equals("网线连网设备"))
        	{
        		try {   
                	
                	list_linename=list_device.get(count).findElements(By.xpath(".//div[@class=\"name\"]"));
              
                	list_lineip = list_device.get(count).findElements(By.xpath(".//p//span[@class=\"v\"]"));
                	list_linemac = list_device.get(count).findElements(By.xpath("./tbody/tr/td[1]/div/ul/li[2]/span[2]"));
                	list_linetime = list_device.get(count).findElements(By.xpath("./tbody/tr/td[1]/div/ul"));
                	for(int i=0;i<list_linename.size();i++)
                    {
                    	a=list_linename.get(i);
                    	b=list_lineip.get(i);
                    	c=list_linemac.get(i);
                    	d=list_linetime.get(i);
                    	String str=d.getAttribute("innerHTML");
                    	String pattern  = "已连接:</span> <span class=\"v\">(.*?)</span>";
                		Pattern r = Pattern.compile(pattern);
                	    Matcher m = r.matcher(str);
                		
                	    
                    	
                    	System.out.println(a.getAttribute("innerHTML").split(" ")[0]);
                    	System.out.println(b.getAttribute("innerHTML"));
                    	System.out.println(c.getAttribute("innerHTML"));
                    	while(m.find()) {
                			System.out.println("时间:"+m.group(1));
                			sql_xiaomilist="insert into xiaomilist (deviceid,flag_line,list_linename,list_lineip,list_linemac,list_linetime) values('"+Device[4]+"','1','"+a.getAttribute("innerHTML").split(" ")[0]+"','"+b.getAttribute("innerHTML")+"','"+c.getAttribute("innerHTML")+"','"+m.group(1)+"')";
                        	System.out.println(sql_xiaomilist);
                        	db.update(sql_xiaomilist);
                		}
                    	
                    }
                }
                catch(Exception e) {
                	System.out.println(e);
                    
                }
        	}
        	else if(devicetype.equals("5G连网设备"))
        	{
        		try {   //5G联网设备
                	
                	list_5Gname=list_device.get(count).findElements(By.xpath(".//div[@class=\"name\"]"));
                	list_5Gip = list_device.get(count).findElements(By.xpath(".//p//span[@class=\"v\"]"));
                	list_5Gmac = list_device.get(count).findElements(By.xpath("./tbody/tr/td[1]/div/ul/li[2]/span[2]"));
                	list_5Gtime = list_device.get(count).findElements(By.xpath("./tbody/tr/td[1]/div/ul"));
                	
                	for(int i=0;i<list_5Gname.size();i++)
                    {
                    	a=list_5Gname.get(i);
                    	b=list_5Gip.get(i);
                    	c=list_5Gmac.get(i);
                    	d=list_5Gtime.get(i);
                    	String str=d.getAttribute("innerHTML");
                    	String pattern  = "已连接:</span> <span class=\"v\">(.*?)</span>";
                		Pattern r = Pattern.compile(pattern);
                	    Matcher m = r.matcher(str);
                		
                    	System.out.println(a.getAttribute("innerHTML").split(" ")[0]);
                    	System.out.println(b.getAttribute("innerHTML"));
                    	System.out.println(c.getAttribute("innerHTML"));
                    	while(m.find()) {
                			System.out.println("时间:"+m.group(1));
                			sql_xiaomilist="insert into xiaomilist (deviceid,flag_5G,list_5Gname,list_5Gip,list_5Gmac,list_5Gtime) values('"+Device[4]+"','1','"+a.getAttribute("innerHTML").split(" ")[0]+"','"+b.getAttribute("innerHTML")+"','"+c.getAttribute("innerHTML")+"','"+m.group(1)+"')";
                        	System.out.println(sql_xiaomilist);
                        	db.update(sql_xiaomilist);
                		}
                    	
                    }
                }
                catch(Exception e) {
                	System.out.println(e);
                    
                }
        	}
        	else if(devicetype.equals("2.4G连网设备"))
        	{
        		try {   //2.4G联网设备
                	list_24Gname=list_device.get(count).findElements(By.xpath(".//div[@class=\"name\"]"));               
                	list_24Gip = list_device.get(count).findElements(By.xpath(".//p//span[@class=\"v\"]"));                
                	list_24Gmac = list_device.get(count).findElements(By.xpath("./tbody/tr/td[1]/div/ul/li[2]/span[2]"));                	
                	list_24Gtime = list_device.get(count).findElements(By.xpath("./tbody/tr/td[1]/div/ul"));
                	
                	for(int i=0;i<list_24Gname.size();i++)
                    {
                    	a=list_24Gname.get(i);
                    	b=list_24Gip.get(i);
                    	c=list_24Gmac.get(i);
                    	d=list_24Gtime.get(i);
                    	String str=d.getAttribute("innerHTML");              
                    	String pattern  = "已连接:</span> <span class=\"v\">(.*?)</span>";
                		Pattern r = Pattern.compile(pattern);
                	    Matcher m = r.matcher(str);
                		
                    	System.out.println(a.getAttribute("innerHTML").split(" ")[0]);
                    	System.out.println(b.getAttribute("innerHTML"));
                    	System.out.println(c.getAttribute("innerHTML"));
                    	
                    	while(m.find()) {
                			System.out.println("时间:"+m.group(1));
                			sql_xiaomilist="insert into xiaomilist (deviceid,flag_24G,list_24Gname,list_24Gip,list_24Gmac,list_24Gtime) values('"+Device[4]+"','1','"+a.getAttribute("innerHTML").split(" ")[0]+"','"+b.getAttribute("innerHTML")+"','"+c.getAttribute("innerHTML")+"','"+m.group(1)+"')";
                        	System.out.println(sql_xiaomilist);
                        	db.update(sql_xiaomilist);
                		}
                    	
                    }
                	
                }
                catch(Exception e) {
                	System.out.println("Wrong");
                }
        	}
        }
        
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        
        
       
       
        try {   //wifi设置界面
        	
			WebElement button3 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/ul/li[2]/a"));
        	button3.click();
        	WebElement button4 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/ul/li[1]/a/span"));
        	button4.click();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        try {   //上网信息界面
        	driver.findElement(By.xpath("//*[@class=\"btn-switch btn-switch-off\"]"));
    
        	
             WebElement wifiset_text4 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/form/div[6]/span/div"));
             way_24G=wifiset_text4.getAttribute("innerText");
             way_24G=way_24G.replaceAll("\r\n|\r|\n|\\s*", "");
             System.out.println("2.4G信道:"+way_24G);
             WebElement wifiset_text5 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/form/div[7]/span/div"));
             width_24G=wifiset_text5.getAttribute("innerHTML");
             System.out.println("2.4G带宽:"+width_24G);
            
             WebElement wifiset_text10 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/form/div[6]/span/div"));
             way_5G=wifiset_text10.getAttribute("innerText");
             way_5G=way_5G.replaceAll("\r\n|\r|\n|\\s*", "");
             System.out.println("5G信道:"+way_5G);
             WebElement wifiset_text11 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/form/div[7]/span/div"));
             width_5G=wifiset_text11.getAttribute("innerHTML");
             System.out.println("5G带宽:"+width_5G);
             
             
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        
        try {   //上网信息界面
        	driver.findElement(By.xpath("//*[@class=\"btn-switch btn-switch-on\"]"));
   
             WebElement wifiset_text4 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/form/div[2]/div[1]/span/div"));
             way_24G=wifiset_text4.getAttribute("innerText");
             way_24G=way_24G.replaceAll("\r\n|\r|\n|\\s*", "");
             System.out.println("2.4G信道:"+way_24G);
             WebElement wifiset_text5 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/form/div[2]/div[2]/span/div"));
             width_24G=wifiset_text5.getAttribute("innerHTML");
             System.out.println("2.4G带宽:"+width_24G);
            
             WebElement wifiset_text10 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/form/div[3]/div[1]/span/div"));
             way_5G=wifiset_text10.getAttribute("innerText");
             way_5G=way_5G.replaceAll("\r\n|\r|\n|\\s*", "");
             System.out.println("5G信道:"+way_5G);
             WebElement wifiset_text11 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/form/div[3]/div[2]/span/div"));
             width_5G=wifiset_text11.getAttribute("innerHTML");
             System.out.println("5G带宽:"+width_5G);
             
             
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        try {   //上网信息
        	
        	WebElement button5 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/ul/li[2]/a/span"));
        	button5.click();
			line_type = driver.findElement(By.xpath("//*[@id=\"wanStatus\"]/div/ul/li[1]/span[2]")).getAttribute("innerHTML");
			line_ip = driver.findElement(By.xpath("//*[@id=\"wanStatus\"]/div/ul/li[2]/span[2]")).getAttribute("innerHTML");
			wangguan = driver.findElement(By.xpath("//*[@id=\"wanStatus\"]/div/ul/li[4]/span[2]")).getAttribute("innerHTML");
			dns = driver.findElement(By.xpath("//*[@id=\"wanStatus\"]/div/ul/li[5]/span[2]")).getText();
			dnsarray=dns.split(" ");
			if(dnsarray.length==2)
			{
				dns1=dnsarray[0];
				dns2=dnsarray[1];
			}
			else
			{
				dns1=dnsarray[0];
				dns2="";
			}
			System.out.println("IP地址："+line_ip);
			System.out.println("默认网关："+wangguan);
			System.out.println("DNS1："+dns1);
			System.out.println("DNS2："+dns2);
        }
        catch(Exception e) {
        	System.out.println(e);
            
        }
        
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        try {   //黑白名单信息
        	
        	WebElement button6 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/ul/li[3]/a/span"));
        	button6.click();
        	
        	
        }
        catch(Exception e) {
        	System.out.println(e);
            
        }
        try {
            Thread.sleep(2000);
        } 
        catch(InterruptedException ie) {}
        try {//黑名单
        	WebElement button7 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/p/label[1]/span"));
        	button7.click();
        }
        catch(Exception e) {
        	System.out.println(e);
            
        }
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        
        try {
        	list_blacklist1=driver.findElements(By.xpath("//*[@id=\"deviceslist\"]/tr"));   
        	
            blacklist_name= new ArrayList();
            blacklist_mac= new ArrayList();
            for(int i=0;i<list_blacklist1.size();i++)
            {
            	list_blacklist2=list_blacklist1.get(i).findElements(By.xpath("./td"));
            	
            	for(int j=0;j<list_blacklist2.size();j++)
            	{
            		if(j%3==0)
            		{
            			blacklist_name.add(list_blacklist2.get(j).getAttribute("innerHTML"));
            			
            		}
            		else if (j%3==1)
            		{
            			blacklist_mac.add(list_blacklist2.get(j).getAttribute("innerHTML"));
            			
            		}
            		else {}
            	}
            }
            System.out.println(blacklist_name);
            System.out.println(blacklist_mac);  

        }
        catch(Exception e) {
        	System.out.println(e);
            
        }
        
        try {
        	for(int i=0;i<blacklist_name.size();i++)
            {
            	sql_xiaomilist="insert into xiaomilist (deviceid,flag_blacklist,blacklist_name,blacklist_mac) values('"+Device[4]+"','1','"+blacklist_name.get(i)+"','"+blacklist_mac.get(i)+"')";
            	System.out.println(sql_xiaomilist);
            	db.update(sql_xiaomilist);
            }
        }
        catch(Exception ie) {}
        
        
        try {//白名单
        	WebElement button8 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/p/label[2]/span"));
        	button8.click();
        }
        catch(Exception e) {
        	System.out.println(e);
            
        }
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
        try {
        	list_whitelist1=driver.findElements(By.xpath("//*[@id=\"deviceslist\"]/tr"));   
        	
        	whitelist_name= new ArrayList();
        	whitelist_mac= new ArrayList();
            for(int i=0;i<list_whitelist1.size();i++)
            {
            	list_whitelist2=list_whitelist1.get(i).findElements(By.xpath("./td"));
            	
            	for(int j=0;j<list_whitelist2.size();j++)
            	{
            		if(j%3==0)
            		{
            			whitelist_name.add(list_whitelist2.get(j).getAttribute("innerHTML"));
            			
            		}
            		else if (j%3==1)
            		{
            			whitelist_mac.add(list_whitelist2.get(j).getAttribute("innerHTML"));
            			
            		}
            		else {}
            	}
            }
            System.out.println(whitelist_name);
            System.out.println(whitelist_mac);  

        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        try {
        	for(int i=0;i<whitelist_name.size();i++)
            {
            	sql_xiaomilist="insert into xiaomilist (deviceid,flag_whitelist,whitelist_name,whitelist_mac) values('"+Device[4]+"','1','"+whitelist_name.get(i)+"','"+whitelist_mac.get(i)+"')";
            	System.out.println(sql_xiaomilist);
            	db.update(sql_xiaomilist);
            }
        }
        catch(Exception ie) {}
 
        try {  
        	
        	driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/ul/li[4]/a/span")).click();;

        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
    	try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
    	
		try {	
			ip_begin = driver.findElement(By.xpath("//*[@id=\"startip\"]")).getAttribute("value");
			ip_end = driver.findElement(By.xpath("//*[@id=\"endip\"]")).getAttribute("value");
			System.out.println("ip范围："+ip_begin+ip_end);
			usetime= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/form/div[1]/div[3]/span/input")).getAttribute("value");
        }
        catch(Exception e) {
        	System.out.println(e);
            
        }

        
        try {  
        	
        	WebElement button10 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/ul/li[5]/a/span"));
        	button10.click();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
    	try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ie) {}
    	
		try {	
			timezone = driver.findElement(By.xpath("//*[@id=\"timezoneval\"]")).getAttribute("innerHTML");
			System.out.println("时区："+timezone);
        }
        catch(Exception e) {
        	System.out.println(e);
            
        }
        
        
        try {   //端口转发
        	
        	WebElement button11 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/ul/li[3]/a"));
        	button11.click();
        }
        catch(Exception e) {
        	System.out.println(e);
            
        }
        
        try {
            Thread.sleep(2000);
        } 
        catch(InterruptedException ie) {}
       
        try {
        	
        	WebElement button12 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/ul/li[4]/a/span"));
        	button12.click();
        }
        catch(Exception e) {
        	System.out.println(e);
            
        }
        
        try {
            Thread.sleep(2000);
        } 
        catch(InterruptedException ie) {}
        
        
        try {
        	list_port=driver.findElements(By.xpath("//*[@id=\"natlist_port\"]/tr"));   
        	
        	port_name= new ArrayList();
            port_type= new ArrayList();
            port_out= new ArrayList();
            port_ip= new ArrayList();
            port_in= new ArrayList();
            
            for(int i=0;i<list_port.size()-1;i++)
            {
            	list_port1=list_port.get(i).findElements(By.xpath("./td"));
            	
            	for(int j=0;j<list_port1.size();j++)
            	{
            		if(j==0)
            		{
            			port_name.add(list_port1.get(j).getAttribute("innerHTML"));
            		}
            		if(j==1)
            		{
            			port_type.add(list_port1.get(j).getAttribute("innerHTML").replaceAll("\r\n|\r|\n|\\s*", ""));
            		}
            		if(j==2)
            		{
            			port_out.add(list_port1.get(j).getAttribute("innerHTML"));
            		}
            		if(j==3)
            		{
            			port_ip.add(list_port1.get(j).getAttribute("innerHTML"));
            		}
            		if(j==4)
            		{
            			port_in.add(list_port1.get(j).getAttribute("innerHTML"));
            		}
            	}
            }
            System.out.println(port_name);
            System.out.println(port_type);
            System.out.println(port_out);
            System.out.println(port_ip);
            System.out.println(port_in);
            

        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        try {
        	for(int i=0;i<port_name.size();i++)
        	{
        		sql_xiaomilist="insert into xiaomilist (deviceid,flag_port,port_name,port_type,port_out,port_ip,port_in) values('"+Device[4]+"','1','"+port_name+"','"+port_type+"','"+port_out+"','"+port_ip+"','"+port_in+"')";
            	System.out.println(sql_xiaomilist);
            	db.update(sql_xiaomilist);
        	}
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        /*
        try {
        	list_port2=driver.findElements(By.xpath("//*[@id=\"natlist_range\"]/tr"));   
        	
        	port6= new ArrayList();
        	port7= new ArrayList();
        	port8= new ArrayList();
        	port9= new ArrayList();
        	port10= new ArrayList();
            
            for(int i=0;i<list_port2.size()-1;i++)
            {
            	list_port3=list_port2.get(i).findElements(By.xpath("./td"));
            	
            	for(int j=0;j<list_port3.size();j++)
            	{
            		if(j==0)
            		{
            			port6.add(list_port3.get(j).getAttribute("innerHTML"));
            		}
            		if(j==1)
            		{
            			port7.add(list_port3.get(j).getAttribute("innerHTML").replaceAll("\r\n|\r|\n|\\s*", ""));
            		}
            		if(j==2)
            		{
            			port8.add(list_port3.get(j).getAttribute("innerHTML"));
            		}
            		if(j==3)
            		{
            			port9.add(list_port3.get(j).getAttribute("innerHTML"));
            		}
            		if(j==4)
            		{
            			port10.add(list_port3.get(j).getAttribute("innerHTML"));
            		}
            	}
            }
            System.out.println(port6);
            System.out.println(port7);
            System.out.println(port8);
            System.out.println(port9);
            System.out.println(port10);

        }
        catch(Exception e) {
        	System.out.println(e);
        }
       */
        try {
        	driver.findElements(By.xpath("//*[@class=\"btn-switch btn-switch-on\"]/tr"));   
        	WebElement dmztext=driver.findElement(By.xpath("//*[@id=\"ipOK\"]"));
            dmz=dmztext.getAttribute("innerHTML").substring(dmz.indexOf("址")+1, dmz.indexOf("已"));
            
            System.out.println(dmz);
            sql_xiaomilist="insert into xiaomilist (deviceid,flag_dmz,dmz_ip) values('"+Device[4]+"','1','"+dmz+"')";
        	System.out.println(sql_xiaomilist);
        	db.update(sql_xiaomilist);

        }
        catch(Exception e) {
        	System.out.println(e);
        	 System.out.println("no dmz");
        }
        
        //upnp
        try {
        	driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/ul/li[6]/a/span")).click();   
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("//*[@class=\"btn-switch btn-switch-on\"]"));
        	upnp_type= new ArrayList();//协议
        	upnp_name= new ArrayList();//应用名称
        	upnp_ip= new ArrayList();//客户端ip
        	upnp_in= new ArrayList();//内部端口
        	upnp_out= new ArrayList();//外部端口
        	
        	list_upnp=driver.findElements(By.xpath("//*[@id=\"upnplist\"]/tr"));
            System.out.println(list_upnp.size());
            for(int i=0;i<list_upnp.size();i++)
            {
            	list_upnp1=list_upnp.get(i).findElements(By.xpath("./td"));
            	if(list_upnp1.size()==1) 
            	{
            		break;
            	}
    			upnp_type.add(list_upnp1.get(0).getAttribute("innerHTML"));
    			upnp_name.add(list_upnp1.get(1).getAttribute("innerHTML"));        		
    			upnp_ip.add(list_upnp1.get(2).getAttribute("innerHTML"));        		
    			upnp_in.add(list_upnp1.get(3).getAttribute("innerHTML"));       		
    			upnp_out.add(list_upnp1.get(4).getAttribute("innerHTML"));
            		
            	}
            
            System.out.println(upnp_type);
            System.out.println(upnp_name);
            System.out.println(upnp_ip);
            System.out.println(upnp_in);
            System.out.println(upnp_out);

        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        try {
        	for(int i=0;i<upnp_type.size();i++)
        	{
        		sql_xiaomilist="insert into xiaomilist (deviceid,flag_upnp,upnp_type,upnp_name,upnp_ip,upnp_in,upnp_out) values('"+Device[4]+"','1','"+upnp_type.get(i)+"','"+upnp_name.get(i)+"','"+upnp_ip.get(i)+"','"+upnp_in.get(i)+"','"+upnp_out.get(i)+"')";
            	System.out.println(sql_xiaomilist);
            	db.update(sql_xiaomilist);
        	}
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
        
        try {
            String sql_xiaomitotal="insert into xiaomitotal values("+Device[4]+",'"+routermodel+"','"+routerversion+"','"+routermac+"','"+routersn+"','"+way_24G+"','"+width_24G+"','"+way_5G+"','"+width_5G+"','"+line_ip+"','"+wangguan+"','"+dns1+"','"+dns2+"','"+ip_begin+"','"+ip_end+"','"+usetime+"','"+timezone+"')";
            System.out.println(sql_xiaomitotal);
            db.update(sql_xiaomitotal);
            }
        catch(Exception ie) {	
        }
        flag=1;
        
        driver.quit();
        System.out.println("end selenium");
	}
	
	
}

