package wifi_final;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainClass {

	public static CaseManage cm;
	public static CaseCreate cc;
	public static DeviceManage dm;
	public static AddDevice ad;
	public static DeviceCaseInfo dci;
	
	public static Color btnColor = new Color(0, 127, 255);
	
	public static List<Case> caselist = new ArrayList<Case>();
	public static ListIterator<Case> listIterator =caselist.listIterator();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testdb db=new Testdb();
		try {
			db.createhuaweitotal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.createdevice();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.createxiaomilist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.createhuaweilist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.createxiaomitotal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.createtotal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cm = new CaseManage();
//		Login login = new Login("", "");
//		login.frame.setVisible(true);
//		dm = new DeviceManage(null);
//		EvidenceInfo ev = new EvidenceInfo();
//		ev.frame.setVisible(true);
	}

}
