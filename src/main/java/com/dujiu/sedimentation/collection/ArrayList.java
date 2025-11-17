package com.dujiu.sedimentation.collection;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author dujiu
 * @date: 2025/10/7
 * @description: 手写一个ArrayList
 */
public class ArrayList<E> implements List<E> {

    private Object[] table = new Object[10];

    private int size;

    @Override
    public void add(E element) {
        if (size == table.length) {
            throw new IndexOutOfBoundsException();
        }
        table[size] = element;
        size++;
    }

    @Override
    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // 要进行扩容
        if (size == table.length) {
            resize();
        }
        System.arraycopy(table, index, table, index + 1, size - index);
        table[index] = element;
        size++;
    }

    private void resize() {
        Object[] newTable = new Object[table.length * 2];
        System.arraycopy(table, 0, newTable, 0, table.length);
        this.table = newTable;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removeElement = (E) table[index];
        System.arraycopy(table,index+1,table,index,size-index-1);
        size--;
        table[size] = null;
        return removeElement;
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, table[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
