package save;

import flag.FlagSet;

public class Save {
	public static final int NUM_SCENES = 256;
	private static final int DEFAULT_SCENE = 0;
	private static final int DEFAULT_ENTRANCE = 0;
	
	private String name;
	
	private int lastEntrance;
	
	private FlagSet storyFlagSet;
	private FlagSet[] sceneFlagSets;
	
	public Save() {
		name = "";
		
		lastEntrance = DEFAULT_ENTRANCE;
		
		storyFlagSet = new FlagSet();
		sceneFlagSets = new FlagSet[NUM_SCENES];
		for (int i = 0; i < NUM_SCENES; i++) {
			sceneFlagSets[i] = new FlagSet();
		}
	}
	
	public Save(String name, int lastEntrance, FlagSet storyFlagSet, FlagSet[] sceneFlagSets) {
		this.name = name;
		
		this.lastEntrance = lastEntrance;
		
		this.storyFlagSet = storyFlagSet;
		this.sceneFlagSets = sceneFlagSets;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLastEntrance() {
		return lastEntrance;
	}
	
	public void setLastEntrance(int lastEntrance) {
		this.lastEntrance = lastEntrance;
	}
	
	public FlagSet getStoryFlagSet() {
		return storyFlagSet;
	}
	
	public FlagSet[] getSceneFlagSets() {
		return sceneFlagSets;
	}
}