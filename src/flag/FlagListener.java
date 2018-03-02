package flag;

public interface FlagListener {
	public void flagSet();
	public void flagCleared();
	public void flagTouched();
}