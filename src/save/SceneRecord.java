package save;

public class SceneRecord {
    
    private int actorFlags;    

    public SceneRecord(int actorFlags) {
	this.actorFlags = actorFlags;
    }
    
    public void setActorFlag(int index) {
	actorFlags = (actorFlags) | (1 << index);
	System.out.println(actorFlags);
    }
    
    public boolean actorFlagIsSet(int index) {
	return ((actorFlags >> index) & 1) == 1;
    }
    
    public void clearActorFlag(int index) {
	
    }
    
    @Override
    public String toString() {
	return actorFlags + "";
    }

}
