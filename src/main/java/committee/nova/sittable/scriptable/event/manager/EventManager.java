package committee.nova.sittable.scriptable.event.manager;

import committee.nova.sittable.scriptable.event.impl.SittableRegisterEvent;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("sittable.event.EventManager")
public class EventManager {
    private static final EventList<SittableRegisterEvent> registers = new EventList<>();

    public static boolean hasRegister() {
        return registers.hasHandlers();
    }

    public static void publishRegister(SittableRegisterEvent event) {
        registers.publish(event);
    }

    @ZenMethod
    public static IEventHandle onSittableRegister(IEventHandler<SittableRegisterEvent> handler) {
        return registers.add(handler);
    }
}
