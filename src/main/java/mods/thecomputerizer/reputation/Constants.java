package mods.thecomputerizer.reputation;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

public class Constants {

	public static final String MODID = "reputation";
	public static final String NAME = "Reputation";
	public static final Logger LOGGER = LogManager.getLogger(NAME);
	private static final Random RANDOM = new Random();
	private static final RandomSource RANDOM_SOURCE = RandomSource.create();

	public static float floatRand() {
		return RANDOM.nextFloat();
	}
	public static float floatRand(float bound) {
		return RANDOM.nextFloat(bound);
	}
	public static float floatRand(float min, float max) {
		return Mth.randomBetween(RANDOM_SOURCE,min,max);
	}
	public static int intRand(int bound) {
		return RANDOM.nextInt(bound);
	}

	public static ResourceLocation res(String name) {
		return new ResourceLocation(MODID, name.toLowerCase());
	}
}
