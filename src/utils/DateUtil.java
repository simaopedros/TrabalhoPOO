package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
//Define as datas
public class DateUtil {
	
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(new Date());
	}

}
