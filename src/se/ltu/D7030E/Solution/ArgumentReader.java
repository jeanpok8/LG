/**
 *The ArgumentReader class is in charge of reading arguments and implements
 *the singleton pattern 
 */
public class ArgumentReader {
	
	private String fileName;
	private String sortIndex;
	
	private static ArgumentReader instance = new ArgumentReader();
	private ArgumentReader() {}
        public static ArgumentReader instance() {
		return instance;
	}
    public void argumentReaders(String[] argv) throws Exception {
		if (argv.length == 2) {
			this.fileName = argv[0];
			this.sortIndex = argv[1];
		}
		else {
			throw new Exception();
		}
	}
	public String getFileName() {
		return this.fileName;
	}
	public String getsortIndex() {
		return this.sortIndex;
	}

	}
