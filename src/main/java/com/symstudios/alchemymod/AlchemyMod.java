package com.symstudios.alchemymod;

import com.symstudios.alchemymod.api.AlchemyAPI;
import com.symstudios.alchemymod.circle.FireCircle1;
import com.symstudios.alchemymod.proxy.ClientProxy;
import com.symstudios.alchemymod.proxy.ServerProxy;
import com.symstudios.alchemymod.tileentity.TileEntityAlchemyCircle;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("alchemymod")
@EventBusSubscriber
public class AlchemyMod {
	
	//public static AlchemyMod instance;
	public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	public static TileEntityType<TileEntityAlchemyCircle> tileEntityDataType;
	
    public AlchemyMod() {    
    	//instance = this;
    	
    	// Events
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupCommon);
		//modEventBus.addListener(this::armorRegeneration);
		
    	// Initializes our different contents
        AlchemyItems.ITEMS.register(modEventBus);
        AlchemyBlocks.BLOCKS.register(modEventBus);
        //AlchemyEntities.ENTITY_TYPES.register(modEventBus);
        
        /*// Registers setup methods
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
			modEventBus.addListener(this::registerItemColors);
		});*/
    }
    
    @SubscribeEvent
    public static void onTileEntityTypeRegistration(final RegistryEvent.Register<TileEntityType<?>> event) {
    	tileEntityDataType = TileEntityType.Builder.create(TileEntityAlchemyCircle::new, AlchemyBlocks.CHALK_BLOCK.get()).build(null);
    	tileEntityDataType.setRegistryName("alchemymod:chalk_tileentity");
    	event.getRegistry().register(tileEntityDataType);
    }
    
    /**
     * Common mod setup
     * @param event
     */
    private void setupCommon(final FMLCommonSetupEvent event) {
    	proxy.preInit();
    	AlchemyAPI.registerCircle(new FireCircle1());
    	//DO ENTITY SPAWNS LATER
    	//AlchemyEntitySpawns.addSpawnsToBiomes();
    }
    
    // DO SPAWN EGGS LATER
    /*@OnlyIn(Dist.CLIENT)
	private void registerItemColors(ColorHandlerEvent.Item event) {
		for(RegistryObject<Item> items : GoatItems.SPAWN_EGGS) {
			Item item = items.get();
			if(item instanceof GoatSpawnEggItem) {
				event.getItemColors().register((itemColor, itemsIn) -> {
					return ((GoatSpawnEggItem) item).getColor(itemsIn);
				}, item);
			}
		}
	}*/
    
    @SubscribeEvent
    public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().register(TileEntityType.Builder.create(TileEntityAlchemyCircle::new, AlchemyBlocks.CHALK_BLOCK.get()).build(null).setRegistryName("chalk_block"));
    }
    
}