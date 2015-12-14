package fr.iutvalence.info.dut.m3105.pattern.state;


public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalUserInterface, TrafficSignalButtonObserver
{
	private TrafficSignalState state;
	private TrafficSignalColorChangeObserver TSCCO;

	@Override
	public void setTrafficSignalState(TrafficSignalState state)
	{
		System.out.println("Traffic signal state is "+state.getName());
		this.state = state;		
	}

	@Override
	public void pressButton()
	{
		this.state.buttonPressed();
	}
	
	
	public void run()
	{
		this.setTrafficSignalState(new TrafficSignalGreenState(this));
		while (true)
		{
			try
			{
				Thread.sleep(1000);
				this.state.secondEllapsed();
			}
			catch (InterruptedException e)
			{
				break;
			}
		}
	}
	
	public void notifyNewChangeOfState(TrafficSignalEvent TSE)
	{
		
	}
	
	public void registerObserver(TrafficSignalColorChangeObserver TSCCO)
	{
		this.TSCCO=TSCCO;
	}
	
	public void unregisterObserver(TrafficSignalColorChangeObserver TSCCO)
	{
		this.TSCCO=null;
	}

	@Override
	public void notifyButtonPressed() {
		// TODO Auto-generated method stub
		
	}
	
}
