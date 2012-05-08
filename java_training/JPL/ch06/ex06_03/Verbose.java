package ch06.ex06_03;

public interface Verbose {

	enum Verbosity{
		SILENT, TERSE, NORMAL, VERBOSE,
	}

	void setVerbosity(Verbosity level);
	int getVerbosity();
}
