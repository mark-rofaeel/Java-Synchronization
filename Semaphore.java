public class Semaphore 
{
	protected int value=0;
	protected Semaphore() 
	{
		value=0; 
	}
	protected Semaphore(int initial)
	{
		value=initial; 
	}
	public synchronized int P() throws InterruptedException 
	{
		value--;
		int pos=0;
		if (value < 0)
		{
			pos=-1;
			wait();
		}
		return pos;
	}
	public synchronized void V() 
	{
		value++; 
		if (value <= 0) 
			notify();
	}
}