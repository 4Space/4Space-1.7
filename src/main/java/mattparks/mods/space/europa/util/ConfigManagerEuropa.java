package mattparks.mods.space.europa.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerEuropa {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerEuropa(File file) {
		if (!ConfigManagerEuropa.loaded) {
			ConfigManagerEuropa.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static boolean idEuropaEnabled;
	public static int idDimensionEuropa;
	public static boolean idDayLength;
	public static int idBiomeEuropa;

	private void setDefaultValues() {
		try {
			ConfigManagerEuropa.configuration.load();

			ConfigManagerEuropa.idEuropaEnabled = ConfigManagerEuropa.configuration.get(Configuration.CATEGORY_GENERAL, "Should Europa, Items and Blocks be registered in the game (Big planet on / off switch.)", true).getBoolean(true);
			ConfigManagerEuropa.idDimensionEuropa = ConfigManagerEuropa.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Dimension", -48).getInt(-48);
			ConfigManagerEuropa.idDayLength = ConfigManagerEuropa.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Day Length Realistic", true).getBoolean(true);
			ConfigManagerEuropa.idBiomeEuropa = ConfigManagerEuropa.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Biome", 218).getInt(218);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space Europa Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerEuropa.configuration.save();
			ConfigManagerEuropa.loaded = true;
		}
	}
}
