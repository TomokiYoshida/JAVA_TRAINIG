package ch01.ex01_16;

import java.io.FileInputStream;
import java.io.IOException;

public class MyUtilities {
	public double [] getDataSet(String setName) throws BadDataSetException
	{
		String file = setName + ".dset";
		FileInputStream in = null;
		try{
			in = new FileInputStream(file);
			return readDataSet(in);

		}catch (IOException e){
			throw new BadDataSetException(file, e);
		}finally{
			try{
				if(in != null)
					in.close();
			}catch (IOException e){

			}
		}

	}
	public double[] readDataSet(FileInputStream in){
		return  new double[10];
	}

}
