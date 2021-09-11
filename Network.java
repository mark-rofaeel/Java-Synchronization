import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Network
{	
	public static void main(String[] args) throws IOException 
	{
		Device device = new Device();
		Router router = new Router();
		Files files = new Files();
		ArrayList <Device> devices=new ArrayList <Device>();
		Scanner input = new Scanner(System.in);
		System.out.println("What is number of WI-FI Connections?");
		int N=input.nextInt(); //counter in semaphore class
		router.value(N);
		System.out.println("What is number of devices Clients want to connect?");
		int TC=input.nextInt();
		for(int i=0; i<TC; i++)
		{
			String name=input.next();
			String type=input.next();
			Device d = new Device(name,type,router);
			devices.add(d);
		}
		for(int i=0; i<TC; i++)
		{
			device=devices.get(i);
			Thread thread = new Thread(device);
			thread.start();
			System.out.println("(" + device.getName() + ")" + "(" + device.getType() + ") arrived");
			String str = "(" + device.getName() + ")" + "(" + device.getType() + ") arrived";
			files.WriteToFile(str);
		}
	}
}