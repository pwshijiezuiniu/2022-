package com.pwalgo.interfacequestion.meituan;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * 骑手有 n 个订单，每个订单需要时间 t 配送，每个订单有一个截止时间；骑手可以使用技能瞬间配送完成，
 * 问最少需要使用几次技能才能把所有订单准时送达。
 */
public class Order {
    public static class Info{
        int line;
        int col;

        public Info(int line, int col) {
            this.line = line;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return line == info.line && col == info.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(line, col);
        }
    }

}
