package net.minecraft.client.renderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.PriorityQueue;

import net.minecraft.client.shader.TesselatorVertexState;
import net.minecraft.client.util.QuadComparator;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Tessellator
{
	private static int nativeBufferSize = 2097152;
	private static int trivertsInBuffer = nativeBufferSize / 48 * 6;
	public static boolean renderingWorldRenderer = false;
	public boolean defaultTexture = false;
	private int rawBufferSize = 0;
	public int textureID = 0;
	private static ByteBuffer byteBuffer = GLAllocation.createDirectByteBuffer(nativeBufferSize * 4);
	private static IntBuffer intBuffer = byteBuffer.asIntBuffer();
	private static FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
	private static ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
	private int[] rawBuffer;
	private int vertexCount;
	private double textureU;
	private double textureV;
	private int brightness;
	private int color;
	private boolean hasColor;
	private boolean hasTexture;
	private boolean hasBrightness;
	private boolean hasNormals;
	private int rawBufferIndex;
	private int addedVertices;
	private boolean isColorDisabled;
	private int drawMode;
	private double xOffset;
	private double yOffset;
	private double zOffset;
	private int normal;
	public static final Tessellator instance = new Tessellator(2097152);
	public boolean isDrawing;
	private int bufferSize;

	static
	{
		instance.defaultTexture = true;
	}

	public int draw()
	{
		if (!this.isDrawing) {
			throw new IllegalStateException("Not tesselating!");
		}
		this.isDrawing = false;

		int offs = 0;
		while (offs < this.vertexCount)
		{
			int vtc = Math.min(this.vertexCount - offs, nativeBufferSize >> 5);
			intBuffer.clear();
			intBuffer.put(this.rawBuffer, offs * 8, vtc * 8);
			byteBuffer.position(0);
			byteBuffer.limit(vtc * 32);
			offs += vtc;
			if (this.hasTexture)
			{
				floatBuffer.position(3);
				GL11.glTexCoordPointer(2, 32, floatBuffer);
				GL11.glEnableClientState(32888);
			}
			if (this.hasBrightness)
			{
				OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
				shortBuffer.position(14);
				GL11.glTexCoordPointer(2, 32, shortBuffer);
				GL11.glEnableClientState(32888);
				OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
			}
			if (this.hasColor)
			{
				byteBuffer.position(20);
				GL11.glColorPointer(4, true, 32, byteBuffer);
				GL11.glEnableClientState(32886);
			}
			if (this.hasNormals)
			{
				byteBuffer.position(24);
				GL11.glNormalPointer(32, byteBuffer);
				GL11.glEnableClientState(32885);
			}
			floatBuffer.position(0);
			GL11.glVertexPointer(3, 32, floatBuffer);
			GL11.glEnableClientState(32884);
			GL11.glDrawArrays(this.drawMode, 0, vtc);
			GL11.glDisableClientState(32884);
			if (this.hasTexture) {
				GL11.glDisableClientState(32888);
			}
			if (this.hasBrightness)
			{
				OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
				GL11.glDisableClientState(32888);
				OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
			}
			if (this.hasColor) {
				GL11.glDisableClientState(32886);
			}
			if (this.hasNormals) {
				GL11.glDisableClientState(32885);
			}
		}
		if ((this.rawBufferSize > 131072) && (this.rawBufferIndex < this.rawBufferSize << 3))
		{
			this.rawBufferSize = 65536;
			this.rawBuffer = new int[this.rawBufferSize];
		}
		int i = this.rawBufferIndex * 4;
		reset();
		return i;
	}

	public TesselatorVertexState getVertexState(float p_147564_1_, float p_147564_2_, float p_147564_3_)
	{
		;
		;
		;
		;
		int[] aint = new int[this.rawBufferIndex];
		PriorityQueue priorityqueue = new PriorityQueue(this.rawBufferIndex, new QuadComparator(this.rawBuffer, p_147564_1_ + (float)this.xOffset, p_147564_2_ + (float)this.yOffset, p_147564_3_ + (float)this.zOffset));
		byte b0 = 32;
		for (int i = 0; i < this.rawBufferIndex; i += b0) {
			priorityqueue.add(Integer.valueOf(i));
		}
		for (int i = 0; !priorityqueue.isEmpty(); i += b0)
		{
			int j = ((Integer)priorityqueue.remove()).intValue();
			for (int k = 0; k < b0; k++) {
				aint[(i + k)] = this.rawBuffer[(j + k)];
			}
		}
		System.arraycopy(aint, 0, this.rawBuffer, 0, aint.length);
		return new TesselatorVertexState(aint, this.rawBufferIndex, this.vertexCount, this.hasTexture, this.hasBrightness, this.hasNormals, this.hasColor);
	}

	public void setVertexState(TesselatorVertexState p_147565_1_)
	{
		;
		;
		while ((p_147565_1_.getRawBuffer().length > this.rawBufferSize) && (this.rawBufferSize > 0)) {
			this.rawBufferSize <<= 1;
		}
		if (this.rawBufferSize > this.rawBuffer.length) {
			this.rawBuffer = new int[this.rawBufferSize];
		}
		System.arraycopy(p_147565_1_.getRawBuffer(), 0, this.rawBuffer, 0, p_147565_1_.getRawBuffer().length);
		this.rawBufferIndex = p_147565_1_.getRawBufferIndex();
		this.vertexCount = p_147565_1_.getVertexCount();
		this.hasTexture = p_147565_1_.getHasTexture();
		this.hasBrightness = p_147565_1_.getHasBrightness();
		this.hasColor = p_147565_1_.getHasColor();
		this.hasNormals = p_147565_1_.getHasNormals();
	}

	private void reset()
	{
		this.vertexCount = 0;
		byteBuffer.clear();
		this.rawBufferIndex = 0;
		this.addedVertices = 0;
	}

	public void startDrawingQuads()
	{
		startDrawing(7);
	}

	public void startDrawing(int p_78371_1_)
	{
		;
		;
		if (this.isDrawing) {
			throw new IllegalStateException("Already tesselating!");
		}
		this.isDrawing = true;
		reset();
		this.drawMode = p_78371_1_;
		this.hasNormals = false;
		this.hasColor = false;
		this.hasTexture = false;
		this.hasBrightness = false;
		this.isColorDisabled = false;
	}

	public void setTextureUV(double p_78385_1_, double p_78385_3_)
	{
		;
		;
		;
		this.hasTexture = true;
		this.textureU = p_78385_1_;
		this.textureV = p_78385_3_;
	}

	public void setBrightness(int p_78380_1_)
	{
		;
		;
		this.hasBrightness = true;
		this.brightness = p_78380_1_;
	}

	public void setColorOpaque_F(float p_78386_1_, float p_78386_2_, float p_78386_3_)
	{
		;
		;
		;
		;
		setColorOpaque((int)(p_78386_1_ * 255.0F), (int)(p_78386_2_ * 255.0F), (int)(p_78386_3_ * 255.0F));
	}

	public void setColorRGBA_F(float p_78369_1_, float p_78369_2_, float p_78369_3_, float p_78369_4_)
	{
		;
		;
		;
		;
		;
		setColorRGBA((int)(p_78369_1_ * 255.0F), (int)(p_78369_2_ * 255.0F), (int)(p_78369_3_ * 255.0F), (int)(p_78369_4_ * 255.0F));
	}

	public void setColorOpaque(int p_78376_1_, int p_78376_2_, int p_78376_3_)
	{
		;
		;
		;
		;
		setColorRGBA(p_78376_1_, p_78376_2_, p_78376_3_, 255);
	}

	public void setColorRGBA(int p_78370_1_, int p_78370_2_, int p_78370_3_, int p_78370_4_)
	{
		;
		;
		;
		;
		;
		if (!this.isColorDisabled)
		{
			if (p_78370_1_ > 255) {
				p_78370_1_ = 255;
			}
			if (p_78370_2_ > 255) {
				p_78370_2_ = 255;
			}
			if (p_78370_3_ > 255) {
				p_78370_3_ = 255;
			}
			if (p_78370_4_ > 255) {
				p_78370_4_ = 255;
			}
			if (p_78370_1_ < 0) {
				p_78370_1_ = 0;
			}
			if (p_78370_2_ < 0) {
				p_78370_2_ = 0;
			}
			if (p_78370_3_ < 0) {
				p_78370_3_ = 0;
			}
			if (p_78370_4_ < 0) {
				p_78370_4_ = 0;
			}
			this.hasColor = true;
			if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
				this.color = (p_78370_4_ << 24 | p_78370_3_ << 16 | p_78370_2_ << 8 | p_78370_1_);
			} else {
				this.color = (p_78370_1_ << 24 | p_78370_2_ << 16 | p_78370_3_ << 8 | p_78370_4_);
			}
		}
	}

	public void func_154352_a(byte p_154352_1_, byte p_154352_2_, byte p_154352_3_)
	{
		;
		;
		;
		;
		setColorOpaque(p_154352_1_ & 0xFF, p_154352_2_ & 0xFF, p_154352_3_ & 0xFF);
	}

	public void addVertexWithUV(double p_78374_1_, double p_78374_3_, double p_78374_5_, double p_78374_7_, double p_78374_9_)
	{
		;
		;
		;
		;
		;
		;
		setTextureUV(p_78374_7_, p_78374_9_);
		addVertex(p_78374_1_, p_78374_3_, p_78374_5_);
	}

	public void addVertex(double p_78377_1_, double p_78377_3_, double p_78377_5_)
	{
		;
		;
		;
		;
		if (this.rawBufferIndex >= this.rawBufferSize - 32) {
			if (this.rawBufferSize == 0)
			{
				this.rawBufferSize = 65536;
				this.rawBuffer = new int[this.rawBufferSize];
			}
			else
			{
				this.rawBufferSize *= 2;
				this.rawBuffer = Arrays.copyOf(this.rawBuffer, this.rawBufferSize);
			}
		}
		this.addedVertices += 1;
		if (this.hasTexture)
		{
			this.rawBuffer[(this.rawBufferIndex + 3)] = Float.floatToRawIntBits((float)this.textureU);
			this.rawBuffer[(this.rawBufferIndex + 4)] = Float.floatToRawIntBits((float)this.textureV);
		}
		if (this.hasBrightness) {
			this.rawBuffer[(this.rawBufferIndex + 7)] = this.brightness;
		}
		if (this.hasColor) {
			this.rawBuffer[(this.rawBufferIndex + 5)] = this.color;
		}
		if (this.hasNormals) {
			this.rawBuffer[(this.rawBufferIndex + 6)] = this.normal;
		}
		this.rawBuffer[(this.rawBufferIndex + 0)] = Float.floatToRawIntBits((float)(p_78377_1_ + this.xOffset));
		this.rawBuffer[(this.rawBufferIndex + 1)] = Float.floatToRawIntBits((float)(p_78377_3_ + this.yOffset));
		this.rawBuffer[(this.rawBufferIndex + 2)] = Float.floatToRawIntBits((float)(p_78377_5_ + this.zOffset));
		this.rawBufferIndex += 8;
		this.vertexCount += 1;
	}

	public void setColorOpaque_I(int p_78378_1_)
	{
		;
		;
		int j = p_78378_1_ >> 16 & 0xFF;
				int k = p_78378_1_ >> 8 & 0xFF;
				int l = p_78378_1_ & 0xFF;
				setColorOpaque(j, k, l);
	}

	public void setColorRGBA_I(int p_78384_1_, int p_78384_2_)
	{
		;
		;
		;
		int k = p_78384_1_ >> 16 & 0xFF;
				int l = p_78384_1_ >> 8 & 0xFF;
				int i1 = p_78384_1_ & 0xFF;
				setColorRGBA(k, l, i1, p_78384_2_);
	}

	public void disableColor()
	{
		this.isColorDisabled = true;
	}

	public void setNormal(float p_78375_1_, float p_78375_2_, float p_78375_3_)
	{
		;
		;
		;
		;
		this.hasNormals = true;
		byte b0 = (byte)(int)(p_78375_1_ * 127.0F);
		byte b1 = (byte)(int)(p_78375_2_ * 127.0F);
		byte b2 = (byte)(int)(p_78375_3_ * 127.0F);
		this.normal = (b0 & 0xFF | (b1 & 0xFF) << 8 | (b2 & 0xFF) << 16);
	}

	public void setTranslation(double p_78373_1_, double p_78373_3_, double p_78373_5_)
	{
		;
		;
		;
		;
		this.xOffset = p_78373_1_;
		this.yOffset = p_78373_3_;
		this.zOffset = p_78373_5_;
	}

	public void addTranslation(float p_78372_1_, float p_78372_2_, float p_78372_3_)
	{
		;
		;
		;
		;
		this.xOffset += p_78372_1_;
		this.yOffset += p_78372_2_;
		this.zOffset += p_78372_3_;
	}

	private Tessellator(int p_i1250_1_) {}

	public Tessellator() {}
}
