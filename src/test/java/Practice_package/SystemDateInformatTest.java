package Practice_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemDateInformatTest {

	public static void main(String[] args) {
		SimpleDateFormat Formatdate=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date=new Date();
		String Systemdateinformat =Formatdate.format(date);
		System.out.println(Systemdateinformat);

	}

}
