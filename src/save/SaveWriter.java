package save;

import java.io.OutputStream;
import java.io.IOException;

public interface SaveWriter {
	public void writeSave(Save save, OutputStream out) throws IOException;
}