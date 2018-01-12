package exam1516;

import java.util.ArrayList;

public class GetATVoltage implements CalculationOfAT {

	@Override
	public double getArrivalTime(ArrayList<Double> al) throws Exception {
		return MainPulse.getArrivalTime(al);
	}

}
