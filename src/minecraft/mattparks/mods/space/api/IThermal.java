package mattparks.mods.space.api;

public interface IThermal 
{
	/**
	* Positive numbers = hot planets, Negative numbers = cold planets. Zero means you do now require any thermal armor.
	*/
	public int getThermalLevelModifier();
}
