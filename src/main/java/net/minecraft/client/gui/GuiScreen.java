package net.minecraft.client.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiScreen extends Gui
{
	protected static RenderItem itemRender = new RenderItem();
	public Minecraft mc;
	public int width;
	public int height;
	public List buttonList = new ArrayList();
	protected List labelList = new ArrayList();
	public boolean allowUserInput;
	protected FontRenderer fontRendererObj;
	private GuiButton selectedButton;
	private int eventButton;
	private long lastMouseEvent;
	private int field_146298_h;
	private static final String __OBFID = "CL_00000710";

	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
	{
		for (int k = 0; k < this.buttonList.size(); k++) {
			((GuiButton)this.buttonList.get(k)).drawButton(this.mc, p_73863_1_, p_73863_2_);
		}
		for (int k = 0; k < this.labelList.size(); k++) {
			((GuiLabel)this.labelList.get(k)).func_146159_a(this.mc, p_73863_1_, p_73863_2_);
		}
	}

	protected void keyTyped(char p_73869_1_, int p_73869_2_)
	{
		if (p_73869_2_ == 1)
		{
			this.mc.displayGuiScreen((GuiScreen)null);
			this.mc.setIngameFocus();
		}
	}

	public static String getClipboardString()
	{
		try
		{
			Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);
			if ((transferable != null) && (transferable.isDataFlavorSupported(DataFlavor.stringFlavor))) {
				return (String)transferable.getTransferData(DataFlavor.stringFlavor);
			}
		}
		catch (Exception exception) {}
		return "";
	}

	public static void setClipboardString(String p_146275_0_)
	{
		try
		{
			StringSelection stringselection = new StringSelection(p_146275_0_);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, (ClipboardOwner)null);
		}
		catch (Exception exception) {}
	}

	protected void renderToolTip(ItemStack p_146285_1_, int p_146285_2_, int p_146285_3_)
	{
		List list = p_146285_1_.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);
		for (int k = 0; k < list.size(); k++) {
			if (k == 0) {
				list.set(k, p_146285_1_.getRarity().rarityColor + (String)list.get(k));
			} else {
				list.set(k, EnumChatFormatting.GRAY + (String)list.get(k));
			}
		}
		FontRenderer font = p_146285_1_.getItem().getFontRenderer(p_146285_1_);
		drawHoveringText(list, p_146285_2_, p_146285_3_, font == null ? this.fontRendererObj : font);
	}

	protected void drawCreativeTabHoveringText(String p_146279_1_, int p_146279_2_, int p_146279_3_)
	{
		func_146283_a(Arrays.asList(new String[] { p_146279_1_ }), p_146279_2_, p_146279_3_);
	}

	protected void func_146283_a(List p_146283_1_, int p_146283_2_, int p_146283_3_)
	{
		drawHoveringText(p_146283_1_, p_146283_2_, p_146283_3_, this.fontRendererObj);
	}

	protected void drawHoveringText(List p_146283_1_, int p_146283_2_, int p_146283_3_, FontRenderer font)
	{
		if (!p_146283_1_.isEmpty())
		{
			GL11.glDisable(32826);
			RenderHelper.disableStandardItemLighting();
			GL11.glDisable(2896);
			GL11.glDisable(2929);
			int k = 0;
			Iterator iterator = p_146283_1_.iterator();
			while (iterator.hasNext())
			{
				String s = (String)iterator.next();
				int l = font.getStringWidth(s);
				if (l > k) {
					k = l;
				}
			}
			int j2 = p_146283_2_ + 12;
			int k2 = p_146283_3_ - 12;
			int i1 = 8;
			if (p_146283_1_.size() > 1) {
				i1 += 2 + (p_146283_1_.size() - 1) * 10;
			}
			if (j2 + k > this.width) {
				j2 -= 28 + k;
			}
			if (k2 + i1 + 6 > this.height) {
				k2 = this.height - i1 - 6;
			}
			this.zLevel = 300.0F;
			itemRender.zLevel = 300.0F;
			int j1 = -267386864;
			drawGradientRect(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1);
			drawGradientRect(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1);
			drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1);
			drawGradientRect(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1);
			drawGradientRect(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1);
			int k1 = 1347420415;
			int l1 = (k1 & 0xFEFEFE) >> 1 | k1 & 0xFF000000;
			drawGradientRect(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1);
			drawGradientRect(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1);
			drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1);
			drawGradientRect(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1);
			for (int i2 = 0; i2 < p_146283_1_.size(); i2++)
			{
				String s1 = (String)p_146283_1_.get(i2);
				font.drawStringWithShadow(s1, j2, k2, -1);
				if (i2 == 0) {
					k2 += 2;
				}
				k2 += 10;
			}
			this.zLevel = 0.0F;
			itemRender.zLevel = 0.0F;
			GL11.glEnable(2896);
			GL11.glEnable(2929);
			RenderHelper.enableStandardItemLighting();
			GL11.glEnable(32826);
		}
	}

	protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_)
	{
		if (p_73864_3_ == 0) {
			for (int l = 0; l < this.buttonList.size(); l++)
			{
				GuiButton guibutton = (GuiButton)this.buttonList.get(l);
				if (guibutton.mousePressed(this.mc, p_73864_1_, p_73864_2_))
				{
					GuiScreenEvent.ActionPerformedEvent.Pre event = new GuiScreenEvent.ActionPerformedEvent.Pre(this, guibutton, this.buttonList);
					if (MinecraftForge.EVENT_BUS.post(event)) {
						break;
					}
					this.selectedButton = event.button;
					event.button.func_146113_a(this.mc.getSoundHandler());
					actionPerformed(event.button);
					if (equals(this.mc.currentScreen)) {
						MinecraftForge.EVENT_BUS.post(new GuiScreenEvent.ActionPerformedEvent.Post(this, event.button, this.buttonList));
					}
				}
			}
		}
	}

	protected void mouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_)
	{
		if ((this.selectedButton != null) && (p_146286_3_ == 0))
		{
			this.selectedButton.mouseReleased(p_146286_1_, p_146286_2_);
			this.selectedButton = null;
		}
	}

	protected void mouseClickMove(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {}

	protected void actionPerformed(GuiButton p_146284_1_) {}

	public void setWorldAndResolution(Minecraft p_146280_1_, int p_146280_2_, int p_146280_3_)
	{
		this.mc = p_146280_1_;
		this.fontRendererObj = p_146280_1_.fontRenderer;
		this.width = p_146280_2_;
		this.height = p_146280_3_;
		if (!MinecraftForge.EVENT_BUS.post(new GuiScreenEvent.InitGuiEvent.Pre(this, this.buttonList)))
		{
			this.buttonList.clear();
			initGui();
		}
		MinecraftForge.EVENT_BUS.post(new GuiScreenEvent.InitGuiEvent.Post(this, this.buttonList));
	}

	public void initGui() {}

	public void handleInput()
	{
		if (Mouse.isCreated()) {
			while (Mouse.next()) {
				handleMouseInput();
			}
		}
		if (Keyboard.isCreated()) {
			while (Keyboard.next()) {
				handleKeyboardInput();
			}
		}
	}

	public void handleMouseInput()
	{
		int i = Mouse.getEventX() * this.width / this.mc.displayWidth;
		int j = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
		int k = Mouse.getEventButton();
		if (Mouse.getEventButtonState())
		{
			if ((this.mc.gameSettings.touchscreen) && (this.field_146298_h++ > 0)) {
				return;
			}
			this.eventButton = k;
			this.lastMouseEvent = Minecraft.getSystemTime();
			mouseClicked(i, j, this.eventButton);
		}
		else if (k != -1)
		{
			if ((this.mc.gameSettings.touchscreen) && (--this.field_146298_h > 0)) {
				return;
			}
			this.eventButton = -1;
			mouseMovedOrUp(i, j, k);
		}
		else if ((this.eventButton != -1) && (this.lastMouseEvent > 0L))
		{
			long l = Minecraft.getSystemTime() - this.lastMouseEvent;
			mouseClickMove(i, j, this.eventButton, l);
		}
	}

	public void handleKeyboardInput()
	{
		if (Keyboard.getEventKeyState()) {
			keyTyped(Keyboard.getEventCharacter(), Keyboard.getEventKey());
		}
		this.mc.func_152348_aa();
	}

	public void updateScreen() {}

	public void onGuiClosed() {}

	public void drawDefaultBackground()
	{
		drawWorldBackground(0);
	}

	public void drawWorldBackground(int p_146270_1_)
	{
		if (this.mc.theWorld != null) {
			drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
		} else {
			drawBackground(p_146270_1_);
		}
	}

	public void drawBackground(int p_146278_1_)
	{
		GL11.glDisable(2896);
		GL11.glDisable(2912);
		Tessellator tessellator = Tessellator.instance;
		this.mc.getTextureManager().bindTexture(optionsBackground);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		float f = 32.0F;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(4210752);
		tessellator.addVertexWithUV(0.0D, this.height, 0.0D, 0.0D, this.height / f + p_146278_1_);
		tessellator.addVertexWithUV(this.width, this.height, 0.0D, this.width / f, this.height / f + p_146278_1_);
		tessellator.addVertexWithUV(this.width, 0.0D, 0.0D, this.width / f, p_146278_1_);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, p_146278_1_);
		tessellator.draw();
	}

	public boolean doesGuiPauseGame()
	{
		return true;
	}

	public void confirmClicked(boolean p_73878_1_, int p_73878_2_) {}

	public static boolean isCtrlKeyDown()
	{
		return (Keyboard.isKeyDown(219)) || (Keyboard.isKeyDown(220));
	}

	public static boolean isShiftKeyDown()
	{
		return (Keyboard.isKeyDown(42)) || (Keyboard.isKeyDown(54));
	}
}
