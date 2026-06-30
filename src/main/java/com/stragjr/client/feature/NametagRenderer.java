package com.stragjr.client.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import com.stragjr.client.config.ClientConfig;

@Environment(EnvType.CLIENT)
public class NametagRenderer {

	public static void init() {
		if (!ClientConfig.CUSTOM_NAMETAG_ENABLED) return;

		WorldRenderEvents.AFTER_TRANSLUCENT.register(context -> {
			// Custom nametag rendering will happen here
			// This gets called after translucent render phase
		});
	}

	public static String getCustomNametag() {
		return ClientConfig.CUSTOM_NAMETAG;
	}

	public static void setCustomNametag(String nametag) {
		ClientConfig.CUSTOM_NAMETAG = nametag;
	}
}
