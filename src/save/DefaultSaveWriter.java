package save;

import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import flag.FlagSet;

public class DefaultSaveWriter implements SaveWriter {
	@Override
	public void writeSave(Save save, OutputStream out) throws IOException {
		DataOutputStream dout = new DataOutputStream(out);
		
		// magic
		dout.write('S');
		dout.write('A');
		dout.write('V');
		dout.write('E');
		
		// version
		dout.write(0);// maj
		dout.write(0);// min
		
		// name
		dout.writeUTF(save.getName());
		
		// last entrance used
		dout.writeInt(save.getLastEntrance());// 4 bytes
		
		// story flags
		dout.write(save.getStoryFlagSet().getBytes());
		
		// scene flags
		FlagSet[] sceneFlagSets = save.getSceneFlagSets();
		for (FlagSet fs : sceneFlagSets) {
			dout.write(fs.getBytes());
		}
	}
}