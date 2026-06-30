package com.stragjr.client.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.network.ClientPlayerEntity;
import com.stragjr.client.feature.NametagRenderer;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerMixin {

	// Mixin for custom nametag rendering on player entity
	// This will be expanded to hook into the rendering pipeline
}
