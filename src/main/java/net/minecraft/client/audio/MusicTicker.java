package net.minecraft.client.audio;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MusicTicker implements IUpdatePlayerListBox
{
	public final Random field_147679_a = new Random();
	public final Minecraft field_147677_b;
	public ISound field_147678_c;
	public int field_147676_d = 100;

	public MusicTicker(Minecraft paramMinecraft)
	{
		this.field_147677_b = paramMinecraft;
	}

	public void update()
	{
		MusicTicker.MusicType localMusicType = this.field_147677_b.func_147109_W();
		if (this.field_147678_c != null)
		{
			if (!localMusicType.getMusicTickerLocation().equals(this.field_147678_c.getPositionedSoundLocation()))
			{
				this.field_147677_b.getSoundHandler().stopSound(this.field_147678_c);
				this.field_147676_d = MathHelper.getRandomIntegerInRange(this.field_147679_a, 0, localMusicType.func_148634_b() / 2);
			}
			if (!this.field_147677_b.getSoundHandler().isSoundPlaying(this.field_147678_c))
			{
				this.field_147678_c = null;
				this.field_147676_d = Math.min(MathHelper.getRandomIntegerInRange(this.field_147679_a, localMusicType.func_148634_b(), localMusicType.func_148633_c()), this.field_147676_d);
			}
		}
		if ((this.field_147678_c == null) && (this.field_147676_d-- <= 0))
		{
			this.field_147678_c = PositionedSoundRecord.func_147673_a(localMusicType.getMusicTickerLocation());
			this.field_147677_b.getSoundHandler().playSound(this.field_147678_c);
			this.field_147676_d = 2147483647;
		}
	}

	@SideOnly(Side.CLIENT)
	public enum MusicType
	{
		MENU(new ResourceLocation("minecraft:music.menu"), 20, 600),  GAME(new ResourceLocation("minecraft:music.game"), 12000, 24000),  CREATIVE(new ResourceLocation("minecraft:music.game.creative"), 1200, 3600),  CREDITS(new ResourceLocation("minecraft:music.game.end.credits"), 2147483647, 2147483647),  NETHER(new ResourceLocation("minecraft:music.game.nether"), 1200, 3600),  END_BOSS(new ResourceLocation("minecraft:music.game.end.dragon"), 0, 0),  END(new ResourceLocation("minecraft:music.game.end"), 6000, 24000);

		private final ResourceLocation field_148645_h;
		private final int field_148646_i;
		private final int field_148643_j;

		private MusicType(ResourceLocation paramResourceLocation, int paramInt1, int paramInt2)
		{
			this.field_148645_h = paramResourceLocation;
			this.field_148646_i = paramInt1;
			this.field_148643_j = paramInt2;
		}

		public ResourceLocation getMusicTickerLocation()
		{
			return this.field_148645_h;
		}

		public int func_148634_b()
		{
			return this.field_148646_i;
		}

		public int func_148633_c()
		{
			return this.field_148643_j;
		}
	}
}
