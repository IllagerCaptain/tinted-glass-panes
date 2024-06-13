package com.tinted_glass_panes;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.minecraft.client.render.RenderLayer;

import static com.tinted_glass_panes.TintedGlassPanes.TINTED_GLASS_PANE;

public class TintedGlassPanesClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(TINTED_GLASS_PANE, RenderLayer.getTranslucent());
	}
}