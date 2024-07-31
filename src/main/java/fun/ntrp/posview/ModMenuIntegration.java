package fun.ntrp.posview;

import java.awt.Color;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionGroup;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.ColorControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        Configuration cfg = Configuration.getInstance();

        // TODO: Refactor this mess
        return parentScreen -> YetAnotherConfigLib.createBuilder()
                .title(Text.literal("Configure PosView"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("Main settings"))
                        .group(OptionGroup.createBuilder()

                                .name(Text.literal("Position"))

                                .option(Option.<Integer>createBuilder()
                                        .name(Text.literal("X"))
                                        .binding(
                                                16,
                                                () -> cfg.getInt("x"),
                                                x -> cfg.setInt("x", x))
                                        .controller(
                                                opt -> IntegerSliderControllerBuilder.create(opt)
                                                        .range(0, 100)
                                                        .step(1))
                                        .build())

                                .option(Option.<Integer>createBuilder()
                                        .name(Text.literal("Y"))
                                        .binding(
                                                16,
                                                () -> cfg.getInt("y"),
                                                y -> cfg.setInt("y", y))
                                        .controller(
                                                opt -> IntegerSliderControllerBuilder.create(opt)
                                                        .range(0, 100)
                                                        .step(1))
                                        .build())
                                .build())

                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Appearance"))
                                .option(Option.<Color>createBuilder()
                                        .name(Text.literal("Color"))
                                        .binding(Color.WHITE,
                                                () -> new Color(cfg.getInt("color")),
                                                color -> cfg.setInt("color", color.getRGB()))
                                        .controller(ColorControllerBuilder::create)
                                        .build())
                                .build())
                        .build())
                .build()
                .generateScreen(parentScreen);
    }
}
