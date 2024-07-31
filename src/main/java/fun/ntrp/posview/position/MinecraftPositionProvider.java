package fun.ntrp.posview.position;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class MinecraftPositionProvider implements IPositionProvider {
    @SuppressWarnings("resource")
    public Vec3d getPosition() {
        return MinecraftClient.getInstance().player.getPos();
    }
}
