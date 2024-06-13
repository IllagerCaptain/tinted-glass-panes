package com.tinted_glass_panes;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class TintedGlassPanes implements ModInitializer {
	public static class TintedGlassPaneBlock extends PaneBlock {
		public TintedGlassPaneBlock(Settings settings) {
			super(settings);
		}

		@Override
		public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
			return 15;
		}
	}

	public static final Block TINTED_GLASS_PANE = new TintedGlassPaneBlock(Block.Settings.create().strength(0.3f).sounds(BlockSoundGroup.GLASS));
	public static final Item TINTED_GLASS_PANE_ITEM = new BlockItem(TINTED_GLASS_PANE, new Item.Settings());

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, new Identifier("tinted_glass_panes", "tinted_glass_pane"), TINTED_GLASS_PANE);
		Registry.register(Registries.ITEM, new Identifier("tinted_glass_panes", "tinted_glass_pane"), TINTED_GLASS_PANE_ITEM);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(content -> content.addAfter(Items.GLASS_PANE, TINTED_GLASS_PANE_ITEM));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.addAfter(Items.TINTED_GLASS, TINTED_GLASS_PANE_ITEM));
	}
}