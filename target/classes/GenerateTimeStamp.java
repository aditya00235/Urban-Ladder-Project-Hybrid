package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateTimeStamp 
{

	public static String generateCurrentTime()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		return timeStamp;
	}
}
