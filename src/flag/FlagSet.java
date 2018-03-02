package flag;

public class FlagSet {
	public static final int NUM_FLAGS = 256;
	
	private int[] ints = new int[NUM_FLAGS / 32];
	
	public FlagSet() {
		ints = new int[NUM_FLAGS / 32];
	}
	
	public FlagSet(byte[] bytes) {
		ints = new int[NUM_FLAGS / 32];
		for (int i = 0; i < ints.length; i++) {
			ints[i] =
				(bytes[i + 0] & 0xFF) << 24 |
				(bytes[i + 1] & 0xFF) << 16 |
				(bytes[i + 2] & 0xFF) << 8 |
				(bytes[i + 3] & 0xFF) << 0;
		}
	}
	
	public void set(int flag) {
		ints[flag / 32] |= 1 << flag % 32;
	}
	
	// little endian int order
	public void clear(int flag) {
		ints[flag / 32] &= ~(1 << flag % 32);
	}
	
	public int[] getInts() {
		return ints;
	}
	
	public byte[] getBytes() {
		byte[] bytes = new byte[ints.length * 4];
		for (int i = 0; i < ints.length; i++) {
			bytes[i + 0] = (byte) (ints[i] >> 24);
			bytes[i + 1] = (byte) (ints[i] >> 16);
			bytes[i + 2] = (byte) (ints[i] >> 8);
			bytes[i + 3] = (byte) (ints[i] >> 0);
		}
		return bytes;
	}
}