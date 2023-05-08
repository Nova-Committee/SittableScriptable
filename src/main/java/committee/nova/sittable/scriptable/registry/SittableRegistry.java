package committee.nova.sittable.scriptable.registry;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlock;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.IFacing;
import crafttweaker.api.world.IVector3d;
import stanhebben.zenscript.annotations.ZenClass;

import java.util.Optional;

@ZenRegister
@ZenClass("sittable.registry.SittableRegistry")
public class SittableRegistry {
    private final IBlock block;
    private final IOffsetProvider provider;

    public SittableRegistry(IBlock block, IOffsetProvider provider) {
        this.block = block;
        this.provider = provider;
    }

    public committee.nova.sittable.common.registry.type.SittableRegistry getInternal() {
        return new committee.nova.sittable.common.registry.type.SittableRegistry(
                CraftTweakerMC.getBlock(block),
                (s, p, f) -> Optional.ofNullable(CraftTweakerMC.getVec3d(provider.get(CraftTweakerMC.getBlockState(s), CraftTweakerMC.getIPlayer(p), CraftTweakerMC.getIFacing(f))))
        );
    }

    @ZenRegister
    @ZenClass("sittable.registry.IOffsetProvider")
    public interface IOffsetProvider {
        IVector3d get(crafttweaker.api.block.IBlockState block, IPlayer player, IFacing face);
    }
}
