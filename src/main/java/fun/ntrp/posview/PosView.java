package fun.ntrp.posview;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Colors;
import net.minecraft.util.math.Vec3d;

public class PosView implements ModInitializer {
	private static final int TEXT_POS_X = 16;
	private static final int TEXT_POS_Y = 16;

	@Override
	public void onInitialize() {
		HudRenderCallback.EVENT.register((context, deltaTickManager) -> {
			draw(context);
		});
	}

	private static void draw(DrawContext context) {
		MinecraftClient minecraft = MinecraftClient.getInstance();
		PlayerEntity player = minecraft.player;
		TextRenderer textRenderer = minecraft.textRenderer;

		context.drawText(
				textRenderer,
				stringifyPos(player.getPos()),
				TEXT_POS_X, TEXT_POS_Y,
				Colors.WHITE,
				/* Shadow */ true);
	}

	private static String stringifyPos(Vec3d pos) {
		return String.format("%.1f %.1f %.1f", pos.x, pos.y, pos.z);
	}
}
