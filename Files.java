import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Files 
{
	public static void WriteToFile(String Input) throws IOException
	{	
		File file = new File("save.txt");
		BufferedWriter out=new BufferedWriter(new FileWriter(file,true));
		out.write(Input);
		out.newLine();
		out.close();
	}	
}
