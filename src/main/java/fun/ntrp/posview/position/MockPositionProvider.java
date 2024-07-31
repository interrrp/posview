package fun.ntrp.posview.position;

import net.minecraft.util.math.Vec3d;

public class MockPositionProvider implements IPositionProvider {
    private final Vec3d pos;

    public MockPositionProvider(int x, int y, int z) {
        pos = new Vec3d(x, y, z);
    }

    public Vec3d getPosition() {
        return pos;
    }
}
