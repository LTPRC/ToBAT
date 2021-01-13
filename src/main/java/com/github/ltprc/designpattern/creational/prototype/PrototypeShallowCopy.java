package com.github.ltprc.designpattern.creational.prototype;

public class PrototypeShallowCopy implements Cloneable {
    private SubObject subObject;
    public SubObject getSubObject() {
        return subObject;
    }
    public void setSubObject(SubObject subObject) {
        this.subObject = subObject;
    }
    @Override
    protected Object clone() {
        PrototypeShallowCopy prototypeShallow = null;
        try {
            prototypeShallow = (PrototypeShallowCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototypeShallow;
    }
}
class SubObject {}
