package mods.thecomputerizer.reputation.registry;

import javax.annotation.Nonnull;

import mods.thecomputerizer.reputation.Constants;
import mods.thecomputerizer.reputation.common.ai.ReputationMemoryModule;
import mods.thecomputerizer.reputation.common.ai.ReputationSenorType;
import mods.thecomputerizer.reputation.network.PacketChatIcon;
import mods.thecomputerizer.reputation.network.PacketFleeIcon;
import mods.thecomputerizer.reputation.network.PacketSetIcon;
import mods.thecomputerizer.reputation.network.PacketSyncChatIcons;
import mods.thecomputerizer.reputation.network.PacketSyncFactionPlayers;
import mods.thecomputerizer.reputation.network.PacketSyncFactions;
import mods.thecomputerizer.reputation.network.PacketSyncReputation;
import mods.thecomputerizer.theimpossiblelibrary.network.NetworkHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;

public class RegistryHandler {

    public static final CreativeModeTab REPUTATION_TAB = new CreativeModeTab(Constants.MODID) {
        @OnlyIn(Dist.CLIENT)
        public @Nonnull ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.FACTION_BAG.get());
        }
    };

    public static void initRegistries(IEventBus bus) {
        BlockRegistry.register(bus);
        ItemRegistry.register(bus);
        RecipeRegistry.register(bus);
        BlockEntitiesRegistry.register(bus);
        SoundRegistry.register(bus);
        ReputationMemoryModule.MEMORY_MODULES.register(bus);
        ReputationSenorType.SENSOR_TYPES.register(bus);
    }

    public static void queuePackets() {
        NetworkHandler.queuePacketRegisterToClient(PacketChatIcon.class,PacketChatIcon::new);
        NetworkHandler.queuePacketRegisterToClient(PacketFleeIcon.class,PacketFleeIcon::new);
        NetworkHandler.queuePacketRegisterToClient(PacketSetIcon.class,PacketSetIcon::new);
        NetworkHandler.queuePacketRegisterToClient(PacketSyncChatIcons.class,PacketSyncChatIcons::new);
        NetworkHandler.queuePacketRegisterToClient(PacketSyncFactionPlayers.class,PacketSyncFactionPlayers::new);
        NetworkHandler.queuePacketRegisterToClient(PacketSyncFactions.class,PacketSyncFactions::new);
        NetworkHandler.queuePacketRegisterToClient(PacketSyncReputation.class,PacketSyncReputation::new);
    }
}
