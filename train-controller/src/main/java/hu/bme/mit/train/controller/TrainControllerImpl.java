package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;


	private int ULTIMATE_SPEED_LIMIT = 400;

	public void TrainControllerImpl() { 	
			TimerTask task = new TimerTask() { 			
				public void run () { 				
					followSpeed();  	
						} 	
	   } ; 
			Timer ti = new Timer( "Reference speed" ); 		
			ti.schedule(task, 0, 1000);

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
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
