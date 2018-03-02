package flag;

public class FlagSystem {
	// singleton stuff
	private static FlagSystem instance = new FlagSystem();
	private FlagSystem() {
		observableFlagSets = new ObservableFlagSet[2];
	}
	public static FlagSystem getInstance() { return instance; }
	
	// flag type constants
	public static final int
		STORY = 0,
		SCENE = 1;
	
	private ObservableFlagSet[] observableFlagSets;
	
	public void registerListener(FlagListener fl, int type, int flag) {
		observableFlagSets[type].registerListener(fl, flag);
	}
	
	public void unregisterListener(FlagListener fl, int type, int flag) {
		observableFlagSets[type].unregisterListener(fl, flag);
	}
	
	public void set(int type, int flag) {
		observableFlagSets[type].set(flag);
	}
	
	public void clear(int type, int flag) {
		observableFlagSets[type].clear(flag);
	}
	
	public void touch(int type, int flag) {
		observableFlagSets[type].touch(flag);
	}
}