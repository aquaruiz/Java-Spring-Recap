package bridge;

public interface Device {
	boolean isEnabled();
	void enable();
	void disable();
	int getVolume();
	void setVolume(int present);
	int getChannel();
	void setChannel(int channel);
}
