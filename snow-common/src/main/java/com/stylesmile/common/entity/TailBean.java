//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.stylesmile.common.entity;

import com.stylesmile.common.exception.PlatformException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TailBean implements Tail {
    protected Map<String, Object> extMap = new HashMap();
    boolean hasLazy = false;

    public TailBean() {
    }
    @Override
    public Object get(String key) {
        if (this.hasLazy) {
            Object o = this.extMap.get(key);
            if (o instanceof LazyEntity) {
                LazyEntity lazyEntity = (LazyEntity)o;

                try {
                    Object real = lazyEntity.get();
                    this.extMap.put(key, real);
                    return real;
                } catch (RuntimeException var5) {
                    var5.printStackTrace();
                    throw new PlatformException(17, "Lazy Load Error:" + key + "," + var5.getMessage(), var5);
                }
            } else {
                return o;
            }
        } else {
            return this.extMap.get(key);
        }
    }

    @Override
    public void set(String key, Object value) {
        if (value instanceof LazyEntity) {
            this.hasLazy = true;
        }

        this.extMap.put(key, value);
    }

    public Map<String, Object> getTails() {
        Map<String, Object> newExtMap = new HashMap();
        if (this.hasLazy) {
            Iterator var2 = this.extMap.entrySet().iterator();

            while(var2.hasNext()) {
                Entry<String, Object> entry = (Entry)var2.next();
                String key = (String)entry.getKey();
                Object value = entry.getValue();
                if (value instanceof LazyEntity) {
                    try {
                        LazyEntity lazyEntity = (LazyEntity)value;
                        Object real = lazyEntity.get();
                        newExtMap.put(key, real);
                    } catch (RuntimeException var8) {
                        throw new PlatformException(17, "Lazy Load Error:" + key + "," + var8.getMessage(), var8);
                    }
                } else {
                    newExtMap.put(key, value);
                }
            }

            this.extMap = newExtMap;
            this.hasLazy = false;
        }

        return this.extMap;
    }
}
