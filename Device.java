import java.io.IOException;

public class Device implements Runnable
{
	Router router = new Router();
	Files files;
	public String name;
	public String type;
	public String getName() 
	{
		return this.name;
	}
	public String getType() 
	{
		return this.type;
	}
	public Device() 
	{
		this.name = "";
		this.type = "";
		this.router = null;
	}
	public Device(String name,String type, Router r)
	{
		this.name = name;
		this.type = type;
		this.router = r;
	}
	public void run() 
	{
		try {this.router.occupy(this);} catch (InterruptedException e){} catch (IOException e) {e.printStackTrace();}
		try {Thread.sleep(1000);} catch (Exception e){}
		System.out.println("Connection "+ (this.router.devices.indexOf(this)+1) + " " + this.getName() + " Occupied");
		String str = "Connection "+ (this.router.devices.indexOf(this)+1) + " " + this.getName() + " Occupied";
		try {
			files.WriteToFile(str);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {Thread.sleep(1000);} catch (Exception e){}
		System.out.println("Connection "+ (this.router.devices.indexOf(this)+1) + " " + this.getName() + " performs online activity");
		String str2 = "Connection "+ (this.router.devices.indexOf(this)+1) + " " + this.getName() + " performs online activity";
		try {
			files.WriteToFile(str2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {Thread.sleep(1000);} catch (Exception e){}
		System.out.println("Connection "+ (this.router.devices.indexOf(this)+1) + " " + this.getName() + " Logged out");
		String str3 = "Connection "+ (this.router.devices.indexOf(this)+1) + " " + this.getName() + " Logged out";
		try {
			files.WriteToFile(str3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.router.release(this);
	}
}