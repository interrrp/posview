package fun.ntrp.posview.tests;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fun.ntrp.posview.Configuration;
import fun.ntrp.posview.PositionRenderer;
import fun.ntrp.posview.position.IPositionProvider;
import fun.ntrp.posview.position.MockPositionProvider;
import fun.ntrp.posview.text.ITextRenderer;
import net.minecraft.util.Colors;

@ExtendWith(MockitoExtension.class)
public class TestPositionRenderer {
    private final IPositionProvider positionProvider = new MockPositionProvider(4, 2, 0);
    @Mock
    private ITextRenderer textRenderer;

    public TestPositionRenderer() {
        Configuration cfg = Configuration.getInstance();
        cfg.setInt("x", 16);
        cfg.setInt("y", 16);
        cfg.setInt("color", Colors.WHITE);
    }

    @Test
    public void test() {
        PositionRenderer renderer = new PositionRenderer(positionProvider, textRenderer);

        renderer.drawPosition();

        verify(textRenderer).drawText("4.0 2.0 0.0", 16, 16, Colors.WHITE);
    }
}
