package com.github.ltprc.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionContainer {
    private Map map;
    private List list;
    private Set set;
    public CollectionContainer(Map map, List list, Set set) {
        super();
        this.map = map;
        this.list = list;
        this.set = set;
    }
}
