package com.stragjr.client.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import com.stragjr.client.config.ClientConfig;

@Environment(EnvType.CLIENT)
public class HudRenderer {

	private static int frameCount = 0;
	private static long lastSecond = System.currentTimeMillis();
	private static int fps = 0;

	public static void init() {
		if (!ClientConfig.HUD_ENABLED) return;

		HudRenderCallback.EVENT.register(HudRenderer::renderHud);
	}

	private static void renderHud(DrawContext context, RenderTickCounter tickCounter) {
		if (!ClientConfig.HUD_ENABLED) return;

		updateFps();

		if (ClientConfig.SHOW_FPS) {
			int x = 10;
			int y = 10;
			String fpsText = "FPS: " + fps;
			context.drawText(context.getTextRenderer(), fpsText, x, y, 0x00FF00, true);
		}

		// Display nametag info
		if (ClientConfig.CUSTOM_NAMETAG_ENABLED) {
			int x = 10;
			int y = 25;
			String nametagText = "Nametag: " + ClientConfig.CUSTOM_NAMETAG;
			context.drawText(context.getTextRenderer(), nametagText, x, y, 0x00FFFF, true);
		}

		// Performance metrics
		int x = 10;
		int y = 40;
		long memUsage = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024;
		String memText = "Memory: " + memUsage + "MB";
		context.drawText(context.getTextRenderer(), memText, x, y, 0xFFFF00, true);
	}

	private static void updateFps() {
		frameCount++;
		long currentTime = System.currentTimeMillis();

		if (currentTime - lastSecond >= 1000) {
			fps = frameCount;
			frameCount = 0;
			lastSecond = currentTime;
		}
	}
}
