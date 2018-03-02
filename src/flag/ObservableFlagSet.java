package flag;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ObservableFlagSet {
	private FlagSet flagSet;
	private Map<Integer, List<FlagListener>> flagToListenerList;
	
	public ObservableFlagSet() {
		flagSet = new FlagSet();
		flagToListenerList = new HashMap<Integer, List<FlagListener>>();
	}
	
	public ObservableFlagSet(FlagSet flagSet) {
		this.flagSet = flagSet;
		flagToListenerList = new HashMap<Integer, List<FlagListener>>();
	}
	
	public void registerListener(FlagListener fl, int flag) {
		if (flagToListenerList.get(flag) == null) {
			flagToListenerList.put(flag, new ArrayList<FlagListener>());
		}
		flagToListenerList.get(flag).add(fl);
	}
	
	public void unregisterListener(FlagListener fl, int flag) {
		List<FlagListener> list = flagToListenerList.get(flag);
		list.remove(fl);
		if (list.isEmpty()) {
			flagToListenerList.remove(flag);
		}
	}
	
	public void set(int flag) {
		flagSet.set(flag);
		for (FlagListener fl : flagToListenerList.get(flag)) {
			fl.flagSet();
		}
	}
	
	public void clear(int flag) {
		flagSet.clear(flag);
		for (FlagListener fl : flagToListenerList.get(flag)) {
			fl.flagCleared();
		}
	}
	
	public void touch(int flag) {
		for (FlagListener fo : flagToListenerList.get(flag)) {
			fo.flagTouched();
		}
	}
}