package save;

import java.io.InputStream;
import java.io.IOException;

public interface SaveReader {
	public void readSave(InputStream in) throws IOException;
}