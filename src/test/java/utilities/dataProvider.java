package utilities;

import org.testng.annotations.DataProvider;

public class dataProvider {
	
	@DataProvider(name="Test2")
	public String[][] dataPassFromExcel() throws Exception
	{
		String path= "D:\\Eclipse\\seleniumByPawanKumar\\SBILProductJourney\\src\\test\\resources\\Data.xlsx";
		readFromExcel r = new readFromExcel(path);
		int totalrow=r.getrowCound("Sheet1");
		int totalcol=r.getcolCount("Sheet1",0);
		
		String data[][] = new String[totalrow][totalcol];
		for(int i=1; i<totalrow; i++)
		{
			for(int j=0; j<totalcol; j++)
			{
				data[i-1][j]=r.getCellData("Sheet1", i, j);
			}
		}
		return data;
	}

}
