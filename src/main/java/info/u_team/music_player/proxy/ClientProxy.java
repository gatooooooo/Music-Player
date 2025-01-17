package info.u_team.music_player.proxy;

import info.u_team.music_player.config.ClientConfig;
import info.u_team.music_player.dependency.DependencyManager;
import info.u_team.music_player.event.EventHandlerMusicPlayer;
import info.u_team.music_player.init.*;
import info.u_team.music_player.musicplayer.MusicPlayerManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.relauncher.*;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@Override
	public void preinit(FMLPreInitializationEvent event) {
		super.preinit(event);
		System.setProperty("http.agent", "Chrome");
		ClientConfig.setupConfig(event.getModConfigurationDirectory());
		DependencyManager.load();
		MusicPlayerKeys.construct();
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		MusicPlayerFiles.setup();
		MusicPlayerManager.setup();
		MinecraftForge.EVENT_BUS.register(new EventHandlerMusicPlayer(MusicPlayerManager.getSettingsManager().getSettings()));
	}
	
	@Override
	public void postinit(FMLPostInitializationEvent event) {
		super.postinit(event);
	}
}
