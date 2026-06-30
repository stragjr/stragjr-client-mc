# StragJr Client 🎮

A high-performance Minecraft Fabric client mod for Minecraft 1.21.1 with custom features and optimization.

## Features ✨

### 🚀 FPS Boost
- **Chunk Rendering Optimization** - Reduces unnecessary chunk rendering
- **Entity Culling** - Skips rendering entities outside your view
- **Particle Reduction** - Decreases particle effects for better performance
- **Memory Optimization** - Efficient memory management

### 🏷️ Custom Nametag
- Display personalized nametags above your player
- Fully customizable text
- Real-time configuration

### 📊 HUD Features
- **FPS Counter** - Real-time FPS display
- **Memory Usage** - Monitor RAM consumption
- **Nametag Display** - Show current nametag info
- **Performance Metrics** - Track client performance

## Installation

### Requirements
- Minecraft 1.21.1
- Fabric Loader 0.15.0+
- Java 21+

### Steps
1. Install Fabric Loader from [fabricmc.net](https://fabricmc.net)
2. Download the latest release from GitHub
3. Place the mod JAR in your `mods` folder
4. Launch Minecraft with Fabric profile

## Configuration

Configuration file: `config/stragjrclient/client.properties`

```properties
fps_boost_enabled=true
custom_nametag_enabled=true
hud_enabled=true
show_fps=true
entity_culling=true
reduce_particles=true
particle_reduction_scale=0.5
custom_nametag=StragJr
```

## Building

```bash
# Clone the repository
git clone https://github.com/stragjr/stragjr-client-mc.git
cd stragjr-client-mc

# Build the mod
./gradlew build

# Output JAR will be in build/libs/
```

## File Structure

```
src/main/java/com/stragjr/client/
├── StragJrClient.java           # Main mod class
├── ClientInit.java              # Client-side initialization
├── config/
│   └── ClientConfig.java        # Configuration management
├── feature/
│   ├── FpsBoostManager.java     # FPS optimization
│   ├── NametagRenderer.java     # Custom nametag rendering
│   └── HudRenderer.java         # HUD elements
└── mixin/
    ├── ClientPlayerMixin.java
    ├── GameRendererMixin.java
    ├── EntityRenderDispatcherMixin.java
    └── ParticleManagerMixin.java
```

## Features Roadmap 🗺️

- [ ] In-game config GUI
- [ ] More FPS optimization options
- [ ] Advanced nametag customization (colors, effects)
- [ ] Performance profiler
- [ ] Custom chat formatting
- [ ] Keybind system

## Contributing

Contributions are welcome! Feel free to submit issues and pull requests.

## License

MIT License - See LICENSE file for details

## Author

**StragJr** - [GitHub](https://github.com/stragjr)

---

*Made with ❤️ for Minecraft players*
