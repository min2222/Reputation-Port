package mods.thecomputerizer.reputation;

import java.util.Collection;

import mods.thecomputerizer.reputation.capability.FactionListener;
import mods.thecomputerizer.reputation.capability.placedcontainer.IPlacedContainer;
import mods.thecomputerizer.reputation.capability.playerfaction.IPlayerFaction;
import mods.thecomputerizer.reputation.capability.reputation.IReputation;
import mods.thecomputerizer.reputation.config.ClientConfigHandler;
import mods.thecomputerizer.reputation.registry.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = Constants.MODID)
public class Reputation {

	public Reputation() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::registerCapabilities);
		MinecraftForge.EVENT_BUS.addListener(this::reloadData);
		RegistryHandler.initRegistries(bus);
		RegistryHandler.queuePackets();
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT,
				ClientConfigHandler.CONFIG,"reputation/client.toml");
	}

	public void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.register(IReputation.class);
		event.register(IPlacedContainer.class);
		event.register(IPlayerFaction.class);
	}

	@SubscribeEvent
	public void reloadData(AddReloadListenerEvent event) {
		event.addListener(new FactionListener());
	}

	public static void logInfo(String message, Object... vars) {
		Constants.LOGGER.info(message, vars);
	}

	public static void logError(String message, Object... vars) {
		Constants.LOGGER.error(message,vars);
	}

	public static void logStringCollection(String initialMessage, Collection<String> collection, int numPerLine) {
		StringBuilder builder = new StringBuilder();
		builder.append(initialMessage).append(": ");
		int i = 0;
		for(String element : collection) {
			builder.append("[").append(i).append("] ").append(element);
			if(i<collection.size()-1) {
				if((i+1)%numPerLine==0) builder.append("\n");
				else builder.append(" ");
				i++;
			}
		} Constants.LOGGER.info(builder.toString());
	}
}
