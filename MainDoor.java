package wk2;

interface Door {
	void door();
}

class frontOpen implements Door {
	@Override
	public void door() {
		System.out.println("Door open from front");
	}
}
class topOpen implements Door {
	@Override
	public void door() {
		System.out.println("Door open from bottom to top");
	}
}

class slideOpen implements Door {
	@Override
	public void door() {
		System.out.println("Door open by sliding");
	}
}

class DoorFactory {
	public Door doorObject(String doorType){
		if(doorType == null){
			return null;
		} 
    if(doorType.equalsIgnoreCase("slideOpen")){
    	return new slideOpen();   
    } else if(doorType.equalsIgnoreCase("frontOpen")){
    	return new frontOpen();  
    } else if(doorType.equalsIgnoreCase("topOpen")){
    	return new topOpen();
    }
    return null;
	}
}

public class MainDoor {
	private static DoorFactory doorFactory = new DoorFactory();
	private MainDoor() {}
	public static void main(String[] args) {
		DoorFactory doorFactory = new DoorFactory();
		Door door_slideOpen = doorFactory.doorObject("slideOpen");
		door_slideOpen.door();
		Door shape_frontOpen = doorFactory.doorObject("frontOpen");
		shape_frontOpen.door();
		Door door_topOpen = doorFactory.doorObject("topOpen");
		door_topOpen.door();
	}
	public static DoorFactory getDoorFactory() {
		return doorFactory;
	}
	public static void setDoorFactory(DoorFactory doorFactory) {
		MainDoor.doorFactory = doorFactory;
	}
}