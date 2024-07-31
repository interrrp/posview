package fun.ntrp.posview;

import fun.ntrp.posview.config.IConfiguration;
import fun.ntrp.posview.position.IPositionProvider;
import fun.ntrp.posview.text.ITextRenderer;
import net.minecraft.util.math.Vec3d;

public class PositionRenderer {
    private final IConfiguration configuration;
    private final IPositionProvider positionProvider;
    private final ITextRenderer textRenderer;

    public PositionRenderer(
            IConfiguration configuration,
            IPositionProvider positionProvider,
            ITextRenderer textRenderer) {
        this.configuration = configuration;
        this.positionProvider = positionProvider;
        this.textRenderer = textRenderer;
    }

    public void drawPosition() {
        int x = configuration.getInt("x");
        int y = configuration.getInt("y");
        int color = configuration.getInt("color");

        Vec3d pos = positionProvider.getPosition();

        textRenderer.drawText(
                String.format("%.1f %.1f %.1f", pos.x, pos.y, pos.z),
                x, y,
                color);
    }
}
