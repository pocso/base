package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import java.util.Timer;
import java.util.TimerTask;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 100;
	private long timeStep = 1000L;



	private int ULTIMATE_SPEED_LIMIT = 400;

	public void TrainControllerImpl(){
		TimerTask task = new TimerTask() {
		@Override	
        public void run() {
            followSpeed(); 	
        }
    	};
    	Timer timer = new Timer("Timer for reference speed");
    	timer.scheduleAtFixedRate(task, 0, 1000);
		System.out.println("TASK CHEDULED");
	} 

	@Override
	public void followSpeed() {
		System.out.println("lefutott"); 
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed + step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}
		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		if(speedLimit > ULTIMATE_SPEED_LIMIT){
			this.speedLimit = ULTIMATE_SPEED_LIMIT;
		}else{
		this.speedLimit = speedLimit;
		}
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;
	}

}
