package net.raizou.client.client.events;

import net.minecraftforge.fml.common.eventhandler.Event;

public class ClientEvent<T> extends Event {
    public boolean canceled;
    public EventType type;

    @Override
    public boolean isCanceled() {
        return canceled;
    }

    @Override
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public EventType getType() {
        return this.type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public boolean isPre() {
        if (this.type == null) {
            return false;
        }
        return this.type == EventType.PRE;
    }

    public boolean isPost() {
        if (this.type == null) {
            return false;
        }
        return this.type == EventType.POST;
    }
}
