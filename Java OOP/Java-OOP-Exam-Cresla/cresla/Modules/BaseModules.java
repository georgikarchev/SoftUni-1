package cresla.Modules;

import cresla.interfaces.Module;

public abstract class BaseModules implements Module {
    private int id;

    protected BaseModules(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%s Module – %d\n", this.getClass().getSimpleName(), this.getId());
    }
}
