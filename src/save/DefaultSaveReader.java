package save;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.IOException;

import flag.FlagSet;

public class DefaultSaveReader implements SaveReader {
	@Override
	public void readSave(InputStream in) throws IOException {
		DataInputStream din = new DataInputStream(in);
		
		// magic
		byte[] magic = new byte[4];
		din.read(magic);
		if (magic[0] != 'S' || magic[1] != 'A' || magic[2] != 'V' || magic[3] != 'E') {
			System.out.println("DEFAULT SAVE READER READ WRONG MAGIC: " +
				(char) magic[0] + (char) magic[1] + (char) magic[2] + (char) magic[3]);
		}
		
		// version
		int verMaj = din.read();
		int verMin = din.read();
		
		// name
		String name = din.readUTF();
		
		// last entrance
		int lastEntrance = din.readInt();// 4 bytes
		
		// story flags
		byte[] storyFlagSetBytes = new byte[FlagSet.NUM_FLAGS / 8];
		din.read(storyFlagSetBytes);
		FlagSet storyFlagSet = new FlagSet(storyFlagSetBytes);
		
		// scene flags
		FlagSet[] sceneFlagSets = new FlagSet[Save.NUM_SCENES];
		for (int i = 0; i < Save.NUM_SCENES; i++) {
			byte[] sceneFlagSetBytes = new byte[FlagSet.NUM_FLAGS / 8];
			din.read(sceneFlagSetBytes);
			sceneFlagSets[i] = new FlagSet(sceneFlagSetBytes);
		}
		
		//return new Save(name, lastEntrance, storyFlagSet, sceneFlagSets);
	}
}