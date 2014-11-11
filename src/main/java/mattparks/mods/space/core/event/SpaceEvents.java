package mattparks.mods.space.core.event;

import mattparks.mods.space.europa.blocks.EuropaBlocks;
import mattparks.mods.space.europa.dimension.WorldProviderEuropa;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SpaceEvents
{
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		final World world = event.world;
		final MovingObjectPosition pos = event.target;
		final Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
		final int meta = world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ);

		if (block == EuropaBlocks.europaWaterFluidBlock && meta == 0)
		{
			final ItemStack filledContainer = FluidContainerRegistry.fillFluidContainer(new FluidStack(EuropaBlocks.europaWaterFluid, FluidContainerRegistry.BUCKET_VOLUME), event.current);

			if (filledContainer != null)
			{
				world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
				event.result = filledContainer;
				event.setResult(Result.ALLOW);
			}
			else
			{
				event.setResult(Result.DENY);
			}
		}
	}
	
	/*@SubscribeEvent
	public void protectedGasArmorEvent(LivingUpdateEvent event)
	{
		final EntityLivingBase entity = event.entityLiving;

		if (entity.worldObj.provider instanceof WorldProviderEuropa)
		{
			if (entity instanceof EntityPlayer)
			{
				final EntityPlayer player = (EntityPlayer)entity;
				final InventoryPlayer inventory = player.inventory;

				if (entity.ticksExisted % 25 == 0)
				{
					if (!(inventory.armorInventory[3] != null && inventory.armorInventory[3].getItem() == PolongniusArmorItems.purpleCrystalHelmet))
					{
						if (!player.capabilities.isCreativeMode)
						{
							if (entity.ticksExisted % 2000 == 0 && !player.capabilities.isCreativeMode)
							{
								player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + StatCollector.translateToLocal("message.warning.infected.gas")));
							}
							entity.addPotionEffect(new PotionEffect(MPPotions.infectedGas.id, 60));
						}
					}
				}
				if (inventory.armorInventory[3] != null && inventory.armorInventory[3].getItem() == PolongniusArmorItems.purpleCrystalHelmet)
				{
					entity.removePotionEffect(MPPotions.infectedGas.id);
					return;
				}
			}
		}
	}*/
}