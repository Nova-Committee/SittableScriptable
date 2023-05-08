package committee.nova.sittable.scriptable.event.impl;

import committee.nova.sittable.scriptable.registry.SittableRegistry;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlock;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("sittable.event.SittableRegisterEvent")
public class SittableRegisterEvent {
    private final committee.nova.sittable.common.event.impl.SittableRegisterEvent internal;

    public SittableRegisterEvent(committee.nova.sittable.common.event.impl.SittableRegisterEvent internal) {
        this.internal = internal;
    }

    public committee.nova.sittable.common.event.impl.SittableRegisterEvent getInternal() {
        return internal;
    }

    @ZenMethod
    public void registerSittable(IBlock block, SittableRegistry.IOffsetProvider provider) {
        registerSittable(new SittableRegistry(block, provider));
    }

    @ZenMethod
    public void registerSittable(SittableRegistry registry) {
        internal.registerSittable(registry.getInternal());
    }
}
