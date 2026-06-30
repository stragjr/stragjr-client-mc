package com.stragjr.client;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StragJrClient implements ModInitializer {
	public static final String MOD_ID = "stragjrclient";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("StragJr Client loaded successfully!");
	}
}
