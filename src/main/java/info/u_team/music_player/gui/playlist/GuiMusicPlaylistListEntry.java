package info.u_team.music_player.gui.playlist;

import info.u_team.music_player.gui.util.GuiTrackUtils;
import info.u_team.music_player.lavaplayer.api.IAudioTrack;
import info.u_team.to_export_to_u_team_core.gui.GuiScrollableListEntry;

abstract class GuiMusicPlaylistListEntry extends GuiScrollableListEntry<GuiMusicPlaylistListEntry> {
	
	protected void addTrackInfo(IAudioTrack track, int entryWidth, int leftMargin, int titleColor) {
		GuiTrackUtils.addTrackInfo(track, getX(), getY(), entryWidth, leftMargin, titleColor);
	}
}
