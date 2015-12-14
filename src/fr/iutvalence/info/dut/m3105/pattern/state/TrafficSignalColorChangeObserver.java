package fr.iutvalence.info.dut.m3105.pattern.state;

public interface TrafficSignalColorChangeObserver
{
	public void notifyNewChangeOfState(TrafficSignalEvent TSE);
}
