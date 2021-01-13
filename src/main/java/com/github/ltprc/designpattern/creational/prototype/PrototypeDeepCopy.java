package com.github.ltprc.designpattern.creational.prototype;

public class PrototypeDeepCopy implements Cloneable {
    SubObjectCloneable subObjectCloneable;
    public SubObjectCloneable getSubObjectClonebale() {
        return subObjectCloneable;
    }
    public void setSubObjectCloneable(SubObjectCloneable subObjectCloneable) {
        this.subObjectCloneable = subObjectCloneable;
    }
    @Override
    protected Object clone() {
        PrototypeDeepCopy prototypeDeepCopy = null;
        try {
            prototypeDeepCopy = (PrototypeDeepCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        prototypeDeepCopy.setSubObjectCloneable((SubObjectCloneable)subObjectCloneable.clone());
        return prototypeDeepCopy;
    }
}
class SubObjectCloneable implements Cloneable {
    @Override
    protected Object clone() {
        SubObjectCloneable subObjectCloneable = null;
        try {
            subObjectCloneable = (SubObjectCloneable) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return subObjectCloneable;
    }
}
