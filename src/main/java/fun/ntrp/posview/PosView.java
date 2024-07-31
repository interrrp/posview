package fun.ntrp.posview;

import fun.ntrp.posview.position.IPositionProvider;
import fun.ntrp.posview.position.MinecraftPositionProvider;
import fun.ntrp.posview.text.MinecraftTextRenderer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.util.Colors;

public class PosView implements ModInitializer {
	private final IPositionProvider positionProvider = new MinecraftPositionProvider();
	private final MinecraftTextRenderer textRenderer = new MinecraftTextRenderer();
	private final PositionRenderer positionRenderer = new PositionRenderer(positionProvider, textRenderer);

	public PosView() {
		Configuration cfg = Configuration.getInstance();
		cfg.setInt("x", 16);
		cfg.setInt("y", 16);
		cfg.setInt("color", Colors.WHITE);
	}

	@Override
	public void onInitialize() {
		HudRenderCallback.EVENT.register((context, deltaTickManager) -> {
			textRenderer.setDrawContext(context);
			positionRenderer.drawPosition();
		});
	}
}
