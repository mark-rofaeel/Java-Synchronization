import java.io.IOException;
import java.util.ArrayList;

public class Router
{
	ArrayList <Device> devices=new ArrayList <Device>();
	Files files;
	Semaphore semaphore;
	int x;
	public void value(int value)
	{
		semaphore = new Semaphore(value); 
	}
	public void occupy(Device device) throws InterruptedException, IOException
	{
		String name = device.getName();
		String type = device.getType();
		x=semaphore.P();
		if(x<0)
		{
			System.out.println(name+"("+type+") arrived and waiting");
			String str = name+"("+type+") arrived and waiting";
			Files.WriteToFile(str);
		}
		devices.add(device);
	}
	public void release(Device device)
	{
		semaphore.V();
		devices.remove(device);
	}
}