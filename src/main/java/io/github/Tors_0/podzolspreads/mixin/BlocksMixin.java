package io.github.Tors_0.podzolspreads.mixin;

import io.github.Tors_0.podzolspreads.blocks.PodzolBlock;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public class BlocksMixin {
    @Redirect(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;COARSE_DIRT:Lnet/minecraft/block/Block;")
            ),
            at = @At(value = "NEW", target = "(Lnet/minecraft/block/AbstractBlock$Settings;)Lnet/minecraft/block/SnowyBlock;", ordinal = 0)
    )
    private static SnowyBlock makePodzolSpread(AbstractBlock.Settings settings) {
            return new PodzolBlock(AbstractBlock.Settings.create().mapColor(MapColor.PODZOL).ticksRandomly().strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    }
}
