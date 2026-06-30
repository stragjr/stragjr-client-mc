package com.stragjr.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import com.stragjr.client.config.ClientConfig;
import com.stragjr.client.feature.NametagRenderer;
import com.stragjr.client.feature.FpsBoostManager;
import com.stragjr.client.feature.HudRenderer;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ClientConfig.load();
		FpsBoostManager.init();
		NametagRenderer.init();
		HudRenderer.init();
		StragJrClient.LOGGER.info("StragJr Client initialized on client side!");
	}
}
