package defeatedcrow.hac.main.item.ores;

import defeatedcrow.hac.api.magic.MagicColor;
import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.core.util.DCUtil;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemGemBlack extends GemItem {

	protected final int maxMeta;

	private static String[] names = { "crude_oil", "schorl", "opal", "iolite", "alexandrite", "clam" };

	public ItemGemBlack(int max) {
		super(names.length);
		maxMeta = max;
	}

	@Override
	public int getMaxMeta() {
		return maxMeta;
	}

	@Override
	public String[] getNameSuffix() {
		return names;
	}

	@Override
	public String getTexPath(int meta, boolean f) {
		String s = "items/ores/gem_" + getNameSuffix()[meta];
		if (f) {
			s = "textures/" + s;
		}
		return ClimateCore.PACKAGE_ID + ":" + s;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		if (!DCUtil.isEmpty(stack)) {
			switch (stack.getItemDamage()) {
			case 0:
				return EnumRarity.COMMON;
			case 1:
				return EnumRarity.UNCOMMON;
			case 2:
				return EnumRarity.RARE;
			case 3:
				return EnumRarity.UNCOMMON;
			case 4:
				return EnumRarity.RARE;
			case 5:
				return EnumRarity.RARE;
			}
		}
		return EnumRarity.COMMON;
	}

	@Override
	public MagicColor getColor(ItemStack stack) {
		return MagicColor.BLACK;
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		int i = stack.getMetadata();
		if (i == 0)
			return 1600;
		else
			return 0;
	}
}
