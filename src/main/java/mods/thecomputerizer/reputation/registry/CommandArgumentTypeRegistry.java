package mods.thecomputerizer.reputation.registry;

import mods.thecomputerizer.reputation.Constants;
import mods.thecomputerizer.reputation.common.command.ReputationFactionArgument;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.commands.synchronization.SingletonArgumentInfo;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CommandArgumentTypeRegistry {

    public static final DeferredRegister<ArgumentTypeInfo<?, ?>> TYPE_REGISTRY = DeferredRegister.create(ForgeRegistries.COMMAND_ARGUMENT_TYPES, Constants.MODID);
    
    public static final RegistryObject<ArgumentTypeInfo<?, ?>> REPUTATION = TYPE_REGISTRY.register("faction_argument", () -> SingletonArgumentInfo.contextFree(ReputationFactionArgument::id));
    
    public static void register(IEventBus bus) {
    	TYPE_REGISTRY.register(bus);
    }
}
