package fun.ntrp.posview.text;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class MinecraftTextRenderer implements ITextRenderer {
    private DrawContext drawContext;

    public void setDrawContext(DrawContext drawContext) {
        this.drawContext = drawContext;
    }

    public void drawText(String text, int x, int y, int color) {
        if (drawContext == null)
            return;

        @SuppressWarnings("resource")
        TextRenderer minecraftTextRenderer = MinecraftClient.getInstance().textRenderer;

        drawContext.drawText(minecraftTextRenderer, text, x, y, color, true);
    }
}
