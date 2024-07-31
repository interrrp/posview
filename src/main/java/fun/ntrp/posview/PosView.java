package fun.ntrp.posview;

import fun.ntrp.posview.config.IConfiguration;
import fun.ntrp.posview.config.InMemoryConfiguration;
import fun.ntrp.posview.position.IPositionProvider;
import fun.ntrp.posview.position.MinecraftPositionProvider;
import fun.ntrp.posview.text.MinecraftTextRenderer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.util.Colors;

public class PosView implements ModInitializer {
	private final IConfiguration configuration = new InMemoryConfiguration();
	private final IPositionProvider positionProvider = new MinecraftPositionProvider();
	private final MinecraftTextRenderer textRenderer = new MinecraftTextRenderer();
	private final PositionRenderer positionRenderer = new PositionRenderer(
			configuration, positionProvider, textRenderer);

	public PosView() {
		configuration.setInt("x", 16);
		configuration.setInt("y", 16);
		configuration.setInt("color", Colors.WHITE);
	}

	@Override
	public void onInitialize() {
		HudRenderCallback.EVENT.register((context, deltaTickManager) -> {
			textRenderer.setDrawContext(context);
			positionRenderer.drawPosition();
		});
	}
}
