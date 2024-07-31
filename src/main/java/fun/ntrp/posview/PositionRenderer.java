package fun.ntrp.posview;

import fun.ntrp.posview.position.IPositionProvider;
import fun.ntrp.posview.text.ITextRenderer;
import net.minecraft.util.math.Vec3d;

public class PositionRenderer {
    private final IPositionProvider positionProvider;
    private final ITextRenderer textRenderer;

    public PositionRenderer(
            IPositionProvider positionProvider,
            ITextRenderer textRenderer) {
        this.positionProvider = positionProvider;
        this.textRenderer = textRenderer;
    }

    public void drawPosition() {
        Configuration cfg = Configuration.getInstance();
        int x = cfg.getInt("x");
        int y = cfg.getInt("y");
        int color = cfg.getInt("color");

        Vec3d pos = positionProvider.getPosition();

        textRenderer.drawText(
                String.format("%.1f %.1f %.1f", pos.x, pos.y, pos.z),
                x, y,
                color);
    }
}
