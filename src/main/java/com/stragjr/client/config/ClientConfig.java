package com.stragjr.client.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClientConfig {
	private static final Path CONFIG_DIR = Paths.get("config/stragjrclient");
	private static final Path CONFIG_FILE = CONFIG_DIR.resolve("client.properties");

	public static boolean FPS_BOOST_ENABLED = true;
	public static boolean CUSTOM_NAMETAG_ENABLED = true;
	public static boolean HUD_ENABLED = true;
	public static boolean SHOW_FPS = true;
	public static boolean ENTITY_CULLING = true;
	public static boolean REDUCE_PARTICLES = true;
	public static float PARTICLE_REDUCTION_SCALE = 0.5f;
	public static String CUSTOM_NAMETAG = "StragJr";

	public static void load() {
		try {
			if (!Files.exists(CONFIG_DIR)) {
				Files.createDirectories(CONFIG_DIR);
			}

			if (!Files.exists(CONFIG_FILE)) {
				saveDefaults();
			} else {
				loadFromFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void saveDefaults() throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("# StragJr Client Configuration\n");
		sb.append("fps_boost_enabled=").append(FPS_BOOST_ENABLED).append("\n");
		sb.append("custom_nametag_enabled=").append(CUSTOM_NAMETAG_ENABLED).append("\n");
		sb.append("hud_enabled=").append(HUD_ENABLED).append("\n");
		sb.append("show_fps=").append(SHOW_FPS).append("\n");
		sb.append("entity_culling=").append(ENTITY_CULLING).append("\n");
		sb.append("reduce_particles=").append(REDUCE_PARTICLES).append("\n");
		sb.append("particle_reduction_scale=").append(PARTICLE_REDUCTION_SCALE).append("\n");
		sb.append("custom_nametag=").append(CUSTOM_NAMETAG).append("\n");

		Files.write(CONFIG_FILE, sb.toString().getBytes());
	}

	private static void loadFromFile() throws IOException {
		Files.readAllLines(CONFIG_FILE).forEach(line -> {
			if (line.isEmpty() || line.startsWith("#")) return;

			String[] parts = line.split("=");
			if (parts.length != 2) return;

			String key = parts[0].trim();
			String value = parts[1].trim();

			switch (key) {
				case "fps_boost_enabled" -> FPS_BOOST_ENABLED = Boolean.parseBoolean(value);
				case "custom_nametag_enabled" -> CUSTOM_NAMETAG_ENABLED = Boolean.parseBoolean(value);
				case "hud_enabled" -> HUD_ENABLED = Boolean.parseBoolean(value);
				case "show_fps" -> SHOW_FPS = Boolean.parseBoolean(value);
				case "entity_culling" -> ENTITY_CULLING = Boolean.parseBoolean(value);
				case "reduce_particles" -> REDUCE_PARTICLES = Boolean.parseBoolean(value);
				case "particle_reduction_scale" -> PARTICLE_REDUCTION_SCALE = Float.parseFloat(value);
				case "custom_nametag" -> CUSTOM_NAMETAG = value;
			}
		});
	}
}
