package stockData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) throws ParseException{
	
		String fileName = "HistoricalQuotes.csv";
		File file = new File(fileName);
	
	try {
		Scanner scan = new Scanner(file);
		
		FileOutputStream fos1 = new FileOutputStream("ClosingPriceHigher.csv",true);
		PrintWriter outputStream1 = new PrintWriter(fos1);
		
		FileOutputStream fos2 = new FileOutputStream("OpeningPriceHigher.csv",true);
		PrintWriter outputStream2 = new PrintWriter(fos2);
		
		FileOutputStream fos3 = new FileOutputStream("MonthlyAverage.csv",true);
		PrintWriter outputStream3 = new PrintWriter(fos3);
		
		int sumVolume1=0,sumVolume2=0,sumVolume3=0,sumVolume4=0,sumVolume5=0,sumVolume6=0,sumVolume7=0,sumVolume8=0,sumVolume9=0,sumVolume10=0,sumVolume11=0,sumVolume12 = 0;
		int count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0,count11=0,count12=0;
		
		scan.nextLine(); //ignore the first line
		
		while (scan.hasNext()) {
			String data = scan.nextLine();
			String[] values = data.split(",");
			double closingPrice = Double.parseDouble(values[1].replace("$", "0"));
			double openingPrice = Double.parseDouble(values[3].replace("$", "0"));
			double volume = Double.parseDouble(values[2]);
			
			//a) print the record in file when stock closed price higher than open price.
			
			if (closingPrice>openingPrice) {
				outputStream1.println(data);
			}
			
			//b) print the record in file when stock closed price is less then open price
			
			else if (closingPrice<openingPrice) {
				outputStream2.println(data);

			}
			
			//C) print monthly average volume traded for last 1 year
			
			String sDate = values[0];
			String[] sd = sDate.split("/");
		    int mm = Integer.parseInt(sd[0]);
		    if(mm==1) {
		    	sumVolume1+= volume;
		    	count1++;
		    }else if (mm==2) {
		    	sumVolume2 += volume;
		    	count2++;
		    }else if (mm==3) {
		    	sumVolume3 += volume;
		    	count3++;
		    }else if (mm==4) {
		    	sumVolume4 += volume;
		    	count4++;
		    }else if (mm==5) {
		    	sumVolume5 += volume;
		    	count5++;
		    }else if (mm==6) {
		    	sumVolume6 += volume;
		    	count6++;
		    }else if (mm==7) {
		    	sumVolume7 += volume;
		    	count7++;
		    }else if (mm==8) {
		    	sumVolume8 += volume;
		    	count8++;
		    }else if (mm==9) {
		    	sumVolume9 += volume;
		    	count9++;
		    }else if (mm==10) {
		    	sumVolume10 += volume;
		    	count10++;
		    }else if (mm==11) {
		    	sumVolume11 += volume;
		    	count11++;
		    }else if (mm==12) {
		    	sumVolume12 += volume;
		    	count12++;
		    }
		    
		    }
		
		outputStream3.println("Monthly Average of January  : "+sumVolume1/count1);	
		outputStream3.println("Monthly Average of February : "+sumVolume2/count2);	
		outputStream3.println("Monthly Average of March    : "+sumVolume3/count3);	
		outputStream3.println("Monthly Average of April    : "+sumVolume4/count4);	
		outputStream3.println("Monthly Average of May      : "+sumVolume5/count5);	
		outputStream3.println("Monthly Average of June     : "+sumVolume6/count6);	
		outputStream3.println("Monthly Average of July     : "+sumVolume7/count7);	
		outputStream3.println("Monthly Average of August   : "+sumVolume8/count8);	
		outputStream3.println("Monthly Average of September: "+sumVolume9/count9);	
		outputStream3.println("Monthly Average of October  : "+sumVolume10/count10);	
		outputStream3.println("Monthly Average of November : "+sumVolume11/count11);	
		outputStream3.println("Monthly Average of December : "+sumVolume12/count12);	
		    
		scan.close();
		outputStream1.close();
		outputStream2.close();
		outputStream3.close();
		
	 	
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	
	}

}
}

