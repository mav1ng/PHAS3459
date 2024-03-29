package module2;


public class ParticleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//creating object ball from the class FallingParticle
		FallingParticle ball = new FallingParticle(5.2, 3.6);
		
		//set the initial height to 10m above the floor
		ball.setH(10);

		//simulation the drop and printing out the time taken and the velocities for 
		//different timesteps deltaT
		System.out.println("Drop with deltaT = 0.5");
		ball.drop(0.5);
		System.out.println("Time taken: " + FallingParticle.t + " Final Velocity: " + ball.getV());
		System.out.println();
		
		System.out.println("Drop with deltaT = 0.1");
		ball.drop(0.1);
		System.out.println("Time taken: " + FallingParticle.t + " Final Velocity: " + ball.getV());
		System.out.println();
		
		System.out.println("Drop with deltaT = 0.01");
		ball.drop(0.01);
		System.out.println("Time taken: " + FallingParticle.t + " Final Velocity: " + ball.getV());
		System.out.println();
		
		System.out.println("Drop with deltaT = 0.001");
		ball.drop(0.001);
		System.out.println("Time taken: " + FallingParticle.t + " Final Velocity: " + ball.getV());
		System.out.println();
		
		System.out.println("Drop with deltaT = 0.0001");
		ball.drop(0.0001);
		System.out.println("Time taken: " + FallingParticle.t + " Final Velocity: " + ball.getV());
		System.out.println();
		System.out.println();
		
		//explaining the difference in the times and velocities
		System.out.println("So why does the data differ?");
		System.out.println("In the vast majority of all cases the exact time the object needs to reach ");
		System.out.println("the ground of the vessel is not an integer number. It is rather a real number with");
		System.out.println("a lot of decimal places. The while loop used by the system cannot measure the time exactly ");
		System.out.println("but can only converge towards the exact time in the deltaT-steps. As soon as the approached");
		System.out.println("time exceeds the exact time the loops stops and thus misses the remaining time the object");
		System.out.println("would need to reach the ground. That is why the Time taken and the final velocity increases");	
		System.out.println("with decreasing deltaT-steps");
	}

}
