package committee.nova.sittable.scriptable.event.handler;

import committee.nova.sittable.scriptable.event.impl.SittableRegisterEvent;
import committee.nova.sittable.scriptable.event.manager.EventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ForgeEventHandler {
    @SubscribeEvent
    public static void onSittableRegister(committee.nova.sittable.common.event.impl.SittableRegisterEvent e) {
        if (EventManager.hasRegister()) EventManager.publishRegister(new SittableRegisterEvent(e));
    }
}
