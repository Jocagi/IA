package gt.edu.url;

import java.util.Arrays;

public class URLArrayList <E> implements List
{
    private int size;
    private int maxSize;
    private final int defaultSize = 10;
    private E elements[];

    public URLArrayList()
    {
        size = 0;
        maxSize = defaultSize;
        elements = (E[]) new Object[defaultSize];
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            return elements[i];
        }
    }

    @Override
    public E set(int i, Object o) throws IndexOutOfBoundsException
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            elements[i] = (E)o;
            return elements[i];
        }
    }

    @Override
    public void add(int i, Object o) throws IndexOutOfBoundsException
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            ensureAvailableSpace();
            for (int j = size; j >= i; j--)
            {
                elements[j+1] = elements[j];
            }
            size++;
            elements[i] = (E)o;
        }
    }

    private void ensureAvailableSpace()
    {
        if (size == maxSize)
        {
            maxSize += defaultSize;
            elements = Arrays.copyOf(elements, maxSize);
        }
    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            E value = elements[i];

            ensureAvailableSpace();
            for (int j = i; j <= size; j++)
            {
                elements[j] = elements[j+1];
            }
            size--;

            return value;
        }
    }
}
